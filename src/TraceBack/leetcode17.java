package TraceBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 */
public class leetcode17 {
    public static void main(String[] args){

    }
}

class Solution17{
    private String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"};
    private StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        if(digits.isEmpty())
            return result;
        backtrack(digits, 0, result);
        return result;
    }


    private void backtrack(String digits, int index, List<String> result){
        if (sb.length() == digits.length()){
            result.add(sb.toString());
        }
        String val = map[digits.charAt(index) - '2']; //减2正好把下标变成0，9变成7
        for (char ch : val.toCharArray()){
            sb.append(ch);
            backtrack(digits, index + 1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
