package org.otw.open.util

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.audio.Music
import org.otw.open.controllers.GameState

/**
  * Created by deftimov on 23.02.2016.
  */
case class AudioManager(fileName: String) {
  private val audioTrack: Music = Gdx.audio.newMusic(Gdx.files.internal("theme/" + GameState.getThemeName + "/" + fileName))

  def getAudio = audioTrack
}
