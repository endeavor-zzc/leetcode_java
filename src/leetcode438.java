import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class leetcode438 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.next();
        String string2 = scanner.next();
        Solution438  solution438 = new Solution438();
        List<Integer> result = solution438.findAnagrams(string1, string2);
        System.out.println(result);
    }
}

class Solution438{
    /**
     * 使用两个数组来记录字符串出现的次数，
     * @param s 给定字符串
     * @param p 子串
     * @return 返回值是一个List列表
     */
    public List<Integer> findAnagrams(String s, String p){
        int p_length = p.length();
        int s_length = s.length();
        List<Integer> result = new ArrayList<>();
        int[] pSet = new int[26];
        int[] sSet = new int[26];
        if (s_length < p_length)
            return result;
        for (int i = 0; i < p_length; i++) {
            pSet[p.charAt(i) - 'a'] += 1;
            sSet[s.charAt(i) - 'a'] += 1;
        }
        if (Arrays.equals(pSet, sSet)){
            result.add(0);
        }
        for (int i = 0; i < s_length - p_length; i++) {
            /**
             * 这里如果一开始判断，无法判断最后的滑动窗口，会跳出循环。为了解决这个问题
             * 要首先判断开头的滑动窗口，然后再进行滑动，这样就可以判断最后的滑动窗口
             */
            sSet[s.charAt(i) - 'a'] -= 1;
            sSet[s.charAt(p_length + i) - 'a'] += 1;
            if (Arrays.equals(pSet, sSet)){
                result.add(i + 1);
            }
        }
        return result;
    }
}