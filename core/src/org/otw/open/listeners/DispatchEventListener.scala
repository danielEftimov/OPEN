package org.otw.open.listeners

import com.badlogic.gdx.Input
import com.badlogic.gdx.scenes.scene2d.{InputEvent, InputListener}
import org.otw.open.controllers.{Event, ScreenController}

/**
  * Created by eilievska on 2/19/2016.
  */
class DispatchEventListener(val screenChangeEvent: Event) extends InputListener {
  override def touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean = {
    if (button == Input.Buttons.LEFT)
      ScreenController.dispatchEvent(screenChangeEvent)
    true

  }
}
