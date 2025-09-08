package ListNode;

public class leetcode142 {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next = head.next;
        Solution142 solution142 = new Solution142();
        ListNode result = solution142.detectCycle(head);

        System.out.println(result.val);
    }
}

class Solution142{
    /**
     * 这个题要计算出快慢指针相遇的位置，当快慢指针相遇的时候，慢指针再走a步就是相遇点
     * 这个题可以假设出从操场入口到操场有a步，相当于的从头节点到入环点有a步，
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow){
                while (slow != head){
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }
}
