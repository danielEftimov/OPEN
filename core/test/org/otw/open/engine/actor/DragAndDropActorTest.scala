package org.otw.open.engine.actor

import org.otw.open.testconfig.UnitSpec
import org.scalatest.BeforeAndAfterEach

/**
  * Created by smirakovska on 2/10/2016.
  */
class DragAndDropActorTest extends UnitSpec with BeforeAndAfterEach {

  private val theme = "car_theme"

  private val imgBackgroundPath = "test.png"

  private val xStart = 0
  private val yStart = 0

  private var actor: DragAndDropActor = _

  override def beforeEach(): Unit = {
    actor = new DragAndDropActor(theme, imgBackgroundPath, xStart, yStart)
  }

  test("when resetPosition is invoked should reset x and y coordinates") {
    actor.setX(50)
    actor.setY(50)
    actor.resetPosition
    assert(actor.getX == xStart && actor.getY == yStart)
  }

  override def afterEach(): Unit = {
    actor.dispose
  }
}
