package GreedyAlgorithm;

/**
 * 跳跃游戏
 */
public class leetcode55 {
    public static void main(String[] args){

    }
}

class Solution55{
    /**
     * 倒序遍历，只要前面某个位置能够到达终点，那么就只需考虑前面的能否到达该位置即可
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums){
        int last = nums.length - 1;
        for (int i = last; i >= 0; i--){
            if (i + nums[i] >= last){
                last = i;
            }
        }
        return last == 0;
    }
}
