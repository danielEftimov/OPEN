package org.otw.open.listeners

import com.badlogic.gdx.scenes.scene2d.{InputEvent, InputListener}
import org.otw.open.actors.MovingObjectActor

/**
  * Created by eilievska on 2/18/2016.
  */
class MovingObjectClickListener(val actor: MovingObjectActor) extends InputListener {

  override def touchDown(event: InputEvent, x: Float, y: Float, pointer: Int, button: Int): Boolean = {
    if (!actor.isMoving) actor.move()
    if (actor.isBeginning) actor.decrementMissCount
    true
  }

}
