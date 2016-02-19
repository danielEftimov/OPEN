package org.otw.open.screens

import org.otw.open.actors.{BackgroundActor, ErasableImageActor}

/**
  * Created by eilievska on 2/12/2016.
  */
class EraserGameScreen() extends AbstractGameScreen {

  override def buildStage(): Unit = {
    addActor(new BackgroundActor("dark-background.png"))
    addActor(new ErasableImageActor)
  }
}
