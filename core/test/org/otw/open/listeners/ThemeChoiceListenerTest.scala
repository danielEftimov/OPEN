package org.otw.open.listeners

import com.badlogic.gdx.scenes.scene2d.{Actor, InputEvent}
import org.mockito.Mockito
import org.otw.open.controllers.GameState
import org.otw.open.testconfig.UnitSpec
import org.scalatest.BeforeAndAfterEach


/**
  * Created by smirakovska on 2/25/2016.
  */
class ThemeChoiceListenerTest extends UnitSpec with BeforeAndAfterEach {

  val actor: Actor = Mockito.mock(classOf[Actor])
  val event = Mockito.mock(classOf[InputEvent])
  val newTheme = "car_theme"

  test("should set new theme when touch down is invoked") {
    val listener = new ThemeChoiceListener(newTheme)
    listener.touchDown(event, 0, 0, 1, 1)
    assert(GameState.getThemeName.equals(newTheme))
    assert(GameState.getLevel == 1)
  }

}
