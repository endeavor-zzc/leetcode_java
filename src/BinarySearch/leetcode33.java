package BinarySearch;

public class leetcode33 {
    public static void main(String[] args){

    }
}

class Solution33{
    public int search(int[] nums, int target){
        int n = nums.length;
        int min = findMin(nums);
        if (target > nums[n - 1]){ //目标在第一段   这块区间要写对
            return lowerBound(nums, 0, min - 1, target);   //****
        }else {
            return lowerBound(nums, min, n - 1, target);
        }
    }


    /**
     * 寻找数组最小值的下标
     * @param nums
     * @return
     */
    private int findMin(int[] nums){
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] <= nums[n - 1]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private int lowerBound(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
