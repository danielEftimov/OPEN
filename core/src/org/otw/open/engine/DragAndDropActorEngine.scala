package org.otw.open.engine

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.{Payload, Source, Target}
import com.badlogic.gdx.scenes.scene2d.{InputEvent, Stage}
import com.badlogic.gdx.utils.viewport.ScreenViewport
import org.otw.open.controllers.{CauseAndEffectFinishedSuccessfully, CauseAndEffectFinishedUnsuccessfully, ScreenController}
import org.otw.open.dto.Drawing
import org.otw.open.engine.actor.DragAndDropActor

/**
  * Created by smirakovska on 2/9/2016.
  *
  * @param theme - name of theme
  * @param imgBackgroundPath - path to background image file
  */
class DragAndDropActorEngine(val theme: String, val imgBackgroundPath: String) extends Engine {

  /**
    * Stage object
    */
  private var stage: Stage = _

  /**
    * Mutable instance of DragAndDropActor
    */
  private var actor = new DragAndDropActor(theme, imgBackgroundPath, 0, 320)

  private val dragAndDrop = new DragAndDrop()

  /**
    * Number of failed attempts
    */
  private var failedAttempts = 0

  /**
    * Number of maximum allowed failed attempts
    */
  private val maxFailedAttempts = 3

  stage = new Stage(new ScreenViewport())
  Gdx.input.setInputProcessor(stage)

  /**
    * adding source actor
    */
  dragAndDrop.addSource(new Source(actor) {
    val payload: Payload = new Payload

    override def dragStart(event: InputEvent, x: Float, y: Float, pointer: Int): Payload = {
      payload.setObject(actor)
      payload.setDragActor(actor)
      payload.setInvalidDragActor(actor)
      payload
    }

    override def dragStop(event: InputEvent, x: Float, y: Float, pointer: Int, payload: Payload,
                          target: Target) {
      if (target == null) {
        actor.resetPosition
        failedAttempts += 1
      }
      stage.addActor(actor)
      if (failedAttempts == maxFailedAttempts) {
        ScreenController.dispatchEvent(CauseAndEffectFinishedUnsuccessfully)
      }
    }
  })

  /**
    * adding target object
    */
  dragAndDrop.addTarget(new Target(actor) {

    def drag(source: Source, payload: Payload, x: Float, y: Float, pointer: Int): Boolean = {
      //      dragAndDrop.setDragActorPosition(-(actor.texture.getWidth() / 2),
      //        actor.texture.getHeight() / 2);
      dragAndDrop.setDragActorPosition(-216, 216)
      true
    }

    def drop(source: Source, payload: Payload, x: Float, y: Float, pointer: Int) {
      if (source.getActor().getX() >= 900
        && source.getActor().getX() <= 1100
        && source.getActor().getY() >= 259
        && source.getActor().getY() <= 452) {
        actor = new DragAndDropActor(theme, imgBackgroundPath, source.getActor.getX(), source.getActor.getY)
        ScreenController.dispatchEvent(CauseAndEffectFinishedSuccessfully)
      }
      else {
        actor.resetPosition
        failedAttempts += 1
      }
    }
  })

  /**
    * add actor to the scene
    */
  stage.addActor(actor)

  override def dispose(): Unit = {
    actor.dispose()
  }

  override def getDrawings(delta: Float): List[Drawing] = {
    stage.draw
    List.empty
  }
}
