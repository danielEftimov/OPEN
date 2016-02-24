package org.otw.open.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Pixmap
import org.otw.open.actors.{BackgroundActor, ErasableImageActor}
import org.otw.open.controllers.GameState

/**
  * Created by eilievska on 2/12/2016.
  */
class EraserGameScreen() extends AbstractGameScreen {

  private val cursorPixmap: Pixmap = new Pixmap(Gdx.files.internal("theme/" + GameState.getThemeName + "/eraser-3.png"))
  private val clickCursor = Gdx.graphics.newCursor(cursorPixmap, 25, 50)
  val backgroundActor: BackgroundActor = new BackgroundActor("dark-background.png")
  val erasableImageActor: ErasableImageActor = new ErasableImageActor

  Gdx.graphics.setCursor(clickCursor)

  override def buildStage(): Unit = {
    addActor(backgroundActor)
    addActor(erasableImageActor)
  }

  override def dispose(): Unit = {
    cursorPixmap.dispose()
    backgroundActor.dispose()
    erasableImageActor.dispose()
  }
}
