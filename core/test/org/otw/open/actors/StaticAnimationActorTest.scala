package org.otw.open.actors

import com.badlogic.gdx.graphics.g2d.{Batch, TextureRegion}
import com.badlogic.gdx.math.Vector2
import org.mockito.Matchers._
import org.mockito.Mockito._
import org.otw.open.testconfig.UnitSpec

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

}
