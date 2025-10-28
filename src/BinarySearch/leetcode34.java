package BinarySearch;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class leetcode34 {
    public static void main(String[] args){

    }
}

class Solution34{
    public int[] searchRange(int[] nums, int target){
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != start){
            return new int[]{-1, -1};
        }
        int end = lowerBound(nums, target + 1) - 1;  //这步最关键
        return new int[]{start, end};
    }

    private int lowerBound(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
