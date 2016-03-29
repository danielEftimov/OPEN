package org.otw.open

import com.badlogic.gdx.{Game, Gdx, Preferences, Screen}
import org.otw.open.screens.MainMenuScreen
import org.otw.open.util.UserSettings

/**
  * Created by eilievska on 1/13/2016.
  */
class OpenGame private() extends Game {

  override def create(): Unit = {
    val screen1 = new MainMenuScreen
    screen1.buildStage()
    setScreen(screen1)
  }


}

/**
  * A singleton object containing an instance of our game.
  */
object OpenGame {
  private lazy val game = new OpenGame

  /**
    *
    * @return our Game instance.
    */
  def getGame: OpenGame = game

  /**
    *
    * Sets a new screen to our game.
    *
    * @param newScreen -  a new screen for our game.
    * @return the current (newly added) screen in the game.
    */
  def changeScreen(newScreen: Screen): Screen = {
    game.setScreen(newScreen)
    game.getScreen
  }

}
