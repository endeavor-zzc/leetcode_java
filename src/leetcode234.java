import java.util.ArrayList;
import java.util.List;

public class leetcode234 {
    public static void main(String[] args){
        ListNode234 head = new ListNode234(1, new ListNode234(2,new ListNode234(2,new ListNode234(1))));
        Solution234_1 solution234_1 = new Solution234_1();
        boolean result = solution234_1.isPalindrome(head);
        System.out.println(result);
    }
}

/**
 * 这个创建链表的方式与下列创造列表方式不同：
 * 方法一：class ListNode {
 *     int val;
 *     ListNode next; // 成员变量的类型是ListNode
 *     ListNode (int x){
 *         val = x;
 *         next = null; // 默认next的值是null
 *     }
 * }
 * 方法一只有一个构造函数，只能用 new ListNode(5) 的方式创建一个节点，默认 next = null
 * 如果要连接链表，必须手动赋值node.next = new ListNode(6);
 *
 * 而本题中的方法提供了三个构造函数，更加灵活，
 * new ListNode234(5, new ListNode234(6))  直接创造了一个5->6的节点
 *
 */
class ListNode234{
    int val;
    ListNode234 next;
    ListNode234() {}
    ListNode234(int val){
        this.val = val;
    }
    ListNode234(int val, ListNode234 next){
        this.val = val;
        this.next = next;
    }
}

class Solution234_1 {
    /**
     * 为了好操作，首先将链表的值复制到数组列表中去，然后利用双指针来判断是否为回文数字
     * @param head 链表的头节点
     * @return 布尔值
     */
    public boolean isPalindrome(ListNode234 head){
        List<Integer> vals = new ArrayList<>();

        //复制链表到数组链表中去
        ListNode234 current = head;
        while (current != null){
            vals.add(current.val);
            current = current.next;
        }

        //判断是否为回文数字
        int front = 0;
        int back = vals.size() - 1;
        while (front < back){
            if(!(vals.get(front)).equals(vals.get(back))){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}

class Solution234_2{
    /**
     * 通过寻找链表的中间节点，之后翻转中间节点之后的链表，与前半部分的值进行比较
     * 链表节点是偶数个的话，取中间节点的后一个
     * 1->2->2->1
     * 变为1—>2->2   2->1
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode234 head){
        ListNode234 mid = midNode(head);
        ListNode234 head2 = reverseNode(mid);
        while (head2 != null){
            if (head.val != head2.val){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }


    //寻找链表中间节点

    /**
     * 通过快慢指针寻找中间节点：慢指针走一步，快指针走两步。
     * 当快指针为空或者下一个节点为空时，慢指针恰好指向中间节点
     * @param head
     * @return
     */
    private ListNode234 midNode(ListNode234 head){
        ListNode234 slow = head;
        ListNode234 fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //反转链表
    private ListNode234 reverseNode(ListNode234 head){
        ListNode234 pre = null;
        ListNode234 cur = head;
        while (cur != null){
            ListNode234 nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
