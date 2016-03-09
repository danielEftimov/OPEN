package org.otw.open.screens

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.utils.Array
import org.otw.open.actors.{StaticAnimationActor, MenuButtonActor, BackgroundActor}
import org.otw.open.controllers._
import org.otw.open.listeners.DispatchEventListener
import org.otw.open.testconfig.UnitSpec
import org.scalatest.BeforeAndAfterEach

/**
  * Created by eilievska on 2/22/2016.
  */
class ActionResultScreenTest extends UnitSpec with BeforeAndAfterEach {

  test("when build stage is invoked, the stage should have 6 actors") {
    val screen = new ActionResultScreen(true)
    screen.buildStage()
    val allActors: Array[Actor] = screen.getActors
    assert(allActors.size == 6)
  }

  test("when stage is build, the first actor should be the Background Actor.") {
    val screen = new ActionResultScreen(true)
    screen.buildStage()
    val allActors: Array[Actor] = screen.getActors
    allActors.get(0) match {
      case x: BackgroundActor => assert(true)
      case _ => assert(false)
    }
  }

  test("when stage is build and level is 4, the second actor should be disabled next level button") {
    GameState.setLevel(4)
    val screen = new ActionResultScreen(true)
    screen.buildStage()
    val actor = screen.getActors.get(2) match {
      case x: MenuButtonActor => x
      case _ => throw new ClassCastException
    }
    assert(actor.getListeners.size == 0)
    assert(actor.imageFileName == "disabled-next-level.png")
    assert(actor.position.x == 722 && actor.position.y == 5)
  }

  test("when stage is build and level is NOT 4, the second actor should be next level button") {
    GameState.setLevel(2)
    val screen = new ActionResultScreen(true)
    screen.buildStage()
    val actor = screen.getActors.get(2) match {
      case x: MenuButtonActor => x
      case _ => throw new ClassCastException
    }
    assert(actor.imageFileName == "next-level.png")
    assert(actor.position.x == 722 && actor.position.y == 5)
    assert(actor.getListeners.size == 1)
    val listener = actor.getListeners.get(0) match {
      case x: DispatchEventListener => x
      case _ => throw new ClassCastException
    }
    assert(listener.screenChangeEvent == NextLevel)
  }

  test("when stage is build the third actor should be retry level button") {
    val screen = new ActionResultScreen(true)
    screen.buildStage()
    val actor = screen.getActors.get(3) match {
      case x: MenuButtonActor => x
      case _ => throw new ClassCastException
    }
    assert(actor.imageFileName == "retry-level.png")
    assert(actor.position.x == 535 && actor.position.y == 5)
    assert(actor.getListeners.size == 1)
    val listener = actor.getListeners.get(0) match {
      case x: DispatchEventListener => x
      case _ => throw new ClassCastException
    }
    assert(listener.screenChangeEvent == RetryLevel)
  }

  test("when stage is build the fourth actor should be to main menu button") {
    val screen = new ActionResultScreen(true)
    screen.buildStage()
    val actor = screen.getActors.get(4) match {
      case x: MenuButtonActor => x
      case _ => throw new ClassCastException
    }
    assert(actor.imageFileName == "to-main-menu.png")
    assert(actor.position.x == 348 && actor.position.y == 5)
    assert(actor.getListeners.size == 1)
    val listener = actor.getListeners.get(0) match {
      case x: DispatchEventListener => x
      case _ => throw new ClassCastException
    }
    assert(listener.screenChangeEvent == ToMainMenu)
  }

  test("when stage is build the fifth actor should be to other theme button") {
    val screen = new ActionResultScreen(true)
    screen.buildStage()
    val actor = screen.getActors.get(5) match {
      case x: MenuButtonActor => x
      case _ => throw new ClassCastException
    }
    assert(actor.imageFileName == "to-other-theme.png")
    assert(actor.position.x == 909 && actor.position.y == 5)
    assert(actor.getListeners.size == 1)
    val listener = actor.getListeners.get(0) match {
      case x: DispatchEventListener => x
      case _ => throw new ClassCastException
    }
    assert(listener.screenChangeEvent == OtherTheme)
  }

  test("when stage is build, and action IS SUCCESSFUL the sixth actor should be a static animation actor") {
    val screen = new ActionResultScreen(true)
    screen.buildStage()
    val actor = screen.getActors.get(1) match {
      case x: StaticAnimationActor => x
      case _ => throw new ClassCastException
    }
    assert(actor.atlasFileName == "happy-animation.atlas")
    assert(actor.position.x == 464 && actor.position.y == 194)
  }

  test("when stage is build, and action IS NOT SUCCESSFUL the sixth actor should be a static animation actor") {
    val screen = new ActionResultScreen(false)
    screen.buildStage()
    val actor = screen.getActors.get(1) match {
      case x: StaticAnimationActor => x
      case _ => throw new ClassCastException
    }
    assert(actor.atlasFileName == "unhappy-animation.atlas")
    assert(actor.position.x == 464 && actor.position.y == 194)
  }

}
