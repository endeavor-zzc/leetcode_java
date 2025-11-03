package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最小栈
 */
public class leetcode155 {
    public static void main(String[] args){

    }
}

/**
 * 采用一个额外的栈空间来记录最小值
 */
class MinStack{
    Deque<Integer> xStack;
    Deque<Integer> minStack;
    public MinStack(){
        xStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val){
        xStack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop(){
        xStack.pop();
        minStack.pop();
    }

    public int top(){
        return xStack.peek();
    }
    public int getMin(){
        return minStack.peek();
    }
}

/**
 * 使用额外的O(1)的辅助空间
 */
//TODO  完成额外的O(1)的辅助空间
class MinStack2{

}
