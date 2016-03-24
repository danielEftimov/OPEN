package org.otw.open.screens

import com.badlogic.gdx.audio.Music.OnCompletionListener
import com.badlogic.gdx.backends.headless.mock.audio.MockMusic
import com.badlogic.gdx.files.FileHandle
import com.badlogic.gdx.scenes.scene2d.{Actor, EventListener}
import com.badlogic.gdx.utils.Array
import com.badlogic.gdx.{Audio, Gdx}
import org.mockito.Matchers.any
import org.mockito.Mockito.{mock, when}
import org.otw.open.actors.{BackgroundActor, MovingObjectActor}
import org.otw.open.controllers.GameState
import org.otw.open.listeners.{MovingObjectClickListener, MovingObjectDragAndDropListener, MovingObjectSceneListener}
import org.otw.open.testconfig.UnitSpec

/**
  * Created by smirakovska on 2/22/2016.
  */
class CauseAndEffectScreenTest extends UnitSpec {

  var screen: CauseAndEffectScreen = _

  private class TestMockMusic extends MockMusic {
    var listener: Option[OnCompletionListener] = None

    var playWasInvoked = false

    override def setOnCompletionListener(listener: OnCompletionListener): Unit = {
      this.listener = Some(listener)
    }

    override def play(): Unit = {
      playWasInvoked = true
    }
  }

  test("should add background and moving actor on the stage when buildStage invoked") {
    GameState.setLevel(2)
    screen = new CauseAndEffectScreen
    screen.buildStage
    assert(screen.getActors.size == 2)
    assert(screen.getActors.get(0).isInstanceOf[BackgroundActor])
    assert(screen.getActors.get(1).isInstanceOf[MovingObjectActor])
    screen.dispose
  }

  test("audioGuidanceClick should have one OnCompleteListener") {
    GameState.setLevel(4)
    Gdx.audio = mock(classOf[Audio])
    when(Gdx.audio.newMusic(any(classOf[FileHandle]))).thenReturn(new MockMusic)

    val music: TestMockMusic = new TestMockMusic
    when(Gdx.audio.newMusic(Gdx.files.internal("theme/" + GameState.getThemeName + "/audio-guidance-cause-and-effect.mp3"))).thenReturn(music)

    screen = new CauseAndEffectScreen
    assert(music.listener.isDefined)
  }

  test("after audioGuidanceClick listener is invoked, the scene and actors should have listener added to them") {
    GameState.setLevel(4)
    Gdx.audio = mock(classOf[Audio])
    when(Gdx.audio.newMusic(any(classOf[FileHandle]))).thenReturn(new MockMusic)

    val music: TestMockMusic = new TestMockMusic
    when(Gdx.audio.newMusic(Gdx.files.internal("theme/" + GameState.getThemeName + "/audio-guidance-cause-and-effect.mp3"))).thenReturn(music)
    screen = new CauseAndEffectScreen
    screen.buildStage()
    music.listener.orNull.onCompletion(music)

    assert(screen.getRoot.getListeners.size == 1)
    assert(screen.getRoot.getListeners.get(0).isInstanceOf[MovingObjectSceneListener])
    val movingObjectActor: Actor = screen.getActors.get(1)
    assert(movingObjectActor.getListeners.size == 1)
    assert(movingObjectActor.getListeners.get(0).isInstanceOf[MovingObjectClickListener])
  }

  test("when the level is 3 audioGuidanceClick method should be invoked") {
    GameState.setLevel(3)
    Gdx.audio = mock(classOf[Audio])
    when(Gdx.audio.newMusic(any(classOf[FileHandle]))).thenReturn(new MockMusic)

    val music: TestMockMusic = new TestMockMusic
    when(Gdx.audio.newMusic(Gdx.files.internal("theme/" + GameState.getThemeName + "/audio-guidance-cause-and-effect.mp3"))).thenReturn(music)
    screen = new CauseAndEffectScreen
    screen.buildStage()

    assert(music.playWasInvoked)

  }

  test("when the level is 2 audioGuidanceClick method should be invoked") {
    GameState.setLevel(3)
    Gdx.audio = mock(classOf[Audio])
    when(Gdx.audio.newMusic(any(classOf[FileHandle]))).thenReturn(new MockMusic)

    val music: TestMockMusic = new TestMockMusic
    when(Gdx.audio.newMusic(Gdx.files.internal("theme/" + GameState.getThemeName + "/audio-guidance-cause-and-effect.mp3"))).thenReturn(music)
    screen = new CauseAndEffectScreen
    screen.buildStage()

    assert(music.playWasInvoked)

  }

  test("when the level is 4 audioGuidanceClick method should NOT be invoked") {
    GameState.setLevel(4)
    Gdx.audio = mock(classOf[Audio])
    when(Gdx.audio.newMusic(any(classOf[FileHandle]))).thenReturn(new MockMusic)

    val music: TestMockMusic = new TestMockMusic
    when(Gdx.audio.newMusic(Gdx.files.internal("theme/" + GameState.getThemeName + "/audio-guidance-cause-and-effect.mp3"))).thenReturn(music)
    screen = new CauseAndEffectScreen
    screen.buildStage()

    assert(!music.playWasInvoked)

  }

  test("audioGuidanceDragAndDrop music should have one OnCompleteListener") {
    GameState.setLevel(4)
    Gdx.audio = mock(classOf[Audio])
    when(Gdx.audio.newMusic(any(classOf[FileHandle]))).thenReturn(new MockMusic)

    val music: TestMockMusic = new TestMockMusic
    when(Gdx.audio.newMusic(Gdx.files.internal("theme/" + GameState.getThemeName + "/audio-guidance-drag-and-drop.mp3"))).thenReturn(music)

    screen = new CauseAndEffectScreen
    assert(music.listener.isDefined)
  }

  test("when audioGuidanceDragAndDrop listener is invoked, " +
    "the moving object actor should gave one MovingObjectDragAndDropListener listener added to it") {
    GameState.setLevel(4)
    Gdx.audio = mock(classOf[Audio])
    when(Gdx.audio.newMusic(any(classOf[FileHandle]))).thenReturn(new MockMusic)

    val music: TestMockMusic = new TestMockMusic
    when(Gdx.audio.newMusic(Gdx.files.internal("theme/" + GameState.getThemeName + "/audio-guidance-drag-and-drop.mp3"))).thenReturn(music)

    screen = new CauseAndEffectScreen
    screen.buildStage()
    music.listener.orNull.onCompletion(music)

    val movingObjectActorListeners: Array[EventListener] = screen.getActors.get(1).getListeners
    assert(movingObjectActorListeners.size == 1)
    assert(movingObjectActorListeners.get(0).isInstanceOf[MovingObjectDragAndDropListener])
  }

  test("when level is 4, then the audioGuidanceDragAndDrop play method should be invoked") {
    GameState.setLevel(4)
    Gdx.audio = mock(classOf[Audio])
    when(Gdx.audio.newMusic(any(classOf[FileHandle]))).thenReturn(new MockMusic)

    val music: TestMockMusic = new TestMockMusic
    when(Gdx.audio.newMusic(Gdx.files.internal("theme/" + GameState.getThemeName + "/audio-guidance-drag-and-drop.mp3"))).thenReturn(music)

    screen = new CauseAndEffectScreen
    screen.buildStage()

    assert(music.playWasInvoked)
  }

  test("when level is NOT 4, then the audioGuidanceDragAndDrop play method should NOT be invoked") {
    GameState.setLevel(2)
    Gdx.audio = mock(classOf[Audio])
    when(Gdx.audio.newMusic(any(classOf[FileHandle]))).thenReturn(new MockMusic)

    val music: TestMockMusic = new TestMockMusic
    when(Gdx.audio.newMusic(Gdx.files.internal("theme/" + GameState.getThemeName + "/audio-guidance-drag-and-drop.mp3"))).thenReturn(music)

    screen = new CauseAndEffectScreen
    screen.buildStage()

    assert(!music.playWasInvoked)
  }

}
