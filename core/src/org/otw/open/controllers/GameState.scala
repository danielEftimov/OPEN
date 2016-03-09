package org.otw.open.controllers

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Vector2
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.otw.open.dto.{Point, Theme}
import org.otw.open.util.UserSettings

/**
  * Created by eilievska on 2/18/2016.
  * Handles global game state
  */
object GameState {
  /** game theme name */
  private var themeName: String = "car_theme"

  /** level of the game */
  private var level = 1

  /** Game settings Json */
  private val jsonGameSettings: String = getGameSettingsFromJson

  /** Json string format */
  implicit val formats = org.json4s.DefaultFormats

  /** Game settings */
  private var gameSettings: Map[String, Theme] = parse(jsonGameSettings).extract[Map[String, Theme]]

  gameSettings = filterThemes(gameSettings)

  /**
    * Filters theme names
    * based on user settings for theme color
    *
    * @param themes
    * @return theme names
    */
  def filterThemes(themes: Map[String, Theme]): Map[String, Theme] = {
    if (UserSettings.isBlackAndWhite)
      themes.filter(themeName => themeName._1.endsWith("_bw"))
    else
      themes.filter(themeName => !themeName._1.endsWith("_bw"))
  }

  /**
    * Parses Json for game settings
    *
    * @return json formatted string
    */
  private def getGameSettingsFromJson: String = {
    val inputStream = Gdx.files.internal("cause_and_effect.json").read()
    val parsedGameSettings: String = scala.io.Source.fromInputStream(inputStream).getLines().mkString(" ")
    parsedGameSettings
  }

  /**
    * @return Game's objects coordinates for the given theme and level
    */
  def getLevelStandPoints = {
    val theme: Theme = gameSettings.get(themeName).orNull
    theme.levels.get(level.toString).orNull
  }

  /**
    *
    * @return Game's objects starting coordinates for the given theme and level
    */
  def getLevelStartPoint = {
    val theme: Theme = gameSettings.get(themeName).orNull
    theme.start_point
  }

  def getResultAnimationStandPoint: Vector2 = {
    val theme: Theme = gameSettings.get(themeName).orNull
    val point: Point = theme.result_animation_point
    new Vector2(point.x, point.y)
  }

  /**
    * Sets the theme on level one
    *
    * @param themeName
    */
  def setThemeOnLevelOne(themeName: String) = {
    this.themeName = themeName
    setLevel(1)
  }

  def getThemeSettings = gameSettings

  def setThemName(themeName: String) = this.themeName = themeName

  def getThemeName = themeName

  def getLevel = level

  def setLevel(newLevel: Int) = {
    if (newLevel > 0 && newLevel < 5)
      level = newLevel
  }

  def incrementLevel = if (level == 4) level = 1 else level += 1

  /**
    * initializes the next theme and sets it on level one
    *
    */
  def setNextTheme = {
    themeName = gameSettings.keys.toList match {
      case themeMap :: x :: _ => x
      case _ => themeName
    }
    setLevel(1)
  }

}
