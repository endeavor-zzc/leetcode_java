package binarytree;


public class leetcode101 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        Solution101 solution101 = new Solution101();
        boolean result = solution101.isSymmetric(root);
        System.out.println(result);
    }
}

class Solution101{
    public boolean isSymmetric(TreeNode root){
         return isSameTree(root.left, root.right);
    }

    /**
     * 是对相同的树改版
     * @param p
     * @param q
     * @return
     */
    private boolean isSameTree(TreeNode p, TreeNode q){

        if (p == null || q == null)
            return p == q;
        if (p.val != q.val)
            return false;
        else
            return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}
