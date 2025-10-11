package binarytree;

import javax.annotation.processing.SupportedOptions;
import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历构造二叉树
 */
public class leetcode105 {
    public static void main(String[] args){

    }
}

class Solution105{

    private Map<Integer, Integer> indexMap;

    /**
     * 前序遍历的顺序为：根节点，递归遍历左子树，递归遍历右子树
     * 中序遍历的顺序为：递归遍历左子树，根节点，递归遍历右子树
     * 所以只需要在中序遍历中定位到根节点就能分别知道左右子树
     * 前序遍历：
     * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
     * 中序遍历：
     * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
     * @param preorder 前序遍历的数组
     * @param inorder 中序遍历的数组
     * @param preorder_left 前序遍历的左边界
     * @param preorder_right 前序遍历的右边界
     * @param inorder_left 中序遍历的左边界
     * @param inorder_right 中序遍历的右边界
     * @return 返回根节点
     */
    private TreeNode Sup_buildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if (preorder_left > preorder_right)
            return null;

        //找到根节点
        int preorder_root = preorder_left;
        //在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        //建立根节点
        TreeNode root = new TreeNode(preorder[preorder_left]);
        //计算左子树的节点数目
        int left_subtree = inorder_root - inorder_left;
        //先序遍历中从（左边界+1）开始的left_subtree个元素对应了中序遍历中左边界到根节点定位-1的元素
        root.left = Sup_buildTree(preorder, inorder, preorder_left + 1, preorder_left + left_subtree, inorder_left, inorder_root - 1);
        //先序遍历中从（左边界+左子树的数目+1）到右边界的元素对应了中序遍历中从根节点定位+1  到 右边界的元素
        root.right = Sup_buildTree(preorder, inorder, preorder_left + left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;

    }

    /**
     *
     * @param preorder 前序遍历的数组
     * @param inorder 中序遍历的数组
     * @return 根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder){
        int n = preorder.length;
        // 使用哈希表快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return Sup_buildTree(preorder, inorder,0, n - 1, 0, n - 1);
    }
}
