package org.otw.open.actors

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.utils.Disposable
import org.otw.open.controllers.GameState

/**
  *
  * @param backgroundName - name of the background file to be used. The file should be located in theme/{theme_name}/
  *                       resources folder.
  */
class BackgroundActor(val backgroundName: String) extends Actor with Disposable {

  private val backgroundTexture = new Texture(Gdx.files.internal("theme/" + GameState.getThemeName + "/" + backgroundName))

  override def draw(batch: Batch, parentAlpha: Float): Unit = {
    batch.draw(backgroundTexture, 0, 0)
  }

  override def dispose(): Unit = backgroundTexture.dispose()
}
