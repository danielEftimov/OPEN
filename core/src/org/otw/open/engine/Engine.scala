package org.otw.open.engine

import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.Disposable
import org.otw.open.dto.Drawing

/**
  * Created by eilievska on 12/29/2015.
  */
trait Engine extends Disposable {

  /**
    * Returns a list of Drawing objects that will be drawn by the Sprite batch.
    * @param delta
    * @return
    */
  def getDrawings(delta: Float): List[Drawing]

  /**
    *
    * @param transformator - High order function that transforms 3D to 2D coordinates
    * @return Boolean value indicating if method is overriden
    */
  def setMouseClickPositionTransformator(transformator: ((Vector2) => Vector2)): Boolean = false

  /**
    *
    * @return an option of stage. Returns Some[Stage] in the case when the engine implements stage.
    */
  def getStage(): Option[Stage] = None

}
