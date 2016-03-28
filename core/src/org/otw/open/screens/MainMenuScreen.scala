package org.otw.open.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.graphics.{Color, GL20, Texture}
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.ScrollPaneStyle
import com.badlogic.gdx.scenes.scene2d.ui.{ScrollPane, Table}
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.Disposable
import org.otw.open.actors.MainMenuButtonActor
import org.otw.open.controllers.{GameState, ToTheme}
import org.otw.open.dto.Theme
import org.otw.open.listeners.{DispatchEventListener, ThemeChoiceListener}

import scala.collection.mutable.ListBuffer

/**
  * Class for the main menu screen
  */
class MainMenuScreen extends AbstractGameScreen with Disposable {

  val WINDOW_WIDTH: Float = 900 - 80
  val WINDOW_HEIGHT: Float = 900
  val CELL_WIDTH: Float = 300
  val MAX_ROWS_ON_SCREEN: Int = 3

  /**
    * all existing themes to choose from
    */
  val themes: Map[String, Theme] = GameState.getThemeSettings

  var themesList = new ListBuffer[MainMenuButtonActor]()

  /**
    * Counter for number of themes in a row
    */
  var index = 0

  /**
    * Texture for the scroll bar
    */
  val texture: Texture = new Texture(Gdx.files.internal("scroll/scrollbar.png"))

  /**
    * Setting style for ScrollPane
    */
  val scrollStyle = new ScrollPaneStyle
  scrollStyle.vScroll = new TextureRegionDrawable(new TextureRegion(texture))
  scrollStyle.vScrollKnob = new TextureRegionDrawable(new TextureRegion(texture))

  /**
    * Table with all themes that will be scrolled
    */
  var scrollableTable: Table = new Table
  scrollableTable.setWidth(WINDOW_WIDTH)
  scrollableTable.setHeight(WINDOW_HEIGHT)

  /**
    * Scroll pane for the scrolling table
    */
  val scrollPane: ScrollPane = new ScrollPane(scrollableTable)

  /**
    * Table will only be scrolled vertically
    */
  scrollPane.setScrollingDisabled(true, false)
  scrollPane.setWidth(WINDOW_WIDTH)
  scrollPane.setHeight(WINDOW_HEIGHT)
  scrollPane.setStyle(scrollStyle)

  themes.foreach(theme => {
    val actor = new MainMenuButtonActor(theme._1)
    actor.addListener(new ThemeChoiceListener(theme._1))
    actor.addListener(new DispatchEventListener(ToTheme))
    themesList += actor
    scrollableTable.add(actor).width(CELL_WIDTH)
      .spaceTop(20)
      .spaceLeft(20) //Padding between images to the left of this one
      .spaceRight(20)
      .center()
    index += 1
    if (index % 4 == 0 && index != 0) {
      index = 0
      scrollableTable.row
    }
  })

  /**
    * needed to end the last row
    */
  scrollableTable.row()


  override def render(delta: Float): Unit = {
    Gdx.gl.glClearColor(0.90f, 0.90f, 0.90f, Color.WHITE.a)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    act(delta)
    draw
  }

  /**
    * Methods to be overriden by all classes.
    */
  override def buildStage = {
    val table: Table = new Table
    table.setBounds(0, 0, Gdx.graphics.getWidth, Gdx.graphics.getHeight)
    scrollPane.setFillParent(true)
    table.add(scrollPane).fill().expand()
    table.setFillParent(true)
    this.addActor(table)
  }

}
