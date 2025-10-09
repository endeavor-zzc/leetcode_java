package binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 */
public class leetcode199 {
    public static void main(String[] args){

    }
}

class Solution199{
    /**
     * 使用层次遍历，记录每一层最后一个节点值
     * @param root 根节点
     * @return
     */
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                if (i == n - 1)
                    ans.add(node.val);
            }
        }
        return ans;
    }
}
