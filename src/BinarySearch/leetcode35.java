package BinarySearch;


/**
 * 搜索插入位置
 */
public class leetcode35 {
    public static void main(String[] args){

    }
}


class Solution35{
    /**
     * 不需要额外判断nums[mid]=target 的情况
     * 不是立刻返回的原因是  在二分查找的过程中，可能不是第一个等于target的下标
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else
                right = mid - 1;
        }
        return left;
    }
}