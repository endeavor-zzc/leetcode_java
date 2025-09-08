package ListNode;

public class leetcode160 {
    public static void main(String[] args){
        //创建公共部分：交叉节点及其后续
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(10);

        //创建链表A: 4->1->8->10
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersect;

        //创建链表B: 5->6->1->8->10
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersect;

        Solution160 solution160 = new Solution160();
        ListNode result = solution160.getIntersectionNode(headA, headB);

        if (result != null)
            System.out.println(result.val);
        else
            System.out.println("no intersection");

    }
}

// 构建链表结构
class ListNode {
    int val;
    ListNode next; // 成员变量的类型是ListNode
    ListNode (int x){
        val = x;
        next = null; // 默认next的值是null
    }
}
class Solution160{
    /**
     * 利用双指针
     *     a1->a2->c1->c2->c3
     * b1->b2->b3->c1->c2->c3
     * (2+3)+3 = (3+3)+2
     * 表示 p 和 q 两个指针分别出发，如果 p 不是空节点，则更新为 p.next，如果是空节点，则跳到 headB
     * 同理 q 也是。
     * 最后 p = q 的时候则是两个链表相交的起始点
     * 如果两条链表不相交，则 p=q 为 null
     * @param headA 第一个链表的头节点
     * @param headB 第二个链表的头节点
     * @return 返回相交的起始点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode p = headA;
        ListNode q = headB;
        while(p != q){
            p = (p != null ? p.next : headB);
            q = (q != null ? q.next : headA);
        }
        return p;
    }
}

