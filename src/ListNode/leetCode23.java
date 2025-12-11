package ListNode;

public class leetCode23 {
    /**
     * 将lists一分为二， 先合并前一半的链表，再合并后一半的链表。然后将这两个链表合并成最终的链表
     * 可以利用递归
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists){
        return mergeLists(lists, 0, lists.length);
    }

    private ListNode mergeLists(ListNode[] lists, int i, int j) {
        int m = j - i;
        if (m == 0){
            return null;
        }
        if (m == 1){
            return lists[i];
        }
        ListNode left = mergeLists(lists, i, i + m / 2); //合并左半部分
        ListNode right = mergeLists(lists, i + m / 2, j); //合并右半部分
        return mergeTwoLists(left, right);
    }

    /**
     * 合并两个有序链表
     * @param left
     * @param right
     * @return
     */
    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (left != null && right != null){
            if (left.val < right.val){
                cur.next = left;
                left = left.next;
            }else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = left != null ? left : right;
        return dummy.next;
    }
}
