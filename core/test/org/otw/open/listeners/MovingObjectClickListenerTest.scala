package org.otw.open.listeners

import com.badlogic.gdx.scenes.scene2d.InputEvent
import org.mockito.Mockito
import org.otw.open.actors.MovingObjectActor
import org.otw.open.testconfig.UnitSpec
import org.scalatest.BeforeAndAfterEach

/**
  * Created by smirakovska on 2/22/2016.
  */
class MovingObjectClickListenerTest extends UnitSpec with BeforeAndAfterEach {

  var actor: MovingObjectActor = _

  var listener: MovingObjectClickListener = _

  override protected def beforeEach(): Unit = {
    actor = Mockito.mock(classOf[MovingObjectActor])
    listener = new MovingObjectClickListener(actor)
  }

  test("should move actor when actor not in motion") {
    Mockito.when(actor.isInMotion).thenReturn(false)
    listener.touchDown(new InputEvent(), 0, 1, 1, 1)
    Mockito.verify(actor, Mockito.times(1)).move
  }

  test("should decrement miss count when actor is on initial position") {
    Mockito.when(actor.isOnInitialPosition).thenReturn(true)
    listener.touchDown(new InputEvent(), 0, 1, 1, 1)
    Mockito.verify(actor, Mockito.times(1)).decrementMissCount
  }
}
