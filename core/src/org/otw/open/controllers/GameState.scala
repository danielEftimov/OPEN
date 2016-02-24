package org.otw.open.controllers

import com.badlogic.gdx.Gdx
import org.otw.open.dto.Theme

import org.json4s._
import org.json4s.jackson.JsonMethods._

import scala.RuntimeException

/**
  * Created by eilievska on 2/18/2016.
  */
object GameState {

  private var themeName: String = "car_theme"

  private var level = 1

  private val jsonString: String = getStringFromJsonFile

  implicit val formats = org.json4s.DefaultFormats
  private val themeMap: Map[String, Theme] = parse(jsonString).extract[Map[String, Theme]]

  private def getStringFromJsonFile: String = {
    val inputStream = Gdx.files.internal("cause_and_effect.json").read()
    val jsonString: String = scala.io.Source.fromInputStream(inputStream).getLines().mkString(" ")
    jsonString
  }

  def getLevelStandPoints = {
    val theme: Theme = themeMap.get(themeName).orNull
    theme.levels.get(level.toString).orNull
  }

  def getLevelStartPoint = {
    val theme: Theme = themeMap.get(themeName).orNull
    theme.start_point
  }

  def setThemName(themeName: String) = this.themeName = themeName

  def getThemeName = themeName

  def getLevel = level

  def incrementLevel = if (level == 4) level = 1 else level += 1

  def nextTheme = {
    themeName = themeMap.keys.toList match {
      case themeMap :: x :: _ => x
      case _ => themeName
    }
    setLevel(1)
  }

  def setLevel(newLevel: Int) = {
    if (newLevel > 0 && newLevel < 5)
      level = newLevel
  }

  def initializeUserSettings(theme: String): Unit = {
    setThemName(theme)
  }
}
