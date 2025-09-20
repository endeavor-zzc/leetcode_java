package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 */
public class leetcode226 {
    /**
     * 层次遍历
     * @param root
     */
    public static void levelOrder(TreeNode root){  //这里加入static是为了可以直接调用，不用实例化对象了
        if (root == null)
            return;
        //使用队列保证先进先出
        Queue<TreeNode> queue = new LinkedList<>(); //链表
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll(); //取出并删除队头元素
            System.out.print(node.val + " ");
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        Solution226 solution226 = new Solution226();
        TreeNode result_root = solution226.invertTree(root);
        levelOrder(result_root);
    }
}

class Solution226{
    public TreeNode invertTree(TreeNode root){
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}


