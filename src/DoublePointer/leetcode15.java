package DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class leetcode15 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数据");
        String input = scanner.nextLine();
        String[] strings = input.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        Solution15 solution15 = new Solution15();
        List<List<Integer>> result = solution15.threeSum(nums);
        System.out.println(result);
    }
}

class Solution15{
    /**
     * 将数组从小到大排序之后，固定第一个数字之后，当b开始从左向右移动时，b从小变大
     * 要维持和为0时，c肯定要相应的变小，所以c要从右向左移动。
     * b 和 c 是并列循环
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();//创建一个数组列表，来存储结果，声明列表时要与函数的类型一样，不然返回结果的时候会报错
//      这样会报错  ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1])  //如果下一个元素和当前元素相同，则跳过，避免重复
                continue;
            int target = -nums[a];
            int c = nums.length - 1;
            for (int b = a + 1; b < nums.length; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                while(b < c && nums[b] + nums[c] > target)
                    c--;
                if (b == c)
                    break;
                if (nums[b] + nums[c] == target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
