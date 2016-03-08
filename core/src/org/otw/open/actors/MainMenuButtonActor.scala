package org.otw.open.actors

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.{Actor, InputEvent, InputListener}
import com.badlogic.gdx.utils.Disposable
import org.otw.open.controllers.GameState

/**
  * Created by eilievska on 3/7/2016.
  */
class MainMenuButtonActor(val position: Vector2, val theme: String) extends Actor with Disposable {

  private val imageText = new Texture(Gdx.files.internal("theme/" + theme + "/" + theme + ".png"))
  private val imageWithShadow = new Texture(Gdx.files.internal("theme/" + theme + "/" + theme + "_sh.png"))
  private var isEntered = false

  setX(position.x)
  setY(position.y)
  setWidth(imageText.getWidth)
  setHeight(imageText.getHeight)
  setBounds(getX, getY, getWidth, getHeight)

  override def draw(batch: Batch, parentAlpha: Float): Unit = {
    if (isEntered) batch.draw(imageWithShadow, getX, getY)
    else batch.draw(imageText, getX, getY)
  }

  override def dispose(): Unit = {
    imageText.dispose
    imageWithShadow.dispose()
  }

  def wasEntered = isEntered

  addListener(new InputListener() {
    override def enter(event: InputEvent, x: Float, y: Float, pointer: Int, fromActor: Actor): Unit = isEntered = true

    override def exit(event: InputEvent, x: Float, y: Float, pointer: Int, toActor: Actor): Unit = isEntered = false
  })

}
