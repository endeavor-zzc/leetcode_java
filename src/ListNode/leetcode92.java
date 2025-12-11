package ListNode;

/**
 * 反转链表Ⅱ
 */
public class leetcode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /**
         * 创建一个dummy哨兵节点指向head，为了防止left等于1的时候head要做反转
         *
         */
        // 1. 创建一个哨兵节点 dummyHead，它的 next 指向 head
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 2. 找到反转区间前面的节点 preLeftNode
        // preLeftNode 在 left 的前面一个位置
        ListNode preLeftNode = dummyHead;
        for (int i = 1; i < left; i++) {
            preLeftNode = preLeftNode.next;
        }

        // 3. 定义反转区间的开头 leftNode
        // leftNode 是反转区间的开头，反转后会变成尾部
        ListNode leftNode = preLeftNode.next;

        // 4. 定义反转区间的指标
        ListNode pre = null;
        ListNode cur = leftNode;

        // 5. 进行反转
        for (int i = 0; i < right - left + 1; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        // 6. 重新连接链表
        // preLeftNode 连接到反转后的头部 pre
        preLeftNode.next = pre;
        // 反转后的尾部 leftNode 连接到后面的 cur
        leftNode.next = cur;

        // 7. 返回哨兵节点的 next，就是新的头部
        return dummyHead.next;
    }
}
