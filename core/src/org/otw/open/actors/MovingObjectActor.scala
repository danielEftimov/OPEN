package org.otw.open.actors

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.actions.{MoveToAction, SequenceAction}
import com.badlogic.gdx.scenes.scene2d.{Action, Actor}
import com.badlogic.gdx.utils.Disposable
import org.otw.open.controllers.{CauseAndEffectFinishedSuccessfully, CauseAndEffectFinishedUnsuccessfully, GameState, ScreenController}
import org.otw.open.dto.Point
import org.otw.open.util.{Animator, AudioManager}

import scala.collection.mutable

/**
  * Created by eilievska on 2/12/2016.
  */
class MovingObjectActor extends Actor with Disposable {

  /**
    * Timer for the vibrating object
    */
  private var animationTime = 0f

  /**
    * animation object sound
    */
  private val sound = AudioManager("movingObjectSound.mp3")

  /**
    * Number of times the actor was missed by a click or not placed on the correct position with drag and drop.
    */
  private var objectMissedCount = 0

  /**
    * Animator object
    */
  private val animator: Animator = new Animator("animation-object.atlas")

  /**
    * Move actions for the actor
    */
  private val actionsQueue = new mutable.Queue[MoveToAction]()

  /**
    * Standpoints for the animation of the actor
    * (held in the json property file)
    */
  private val standPoints: List[Point] = GameState.getLevelStandPoints

  /**
    * add MoveAction in the stack for each standpoint
    */
  standPoints.foldLeft(GameState.getLevelStartPoint)((lastPoint: Point, thisPoint: Point) => {
    val moveToAction = new MoveToAction
    val moveSpeed = 200f
    val distance: Float = thisPoint.x.toFloat - lastPoint.x.toFloat
    moveToAction.setDuration(distance / moveSpeed)
    moveToAction.setPosition(thisPoint.x, thisPoint.y)
    actionsQueue += moveToAction
    thisPoint
  })

  /**
    * next standpoint for animating object
    */
  private var currentMoveToAction = actionsQueue.head

  /**
    * the width of actor object
    */
  private val actorWidth: Float = animator.getCurrentTexture(0).getRegionWidth

  /**
    * the height of actor object
    */
  private val actorHeight: Float = animator.getCurrentTexture(0).getRegionHeight

  setWidth(actorWidth)
  setHeight(actorHeight)
  resetPosition()

  /**
    * set actor's position to start point
    */
  def resetPosition() = {
    val startPoint: Point = GameState.getLevelStartPoint
    setX(startPoint.x)
    setY(startPoint.y)
    sound.getAudio.stop
  }

  /**
    * Count failed attempts
    */
  def incrementMissCount = {
    objectMissedCount += 1
    if (objectMissedCount >= 3) {
      ScreenController.dispatchEvent(CauseAndEffectFinishedUnsuccessfully)
    }
  }

  /**
    * @return number of missed counts
    */
  def getObjectMissCount = objectMissedCount

  /**
    * @return true if the actor is on the initial position (start_point from the JSON file).
    */
  def isOnInitialPosition: Boolean = getX == GameState.getLevelStartPoint.x

  /**
    * @return true if actor is moving on the stage
    */
  def isInMotion = {
    val isMoving: Boolean = getX != currentMoveToAction.getX
    if (isOnInitialPosition) false else isMoving
  }

  /**
    * @return true if actor has reached final point
    */
  def actorFinishedAllActions = actionsQueue.isEmpty

  /**
    * decreases missed count if screen was clicked and actor was not
    */
  def decrementMissCount = objectMissedCount -= 1

  /**
    * Changes screen if actor has reached endpoint
    *
    * @param batch
    * @param parentAlpha
    */
  override def draw(batch: Batch, parentAlpha: Float): Unit = {
    animationTime += Gdx.graphics.getDeltaTime
    batch.draw(animator.getCurrentTexture(animationTime), getX, getY)
    if (!isInMotion && actorFinishedAllActions) {
      sound.getAudio.stop
      ScreenController.dispatchEvent(CauseAndEffectFinishedSuccessfully)
    }
  }

  /**
    * adds new move action to the actor for the next standpoint
    */
  def move() = {
    currentMoveToAction = actionsQueue.dequeue()
    addAction(new SequenceAction(currentMoveToAction, completeAction))
  }

  def playSound(): Unit = {
    sound.getAudio.setLooping(true)
    sound.getAudio.play
  }

  def stopSound(): Unit = {
    sound.getAudio.stop
  }

  def completeAction = new Action() {
    def act(delta: Float): Boolean = {
      sound.getAudio.stop
      true
    }
  }

  override def dispose(): Unit = {
    sound.getAudio.dispose
    animator.dispose
  }
}
