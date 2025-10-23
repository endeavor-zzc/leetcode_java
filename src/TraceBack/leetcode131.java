package TraceBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割回文串
 */
public class leetcode131 {
    public static void main(String[] args){

    }
}

class Solution131{
    public List<List<String>> partition(String s){
        List<List<String>> result = new ArrayList<>();
        List<String> output = new ArrayList<>();
        backtrack(result, output, s, 0);
        return result;
    }


    private boolean justice(String s){
        String sb = new StringBuilder(s).reverse().toString();
        return sb.equals(s);
    }

    private void backtrack(List<List<String>> result, List<String> output, String s, int index){
        if (index == s.length()){
            result.add(new ArrayList<>(output));
        }
        for (int i = index; i < s.length(); i++) {
            if (justice(s.substring(index, i + 1))){
//            if (isPalindrome(s, index, i)){
                output.add(s.substring(index, i + 1));
                backtrack(result, output, s, i + 1);
                output.removeLast();
            }
        }
    }

    //判断回文串的新函数
    private boolean isPalindrome(String s, int left, int right){
        while (left < right){
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
