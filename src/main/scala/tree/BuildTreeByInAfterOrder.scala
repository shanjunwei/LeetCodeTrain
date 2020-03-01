package tree

import tree.pojo.TreeNode

object BuildTreeByInAfterOrder {


  def main(args: Array[String]): Unit = {
    val in = Array(9, 3, 15, 20, 7)
    val after = Array(9, 15, 7, 20, 3)
    buildTree(in, after)
  }

  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
   // println("inorder >> "+ inorder.mkString(" ") + " postorder"+postorder.mkString(" ") )


    if (inorder.length == 0 || postorder.length == 0) return null
    val midVal = postorder(postorder.length - 1)
    val root = new TreeNode(midVal)

    val mid = inorder.indexOf(midVal)


    root.left = buildTree(inorder.slice(0, mid), postorder.slice(0, mid))

    root.right = buildTree(inorder.slice(mid + 1, inorder.length ), postorder.slice(mid , postorder.length - 1))

    return root;

  }

}
