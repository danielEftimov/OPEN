package org.otw.open.engine.impl

import org.otw.open.testconfig.UnitSpec
import org.scalatest.BeforeAndAfterEach

/**
  * Created by smirakovska on 2/10/2016.
  */
class DragAndDropActorEngineTest extends UnitSpec with BeforeAndAfterEach {


  private var engine: DragAndDropActorEngine = _

  override def beforeEach(): Unit = {
    engine = new DragAndDropActorEngine("car_theme", "theme/car_theme/light-background.png")
  }

  override def afterEach(): Unit = {
    engine.dispose()
  }

  test("when object is clicked with mouse it should be dragged on the screen") {
    engine.stage.touchDown(100, 320, 1, 1)
    engine.stage.touchDragged(100, 300, 1)
    assert(engine.dragAndDrop.getDragActor != null)
  }

  test("when object is clicked with mouse and dragged to final endpoint dragAndDrop.isDragging is false") {
    engine.stage.touchDown(100, 320, 1, 1)
    engine.stage.touchDragged(100, 300, 1)
    engine.stage.touchUp(950, 300, 1, 1)

    assert(!engine.dragAndDrop.isDragging)
    assert(engine.dragAndDrop.getDragActor == null)
  }

}
