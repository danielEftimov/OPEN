package org.otw.open.actors

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.utils.Disposable
import org.otw.open.controllers.GameState

/**
  * Created by eilievska on 2/12/2016.
  */
class BackgroundActor extends Actor with Disposable {

  private val backgroundTexture = new Texture(Gdx.files.internal("theme/" + GameState.getThemeName + "/light-background.png"))

  override def draw(batch: Batch, parentAlpha: Float): Unit = {
    batch.draw(backgroundTexture, 0, 0)
  }

  override def dispose(): Unit = backgroundTexture.dispose()
}
