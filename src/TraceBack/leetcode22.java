package TraceBack;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
    public static void main(String[] args){

    }
}

class Solution22{
    int length;
    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        length = 2 * n;
        backtrack(result, path, n, n);
        return result;
    }

    /**
     * 有左括号选左括号，没有左括号选右括号
     * @param result
     * @param path
     * @param left 左括号个数
     * @param right 右括号个数
     */
    private void backtrack(List<String> result, StringBuilder path, int left, int right){
        if (path.length() == length){
            result.add(path.toString());//保证path返回的是新的不可变的string类型的副本
            return;
        }
        if (left > 0){
            path.append("(");
            backtrack(result, path, left - 1, right);
            path.deleteCharAt(path.length() - 1);
        }
        if (right > 0 && right > left){
            path.append(")");
            backtrack(result, path, left, right - 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
