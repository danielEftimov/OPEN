package org.otw.open.controllers

import org.otw.open.dto.Point
import org.otw.open.testconfig.UnitSpec
import org.scalatest.BeforeAndAfterEach

/**
  * Created by eilievska on 2/22/2016.
  */
class GameStateTest extends UnitSpec with BeforeAndAfterEach {
  override def beforeEach(): Unit = {
    GameState.setThemName("car_theme")
  }
  test("when getLevelStandPoints is invoked, for level 1 of car theme, it should return empty list") {
    GameState.setLevel(1)
    val standPoints: List[Point] = GameState.getLevelStandPoints
    assert(standPoints.isEmpty)
  }

  test("when getLevelStandPoints is invoked, for level 2 of car theme, it should return a list with one element") {
    GameState.setLevel(2)
    val standPoints: List[Point] = GameState.getLevelStandPoints
    assert(standPoints.size == 1)
  }

  test("when getLevelStandPoints is invoked, for level 2 of car theme, the stand point should be on coordinates 1000, 480") {
    GameState.setLevel(2)
    val standPoints: List[Point] = GameState.getLevelStandPoints
    assert(standPoints.head.x == 1000 && standPoints.head.y == 480)
  }

  test("when getLevelStandPoints is invoked, for level 3 of car theme, it should return a list with three elements") {
    GameState.setLevel(3)
    val standPoints: List[Point] = GameState.getLevelStandPoints
    assert(standPoints.size == 3)
  }

  test("when getLevelStandPoints is invoked, for level 2 of car theme, " +
    "the stand points should be on coordinates (330, 480), (660, 480), (1000, 480)") {
    GameState.setLevel(3)
    val expectedStandPoints = List(new Point(330, 480), new Point(660, 480), new Point(1000, 480))
    val standPoints: List[Point] = GameState.getLevelStandPoints
    assert(standPoints.filterNot(expectedStandPoints.toSet).isEmpty)
  }

  test("when getLevelStandPoints is invoked, for level 4 of car theme, it should return a list with one element") {
    GameState.setLevel(4)
    val standPoints: List[Point] = GameState.getLevelStandPoints
    assert(standPoints.size == 1)
  }

  test("when getLevelStandPoints is invoked, for level 4 of car theme, the stand point should be on coordinates 900, 480") {
    GameState.setLevel(4)
    val standPoints: List[Point] = GameState.getLevelStandPoints
    assert(standPoints.head.x == 900 && standPoints.head.y == 250)
  }

  test("when getLevelStartPoint is invoked, ") {
    GameState.setLevel(1)
    val startPoint: Point = GameState.getLevelStartPoint
    assert(startPoint.x == 0 && startPoint.y == 480)
  }

  test("when getThemeName is invoked, \"car_theme\" is returned") {
    assert(GameState.getThemeName == "car_theme")
  }

  test("when current level is 4, and incrementLevel is invoked, the new level is 1") {
    GameState.setLevel(4)
    GameState.incrementLevel
    assert(GameState.getLevel == 1)
  }

  test("when current level is not 4, and incrementLevel is invoked, the new level is incremented") {
    GameState.setLevel(3)
    GameState.incrementLevel
    assert(GameState.getLevel == 4)
  }

  test("when you try to set a level grater than 4, the level will stay the same") {
    GameState.setLevel(1)
    GameState.setLevel(5)
    assert(GameState.getLevel == 1)
  }

}
