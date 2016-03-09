package org.otw.open.screens

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.Disposable
import org.otw.open.actors.{BackgroundActor, MenuButtonActor, StaticAnimationActor}
import org.otw.open.controllers._
import org.otw.open.listeners.DispatchEventListener
import org.otw.open.util.AudioManager

/**
  * Created by eilievska on 2/19/2016.
  */
class ActionResultScreen(val isSuccessfulAction: Boolean) extends AbstractGameScreen {

  /**
    * Screen background.
    */
  private val backgroundActor = new BackgroundActor("dark-background.png")

  private val nextLevelButton = new MenuButtonActor(new Vector2(722, 5), "next-level.png")

  private val disabledNextLevelButton = new MenuButtonActor(new Vector2(722, 5), "disabled-next-level.png")

  private val retryLevelButton = new MenuButtonActor(new Vector2(535, 5), "retry-level.png")

  private val toMainMenuButton = new MenuButtonActor(new Vector2(348, 5), "to-main-menu.png")

  private val toOtherThemeButton = new MenuButtonActor(new Vector2(909, 5), "to-other-theme.png")

  nextLevelButton.addListener(new DispatchEventListener(NextLevel))

  retryLevelButton.addListener(new DispatchEventListener(RetryLevel))

  toMainMenuButton.addListener(new DispatchEventListener(ToMainMenu))

  toOtherThemeButton.addListener(new DispatchEventListener(OtherTheme))

  private val atlasFileName = if (isSuccessfulAction) "happy-animation.atlas" else "unhappy-animation.atlas"

  private val audioGuidanceFileName = if (isSuccessfulAction) "audioGuidanceHappyAnimation.mp3" else "audioGuidanceSadAnimation.mp3"

  /** Sound instance for audio guidance */
  private val audio = AudioManager(audioGuidanceFileName)
  audio.getAudio.play

  private val position: Vector2 = GameState.getResultAnimationStandPoint
  private val staticAnimationActor = new StaticAnimationActor(position, atlasFileName)

  /**
    * Methods to be overridden by all classes.
    */
  override def buildStage(): Unit = {
    addActor(backgroundActor)
    addActor(staticAnimationActor)
    if (GameState.getLevel == 4)
      addActor(disabledNextLevelButton)
    else
      addActor(nextLevelButton)
    addActor(retryLevelButton)
    addActor(toMainMenuButton)
    addActor(toOtherThemeButton)
  }

  override def dispose(): Unit = {
    staticAnimationActor.dispose
    backgroundActor.dispose
    toMainMenuButton.dispose
    retryLevelButton.dispose
    nextLevelButton.dispose
    toOtherThemeButton.dispose
    disabledNextLevelButton.dispose
    audio.getAudio.dispose
  }
}
