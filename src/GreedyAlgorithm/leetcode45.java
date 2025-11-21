package GreedyAlgorithm;

/**
 * 跳跃游戏Ⅱ
 */
public class leetcode45 {
    public static void main(String[] args){

    }
}

class Solution45{
    /**
     * 可以将这个场景想象成建桥
     * 把区间[i, i + nums[i]]视作一座桥，一开始只能建一座桥，[0, nums[0]].
     * 在可以选的桥中，选择右端点最大的桥、
     * 两个说明：
     * <p>
     *     1.为什么走到头了才跳是对的，题意不应该是从中间某座桥的起点位置就跳吗？
     *      因为在同一座桥上走回头路并不会让你的跳跃次数+1
     * </p>
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums){
        int ans = 0;
        int curRight = 0; //已建造桥的右端点
        int nextRight = 0; //下一座桥的右端点的最大值
        for (int i = 0; i < nums.length - 1; i++) {
            nextRight = Math.max(nextRight, i + nums[i]);
            if (i == curRight){
                curRight =  nextRight;
                ans++;
            }
        }
        return ans;
    }
}
