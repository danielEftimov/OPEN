package org.otw.open.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode
import com.badlogic.gdx.graphics.g2d.{Animation, TextureAtlas, TextureRegion}
import org.otw.open.controllers.GameState
import org.otw.open.testconfig.UnitSpec

/**
  * Created by jivanovski on 1/26/2016.
  */
class AnimatorTest extends UnitSpec {

  val atlasFileName: String = "test.atlas"
  val animatorToTest = new Animator(atlasFileName)
  val atlas = new TextureAtlas(Gdx.files.internal("theme/" + GameState.getThemeName + "/" + atlasFileName))
  val animation = new Animation(1 / 5f, atlas.getRegions)

  test("test animator when timePassed for getCurrentTexture is 0") {
    val timePassed: Float = 0f
    val expectedValue: TextureRegion = animation.getKeyFrame(timePassed, true)
    val returnedValue: TextureRegion = animatorToTest.getCurrentTexture(timePassed)
    assert(assertTextureRegions(expectedValue, returnedValue)
    )
  }

  test("test animator when timePassed for getCurrentTexture is not 0") {
    val timePassed: Float = 1.56f
    val expectedValue: TextureRegion = animation.getKeyFrame(timePassed, true)
    val returnedValue: TextureRegion = animatorToTest.getCurrentTexture(timePassed)
    assert(assertTextureRegions(expectedValue, returnedValue)
    )
  }

  test("tests that dispose method is implemented") {
    assert(animatorToTest.dispose())
  }

  def assertTextureRegions(expectedValue: TextureRegion, returnedValue: TextureRegion): Boolean = {
    returnedValue.getRegionX == expectedValue.getRegionX &&
      returnedValue.getRegionY == expectedValue.getRegionY &&
      returnedValue.getRegionHeight == expectedValue.getRegionHeight &&
      returnedValue.getRegionWidth == expectedValue.getRegionWidth
  }

  test("when no argument for PlayMode is provided, the default mode should be LOOP") {
    val animator = new Animator("test.atlas")
    val animationMethod = PrivateMethod[Animation]('getAnimationObject)

    val returnedAnimation: Animation = animator invokePrivate animationMethod()

    assert(returnedAnimation.getPlayMode == PlayMode.LOOP)

  }

  test("when an argument for PlayMode is provided, the animator play mode should be the one provided") {
    val providedPlayMode: PlayMode = PlayMode.LOOP_REVERSED
    val animator = new Animator("test.atlas", providedPlayMode)
    val animationMethod = PrivateMethod[Animation]('getAnimationObject)

    val returnedAnimation: Animation = animator invokePrivate animationMethod()

    assert(returnedAnimation.getPlayMode == providedPlayMode)

  }
}
