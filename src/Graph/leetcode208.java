package Graph;

import java.util.Locale;

public class leetcode208 {
    public static void main(String[] args){

    }
}

class Trie{
    /**
     * 创建一颗26叉树
     */
    private static class Node{
        Node[] son = new Node[26];
        boolean end = false;
    }

    private final Node root = new Node();

    /**
     * 遍历字符串，用cur节点表示当前遍历到word中的哪个位置
     *
     * @param word
     */
    public void insert(String word){
        Node cur = root;
        for (char c : word.toCharArray()){
            c -= 'a';
            if (cur.son[c] == null) // 如果下一项为空，就创建一个新节点
                cur.son[c] = new Node();
            cur = cur.son[c];
        }
        cur.end = true; //遍历完end为true
    }

    private int find(String word){
        Node cur = root;
        for (char c : word.toCharArray()){
            c -= 'a';
            if (cur.son[c] == null) //如果为空，直接返回0.search和startsWith函数收到0返回false
                return 0;
            cur = cur.son[c];
        }
        return cur.end ? 2 : 1; //返回2表示完全匹配，返回1表示部分匹配
    }
    public boolean search(String word){
        return find(word) == 2;
    }

    public boolean startsWith(String prefix){
        return find(prefix) != 0;  //会出现等于2和等于1的情况
    }
}
