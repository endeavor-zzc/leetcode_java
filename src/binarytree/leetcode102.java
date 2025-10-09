package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 */
public class leetcode102 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution102 solution102 = new Solution102();
        List<List<Integer>> result = solution102.levelOrder_1(root);
        System.out.println(result);
    }
}

class Solution102 {
    /**
     * 用两个数组 cur和nxt
     * cur存储当前这一层的节点，nxt存储cur的左右节点
     * 然后cur=nxt
     * 循环结束条件：cur为空的时候
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_1(TreeNode root){
        if (root == null)
            return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> cur = List.of(root); //创建元素
        while (!cur.isEmpty()){
            List<TreeNode> nxt = new ArrayList<>();
            List<Integer> vals = new ArrayList<>(cur.size()); //预分配空间,可以节省内存消耗
            for (TreeNode node : cur){
                vals.add(node.val);
                if (node.left != null)
                    nxt.add(node.left);
                if (node.right != null)
                    nxt.add(node.right);
            }
            cur = nxt;
            ans.add(vals);
        }
        return ans;
    }

    /**
     * 使用一个队列，是方法一的改进
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder_2(TreeNode root){
        if (root == null)
            return List.of();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size(); //记录的是当前层的节点个数
            List<Integer> vals = new ArrayList<>(n);
            while (n-- > 0){
                TreeNode node = q.poll(); // 取出并删除头部元素
                vals.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            ans.add(vals);
        }
        return ans;
    }
}