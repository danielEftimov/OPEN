package org.otw.open.listeners

import com.badlogic.gdx.{Screen, Input}
import com.badlogic.gdx.scenes.scene2d.InputEvent
import org.mockito.Mockito.mock
import org.otw.open.OpenGame
import org.otw.open.controllers.CauseAndEffectFinishedSuccessfully
import org.otw.open.screens.ActionResultScreen
import org.otw.open.testconfig.UnitSpec

/**
  * Created by eilievska on 2/22/2016.
  */
class DispatchEventListenerTest extends UnitSpec {

  test("when touchDown event is received and button is Input.Buttons.LEFT, then an event should be dispatched to the screen controller") {
    val listener = new DispatchEventListener(CauseAndEffectFinishedSuccessfully)
    val inputEvent = mock(classOf[InputEvent])
    listener.touchDown(inputEvent, 0f, 0f, 1, Input.Buttons.LEFT)
    assert(OpenGame.getGame.getScreen.isInstanceOf[ActionResultScreen])
  }

  test("when touchDown event is received and button is NOT Input.Buttons.LEFT, then the screen should not be changed") {
    val screen: Screen = OpenGame.getGame.getScreen
    val listener = new DispatchEventListener(CauseAndEffectFinishedSuccessfully)
    val inputEvent = mock(classOf[InputEvent])
    listener.touchDown(inputEvent, 0f, 0f, 1, Input.Buttons.RIGHT)
    assert(OpenGame.getGame.getScreen == screen)
  }
}
