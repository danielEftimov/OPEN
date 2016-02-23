package org.otw.open.actors

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import org.mockito.Matchers.any
import org.mockito.Mockito.{mock, verify}
import org.otw.open.testconfig.UnitSpec

/**
  * Created by eilievska on 2/23/2016.
  */
class BackgroundActorTest extends UnitSpec {

  test("when draw method is invoked, it should draw the background texture on coordinates 0, 0") {
    val batch = mock(classOf[Batch])
    val backgroundName = "dark-background.png"
    val actor = new BackgroundActor(backgroundName)
    actor.draw(batch, 0f)
    verify(batch).draw(any(classOf[Texture]), org.mockito.Matchers.eq(0f), org.mockito.Matchers.eq(0f))
  }

}
