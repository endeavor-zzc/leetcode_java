package DynamicProgramming;

import java.util.Arrays;

/**
 * 分割等和子集
 */
public class leetcode416 {
    public static void main(String[] args){

    }
}


class Solution416{
    public boolean canPartition(int[] nums){
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        boolean[] dp = new boolean[sum / 2 + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum / 2];
    }
}