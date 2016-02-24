package org.otw.open.actors

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.graphics.Pixmap.Blending
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.{Pixmap, Texture}
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.{Actor, InputEvent, InputListener}
import com.badlogic.gdx.utils.Disposable
import org.otw.open.controllers.{GameState, EraserGameFinished, ScreenController}
import org.otw.open.dto.DrawablePixmap
import org.otw.open.util.AudioManager

/**
  * Created by eilievska on 2/12/2016.
  */
class ErasableImageActor extends Actor with Disposable {

  /** wrapper for drawing actions */
  private val pixmapMask: DrawablePixmap = new DrawablePixmap(new Pixmap(Gdx.files.internal("theme/" + GameState.getThemeName + "/mask.png")))

  /** Texture under The Mask Texture */
  private val maskTexture: Texture = pixmapMask.initializePixmapDrawingOntoTexture

  Pixmap.setBlending(Blending.None)

  private var lastPointerPosition: Option[Vector2] = None

  private var currentPointerPosition: Option[Vector2] = None

  setX(0)

  setY(0)

  setWidth(maskTexture.getWidth)

  setHeight(maskTexture.getHeight)

  setBounds(0, 0, getWidth, getHeight)

  /** Sound instance for audio guidance */
  private val audio = AudioManager("audioGuidanceEraserGame.mp3")
  audio.getAudio.play()

  override def draw(batch: Batch, parentAlpha: Float): Unit = {
    val mouseWasMoved: Boolean = lastPointerPosition.isDefined && lastPointerPosition.orNull != currentPointerPosition.orNull
    if (mouseWasMoved) {
      pixmapMask.drawLerped(lastPointerPosition.orNull, currentPointerPosition.orNull)
      pixmapMask.drawOnTexture(maskTexture)
      if (pixmapMask.isTransparent) ScreenController.dispatchEvent(EraserGameFinished)
    }
    lastPointerPosition = currentPointerPosition
    batch.draw(maskTexture, 0, 0)
  }

  addListener(new InputListener() {
    override def mouseMoved(event: InputEvent, x: Float, y: Float) = {
      audio.getAudio.isPlaying match {
        case true => false
        case false =>
          currentPointerPosition = Some(new Vector2(x, 900 - y))
          true
      }
    }
  })

  override def dispose(): Unit = {
    pixmapMask.dispose()
    maskTexture.dispose()
    audio.getAudio.dispose()
  }
}
