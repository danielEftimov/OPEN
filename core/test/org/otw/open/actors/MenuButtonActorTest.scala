package org.otw.open.actors

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.math.Vector2
import org.otw.open.testconfig.UnitSpec
import org.mockito.Matchers.any
import org.mockito.Mockito.{mock, verify}

/**
  * Created by eilievska on 2/23/2016.
  */
class MenuButtonActorTest extends UnitSpec {

  test("when draw is invoked, it should draw a texture on the specified coordinates") {
    val batch = mock(classOf[Batch])
    val position = new Vector2(0, 0)
    val imageFileName = "disabled-next-level.png"
    val button = new MenuButtonActor(position, imageFileName)
    button.draw(batch, 0f)
    verify(batch).draw(any(classOf[Texture]), org.mockito.Matchers.eq(position.x),
      org.mockito.Matchers.eq(position.y))
  }

}
