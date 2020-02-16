package tree;

import java.util.LinkedList;
import java.util.Queue;
import tree.pojo.TreeNode;

/**
 * @description: 构建二叉树
 * @author: shan junwei
 * @create: 2020-02-16 12:28 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意: 你可以假设树中没有重复的元素。
 **/

public class BuildTreeByPreInOrder {


    Queue<Integer> preQueue = new LinkedList<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0 || inorder.length ==0){
            return null;
        }

        for (int item : preorder) {
            preQueue.add(item);
        }
        int rootVal = preQueue.poll();
        TreeNode root = new TreeNode(rootVal);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(",");
        for (int item : inorder) {
            stringBuilder.append(item);
            stringBuilder.append(",");
        }
        String inorderStr = stringBuilder.toString().trim();
        recursiveBuildTree(root, getLeftStr(inorderStr,rootVal), getRightStr(inorderStr,rootVal));
        return root;
    }

    // 递归构造二叉树 按照先序顺序来的
    public void recursiveBuildTree(TreeNode root, String leftList, String rightList) {
        if (preQueue.isEmpty() || root == null) {
            return;
        }
        if (!",".equals(leftList.trim())) {

            int leftVal = preQueue.poll();
            root.left = new TreeNode(leftVal);


            String left = getLeftStr(leftList,leftVal);
            String right = getRightStr(leftList,leftVal);
            if(left.equals(leftList) || right.equals(leftList)){
                recursiveBuildTree(root.left, "", "");
            }else{
                recursiveBuildTree(root.left, getLeftStr(leftList,leftVal), getRightStr(leftList,leftVal));
            }
        }
        if (!",".equals(rightList.trim())) {

            int rightVal = preQueue.poll();
            root.right = new TreeNode(rightVal);

            String left = getLeftStr(rightList,rightVal);
            String right = getRightStr(rightList,rightVal);
            if(left.equals(rightList) || right.equals(rightList)){
                recursiveBuildTree(root.right, "", "");
            }else{
                recursiveBuildTree(root.right, getLeftStr(rightList,rightVal), getRightStr(rightList,rightVal));
            }
        }
    }


    public String  getLeftStr(String origin,int val){
      String[] array =  origin.split(String.valueOf(","+val+","));
      String leftStr = array.length >= 1 ? array[0] : "";
        leftStr = leftStr + ",";
        System.out.println("origin >> "+ origin +" val >> "+val);
      return  leftStr;
    }


    public String  getRightStr(String origin,int val){
        String[] array =  origin.split(String.valueOf(","+val+","));
        String rightStr = array.length >= 2 ? array[1] : "";
        rightStr = ","+rightStr;
        System.out.println("origin >> "+ origin +" val >> "+val);
        return  rightStr;
    }


    public static void main(String[] args) {
        BuildTreeByPreInOrder buildTreeByPreInOrder = new BuildTreeByPreInOrder();

        int[] pre = {-77,24,-74,84,93,28,83,6,95,58,59,66,22,-3,-66,-68,-22,3,-80,-79,-85,17,32,9,-88,-99,14,-60,13,-93,-63,91,82,21,26,-11,-32,-16,-100,-94,-31,-62,-89,49,-9,-8,87,-33,-81,80,0,69,-7,52,67,-5,-65,31,-30,37,-57,27,23,38,-28,7,-82,-42,11,-55,-36,-58,-24,89,56,73,41,18,-87,-70,4,-64,20,-52,-39,79,19,30,65,25,-71,-76,-1,62,-69,98,39,-25,-73,70,88,-17,-20,-75,55,34,57,81,-10,94,48,-35,5,-23,-44,40,-51,-61,-13,-86,63,71,-97,45,43,51,75,33,-34,92,47,-78,85,-26,97,-29,-92,-83,-59,74,96,68,77,16,-4,10,60,64,-21,-2,1,-91,86,46,76,-37,-19,-96,36,-98,29,-72,61,50,15,-95,-40,-43,-53,90,-15,-48,-27,-90,-54,72,-50,-49,-18,78,54,35,-38,99,44,-67,53,-12,-41,2,8,-14,-84,-56,-6,12,-45,42,-47,-46};
        int[] in = {93,28,84,83,-74,59,58,66,-66,-3,-79,-80,3,-22,-68,22,-85,-99,14,-88,9,32,17,-60,95,-93,82,21,91,-63,26,13,-16,-32,-11,-100,6,-62,49,-89,-31,87,-8,69,0,80,-7,-81,-65,-5,67,-30,31,52,-33,37,-57,-9,7,-28,-42,-82,38,-55,11,23,-36,27,56,89,73,-24,41,-58,-70,-87,20,-64,-52,4,18,-94,19,30,-76,-1,-71,62,-69,25,-73,-25,70,39,88,98,-20,-17,65,55,-75,79,34,-39,48,94,-23,5,-44,-35,40,-10,-61,-51,-13,81,63,-97,71,-86,57,45,24,-34,85,97,-26,-78,-83,-92,74,-59,96,-29,68,47,77,92,10,-4,16,60,33,-21,1,86,76,46,-37,-91,-2,64,75,51,-19,-96,43,-98,29,61,-72,50,36,-95,-40,-43,15,90,-15,-53,-77,-54,-90,-49,-50,72,-27,35,54,-38,78,-67,44,53,99,-41,-12,-18,8,2,-48,-56,-84,-14,-45,12,42,-6,-46,-47};
        buildTreeByPreInOrder.buildTree(pre, in);


    }

}
