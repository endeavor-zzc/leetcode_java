package NormalArray;

/**
 * 缺失的第一个正数
 */
public class leetcode41 {
    public static void main(String[] args){

    }
}

/**
 * 思路：
 * 想象有一间教室，座位从左到右编号1到n.
 * 有n个学生需要按学号坐到相应的座位上去
 * 比如  1坐在1上，2坐在2上  然后一一交换位置
 * 当循环结束后，从左向右排列，第一个座位与学号不符的就是答案
 * 如果都正确，那么答案就是n+1
 */
class Solution41{
    public int firstMissingPositive(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] < n && nums[i] != nums[nums[i] - 1]){
                int j = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                /*int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;  不能这样写
                当你执行 nums[i] = nums[nums[i] - 1] 之后，nums[i] 已经被改变，原本的值丢失了！*/
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }
}
