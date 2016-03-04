package org.otw.open.controllers

import com.badlogic.gdx.graphics.Pixmap
import com.badlogic.gdx.{Gdx, Screen}
import org.otw.open.OpenGame
import org.otw.open.screens._
import org.otw.open.util.UserSettings

/**
  * Screen controller.
  * Created by eilievska on 1/28/2016.
  */
object ScreenController {

  /**
    * Cursor pixmap.
    */
  private val clickCursor = UserSettings.pointerSize match {
    case "s" => Gdx.graphics.newCursor(getCursorPixmap, 26, 4)
    case "m" => Gdx.graphics.newCursor(getCursorPixmap, 52, 7)
    //case "l" => Gdx.graphics.newCursor(getCursorPixmap, 104, 15)
  }

  /**
    * Switches the current game screen based on the Event type received.
    *
    * @param event - event received form screens.
    * @return the newly set screen.
    */
  def dispatchEvent(event: Event): AbstractGameScreen = {

    setUpCursor()

    val currentScreen: Screen = OpenGame.getGame.getScreen

    val screen: AbstractGameScreen = event match {
      case EraserGameFinished => new ActionResultScreen(true)
      case CauseAndEffectFinishedSuccessfully => new ActionResultScreen(true)
      case CauseAndEffectFinishedUnsuccessfully => new ActionResultScreen(false)
      case RetryLevel => getScreenByLevel()
      case NextLevel => GameState.incrementLevel; getScreenByLevel()
      case OtherTheme => GameState.setNextTheme; getScreenByLevel()
      case ToMainMenu => GameState.setLevel(1); new MainMenuScreen
      case ToTheme => getScreenByLevel()
    }
    screen.buildStage()
    OpenGame.changeScreen(screen)
    currentScreen.dispose()
    screen
  }

  def setUpCursor(): Unit = {
    Gdx.graphics.setCursor(clickCursor)
  }

  def getCursorPixmap: Pixmap = {
    val pointerFileName: String = getPointerFileNameFromUserSettings
    val handPixmap: Pixmap = new Pixmap(Gdx.files.internal(pointerFileName))
    val pointerSize = getPointerSizeFromUserSettings
    resizePointerToUserSpecifiedSize(handPixmap, pointerSize)
  }

  def resizePointerToUserSpecifiedSize(handPixmap: Pixmap, pointerSize: Int): Pixmap = {
    val cursorPixmap = new Pixmap(pointerSize, pointerSize, handPixmap.getFormat())
    cursorPixmap.drawPixmap(handPixmap, 0, 0, handPixmap.getWidth(), handPixmap.getHeight(), 0, 0,
      cursorPixmap.getWidth(), cursorPixmap.getHeight())
    cursorPixmap
  }

  def getPointerSizeFromUserSettings: Int = {
    UserSettings.pointerSize match {
      case "s" => 64
      case "m" => 128
      //case "l" => 256
    }
  }

  def getPointerFileNameFromUserSettings: String = {
    UserSettings.isBlackAndWhite match {
      case true => (if (UserSettings.pointerColor == "yellow") "hand_" + UserSettings.pointerColor else "hand_white") + ".png"
      case false => "hand_" + UserSettings.pointerColor + ".png"
    }
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
