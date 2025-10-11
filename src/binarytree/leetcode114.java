package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树展开为链表
 */
public class leetcode114 {
    public static void main(String[] args){

    }
}

class Solution114{

    /**
     * 采用前序遍历
     * 首先用前序遍历将二叉树表示出来，然后用for循环来组成单链表
     * @param root 二叉树根节点
     */
    public void flatten(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode pre = list.get(i);
            TreeNode cur = list.get(i + 1);
            pre.left = null;
            pre.right = cur;
        }
    }
    private void preorder(TreeNode root, List<TreeNode> list){
        if (root == null)
            return;
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    /**
     * 空间复杂度为o(1)
     * 核心思想：
     * 通过迭代，不使用递归
     * 对于每个节点cur:
     * 1.如果节点cur没有左子树，那么直接向右移动
     * 2.如果节点存在左子树
     *   - 找到左子树的最右侧节点pre
     *   - 将cur的右子树连接到pre的右子树上
     *   - 然后把cur的左子树整体移到右边
     *   - 最后将cur.left置为null
     * 每次操作后，将cur的指针右移，继续处理下一个节点
     */
    public void flatten_2(TreeNode root){
        TreeNode cur = root;
        while (cur != null){
            if (cur.left != null){
                TreeNode nxt = cur.left;
                TreeNode pre = cur.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.left = null;
                cur.right = nxt;
            }
            cur = cur.right;
        }
    }
}