package DoublePointer;

import java.util.Scanner;

public class leetcode11 {
    public static void main(String[] args){
        int result;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数据");
        String input = scanner.nextLine();
        String[] strings = input.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        Solution11 solution11 = new Solution11();
        result = solution11.maxArea(nums);
        System.out.println(result);
    }
}
class Solution11{
    /**
     * 双指针，一个指针指向开头，一个指针指向末尾，相当于拿着一块大木板找更大的木板
     * @param height
     * @return
     */
    public int maxArea(int[] height){
        int max = 0;
        int left = 0; //左指针，指向开头
        int right = height.length - 1;//右指针，指向数组末尾
        while (left < right){
            int temp = Math.min(height[left],height[right]) * (right - left);
            max = Math.max(max, temp);
            if (height[left] <= height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}
