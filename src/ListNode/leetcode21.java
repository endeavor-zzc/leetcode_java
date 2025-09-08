package ListNode;

public class leetcode21 {
    public static void main(String[] args){

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

class Solution21{
    public ListNode21 mergeTwoLists(ListNode21 list1, ListNode21 list2){
        
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
        cur.next = (list1 != null ? list1 : list2);
        return NewList.next;
    }
}
