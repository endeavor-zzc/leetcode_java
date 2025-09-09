package ListNode;

public class leetcode21 {
    public static void main(String[] args){
        ListNode21 list1 = new ListNode21(1,new ListNode21(2,new ListNode21(4)));
        ListNode21 list2 = new ListNode21(2, new ListNode21(5));
        Solution21_2 solution212 = new Solution21_2();
        ListNode21 result = solution212.mergeTwoLists(list1, list2);
        while (result != null){
            System.out.print(result.val);
            if (result.next != null)
                System.out.print("->");
            result = result.next;
        }
    }
}

class ListNode21{
    int val;
    ListNode21 next;
    ListNode21() {}
    ListNode21(int val){
        this.val = val;
    }
    ListNode21(int val, ListNode21 next){
        this.val = val;
        this.next = next;
    }
}

class Solution21_1 {
    /**
     * 用迭代法，逐个比较
     * @param list1 第一个链表
     * @param list2 第二个链表
     * @return NewList的下一个，即头节点
     */
    public ListNode21 mergeTwoLists(ListNode21 list1, ListNode21 list2){
        //新创建一个链表，指向空，表示合并完链表之后的头节点的前一个节点，这样避免单独处理头节点
        ListNode21 NewList = new ListNode21();
        ListNode21 cur = NewList;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = (list1 != null ? list1 : list2); //将剩余的部分连接到NewList的尾部
        return NewList.next;
    }
}

class Solution21_2{
    /**
     *  递归的方法
     */
    public ListNode21 mergeTwoLists(ListNode21 list1, ListNode21 list2){
        if(list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
