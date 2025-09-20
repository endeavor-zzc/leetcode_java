package binarytree;

/**
 * 二叉树的最大深度
 */
public class leetcode104 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution104 solution104 = new Solution104();
        int result = solution104.maxDepth(root);
        System.out.println(result);
    }
}

class Solution104 {
    public int maxDepth(TreeNode root){
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;

    }
}
