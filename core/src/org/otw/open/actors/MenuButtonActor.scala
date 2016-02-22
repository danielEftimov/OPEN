package org.otw.open.actors

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.{Actor, Touchable}

/**
  * Created by eilievska on 2/19/2016.
  */
class MenuButtonActor(val position: Vector2, val imageFileName: String) extends Actor {

  setTouchable(Touchable.enabled)

  private val imageText = new Texture(Gdx.files.internal(imageFileName))

  setX(position.x)
  setY(position.y)
  setWidth(imageText.getWidth)
  setHeight(imageText.getHeight)
  setBounds(getX, getY, getWidth, getHeight)

  override def draw(batch: Batch, parentAlpha: Float): Unit = {
    batch.draw(imageText, getX, getY)
  }

}
