package tree

import tree.pojo.TreeNode
import Array._
/**
  *  前中序构建二叉树
  */
object BuildTreeByPreInOrder_scala {


  def main(args: Array[String]): Unit = {

  }
  // Scala  slice 是 （a,b）  左闭右开区间


  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    if (preorder.length == 0 ) return null
    //  前序遍历第一个值为根节点
    val root = new TreeNode(preorder(0))
    //    因为没有重复元素，所以可以直接根据值来查找根节点在中序遍历中的位置
    val mid = inorder.indexOf(preorder(0))
    //    构建左子树
    root.left =   buildTree(preorder.slice(1,mid+1), inorder.slice(0,mid))
     //   构建右子树
    root.right = buildTree(preorder.slice(mid+1,preorder.length-1), preorder.slice(mid+1,preorder.length-1))

    root
  }

}
