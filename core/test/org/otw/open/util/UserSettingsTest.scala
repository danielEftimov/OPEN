package org.otw.open.util

import org.otw.open.testconfig.UnitSpec

/**
  * Created by smirakovska on 2/29/2016.
  */
class UserSettingsTest extends UnitSpec {

  test("should set user setting when setUserSettings is invoked for black and white theme") {
    UserSettings.setUserSettings("true", "s", "green")
    assert(UserSettings.pointerSize == "s")
    assert(UserSettings.isBlackAndWhite == true)
    assert(UserSettings.pointerColor == "green")
  }


  test("should set user setting when setUserSettings is invoked for coloured theme") {
    UserSettings.setUserSettings("false", "s", "green")
    assert(UserSettings.isBlackAndWhite == false)
  }


}
