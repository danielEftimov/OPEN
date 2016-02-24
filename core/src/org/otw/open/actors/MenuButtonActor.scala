package org.otw.open.actors

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.{Actor, Touchable}
import org.otw.open.controllers.GameState
import com.badlogic.gdx.utils.Disposable

/**
  * Created by eilievska on 2/19/2016.
  */
class MenuButtonActor(val position: Vector2, val imageFileName: String) extends Actor with Disposable {

  setTouchable(Touchable.enabled)

  private val imageText = new Texture(Gdx.files.internal("theme/" + GameState.getThemeName + "/" + imageFileName))

  setX(position.x)
  setY(position.y)
  setWidth(imageText.getWidth)
  setHeight(imageText.getHeight)
  setBounds(getX, getY, getWidth, getHeight)

  override def draw(batch: Batch, parentAlpha: Float): Unit = {
    batch.draw(imageText, getX, getY)
  }

  override def dispose(): Unit = imageText.dispose
}
