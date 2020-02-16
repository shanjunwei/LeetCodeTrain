package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树的最大深度
 * @author: shan junwei
 * @create: 2020-02-09 20:18
 **/

public class MaxDeepOfTree {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {

            val = x;
        }
    }


    private Queue<TreeNode> queue = new LinkedList<>();

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root != null) {
            queue.add(root);
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode);
            }
            List<Integer> intList = new ArrayList<>();
            for (TreeNode treeNode : list) {
                intList.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            depth++;
        }
        return depth;
    }


}
