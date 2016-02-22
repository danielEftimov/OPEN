package org.otw.open.screens

import org.otw.open.actors.{BackgroundActor, MovingObjectActor}
import org.otw.open.controllers.GameState
import org.otw.open.listeners.{MovingObjectDragAndDropListener, MovingObjectClickListener}
import org.otw.open.testconfig.UnitSpec
import org.scalatest.BeforeAndAfterEach

/**
  * Created by smirakovska on 2/22/2016.
  */
class CauseAndEffectScreenTest extends UnitSpec with BeforeAndAfterEach {

  var screen: CauseAndEffectScreen = _

  test("should add background and moving actor on the stage when buildStage invoked") {
    screen = new CauseAndEffectScreen
    screen.buildStage
    assert(screen.getActors.size == 2)
    assert(screen.getActors.get(0).isInstanceOf[BackgroundActor])
    assert(screen.getActors.get(1).isInstanceOf[MovingObjectActor])
  }

  test("should add MovingObjectClickListener to actor when game level is 2 ") {
    GameState.setLevel(2)
    screen = new CauseAndEffectScreen
    screen.buildStage
    assert(screen.getActors.get(1).getListeners.get(0).isInstanceOf[MovingObjectClickListener])
  }

  test("should add MovingObjectClickListener to actor when game level is 3") {
    GameState.setLevel(3)
    screen = new CauseAndEffectScreen
    screen.buildStage
    assert(screen.getActors.get(1).getListeners.get(0).isInstanceOf[MovingObjectClickListener])
  }

  test("should add MovingObjectDragAndDropListener to actor when game level is 4 ") {
    GameState.setLevel(4)
    screen = new CauseAndEffectScreen
    screen.buildStage
    assert(screen.getActors.get(1).getListeners.get(0).isInstanceOf[MovingObjectDragAndDropListener])
  }


  override protected def afterEach(): Unit = screen.dispose
}
