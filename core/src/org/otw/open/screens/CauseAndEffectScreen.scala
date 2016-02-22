package org.otw.open.screens

import org.otw.open.actors.{BackgroundActor, MovingObjectActor}
import org.otw.open.controllers.GameState
import org.otw.open.listeners.{MovingObjectClickListener, MovingObjectDragAndDropListener, MovingObjectSceneListener}

/**
  * Created by eilievska on 2/15/2016.
  */
class CauseAndEffectScreen extends AbstractGameScreen {

  private val backgroundActor = new BackgroundActor("light-background.png")

  private val movingObjectActor = new MovingObjectActor

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
