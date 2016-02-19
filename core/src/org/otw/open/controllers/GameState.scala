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

  private var level = 3

  def getLevelStandPoints = {
    val theme: Theme = themeMap.get(themeName).orElse(throw new RuntimeException).get
    theme.levels.get(level.toString).get
  }

  def getLevelStartPoint = {
    val theme: Theme = themeMap.get(themeName).orElse(throw new RuntimeException).get
    theme.start_point
  }

  private val jsonString: String = getStringFromJsonFile

  implicit val formats = org.json4s.DefaultFormats
  val themeMap: Map[String, Theme] = parse(jsonString).extract[Map[String, Theme]]

  private def getStringFromJsonFile: String = {
    val inputStream = Gdx.files.internal("cause_and_effect.json").read()
    val jsonString: String = scala.io.Source.fromInputStream(inputStream).getLines().mkString(" ")
    jsonString
  }

  def getThemeName = themeName

  def getLevel = level

}
