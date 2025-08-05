public class leetcode206 {
    public static void main(String[] args){
        ListNode206 head = new ListNode206(1);
        head.next = new ListNode206(2);
        head.next.next = new ListNode206(3);
        head.next.next.next = new ListNode206(4);
        Solution206 solution206 = new Solution206();
        ListNode206 reverse = solution206.reverseList(head);

        while (reverse != null){
            System.out.print(reverse.val);
            if (reverse.next != null)
                System.out.print("->");
            reverse = reverse.next;
        }
    }
}

class ListNode206{
    int val;
    ListNode206 next;
    ListNode206(){}
    ListNode206(int val){
        this.val = val;
    }
    ListNode206(int val, ListNode206 next){
        this.val = val;
        this.next = next;
    }
}

class Solution206{
    /**
     *
     * @param head 头节点
     * @return 返回新链表的头节点
     */
    public ListNode206 reverseList(ListNode206 head){
        ListNode206 pre = null;
        ListNode206 cur = head;
        while(cur != null){
            ListNode206 nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}