import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class leetcode3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数据");
        String input = scanner.nextLine();
        Solution3 solution3 = new Solution3();
        int result = solution3.lengthOfLongestSubstring(input);
        System.out.println(result);
    }
}

class Solution3{
    /**
     * 从字符串开始出发，遍历每个字符开头的最长无重复子序列
     * @param s 目标字符串
     * @return
     */
    public int lengthOfLongestSubstring(String s){
        Set<Character> list = new HashSet<>(); //哈希集合里面不允许有重复数组
        int end = -1; //表示从字符串最左端开始
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0)
                list.remove(s.charAt(i - 1));  //表示移除上一个区间的开头字符串
            while (end + 1< s.length() && !list.contains(s.charAt(end + 1))){
               list.add(s.charAt(end + 1));
               end++;
            }
            result = Math.max(result, end - i + 1);
        }
        return  result;
    }
}
