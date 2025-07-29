import java.util.Scanner;

public class leetcode189 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strs = input.split(",");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        Solution189 solution189 = new Solution189();
        solution189.rotate_reverse(nums, 3);
        for (int i : nums)
            System.out.print(i + ",");
    }
}

class Solution189{
    /**
     * 直接拷贝一个数组，然后将目标数填进去
     * @param nums 操作数组
     * @param k 移动次数
     */
    public void rotate(int[] nums, int k){
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(copy, 0, nums, 0,nums.length); //基于底层的拷贝。arraycopy(src, srcPos, dest, destPos, length)
    }

    /**
     * 1 2 3 4 5 6 7
     * 5 6 7 1 2 3 4
     * 首先翻转整个数组：7 6 5 4 3 2 1
     * 然后反转前k个数：5 6 7 4 3 2 1
     * 然后反转剩下的数字：5 6 7 1 2 3 4
     * @param nums 操作数组
     * @param k 移动次数
     */
    public void rotate_reverse(int[] nums, int k){
        k %= nums.length; //处理k大于数组长度的情况
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
