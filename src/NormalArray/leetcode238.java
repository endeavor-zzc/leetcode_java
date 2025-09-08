package NormalArray;

import java.util.Scanner;

public class leetcode238 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strs = input.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        Solution238 solution238 = new Solution238();
        int[] result = solution238.productExceptSelf(nums);
        for (int i : result)
            System.out.print(i + " ");
    }
}

class Solution238{
    /**
     * 核心思想是分别计算以i为节点，分别计算出i之前的乘积和i之后的乘积。两者相乘
     * 1 2 3 4
     * i节点之前：1 1 2 6
     * i节点之后：24 12 4 1
     *
     * @param nums 操作数组
     * @return 返回新数组
     */
    public int[] productExceptSelf(int[] nums){
        int[] pre = new int[nums.length];
        pre[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        int[] after = new int[nums.length];
        after[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            after[i] = after[i + 1] * nums[i + 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = pre[i] * after[i];
        }
        return result;
    }
}
