package ListNode;

/**
 * 随机链表的复制
 */

class Node{
    int val;
    Node next;
    Node random;
    public Node(int val, Node next){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class leetcode138 {

    /**
     * 例如链表 1→2→3，依次复制每个节点（创建新节点并复制 val 和 next），把新节点直接插到原节点的后面，形成一个交错链表：
     * 1→1'→2→2'→3→3'
     * 如此一来，原链表节点的下一个节点，就是其对应的新链表节点了！
     * 然后遍历这个交错链表，假如节点 1 的 random 指向节点 3，那么就把节点 1'的 random 指向节点 3 的下一个节点 3'，这样就完成了对 random 指针的复制。
     * @param head
     * @return
     */
    public Node copyRandomList(Node head){
        if (head == null){
            return null;
        }
        // 复制每个节点，把新节点直接插到原节点后面
        for (Node cur = head; cur != null; cur = cur.next.next) {
            cur.next = new Node(cur.val, cur.next);
        }
        //遍历交错链表中的原链表节点
        for (Node cur = head; cur != null; cur = cur.next.next){
            if (cur.random != null){
                //要复制的random是cur.next的下一个节点
                //例如：cur.next为1‘，1’的random指向 1的random（3）的下一个即3’
                cur.next.random = cur.random.next;
            }
        }

        //把交错链表分离成两个链表
        Node newHead = head.next;
        Node cur = head;
        for (; cur.next.next != null; cur = cur.next){
            Node copy = cur.next;
            cur.next = copy.next;
            copy.next = copy.next.next;
        }
        cur.next = null;
        return newHead;
    }
}
