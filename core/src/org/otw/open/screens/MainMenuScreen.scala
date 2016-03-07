package org.otw.open.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{Color, GL20}
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.Disposable
import org.otw.open.actors.MainMenuButtonActor
import org.otw.open.controllers.{GameState, ToTheme}
import org.otw.open.dto.Theme
import org.otw.open.listeners.{DispatchEventListener, ThemeChoiceListener}

import scala.collection.mutable.ListBuffer

/**
  * Created by smirakovska on 2/23/2016.
  */
class MainMenuScreen extends AbstractGameScreen with Disposable {

  /**
    * all existing themes to choose between
    */
  val themes: Map[String, Theme] = GameState.getThemeSettings

  var themesList = new ListBuffer[MainMenuButtonActor]()

  /** for row count */
  var index = 0

  var gridRowCount = 0

  themes.foreach(theme => {
    val actor = new MainMenuButtonActor(new Vector2(75 + index * 330, 550 - gridRowCount * 300), theme._1)
    if (gridRowCount == 2) gridRowCount = 0
    actor.addListener(new ThemeChoiceListener(theme._1))
    actor.addListener(new DispatchEventListener(ToTheme))
    themesList += actor
    index += 1
    if (index % 5 == 0 && index != 0) {
      gridRowCount += 1
      index = 0
    }

  })

  override def render(delta: Float): Unit = {
    Gdx.gl.glClearColor(0.90f, 0.90f, 0.90f, Color.WHITE.a)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    act(delta)
    draw
  }

  /**
    * Methods to be overriden by all classes.
    */
  override def buildStage = themesList.foreach(actor => this.addActor(actor))

}
