package DynamicProgramming;

import java.util.Arrays;

/**
 * 完全平方数
 */
public class leetcode279 {
    public static void main(String[] args){

    }
}

class Solution279{
    public int numSquares(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n); //初始化成n
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i] , dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
