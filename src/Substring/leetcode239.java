package Substring;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode239 {
    public static void main(String[] args){

    }
}

class Solution239{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();  //保证队列是单调递减的，第一个永远是最大值
            }
            q.addLast(i); //保存的是下标
            //队首存的是最大值的下标
            int left = i - k + 1;
            if (q.getFirst() < left) {
                q.removeFirst();
            }

            if (left >= 0) {
                result[left] = nums[q.getFirst()];
            }
        }
        return result;
    }

}

