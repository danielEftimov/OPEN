package org.otw.open.listeners

import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.utils.DragListener
import org.otw.open.actors.MovingObjectActor
import org.otw.open.controllers.{CauseAndEffectFinishedSuccessfully, GameState, ScreenController}
import org.otw.open.dto.Point

/**
  * Created by eilievska on 2/18/2016.
  */
class MovingObjectDragAndDropListener(val actor: MovingObjectActor) extends DragListener {

  override def drag(event: InputEvent, x: Float, y: Float, pointer: Int): Unit = {
    actor.playSound
    actor.moveBy(x - actor.getWidth / 2, y - actor.getHeight / 2)
  }

  override def dragStop(event: InputEvent, x: Float, y: Float, pointer: Int): Unit = {
    val standPoint: Point = GameState.getLevelStandPoints.head
    val positionWithinTargetRange: Boolean = (actor.getX >= standPoint.x && actor.getX <= standPoint.x + 200
      && actor.getY >= standPoint.y && actor.getY <= standPoint.y + 300)
    if (positionWithinTargetRange) ScreenController.dispatchEvent(CauseAndEffectFinishedSuccessfully)
    else {
      actor.resetPosition()
      actor.incrementMissCount
    }
    actor.stopSound
  }
}
