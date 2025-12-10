package Skill;

/**
 * 下一个排列
 */
public class leetcode31 {
    /**
     * <p>
     *     分三步
     * </p>
     * <p>
     *     从右向左，找第一个小于右侧相邻数字的数x
     * </p>
     * <p>找x右边最小的大于x的数y,交换x和y的位置</p>
     * <p>反转y右边的数，把右边的数变成最小的排列</p>
     */
    public void nextPermutation(int[] nums){

        int n = nums.length;
        int i = n - 2; //从右向左找第一个小于右侧相邻数字的数
        while (i >= 0){
            if (nums[i] < nums[i + 1]){
                break;
            }
            i--;
        }
        if (i >= 0){
            //从右向左找到nums[i]右边最小大于nums的数
            int j = n - 1;
            while (nums[j] <= nums[i]){
                j--;
            }
            //找到之后交换位置
            swap(nums, i , j);
        }
        //反转nums[j]之后的数字
        reverse(nums, i + 1, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
