public class leetcode141 {
    public static void main(String[] args){
        ListNode141 head = new ListNode141(1);
        head.next = new ListNode141(2);
        head.next.next = new ListNode141(3);
        head.next.next.next = new ListNode141(4);
        head.next.next.next = head.next;
        Solution141 solution141 = new Solution141();
        boolean result = solution141.hasCycle(head);
        System.out.println(result);
    }
}

class ListNode141{
    int val;
    ListNode141 next;
    ListNode141() {}
    ListNode141(int x){
        val = x;
        next = null;
    }
}

class Solution141 {
    /**
     * 利用快慢指针，如果快指针追上了慢指针（套圈），则证明有环存在
     *
     * @param head 链表头节点
     * @return 返回结果
     */
    public boolean hasCycle(ListNode141 head) {
        ListNode141 slow = head;
        ListNode141 fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            //注意这里比较的是地址不是值大小，因为一个链表可能出现多个相同的值
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
