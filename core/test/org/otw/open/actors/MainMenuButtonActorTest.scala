package org.otw.open.actors

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.{InputEvent, InputListener, EventListener}
import org.otw.open.testconfig.UnitSpec

import org.mockito.Mockito
import org.mockito.Matchers

import scala.ClassCastException

/**
  * Created by eilievska on 3/7/2016.
  */
class MainMenuButtonActorTest extends UnitSpec {

  test("when render of actor is invoked, it should draw on the batch") {

    val theme = "car_theme"
    val position = new Vector2(0, 0)
    val mockBatch = Mockito.mock(classOf[Batch])

    val actor = new MainMenuButtonActor(theme)
    actor.draw(mockBatch, 0.3f)
    Mockito.verify(mockBatch).draw(Matchers.any(classOf[Texture]), Matchers.eq(actor.getX), Matchers.eq(actor.getY))
  }

  test("when the enter input listener is invoked, the value of isEnter should be true") {
    val theme = "car_theme"
    val position = new Vector2(0, 0)
    val mockBatch = Mockito.mock(classOf[Batch])
    val actor = new MainMenuButtonActor(theme)
    val listener: InputListener = actor.getListeners.get(0) match {
      case x: InputListener => x
      case _ => throw new ClassCastException
    }
    listener.enter(new InputEvent, 0f, 0f, 1, actor)
    actor.draw(mockBatch, 0.3f)
    assert(actor.wasEntered)
    Mockito.verify(mockBatch).draw(Matchers.any(classOf[Texture]), Matchers.eq(actor.getX), Matchers.eq(actor.getY))
  }

  test("when the enter input listener is invoked, the value of isEnter should be false") {
    val theme = "car_theme"
    val position = new Vector2(0, 0)
    val mockBatch = Mockito.mock(classOf[Batch])
    val actor = new MainMenuButtonActor(theme)
    val listener: InputListener = actor.getListeners.get(0) match {
      case x: InputListener => x
      case _ => throw new ClassCastException
    }
    listener.exit(new InputEvent, 0f, 0f, 1, actor)
    actor.draw(mockBatch, 0.3f)
    assert(!actor.wasEntered)
    Mockito.verify(mockBatch).draw(Matchers.any(classOf[Texture]), Matchers.eq(actor.getX), Matchers.eq(actor.getY))
  }

}
