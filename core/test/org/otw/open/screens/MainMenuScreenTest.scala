package org.otw.open.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{GL20, Color}
import org.otw.open.testconfig.UnitSpec
import org.mockito.Mockito.verify

/**
  * Created by eilievska on 2/29/2016.
  */
class MainMenuScreenTest extends UnitSpec {

  test("when render is invoked in the main menu screen, it should set the background color to grey") {
    val mainManuScreen = new MainMenuScreen
    mainManuScreen.render(0.1f)
    verify(Gdx.gl).glClearColor(0.95f, 0.95f, 0.95f, Color.WHITE.a)
    verify(Gdx.gl).glClear(GL20.GL_COLOR_BUFFER_BIT)
  }

}
