package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.Assert;
import org.junit.Test;
import tree.pojo.TreeNode;

/**
 * @description: 二叉树最小深度
 * @author: shan junwei
 * @create: 2020-03-01 11:03
 **/

public class MinDeepOfTree {


    @Test
    public  void test() {
        // 构造一棵树
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);


        Assert.assertEquals( minDepth(treeNode),3);
    }


    private Queue<TreeNode> queue = new LinkedList<>();
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDeep = Integer.MAX_VALUE;
        int depth = 1;
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode);
            }
            List<Integer> intList = new ArrayList<>();
            for (TreeNode treeNode : list) {
                intList.add(treeNode.val);
                // 判断是否为叶子节点
                if (treeNode.left == null && treeNode.right == null) {
                    minDeep = Math.min(depth, minDeep);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            depth++;
        }
        return minDeep;
    }


}
