package tree.builder;

import java.util.LinkedList;
import java.util.Queue;
import tree.pojo.TreeNode;

/**
 * @description: 二叉树构建者
 * @author: shan junwei
 * @create: 2020-03-01 15:30
 **/

public class TreeBuilder {

    /**
     * 先序构造一颗二叉树
     * @param str
     * @return
     */
    public  static TreeNode derializeTreeByFirstOrder(String str) {
        if ("#_".equals(str)) return null;
        Queue<String> queue = new LinkedList<>();
        for (char c : str.toCharArray()) {
            if ('_' == c) continue;
            queue.add(String.valueOf(c));
        }
        return reconPreOrder(queue);
    }

    //  二叉树的先序反序列化
    public static TreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

}
