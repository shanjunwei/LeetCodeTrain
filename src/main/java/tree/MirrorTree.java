package tree;

import javax.swing.tree.TreeNode;

/**
 * @description: 镜像树
 * @author: shan junwei
 * @create: 2020-01-31 20:36
 **/

public class MirrorTree {


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
       return isMirror(root,root);
    }

    // 两个树在什么情况下互为镜像
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }

}
