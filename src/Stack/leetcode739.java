package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 每日温度
 */
public class leetcode739 {
    public static void main(String[] args){

    }
}

class Solution739{
    /**
     * 存储的是索引，这样好计算出天数，
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures){
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > temperatures[stack.peek()]){
                int j = stack.pop();
                ans[j] = i - j;
            }
            stack.push(i);
        }
        return ans;
    }
}
