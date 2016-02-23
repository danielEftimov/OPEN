package org.otw.open.actors

import com.badlogic.gdx.Screen
import org.otw.open.OpenGame
import org.otw.open.controllers.GameState
import org.otw.open.screens.{AbstractGameScreen, ActionResultScreen, CauseAndEffectScreen}
import org.otw.open.testconfig.UnitSpec
import org.scalatest.BeforeAndAfterEach

/**
  * Created by smirakovska on 2/19/2016.
  */
class MovingObjectActorTest extends UnitSpec with BeforeAndAfterEach {

  var actor: MovingObjectActor = _

  override protected def beforeEach(): Unit = {

    GameState.setLevel(3)
    actor = new MovingObjectActor
  }

  test("isOnInitialPosition should return true when actor in initial state") {
    assert(actor.isOnInitialPosition)
  }

  test("isInMotion should return false when actor in initial state") {
    assert(!actor.isInMotion)
  }

  test("actorFinishedAllActions should return false when actor in initial state") {
    assert(!actor.actorFinishedAllActions)
  }

  test("incrementMissCount should increment missedCount for actor") {
    actor.incrementMissCount
    assert(actor.getObjectMissCount == 1)
  }

  test("decrementMissCount should increment missedCount for actor") {
    actor.incrementMissCount
    actor.incrementMissCount
    actor.decrementMissCount
    assert(actor.getObjectMissCount == 1)
  }

  test("isInMotion should return true is actor is moving") {
    actor.setX(30)
    assert(actor.isInMotion)
  }

  test("actorFinishedAllActions should return true when actor in end state and was moved 3 times") {
    actor.setX(1000)
    actor.move
    actor.move
    actor.move
    assert(actor.actorFinishedAllActions)
  }

  test("Unhappy animation should be shown when actor was missed 3 times") {

    actor.incrementMissCount
    actor.incrementMissCount
    actor.incrementMissCount

    val screen = OpenGame.getGame.getScreen match {
      case x: ActionResultScreen => Some(x)
      case _ => None
    }

    assert(screen.isDefined)
    assert(screen.get.isSuccessfulAction == false)
  }

  def getGameScreen(screen: Screen) = screen match {
    case x: AbstractGameScreen => x
    case _ => throw new ClassCastException
  }

  override protected def afterEach(): Unit = actor.dispose
}
