package org.otw.open.controllers

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Pixmap
import org.otw.open.OpenGame
import org.otw.open.screens._

/**
  * Screen controller.
  * Created by eilievska on 1/28/2016.
  */
object ScreenController {

  /**
    * Switches the current game screen based on the Event type received.
    *
    * @param event - event received form screens.
    * @return the newly set screen.
    */
  def dispatchEvent(event: Event): AbstractGameScreen = {

    Gdx.graphics.setCursor(null)

    val screen: AbstractGameScreen = event match {
      case EraserGameFinished => new ActionResultScreen(true)
      case CauseAndEffectFinishedSuccessfully => new ActionResultScreen(true)
      case CauseAndEffectFinishedUnsuccessfully => new ActionResultScreen(false)
      case RetryLevel => getScreenByLevel()
      case NextLevel => GameState.incrementLevel; getScreenByLevel()
      case OtherTheme => GameState.nextTheme; getScreenByLevel()
      case ToMainMenu => GameState.setLevel(1); new EraserGameScreen
    }
    screen.buildStage()
    OpenGame.changeScreen(screen)
    screen
  }

  def getScreenByLevel(): AbstractGameScreen = {
    GameState.getLevel match {
      case 1 => new EraserGameScreen
      case 2 => new CauseAndEffectScreen
      case 3 => new CauseAndEffectScreen
      case 4 => new CauseAndEffectScreen
    }

  }

}
