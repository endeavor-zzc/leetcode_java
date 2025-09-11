package ListNode;

public class leetcode148 {
    public static void main(String[] args){
        ListNode list1 = new ListNode(7, new ListNode(0, new ListNode(8, new ListNode( 10))));
        Solution148 solution148 = new Solution148();
        ListNode result = solution148.sortList(list1);
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null)
                System.out.print("->");
            result = result.next;
        }
    }
}

class Solution148{
    /**
     * 用归并排序，首先找到链表的中间节点，然后一分为2，这样就变成了两个有序数组排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null)
            return head;

        //找到中间节点
        ListNode head2 = FindMidNode(head);

        //分治
        head = sortList(head);
        head2 = sortList(head2);

        return mergeTwoList(head, head2);
    }

    private ListNode FindMidNode(ListNode head){
        ListNode pre = head; //记录slow前一个位置，方便断开成两个链表
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null; //断开slow与前一个连接
        return slow;
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2){
        ListNode NewList = new ListNode();
        ListNode cur = NewList;
        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = (list1 != null ? list1 : list2);
        return NewList.next;
    }
}

class Solution148_2{
    /**
     * 方法2是自底向上的归并排序，采用迭代的方法
     * 即先归并长度为1的链表，4 2 3 1  变为  2 4 1 3
     * 然后再归并长度为2的链表，变为 1 2 3 4
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head){
        int length = getListLength(head);
        ListNode NewList = new ListNode(0, head);
        for (int i = 1; i < length; i *= 2) {
            ListNode newTail = NewList; // 用来记录新链表的末尾，方便将排完序的链表插入进来
            ListNode cur = NewList.next; //记录当前处理的节点
            while (cur != null){
                ListNode head1 = cur; // head1 = 4
                ListNode head2 = spiltList(cur, i); // head2 = 2, 这时候 4 与 2->3->1断开
                //更新下一轮循环
                cur = spiltList(head2, i);  // 这时候cur = 3. 2与3->1断开

                ListNode[] merged = mergeTwoList(head1, head2);
                newTail.next = merged[0]; //  2->4
                newTail = merged[1];  // 4的位置
            }
        }
        return NewList.next;
    }

    /**
     * 计算链表长度
     * @param head
     * @return 返回长度值
     */
    private int getListLength(ListNode head){
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 分割链表
     * @param head 要分割的链表
     * @param size 分割的长度
     * @return 后一个链表的头节点
     */
    private ListNode spiltList(ListNode head, int size){
        ListNode cur = head;
        for (int i = 0; i < size - 1; i++) {
            cur = cur.next;
        }

        if (cur == null || cur.next == null){
            return null;
        }

        ListNode nexthead = cur.next;
        cur.next = null;
        return nexthead;
    }


    /**
     * 合并两个有序链表
     * @param list1
     * @param list2
     * @return 返回链表数组，第一个表示合并后链表的头节点，第二个表示合并后的尾节点
     */
    private ListNode[] mergeTwoList(ListNode list1, ListNode list2){
        ListNode NewList = new ListNode();
        ListNode cur = NewList;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                cur = list1;
                list1 = list1.next;
            }else {
                cur = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = (list1 != null ? list1 : list2);
        // 使cur走到尾节点
        while (cur != null){
            cur = cur.next;
        }

        return new ListNode[]{NewList.next, cur};
    }
}

