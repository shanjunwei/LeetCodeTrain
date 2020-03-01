package tree

import java.util

import org.junit.Test
import tree.BuildTreeByInAfterOrder.buildTree
import tree.pojo.TreeNode

import scala.collection.JavaConversions._

/**
  * 二叉树的最小深度
  */
class MinDepthOfTree {
  @Test
  def test1(): Unit = {
    val in = Array(9, 3, 15, 20, 7)
    val after = Array(9, 15, 7, 20, 3)
    val root = buildTree(in, after)
    assert(minDepth(root) == 2)

    val in2 = Array(0, 1)
    val after2 = Array(0, 1)
    val root2 = buildTree(in2, after2)
    assert(minDepth(root2) == 2)
    assert(minDepth(null) == 0)
  }

  def minDepth(root: TreeNode): Int = {
    return levelOrder(root)
  }


  private val queue: util.Queue[TreeNode] = new util.LinkedList[TreeNode]

  def levelOrder(root: TreeNode): Int = {
    if (root == null) return 0

    var deepTh = Int.MaxValue
    var depth = 1
    if (root != null) queue.add(root)
    while (!queue.isEmpty) {
      val list: util.List[TreeNode] = new util.ArrayList[TreeNode]
      while (!queue.isEmpty) {
        val treeNode: TreeNode = queue.poll
        list.add(treeNode)
      }
      list.foreach(treeNode => {
        print(" voo " + treeNode.`val`)
        if (treeNode.left == null && treeNode.right == null) {
          deepTh = Math.min(depth, deepTh)
        }
        if (treeNode.left != null) queue.add(treeNode.left)
        if (treeNode.right != null) queue.add(treeNode.right)
        depth += 1
      })
    }
    println()
    deepTh
  }

}
