package Hash;

import java.util.HashMap;
import java.util.Scanner;

public class leetcode1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组长度");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("请输入数组");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println("请输入目标值");
        int target = scanner.nextInt();

        Solution2 solution = new Solution2();
        int[] result = solution.twoSum_HashMap(nums, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
        }
}
class Solution1{
    /**
     * 暴力枚举
     * @param nums 数组
     * @param target 目标值
     * @return 返回数组下标
     */
    public int[] twoSum_brute(int[] nums, int target){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {};
    }
}

class Solution2{
    /**
     * 使用哈希表
     * @param nums 数组
     * @param target 目标值
     * @return 返回数组下标
     */
    public int[] twoSum_HashMap(int[]nums, int target){
        //1、创建哈希表
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]), i};
            }
                hashMap.put(nums[i], i);
        }
        return new int[] {};
    }
}