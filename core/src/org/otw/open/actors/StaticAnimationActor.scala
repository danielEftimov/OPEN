package org.otw.open.actors

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.utils.Disposable
import org.json4s.ParserUtil.DisposableSegment
import org.otw.open.util.Animator

/**
  * Created by eilievska on 2/19/2016.
  */
class StaticAnimationActor(val position: Vector2, val atlasFileName: String) extends Actor with Disposable {

  private val animator = new Animator(atlasFileName)

  private var timePassed = 0f

  setX(position.x)
  setY(position.y)
  setWidth(animator.getCurrentTexture(0).getRegionWidth)
  setHeight(animator.getCurrentTexture(0).getRegionHeight)

  override def draw(batch: Batch, parentAlpha: Float): Unit = {
    timePassed = timePassed + Gdx.graphics.getDeltaTime
    batch.draw(animator.getCurrentTexture(timePassed), getX, getY)
  }

  override def dispose(): Unit = animator.dispose
}
