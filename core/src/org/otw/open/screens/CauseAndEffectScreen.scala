package org.otw.open.screens

import org.otw.open.actors.{BackgroundActor, MovingObjectActor}
import org.otw.open.controllers.GameState
import org.otw.open.listeners.{MovingObjectClickListener, MovingObjectDragAndDropListener, MovingObjectSceneListener}

/**
  * Created by eilievska on 2/15/2016.
  * Screen that handles Cause And Effect game
  */
class CauseAndEffectScreen extends AbstractGameScreen {

  /**
    * instance of BackgroundActor
    */
  private val backgroundActor = new BackgroundActor("light-background.png")

  /**
    * instance of MovingObjectActor
    */
  private val movingObjectActor = new MovingObjectActor

  /**
    * Current game level
    */
  private val level: Int = GameState.getLevel

  /**
    * add click listener to screen if object is moving by 1 or 3 clicks
    */
  if (level == 2 || level == 3) {
    addListener(new MovingObjectSceneListener(movingObjectActor))
  }

  /**
    * add listener to actor depending on current game level
    */
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
