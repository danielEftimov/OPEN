package org.otw.open.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{GL20, Color}
import org.otw.open.testconfig.UnitSpec
import org.mockito.Mockito.verify

/**
  * Created by eilievska on 2/22/2016.
  */
class AbstractGameScreenTest extends UnitSpec {

  val screen = new AbstractGameScreen {

    /**
      * Methods to be overriden by all classes.
      */
    override def buildStage(): Unit = {

    }
  }

  test("when render is invoked, the screen should be cleared") {
    screen.render(0.3f)
    verify(Gdx.gl).glClearColor(Color.WHITE.r, Color.WHITE.g, Color.WHITE.b, Color.WHITE.a)
    verify(Gdx.gl).glClear(GL20.GL_COLOR_BUFFER_BIT)
  }

}
