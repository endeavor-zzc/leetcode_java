package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 */
public class leetcode84 {
    public static void main(String[] args){

    }
}

class Solution84{
    /**
     * 对每个柱子   找到左边第一个比它低的柱子  右边第一个比它低的柱子
     * 维护一个单调栈
     * 那么它能延伸的宽度 = right[i] - left[i] - 1
     * 面积 = heights[i] * (right[i] - left[i] - 1)
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights){
        int result = 0;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);  //现在栈里加入-1，表示初始状态，最后栈里只剩-1说明所有柱子都处理完了
        for (int right = 0; right <= n; right++) { //right == n 时人为加入一个高度 -1，相当于强制清空栈，把所有柱子都处理完。
            int h = heights[right] < n ? heights[right] :-1;
            /*
            如果当前柱子比栈顶柱子高，入栈；
            如果当前柱子比栈顶柱子矮，就说明：
            “栈顶柱子的右边界到了”。
             */
            while (!stack.isEmpty() && h <= heights[stack.peek()]){
                int i = stack.pop();
                int left = stack.peek();
                result = Math.max(result, heights[i] * (right - left - 1));
            }
            stack.push(right);
        }
        return result;
    }
}
