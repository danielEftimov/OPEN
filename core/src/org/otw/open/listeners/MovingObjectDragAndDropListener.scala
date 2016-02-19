package org.otw.open.listeners

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.utils.DragListener
import org.otw.open.actors.MovingObjectActor
import org.otw.open.controllers.{CauseAndEffectFinishedUnsuccessfully, CauseAndEffectFinishedSuccessfully, ScreenController}

/**
  * Created by eilievska on 2/18/2016.
  */
class MovingObjectDragAndDropListener(val actor: MovingObjectActor) extends DragListener {

  override def drag(event: InputEvent, x: Float, y: Float, pointer: Int): Unit = {
    actor.moveBy(x - actor.getWidth / 2, y - actor.getHeight / 2)
  }

  override def dragStop(event: InputEvent, x: Float, y: Float, pointer: Int): Unit = {
    val possitionWithinTargetRange: Boolean = actor.getX >= 900 && actor.getX <= 1100 && actor.getY >= 359 && actor.getY <= 552
    if (possitionWithinTargetRange) ScreenController.dispatchEvent(CauseAndEffectFinishedSuccessfully)
    else {
      actor.resetPosition()
      actor.incrementMissCount
    }
  }
}
