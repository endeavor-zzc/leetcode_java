package DynamicProgramming;

/**
 * 乘积最大子数组
 */
public class leetcode152 {
    public static void main(String[] args){

    }
}

class Solution{
    public int maxProduct(int[] nums){
        int n = nums.length;
        int[] dpMin = new int[n];  //表示以nums[i]结尾的子数组最大乘积
        int[] dpMax = new int[n];  //表示以nums[i]结尾的子数组最小乘积
        //初始化
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        int maxAns = nums[0];
        for (int i = 1; i < n; i++) {
            /*
            每个位置有三种可能：
            1、从当前元素重新开始（遇到0）
            2.前一个最大乘积*当前元素
            3.前一个最小乘积*当前元素（负负得正）
             */
            int situation1 = nums[i];
            int situation2 = dpMax[i - 1] * nums[i];  // 延续之前的乘积
            int situation3 = dpMin[i - 1] * nums[i];  // 负负得正的情况

            dpMax[i] = Math.max(situation1, Math.max(situation2, situation3));
            dpMin[i] = Math.min(situation1, Math.min(situation2, situation3));

            maxAns = Math.max(maxAns, dpMax[i]);
        }
        return maxAns;
    }
}
