package DynamicProgramming;

/**
 * 最长有效括号
 */
public class leetcode32 {
    public static void main(String[] args){
        String s = "()";
        Solution32 solution32 = new Solution32();
        int ans = solution32.longestValidParentheses(s);
        System.out.println(ans);
    }
}

class Solution32{
    public int longestValidParentheses(String s){
        if (s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (chars[i] == ')'){
                //如果当前是右括号，判断左边位置是否有长度
                int length = dp[i - 1];
                //找到这个长度的括号，判断是否匹配
                int start = i - length - 1;
                if (start >= 0){
                    if (chars[start] == '(') {
                        dp[i] = dp[i - 1] + 2;
                        max = Math.max(dp[i], max);
                        //检查能够与之前的长度进行合并
                        if (start - 1 >= 0 && dp[start - 1] >= 0){
                            dp[i] = dp[i] + dp[start - 1];
                            max = Math.max(dp[i], max);
                        }
                    }
                }
            }
        }
        return max;
    }
}
