package org.otw.open.engine

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.{Payload, Source, Target}
import com.badlogic.gdx.scenes.scene2d.{InputEvent, Stage}
import com.badlogic.gdx.utils.viewport.ScreenViewport
import org.otw.open.controllers.{CauseAndEffectFinishedSuccessfully, ScreenController}
import org.otw.open.dto.Drawing
import org.otw.open.engine.actor.DragAndDropActor

/**
  * Created by smirakovska on 2/9/2016.
  */
class DragAndDropActorEngine(val imgActorPath: String, val imgBackgroundPath: String) extends Engine {

  private var stage: Stage = _

  private var sourceActor = new DragAndDropActor(imgActorPath, imgBackgroundPath, 0, 320)

  private val dragAndDrop = new DragAndDrop()

  stage = new Stage(new ScreenViewport())
  Gdx.input.setInputProcessor(stage)


  /**
    * adding source actor
    */
  dragAndDrop.addSource(new Source(sourceActor) {
    val payload: Payload = new Payload

    override def dragStart(event: InputEvent, x: Float, y: Float, pointer: Int): Payload = {
      println("dragStart")
      payload.setObject(sourceActor)
      payload.setDragActor(sourceActor)
      payload.setInvalidDragActor(sourceActor)
      payload
    }

    override def dragStop(event: InputEvent, x: Float, y: Float, pointer: Int, payload: Payload,
                          target: Target) {
      println("dragStop")
      if (target == null) sourceActor.resetPosition
      stage.addActor(sourceActor);
    }
  })

  dragAndDrop.addTarget(new Target(sourceActor) {

    def drag(source: Source, payload: Payload, x: Float, y: Float, pointer: Int): Boolean = {
      println("drag")
      //      dragAndDrop.setDragActorPosition(-(sourceActor.texture.getWidth() / 2),
      //        sourceActor.texture.getHeight() / 2);
      dragAndDrop.setDragActorPosition(-216, 216)
      true
    }

    def drop(source: Source, payload: Payload, x: Float, y: Float, pointer: Int) {
      println("drop");
      if (source.getActor().getX() >= 900
        && source.getActor().getX() <= 1100
        && source.getActor().getY() >= 259
        && source.getActor().getY() <= 452) {
        sourceActor = new DragAndDropActor(imgActorPath, imgBackgroundPath, source.getActor.getX(), source.getActor.getY)
        ScreenController.dispatchEvent(CauseAndEffectFinishedSuccessfully)
      }
      else
        sourceActor.resetPosition();
    }
  })

  /**
    * add the actor to the scene
    */
  stage.addActor(sourceActor)


  override def dispose(): Unit = {
    sourceActor.dispose()
  }

  override def getDrawings(delta: Float): List[Drawing] = {
    stage.draw
    List.empty
  }
}
