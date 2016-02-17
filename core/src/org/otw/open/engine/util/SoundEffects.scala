package org.otw.open.engine.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.{Music, Sound}
import com.badlogic.gdx.utils.Disposable

/**
  * SoundEffect class that will handle the audio guidance in the application
  * Created by jivanovski on 2/4/2016.
  */
class SoundEffects(val audioSampleName: String) {

  /* sound instance from libGdx */
  private val sound: Music = Gdx.audio.newMusic(Gdx.files.internal(audioSampleName))

  def playSound() = {
    sound.play()
  }

  def stopSound() = {
    sound.stop()
  }

  def setLoop() = {
    sound.setLooping(true)
  }

  def isLooping: Boolean = {

    sound.isLooping
  }

  def isPlaying: Boolean = {

    sound.isPlaying
  }

  /** Disposes all sounds.
    *
    * @return true if the method is implemented.
    */
  def dispose(): Boolean = {
    sound.dispose()
    true
  }
}
