package ListNode;

public class leetcode2 {
    public static void main(String[] args){

    }
}

class Solution2{
    /**
     * 和21题类似都是创建一个哨兵节点，这样就不用考虑节点为空的情况了
     * 返回值是哨兵节点的下一个，也就是头节点
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode NewList = new ListNode();
        ListNode cur = NewList;
        int num = 0; //记录进位数字 同时也是两个数字相加的中转站
        while(l1 != null || l2 != null || num != 0){
            if (l1 != null) {
                num += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                num += l2.val;
                l2 = l2.next;
            }
            // 前面两个if循环结束后，num存储的是进位加两个节点的和
            //首先创建一个新节点来连接到cur的下一个值
            cur.next = new ListNode(num % 10);
            cur = cur.next;
            num /= 10;
        }
        return NewList.next;
    }
}