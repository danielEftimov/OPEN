package org.otw.open.listeners

import com.badlogic.gdx.scenes.scene2d.InputEvent
import org.mockito.Mockito
import org.otw.open.actors.MovingObjectActor
import org.otw.open.controllers.GameState
import org.otw.open.testconfig.UnitSpec
import org.scalatest.BeforeAndAfterEach

/**
  * Created by smirakovska on 2/22/2016.
  */
class MovingObjectDragAndDropListenerTest extends UnitSpec with BeforeAndAfterEach {

  var actor: MovingObjectActor = _

  var listener: MovingObjectDragAndDropListener = _

  override protected def beforeEach(): Unit = {
    GameState.setLevel(3)
    actor = Mockito.mock(classOf[MovingObjectActor])
    listener = new MovingObjectDragAndDropListener(actor)
  }

  test("should change actor's x and y coordinates when actor is dragged on the screen") {
    listener.drag(new InputEvent(), 50, 50, 1)
    Mockito.verify(actor).moveBy(50 - actor.getWidth / 2, 50 - actor.getHeight / 2)
  }

  test("should reset actor's position and increment miss count when actor is not dragged to destination") {
    Mockito.when(actor.getX).thenReturn(0)
    Mockito.when(actor.getY).thenReturn(0)
    listener.dragStop(new InputEvent(), 0, 0, 1)
    Mockito.verify(actor, Mockito.times(1)).resetPosition
    Mockito.verify(actor, Mockito.times(1)).incrementMissCount
  }

  override protected def afterEach(): Unit = {
    actor.dispose
  }
}
