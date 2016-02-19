package org.otw.open.actors

import com.badlogic.gdx.{InputProcessor, Gdx}
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.actions.{MoveToAction, MoveByAction}
import com.badlogic.gdx.scenes.scene2d.{InputEvent, InputListener, Touchable, Actor}
import com.badlogic.gdx.utils.Pool
import org.otw.open.controllers.{GameState, CauseAndEffectFinishedUnsuccessfully, ScreenController}
import org.otw.open.dto.Point
import org.otw.open.engine.util.Animator

import scala.collection.mutable

/**
  * Created by eilievska on 2/12/2016.
  */
class MovingObjectActor extends Actor {

  /**
    * Timer for the vibrating object
    */
  private var animationTime = 0f

  /**
    * Number of times the actor was missed by a click or not placed on the correct position with drag and drop.
    */
  private var objectMissedCount = 0

  /**
    * A flag to indicate if the actor is moving at the moment.
    */
  private var isInMotion = false

  /**
    * Animator object
    */
  private val animator: Animator = new Animator("theme/" + GameState.getThemeName + "/animation-object.atlas")

  private val actionStack = mutable.Stack[MoveToAction]()

  private val standPoints: List[Point] = GameState.getLevelStandPoints

  standPoints.reverse.foreach(point => {
    val moveToAction = new MoveToAction
    moveToAction.setDuration(2f)
    moveToAction.setPosition(point.x, point.y)
    actionStack.push(moveToAction)
  })

  private var currentMoveToAction = actionStack.top

  resetPosition()

  private val actorWidth: Float = animator.getCurrentTexture(0).getRegionWidth
  private val actorHeight: Float = animator.getCurrentTexture(0).getRegionHeight
  setWidth(actorWidth)
  setHeight(actorHeight)

  def resetPosition() = {
    val startPoint: Point = GameState.getLevelStartPoint
    setX(startPoint.x)
    setY(startPoint.y)
  }

  def incrementMissCount = {
    objectMissedCount += 1
    if (objectMissedCount >= 3) {
      ScreenController.dispatchEvent(CauseAndEffectFinishedUnsuccessfully)
    }
  }

  def getObjectMissCount = objectMissedCount

  def isBeginning: Boolean = getX == GameState.getLevelStartPoint.x

  def isMoving = {
    val isMoving: Boolean = getX != currentMoveToAction.getX
    if (isBeginning) false else isMoving
  }

  def actorFinishedAllActions = actionStack.isEmpty

  def decrementMissCount = objectMissedCount -= 1

  override def draw(batch: Batch, parentAlpha: Float): Unit = {
    animationTime += Gdx.graphics.getDeltaTime
    batch.draw(animator.getCurrentTexture(animationTime), getX, getY)
  }

  def move() = {
    currentMoveToAction = actionStack.pop
    addAction(currentMoveToAction)
  }

}
