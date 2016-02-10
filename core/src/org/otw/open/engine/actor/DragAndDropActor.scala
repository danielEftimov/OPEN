package org.otw.open.engine.actor

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.utils.Disposable
import org.otw.open.engine.util.Animator

/**
  * Created by smirakovska on 2/9/2016.
  *
  * @param theme             - path to object's atlas file
  * @param imgBackgroundPath - path to background's image file
  * @param startingX         - starting x coordinate
  * @param startingY         - starting y coordinate
  */
class DragAndDropActor(val theme: String, val imgBackgroundPath: String, val startingX: Float, val startingY: Float) extends Actor with Disposable {

  /**
    * Elapsed time between frames
    */
  private var timePassed: Float = 0

  /**
    * Animator object
    */
  private val animator: Animator = new Animator("theme/" + theme + "/animation-object.atlas")

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
  setBounds(getX, getY, animator.getCurrentTexture(timePassed).getRegionWidth, animator.getCurrentTexture(timePassed).getRegionHeight)

  override def draw(batch: Batch, alpha: Float): Unit = {
    batch.draw(backgroundTexture, 0, 0)
    timePassed += Gdx.graphics.getRawDeltaTime
    batch.draw(animator.getCurrentTexture(timePassed), getX, getY)
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
    animator.dispose
    backgroundTexture.dispose
  }
}
