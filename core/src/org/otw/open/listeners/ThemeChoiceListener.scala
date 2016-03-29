package org.otw.open.listeners

import com.badlogic.gdx.scenes.scene2d.{Actor, InputEvent, InputListener}
import org.otw.open.controllers.GameState

/**
  * Created by smirakovska on 2/24/2016.
  */
class ThemeChoiceListener(themeName: String) extends InputListener {

  override def touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean = {
    GameState.setThemeOnLevelOne(themeName)
    true
  }


}
