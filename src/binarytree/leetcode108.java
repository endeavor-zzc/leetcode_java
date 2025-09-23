package binarytree;


/**
 * 将有序数组转换为二叉搜索树
 *
 * 二叉搜索树：
 * 若左子树不为空，则左子树上所有节点值小于根节点值
 * 若右子树不为空，则右子树上所有节点值大于根节点值
 * 平衡性：树中任意节点的左右两个子树的高度差的绝对值不超过1
 */
public class leetcode108 {
    public static void main(String[] args){

    }
}

class Solution108{
    public TreeNode sortedArrayToBST(int[] nums){
        return dfs(nums, 0, nums.length - 1);
    }
    private TreeNode dfs(int[] nums, int left, int right){
        if(left > right)
            return null;

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
}
