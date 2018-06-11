package com.tbuonomo.magicshapepath

import com.google.android.material.shape.ShapePath
import com.google.android.material.shape.ShapePath.PathLineOperation
import com.google.android.material.shape.ShapePath.PathOperation
import org.junit.Assert
import org.junit.Test
import java.util.ArrayList

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class MagicShapePathTest {
  @Test
  fun numberOfOperationsCorrectSimpleLine() {
    val magicShapePath = MagicShapePath.create(0f, 0f, 1f, 1f)
    val toShapePath = magicShapePath.toShapePath()
    var operations: ArrayList<ShapePath.PathOperation> = getPathOperations(toShapePath)

    Assert.assertEquals(2, operations.size)
    Assert.assertTrue(operations[0] is PathLineOperation)
    Assert.assertTrue(operations[1] is PathLineOperation)
  }

  companion object {
    fun getPathOperations(
            toShapePath: ShapePath): ArrayList<PathOperation> {
      val operationsField = toShapePath.javaClass.getDeclaredField("operations")
      operationsField.isAccessible = true
      return operationsField.get(toShapePath) as ArrayList<PathOperation>
    }
  }
}