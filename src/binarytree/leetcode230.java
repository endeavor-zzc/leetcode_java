package binarytree;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中第k小的元素
 */
public class leetcode230 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        Solution230_1 solution2301 = new Solution230_1();
        int result = solution2301.kthSmallest(root, 1);
        System.out.println(result);
    }
}

/**
 * 此方法是使用了二叉树的中序遍历，先将二叉树中序遍历出来，然后找到第k个元素
 */
class Solution230_1 {
    public int kthSmallest(TreeNode root, int k){
        List<Integer> result = sortedArray(root);
        return result.get(k-1);
    }

    private List<Integer> sortedArray(TreeNode node){
        List<Integer> result = new ArrayList<>();
        inorder(node, result);
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

/**
 * 采用中序遍历，每次递归完左子树，把k减少1，相当于我们访问了一个节点
 * 当k等于0后，那么答案就是当前节点的值
 */
class Solution230_2{
    private int ans;
    private int k;
    public int kthSmallest(TreeNode root, int k){
        this.k = k;
        dfs(root);
        return ans;
    }
    private void dfs(TreeNode node){
        if (node == null || k == 0)
            return;
        dfs(node.left);
        k -= 1;
        if (k == 0)
            ans = node.val;
        dfs(node.right);
    }
}

