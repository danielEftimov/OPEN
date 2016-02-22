package org.otw.open.listeners

import com.badlogic.gdx.scenes.scene2d.InputEvent
import org.mockito.Mockito
import org.otw.open.actors.MovingObjectActor
import org.otw.open.testconfig.UnitSpec
import org.scalatest.BeforeAndAfterEach

/**
  * Created by smirakovska on 2/22/2016.
  */
class MovingObjectSceneListenerTest extends UnitSpec with BeforeAndAfterEach {

  var actor: MovingObjectActor = _

  var listener: MovingObjectSceneListener = _

  override protected def beforeEach(): Unit = {
    actor = Mockito.mock(classOf[MovingObjectActor])
    listener = new MovingObjectSceneListener(actor)
  }

  test("should increment miss count when actor not in motion") {
    Mockito.when(actor.isInMotion).thenReturn(false)
    listener.touchDown(new InputEvent(), 0, 1, 1, 1)
    Mockito.verify(actor, Mockito.times(1)).incrementMissCount
  }

  test("should not increment miss count when actor is in motion") {
    Mockito.when(actor.isInMotion).thenReturn(true)
    listener.touchDown(new InputEvent(), 0, 1, 1, 1)
    Mockito.verify(actor, Mockito.times(0)).incrementMissCount
  }
}
