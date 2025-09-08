package DoublePointer;

import java.util.Arrays;
import java.util.Scanner;

public class leetcode283 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一串数字");
        String input = scanner.nextLine();
        String[] strings = input.split(",");
        int[] nums = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        Solution283_double_pointer solution283 = new Solution283_double_pointer();
        solution283.moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution283{
    /**
     * 这种方法是利用一个指针将非零元素全部挪到左边，剩下的位置补0
     * @param nums 目标数组
     */
    public void moveZeros(int[] nums){
        int n = nums.length;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0){
                nums[left] = nums[i];
                left++;
            }
        }
        for (int i = left; i < n; i++) {
            nums[i] = 0;
        }
    }
}

class Solution283_double_pointer{
    /**
     * 使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
     * 注意到以下性质：
     * 左指针左边均为非零数；
     * 右指针左边直到左指针处均为零。
     * 因此每次交换，都是将左指针的零与右指针的非零数交换，且非零数的相对顺序并未改变。
     * @param nums 目标数组
     */
    public void moveZeros(int[] nums){
        int n = nums.length;
        int left = 0;
        int right = 0;
        while(right < n){
            if(nums[right] != 0){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right){
        int temp;
        temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
