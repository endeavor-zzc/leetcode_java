package NormalArray;

import java.util.Scanner;

public class leetcode53 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组");
        String input = scanner.nextLine();
        String[] strings = input.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        Solution53 solution53 = new Solution53();
        int result = solution53.maxSubArray(nums);
        System.out.println(result);
    }
}

class Solution53{
    /**
     * 还是利用前缀和的概念,因为是连续数组，可以考虑使用前缀和
     * 当前的前缀和减去在这之前的最小前缀和就是这一段数组的最大值。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums){
        int max = Integer.MIN_VALUE;
        int presum = 0; // 当前的前缀和
        int min_presum = 0; //最小的前缀和
        for (int num : nums) {
            presum += num;
            max = Math.max(max, presum - min_presum);
            min_presum = Math.min(presum, min_presum);
        }
        return max;
    }
}