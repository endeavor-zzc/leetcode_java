package ListNode;

public class leetcode24 {
    public static void main(String[] args){
        ListNode list = new ListNode(7, new ListNode(0, new ListNode(8)));
        Solution24 solution24 = new Solution24();
        ListNode result = solution24.swapParis(list);
        while(result != null){
            System.out.print(result.val);
            if (result.next != null)
                System.out.print("->");
            result = result.next;
        }
    }
}

class Solution24 {
    /**
     *
     */
    public ListNode swapParis(ListNode head) {
        ListNode NewList = new ListNode(0, head);
        ListNode node0 = NewList;
        ListNode node1 = head;
        while(node1 != null && node1.next != null){
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;

            node0.next = node2; // 把0指向2
            node2.next = node1; // 2指向1
            node1.next = node3; // 1指向3

            // 更新节点位置
            node0 = node1;
            node1 = node3;
        }
        return NewList.next;
    }
}
