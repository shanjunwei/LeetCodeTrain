package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.junit.Test;

/**
 * @description: 二叉树层次遍历
 * @author: shan junwei
 * @create: 2020-02-01 11:24
 **/

public class TreeLevelOrder {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {

            val = x;
        }
    }


    private Queue<TreeNode> queue = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
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
            result.add(intList);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            result.add(intList);
        }
        Collections.reverse(result);
        return result;
    }






    private Deque<TreeNode> deque = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root != null) {
            deque.add(root);
        }
        List<List<Integer>> result = new ArrayList<>();
        int flag = 0;
        while (!deque.isEmpty()) {
            flag = flag ^ 1;
            List<TreeNode> list = new ArrayList<>();
            while (!deque.isEmpty()) {
               // TreeNode treeNode = (flag == 1) ? deque.pollFirst() : deque.pollLast();
                TreeNode treeNode = deque.pollFirst();
                list.add(treeNode);
            }
            List<Integer> intList = new ArrayList<>();
            for (TreeNode treeNode : list) {
                intList.add(treeNode.val);
                if (treeNode.left != null) {
                    deque.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.add(treeNode.right);
                }
            }

            if(flag == 0){
                Collections.reverse(intList);
            }
            result.add(intList);
        }
        System.out.println(result);
        return result;
    }


    @Test
    public void test() {

        TreeLevelOrder treeLevelOrder = new TreeLevelOrder();
        // 构造一棵树

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);

        // treeNode.left.right.left = new TreeNode(6);
        //  treeNode.left.right.right = new TreeNode(7);

        String result = treeLevelOrder.levelOrder(treeNode).toString();
        //  Assert.assertEquals("[[1], [2, 3], [4], [5]]", result);

        result = treeLevelOrder.zigzagLevelOrder(treeNode).toString();

    }


}
