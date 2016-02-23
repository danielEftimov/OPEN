package org.otw.open.screens

import com.badlogic.gdx.{Gdx, Screen}
import com.badlogic.gdx.graphics.{GL20, Color, OrthographicCamera}
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.StretchViewport

/**
  * Created by eilievska on 2/12/2016.
  */
abstract class AbstractGameScreen extends Stage(new StretchViewport(1440, 900, new OrthographicCamera())) with Screen {

  override def render(delta: Float): Unit = {
    Gdx.gl.glClearColor(Color.WHITE.r, Color.WHITE.g, Color.WHITE.b, Color.WHITE.a)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    act(delta)
    draw
  }

  /**
    * Methods to be overriden by all classes.
    */
  def buildStage()

  override def resize(width: Int, height: Int) = getViewport.update(width, height)

  override def hide(): Unit = {
  }

  override def pause(): Unit = {
  }

  override def show(): Unit = Gdx.input.setInputProcessor(this)

  override def resume(): Unit = {
  }
}
