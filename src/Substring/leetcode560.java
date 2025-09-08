package Substring;

import java.util.*;

public class leetcode560 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入整数数组");
        String input = scanner.nextLine();
        String[] strings = input.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.println("输入整数");
        int number = scanner.nextInt();
        Solution560 solution560 = new Solution560();
        int result = solution560.subarraySum(nums, number);
        System.out.println(result);
    }
}

class Solution560{
    /**
     * 暴力求解
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum_BruteForce(int[] nums, int k){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (nums[i] == k){
                result++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k){
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 使用前缀和的概念.
     * 前缀和：对于数组中的任何位置 j，前缀和 sum[j] 是数组中从第一个元素到第 j 个元素的总和。这意味着如果你想知道从元素 i+1 到 j 的子数组的和
     * sum[j] - sum[i] = k表示从元素i+1到元素j之和为k
     * sum[i] = sum[j]-k 表示当前累积和为sum[j]，从某个点的累积和是sum[i],从某个点到当前的累积和的子数组和为k
     * 统计sum[i]的数量，表示从不同起始点的累积和为k的数量
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k){
        int count = 0; //符合条件的个数
        int sum = 0; //前缀和
        Map<Integer, Integer> map = new HashMap<>();//<前缀和，出现的次数>
        /**
         * 一开始还没有加任何元素的时候，前缀和是 0
         * 某个前缀和 sum == k，那么就意味着从数组起始位置开始，到当前位置 i 的这段子数组本身就是一个答案。
         */
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /***
     * 输出符合结果的子数组
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum_output(int[] nums, int k){
        int count = 0;
        int sum = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>(List.of(-1)));
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k)){
                 for (int startIdx : map.get(sum - k)){
                     int from = startIdx + 1;
                     int to = i;
                     System.out.println("[");
                     for (int j = from; j < to; j++) {
                         System.out.println(nums[j] + (j < to ? "," : ""));
                     }
                     System.out.println("]");
                     count++;
                 }
            }
            map.put(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return count;
    }
}
