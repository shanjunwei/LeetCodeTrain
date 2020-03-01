package tree;

import org.junit.Assert;
import org.junit.Test;
import tree.builder.TreeBuilder;
import tree.pojo.TreeNode;


/**
 * @description: 二叉树路径的和
 * @author: shan junwei
 * @create: 2020-03-01 15:24
 **/

public class TreePathSum {


    @Test
    public void test1() {
        TreeNode root = TreeBuilder.derializeTreeByFirstOrder("124###35###");

        TreePathSum treePathSum = new TreePathSum();

        boolean excepted = treePathSum.hasPathSum(root, 9);

        Assert.assertEquals(excepted,true);
    }

    boolean flag = false;


    public boolean hasPathSum(TreeNode root, int sum) {
        printAllPath(root, 0, sum);
        return flag;
    }


    public void printAllPath(TreeNode root, int sum, int key) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (root.left == null || root.right == null) {
            if (sum == key) {
                flag = true;
            }
        }
        if (root.left != null) {
            printAllPath(root.left, sum, key);
        }
        if (root.right != null) {
            printAllPath(root.right, sum, key);
        }
    }

    /**
     * 打印二叉树所有路径
     */
    public void printAllPath(TreeNode root, String str) {
        if (root == null) {
            return;
        }
        str += root.val + " ";
        if (root.left == null || root.right == null) {
            System.out.println(str);
        }
        if (root.left != null) {
            printAllPath(root.left, str);
        }
        if (root.right != null) {
            printAllPath(root.right, str);
        }
    }


}
