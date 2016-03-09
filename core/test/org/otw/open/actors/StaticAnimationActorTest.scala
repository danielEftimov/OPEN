package org.otw.open.actors

import com.badlogic.gdx.graphics.g2d.Animation.PlayMode
import com.badlogic.gdx.graphics.g2d.{Animation, Batch, TextureRegion}
import com.badlogic.gdx.math.Vector2
import org.mockito.Matchers._
import org.mockito.Mockito._
import org.otw.open.testconfig.UnitSpec
import org.otw.open.util.Animator

/**
  * Created by eilievska on 2/23/2016.
  */
class StaticAnimationActorTest extends UnitSpec {

  test("when draw is invoked, it should draw a texture on the specified coordinates") {
    val batch = mock(classOf[Batch])
    val position = new Vector2(0, 0)
    val atlasFileName = "test.atlas"
    val animationActor = new StaticAnimationActor(position, atlasFileName)
    animationActor.draw(batch, 0f)
    verify(batch).draw(any(classOf[TextureRegion]), org.mockito.Matchers.eq(position.x),
      org.mockito.Matchers.eq(position.y))
  }

  test("when \"unhappy-animation.atlas\" is provided as an argument, the animation play mode should be LOOP_PINGPONG") {
    val actor = new StaticAnimationActor(new Vector2(0, 0), "unhappy-animation.atlas")
    val getAnimator = PrivateMethod[Animator]('getAnimatorObject)
    val animator: Animator = actor invokePrivate getAnimator()

    val animationMethod = PrivateMethod[Animation]('getAnimationObject)

    val returnedAnimation: Animation = animator invokePrivate animationMethod()
    assert(returnedAnimation.getPlayMode == PlayMode.LOOP_PINGPONG)
  }

  test("when any atlas file name is provided not equal to \"unhappy-animation.atlas\", the animation play mode should be LOOP") {
    val actor = new StaticAnimationActor(new Vector2(0, 0), "test.atlas")
    val getAnimator = PrivateMethod[Animator]('getAnimatorObject)
    val animator: Animator = actor invokePrivate getAnimator()

    val animationMethod = PrivateMethod[Animation]('getAnimationObject)

    val returnedAnimation: Animation = animator invokePrivate animationMethod()
    assert(returnedAnimation.getPlayMode == PlayMode.LOOP)
  }

}
