package org.otw.open.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{Color, GL20}
import org.otw.open.actors.{BackgroundActor, MovingObjectActor}
import org.otw.open.controllers.{GameState, CauseAndEffectFinishedSuccessfully, ScreenController}
import org.otw.open.listeners.{MovingObjectSceneListener, MovingObjectDragAndDropListener, MovingObjectClickListener}

/**
  * Created by eilievska on 2/15/2016.
  */
class CauseAndEffectScreen extends AbstractGameScreen {

  private val backgroundActor = new BackgroundActor("light-background.png")

  private val movingObjectActor = new MovingObjectActor

  override def render(delta: Float) = {
    Gdx.gl.glClearColor(Color.WHITE.r, Color.WHITE.g, Color.WHITE.b, Color.WHITE.a)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    act(delta)
    draw
    if (!movingObjectActor.isInMotion && movingObjectActor.actorFinishedAllActions) ScreenController.dispatchEvent(CauseAndEffectFinishedSuccessfully)
  }

  private val level: Int = GameState.getLevel

  if (level == 2 || level == 3) {
    addListener(new MovingObjectSceneListener(movingObjectActor))
  }

  val listener = level match {
    case 2 => new MovingObjectClickListener(movingObjectActor)
    case 3 => new MovingObjectClickListener(movingObjectActor)
    case 4 => new MovingObjectDragAndDropListener(movingObjectActor)
  }
  movingObjectActor.addListener(listener)

  /**
    * Methods to be overriden by all classes.
    */
  override def buildStage(): Unit = {
    addActor(backgroundActor)
    addActor(movingObjectActor)
  }
}
