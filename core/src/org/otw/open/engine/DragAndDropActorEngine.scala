package org.otw.open.engine

import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.{Payload, Source, Target}
import com.badlogic.gdx.scenes.scene2d.{InputEvent, Stage}
import com.badlogic.gdx.utils.viewport.ScreenViewport
import com.badlogic.gdx.{Game, Gdx}
import org.otw.open.engine.actor.DragAndDropActor

/**
  * Created by smirakovska on 2/9/2016.
  */
class DragAndDropActorEngine(val imgActorPath:String, val imgBackgroundPath:String) extends Game {

  private var stage: Stage = _

  private var sourceActor: DragAndDropActor = _

  private var dnd: DragAndDrop = _

  override def resize(width: Int, height: Int): Unit = {

    stage.getViewport().update(width, height, true);
  }

  override def dispose(): Unit = {
    sourceActor.dispose()
  }

  override def pause(): Unit = false

  override def render(): Unit = {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    stage.act(Gdx.graphics.getDeltaTime)
    stage.draw
  }

  override def resume(): Unit = false

  override def create(): Unit = {
    stage = new Stage(new ScreenViewport())
    Gdx.input.setInputProcessor(stage)

    /**
      * create DragAndDropActor
      */
    sourceActor = new DragAndDropActor(imgActorPath, imgBackgroundPath, 0, 320)

    dnd = new DragAndDrop()

    /**
      * adding source actor
      */
    dnd.addSource(new Source(sourceActor) {
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
        if(target==null) sourceActor.resetPosition
        stage.addActor(sourceActor);
      }
    });

    dnd.addTarget(new Target(sourceActor) {

      def drag(source: Source, payload: Payload, x: Float, y: Float, pointer: Int): Boolean = {
        println("drag")
        dnd.setDragActorPosition(-(sourceActor.texture.getWidth() / 2), sourceActor.texture.getHeight() / 2);
        true
      }

      def drop(source: Source, payload: Payload, x: Float, y: Float, pointer: Int) {
       println("drop");
        if (source.getActor().getX() >= 1000
          && source.getActor().getX()<= 1100
          && source.getActor().getY() >= 299
           && source.getActor().getY()<=402)
          sourceActor = new DragAndDropActor(imgActorPath, imgBackgroundPath, source.getActor.getX(), source.getActor.getY)
        else
        sourceActor.resetPosition();
      }
    });


    /**
      * add the actor to the scene
      */
    stage.addActor(sourceActor)
  }

}
