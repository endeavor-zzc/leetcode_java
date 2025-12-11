package ListNode;

public class leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //统计节点个数
        int n = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p0 = dummy;
        ListNode pre = null;
        ListNode cur = head;
        for (; n >= k; n -= k) {
            for (int i = 0; i < k; i++) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }

            /**
             * 每次组反转结束后 cur指向下一个组的头结点 pre指向本组头节点（反转后的） 也即是反转前该组尾结点
             * 而p0是 进行反转操作的组的头结点的上一个节点（组的上一个节点）
             * 所以 p0.next（进行反转操作的组的头结点，在反转结束后是尾结点） 要指向 下个组的头结点cur =>p0.next.next=cur;
             * p0 此时依然是进行反转操作的组的头结点的上一个节点，我们希望该节点（也是上一个进行反转操作的组的尾结点）指向
             * 反转后本组头节点（这样就连上了）
             * 最后，保持p0的本质，更新p0为此次反转操作结束、下个待反转操作的组的头结点的上一个节点
             */
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }
}
