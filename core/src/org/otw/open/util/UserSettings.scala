package org.otw.open.util

/**
  * Created by deftimov on 25.02.2016.
  */
object UserSettings {

  var gameThemeNoColor: String = "false"

  var pointerSize: String = "m"

  var pointerColor: String = "white"

  def setUserSettings(gameThemeColor: String, pointerSize: String, pointerColor: String) = {
    this.gameThemeNoColor = gameThemeColor
    this.pointerSize = pointerSize
    this.pointerColor = pointerColor
  }

}
