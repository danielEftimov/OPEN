package org.otw.open.dto

/**
  * Created by deftimov on 18.02.2016.
  * UserSetting handler
  */
case object UserSettings {

  var pointerType: String = "hand"

  var pointerSize: String = "medium"

  var pointerSpeed: String = "normal"

  var pointerColor: String = "white"

  var gameThemeColor: String = "color"

  /**
    * sets user setting based on the parameters passed
    *
    * @param pointerType
    * @param pointerSize
    * @param gameThemeColor
    */
  def setUserSettings(pointerType: String, pointerSize: String, pointerSpeed: String, pointerColor: String, gameThemeColor: String): Unit = {
    this.pointerType = pointerType
    this.pointerSize = pointerSize
    this.pointerSpeed = pointerSpeed
    this.pointerColor = pointerColor
    this.gameThemeColor = gameThemeColor
  }
}
