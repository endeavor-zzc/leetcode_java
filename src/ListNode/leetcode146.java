package ListNode;

import java.lang.classfile.instruction.NewObjectInstruction;
import java.util.HashMap;
import java.util.Map;

class LRUCache{
    private static class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Node NewNode = new Node(0,0);//哨兵节点
    private final Map<Integer, Node> keyToNode = new HashMap<>();

    /**
     * cache初始化
     * @param capacity 容量大小
     */
    public LRUCache(int capacity){
        this.capacity = capacity;
        NewNode.next = NewNode;
        NewNode.prev = NewNode;
    }

    public int get(int key){
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value){
        Node node = getNode(key);
        if (node != null){
            node.value = value;
        }
        node = new Node(key, value);
        keyToNode.put(key, node);
        pushFront(node);
        if (keyToNode.size() > capacity){
            Node lastNode = NewNode.prev;
            keyToNode.remove(lastNode.key);
//            keyToNode.remove(key, lastNode);不能写成这样，因为key和lastnode不相等，会导致删除失败，还在哈希表里
            removeNode(lastNode);
        }
    }

    /**
     * 获取对应key的节点，并把节点移到头部
     * @param key
     * @return 节点
     */
    private Node getNode(int key){
        if(!keyToNode.containsKey(key))
            return null;
        Node node = keyToNode.get(key);
        removeNode(node); //把这本书抽出来
        pushFront(node); //放到最上面
        return node;
    }

    private void removeNode(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    private void pushFront(Node x){
        x.prev = NewNode;
        x.next = NewNode.next;
        x.prev.next = x;
        x.next.prev = x;
    }
}