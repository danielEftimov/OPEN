package org.otw.open.screens

import org.mockito.Mockito._
import org.otw.open.testconfig.UnitSpec
import org.scalatest.BeforeAndAfterEach

/**
  * Created by deftimov on 19.02.2016.
  */
class EraserGameScreenTest extends UnitSpec with BeforeAndAfterEach {
  var eraserGameScreen: EraserGameScreen = _

  override def beforeEach(): Unit = {
    eraserGameScreen = spy(new EraserGameScreen)
  }

  override def afterEach(): Unit = {
    eraserGameScreen.dispose()
  }

  test("should invoke mouseMoved and draw once on eraserGameScreen") {
    eraserGameScreen.buildStage()
    eraserGameScreen.mouseMoved(20, 20)
    eraserGameScreen.draw()
    verify(eraserGameScreen, times(1)).mouseMoved(20, 20)
    verify(eraserGameScreen, times(1)).draw()

  }

  test("should invoke mouseMoved and draw twice on eraserGameScreen") {
    eraserGameScreen.buildStage()
    eraserGameScreen.mouseMoved(20, 20)
    eraserGameScreen.draw()
    eraserGameScreen.mouseMoved(40, 40)
    eraserGameScreen.draw()
    verify(eraserGameScreen, times(1)).mouseMoved(20, 20)
    verify(eraserGameScreen, times(1)).mouseMoved(40, 40)
    verify(eraserGameScreen, times(2)).draw()

  }
}
