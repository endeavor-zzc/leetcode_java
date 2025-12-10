package Skill;

/**
 * 颜色分类
 */
public class leetcode75 {
    /**
     * 现在有三个区域，0区 1区 2区
     *
     * @param nums
     */

    public void sortColors(int[] nums){
        int low = 0; //  0区的下一个位置，用于放置0
        int mid = 0; // 当前正在处理的位置
        int high = nums.length - 1; // 2区的前一个位置
        while(mid <= high){
            if (nums[mid] == 0){ //要交换到0区
                swap(nums, low, mid);
                low += 1;
                mid += 1;
            } else if (nums[mid] == 1) {
                    mid += 1;
            }else {
                swap(nums, mid, high);
                high -= 1;  //mid不动，是因为交换过来的可能还需要做判断
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
