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

    /**
     *  先递归右子树，再递归左子树，当某个深度首次到达时，对应的节点就在右视图中
     * @param root
     * @return
     */
    public List<Integer> rightSideView_2(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode root, int depth, List<Integer> ans){
        if (root == null)
            return;
        /**
         * depth表示当前层数，ans.size()表示当前结果已经记录了多少最右节点
         *         1
         *        / \
         *       2   3
         *        \   \
         *         5   4
         * | 递归层级 | 当前节点 | depth | ans.size() | 是否加入 | ans结果|
         * | ---- | ---- | ----- | ---------- | ---- | --------- |
         * | 1️⃣  | 1    | 0     | 0          | ✅ 是  | [1]       |
         * | 2️⃣  | 3    | 1     | 1          | ✅ 是  | [1, 3]    |
         * | 3️⃣  | 4    | 2     | 2          | ✅ 是  | [1, 3, 4] |
         * | 4️⃣  | 2    | 1     | 3          | ❌ 否  | [1, 3, 4] |
         * | 5️⃣  | 5    | 2     | 3          | ❌ 否  | [1, 3, 4] |
         */
        if (depth == ans.size()) //表示深度首次遇到
            ans.add(root.val);
        dfs(root.right, depth + 1, ans);
        dfs(root.left, depth + 1, ans);
    }
}
