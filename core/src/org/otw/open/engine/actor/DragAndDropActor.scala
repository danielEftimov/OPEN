package org.otw.open.engine.actor

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{TextureRegion, Batch}
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.utils.Disposable

/**
  * Created by smirakovska on 2/9/2016.
  *
  * @param imgObjectPath - path to object's image file
  * @param imgBackgroundPath - path to background's image file
  * @param startingX - starting x coordinate
  * @param startingY - starting y coordinate
  */
class DragAndDropActor(val imgObjectPath: String, val imgBackgroundPath: String, val startingX: Float, val startingY: Float) extends Actor with Disposable {

  /**
    * Moving object texture
    */
  val texture: Texture = new Texture(Gdx.files.internal(imgObjectPath))

  /**
    * The background texture where the object moves on.
    */
  private val backgroundTexture = new Texture(Gdx.files.internal(imgBackgroundPath))

  /**
    * set starting X coordinate
    */
  setX(startingX)

  /**
    * set starting Y coordinate
    */
  setY(startingY)
  setBounds(getX, getY, texture.getWidth, texture.getHeight)

  override def draw(batch: Batch, alpha: Float): Unit = {
    val region = new TextureRegion(texture,0,168,432,115)
    batch.draw(backgroundTexture, 0, 0)
    batch.draw(region, getX, getY)
  }

  /**
    * Reset object's position to initial coordinates
    */
  def resetPosition() {
    setX(startingX)
    setY(startingY)
    setBounds(getX, getY, getWidth, getHeight)
  }

  /**
    * Dispose resources
    */
  override def dispose(): Unit = {
    texture.dispose
    backgroundTexture.dispose
  }
}
