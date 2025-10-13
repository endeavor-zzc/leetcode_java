package binarytree;

/**
 * 二叉树的最近公共祖先
 *
 */
public class leetcode236 {
    public  static void main(String[] args){

    }
}

class Solution236{
    /**
     * 根据最近公共祖先的定义：会出现一下3种情况：
     * p和q在root的子树中，并且在root的异侧
     * p=root,且q在root的左子树或右子树中
     * q=root,且q在root的左子树或右子树中
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        /*
          根据返回值，可以分为下面四种情况
         */
        if (left == null && right == null) //情况一：left和right同时为空，说明root的左右子树都不包含p,q
            return null;
        /*
          情况三：left为空，right不为空。说明p，q都不在左子树中，直接返回right。具体分为以下两种情况：
          p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
          p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
         */
        if (left == null)
            return right;
        if (right == null)  // 情况四：left不为空，right为空，与情况三同理
            return left;
        return root;  // 情况二：左右子树都不为空
    }
}
