package org.otw.open.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Pixmap
import org.otw.open.actors.{BackgroundActor, ErasableImageActor}

/**
  * Created by eilievska on 2/12/2016.
  */
class EraserGameScreen() extends AbstractGameScreen {

  private val clickCursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("eraser-3.png")), 25, 50)
  Gdx.graphics.setCursor(clickCursor)

  override def buildStage(): Unit = {
    addActor(new BackgroundActor("dark-background.png"))
    addActor(new ErasableImageActor)
  }
}
