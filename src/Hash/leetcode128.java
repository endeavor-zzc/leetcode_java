package Hash;

import java.util.Arrays;
import java.util.Scanner;

public class leetcode128 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一串数字");

        String input = scanner.nextLine();
        String[] strs = input.split(",");
        int[] nums = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        Solution128 solution128 = new Solution128();
        int result = solution128.longestConsecutive(nums);
        System.out.println(result);
    }
}

class Solution128 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        var max = 0; // 记录最大长度
        var temp = 1; // 记录临时最大长度
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1])
                continue;
            if (nums[i] + 1 == nums[i + 1]) {
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 1;
            }
        }
        max = Math.max(max, temp); // 如果出现0 1 2 3 4这样的，重新赋值，防止temp丢失
        return max;
    }
}
