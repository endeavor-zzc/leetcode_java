package binarytree;

/**
 * 二叉树的直径
 */
public class leetcode543 {
    public static void main(String[] args){

    }
}

class Solution543{
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root){
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node){
        if (node == null)
            return -1;
        int left = dfs(node.left) + 1;
        int right = dfs(node.right) + 1;
        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }
}
