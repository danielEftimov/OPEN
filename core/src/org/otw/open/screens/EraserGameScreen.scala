package org.otw.open.screens

import com.badlogic.gdx.scenes.scene2d.Actor
import org.otw.open.actors.{ErasableImageActor, BackgroundActor}

/**
  * Created by eilievska on 2/12/2016.
  */
class EraserGameScreen() extends AbstractGameScreen {

  override def buildStage(): Unit = {
    addActor(new BackgroundActor)
    addActor(new ErasableImageActor)
  }
}
