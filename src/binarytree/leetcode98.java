package binarytree;

/**
 * 验证二叉搜索树
 * 二叉搜索树的中序遍历是升序
 */
public class leetcode98 {
    public static void main(String[] args){

    }
}

/**
 * 中序遍历
 * 把二叉搜索树看成一个有序数组，只要比较相邻元素大小
 */
class Solution{
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root){
        if(root == null)
            return true;
        if(!isValidBST(root.left))
            return false;
        if (root.val <= pre)
            return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}
