package Stack;

import java.util.*;

/**
 * 有效的括号
 */
public class leetcode20 {
    public static void main(String[] args){

    }
}

class Solution20{
    public boolean isValid(String s){
        //先判断长度，长度为奇数直接返回false
        if (s.length() % 2 != 0){
            return false;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.push(chars[i]);
            }else if (stack.isEmpty()){
                return false;
            } else if (chars[i] == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (chars[i] == ']' && stack.peek() == '[') {
                stack.pop();
            }else if (chars[i] == '}' && stack.peek() == '{') {
                stack.pop();
            }else {
                return false;
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}
