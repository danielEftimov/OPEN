package org.otw.open.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{Color, GL20}
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.Disposable
import org.otw.open.actors.MenuButtonActor
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
  var themes: Map[String, Theme] = GameState.getThemeSettings

  var themesList = new ListBuffer[MenuButtonActor]()

  /** for row count */
  var index = 0

  var gridRowCount = 0

  themes.foreach(theme => {
    val actor = new MenuButtonActor(new Vector2(100 + index * 250, 600 - gridRowCount * 300), theme._1 + ".png", theme._1)
    if (gridRowCount == 2) gridRowCount = 0
    val toTheme = ToTheme
    toTheme.themeName = theme._1
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
    Gdx.gl.glClearColor(0.95f, 0.95f, 0.95f, Color.WHITE.a)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    act(delta)
    draw
  }

  /**
    * Methods to be overriden by all classes.
    */
  override def buildStage = themesList.foreach(actor => this.addActor(actor))

}
