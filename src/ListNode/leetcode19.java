package ListNode;

public class leetcode19 {
    public static void main(String[] args){
        ListNode list = new ListNode(7, new ListNode(0, new ListNode(8)));
        Solution19_2 solution192 = new Solution19_2();
        ListNode result = solution192.removeNthFromEnd(list, 2);
        while(result != null){
            System.out.print(result.val);
            if (result.next != null)
                System.out.print("->");
            result = result.next;
        }
    }
}

class Solution19_1 {
    /**
     * 翻转两次
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverseList(head);
        if (n == 1){
            head = head.next;
        }else {
            ListNode cur = head;
            for (int i = 1; i < n - 1 && cur != null; i++) {
                cur = cur.next;
            }
            if (cur != null && cur.next != null) //如果cur不为空而且下一个也不为空
                cur.next = cur.next.next;
        }
        head = reverseList(head);
        return head;
    }

    private ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}

class Solution19_2{
    /**
     * 相当于一把固定长度的尺子，左端点在头部，右端点在第n个位置，当右端点移动到最后一个节点的时候，刚好左端点在倒数第n个位置
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode NewList = new ListNode(0,head);
        ListNode left = NewList;
        ListNode right = NewList;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right.next != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return NewList.next;
    }
}
