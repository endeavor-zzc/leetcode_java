package binarytree;

/**
 * 二叉树中的最大路径和
 */
public class leetcode124 {
    public static void main(String[] args){

    }
}

class Solution124{
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        dfs(root);
        return ans;
    }
    //和543题一样
    private int dfs(TreeNode node){
        if (node == null)
            return 0;
        int left = Math.max(node.val, dfs(node.left) + node.val);
        int right = Math.max(node.val, dfs(node.right) + node.val);
        ans = Math.max(ans, left + right - node.val);  //这里因为把左右子树加在一起会多算一个root的值，所以要减去
        return Math.max(left, right);
    }
}
