package binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径综合 III
 */
public class leetcode437 {
    public static void main(String[] args){

    }
}

class Solution437{
    int res = 0;
    Map<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum){
        map.put(0L, 1); //0L表示长整型的0
        dfs(root, targetSum, 0L);
        return res;
    }

    private void dfs(TreeNode node, int targetSum, Long sum){
        if (node == null)
            return;
        sum += node.val;
        if (map.containsKey(sum - targetSum)){
            res += map.get(sum - targetSum);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        dfs(node.left, targetSum, sum);
        dfs(node.right, targetSum, sum);

        map.put(sum,map.get(sum) - 1);
    }
}
