package org.otw.open.screens

import com.badlogic.gdx.audio.Music
import com.badlogic.gdx.audio.Music.OnCompletionListener
import com.badlogic.gdx.utils.Disposable
import org.otw.open.actors.{BackgroundActor, MovingObjectActor}
import org.otw.open.controllers.GameState
import org.otw.open.listeners.{MovingObjectClickListener, MovingObjectDragAndDropListener, MovingObjectSceneListener}
import org.otw.open.util.AudioManager

/**
  * Created by eilievska on 2/15/2016.
  * Screen that handles Cause And Effect game
  */
class CauseAndEffectScreen extends AbstractGameScreen {

  /**
    * instance of BackgroundActor
    */
  private val backgroundActor = new BackgroundActor("light-background.png")

  /**
    * instance of MovingObjectActor
    */
  private val movingObjectActor = new MovingObjectActor

  /** Sound instance for audio guidance in Cause And Effect Game with clicks */
  private val audioCauseAndEffect = AudioManager("audio-guidance-cause-and-effect.mp3")

  audioCauseAndEffect.getAudio.setOnCompletionListener(new OnCompletionListener {
    override def onCompletion(music: Music): Unit = {
      addListener(new MovingObjectSceneListener(movingObjectActor))
      movingObjectActor.addListener(new MovingObjectClickListener(movingObjectActor))
    }
  })

  /** Sound instance for audio guidance Cause And Effect Game with drag and drop */
  private val audioDragAndDrop = AudioManager("audio-guidance-drag-and-drop.mp3")

  audioDragAndDrop.getAudio.setOnCompletionListener(new OnCompletionListener {
    override def onCompletion(music: Music): Unit = {
      movingObjectActor.addListener(new MovingObjectDragAndDropListener(movingObjectActor))
    }
  })

  /**
    * Current game level
    */
  private val level: Int = GameState.getLevel

  /**
    * Methods to be overriden by all classes.
    */
  override def buildStage(): Unit = {
    addActor(backgroundActor)
    addActor(movingObjectActor)
    if (level == 2 || level == 3) audioCauseAndEffect.getAudio.play
    if (level == 4) audioDragAndDrop.getAudio.play
  }

  override def dispose(): Unit = {
    audioCauseAndEffect.getAudio.dispose
    audioDragAndDrop.getAudio.dispose
    backgroundActor.dispose
    movingObjectActor.dispose
  }
}
