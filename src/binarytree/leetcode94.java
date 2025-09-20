package binarytree;
/**
 * 中序遍历二叉树
 */

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {};
     TreeNode(int val){
         this.val = val;
     }
     TreeNode(int val, TreeNode left, TreeNode right){
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class leetcode94 {
    public static void main(String[] args){
        TreeNode leftchild = new TreeNode(2);
        TreeNode rightchild = new TreeNode(3);
        TreeNode root = new TreeNode(1, leftchild, rightchild);
        Solution94 solution94 = new Solution94();
        List<Integer> result = new ArrayList<>();
        result = solution94.inorderTraversal(root);
        System.out.println(result);
    }
}

class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> res){
        if (root == null)
            return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
