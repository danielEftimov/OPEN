package org.otw.open.util

/**
  * Created by deftimov on 25.02.2016.
  */
object UserSettings {

  var isBlackAndWhite: Boolean = false

  var pointerSize: String = "m"

  var pointerColor: String = "white"

  def setUserSettings(gameThemeColor: String, pointerSize: String, pointerColor: String) = {
    this.isBlackAndWhite = if (gameThemeColor == "true") true else false
    this.pointerSize = pointerSize
    this.pointerColor = pointerColor
  }

}
