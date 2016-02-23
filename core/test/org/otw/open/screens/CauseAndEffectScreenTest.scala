package org.otw.open.screens

import org.otw.open.actors.{BackgroundActor, MovingObjectActor}
import org.otw.open.controllers.GameState
import org.otw.open.testconfig.UnitSpec

/**
  * Created by smirakovska on 2/22/2016.
  */
class CauseAndEffectScreenTest extends UnitSpec {

  var screen: CauseAndEffectScreen = _

  test("should add background and moving actor on the stage when buildStage invoked") {
    GameState.setLevel(2)
    screen = new CauseAndEffectScreen
    screen.buildStage
    assert(screen.getActors.size == 2)
    assert(screen.getActors.get(0).isInstanceOf[BackgroundActor])
    assert(screen.getActors.get(1).isInstanceOf[MovingObjectActor])
    screen.dispose
  }
}
