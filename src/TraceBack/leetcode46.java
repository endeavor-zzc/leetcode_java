package TraceBack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 */
public class leetcode46 {
    public static void main(String[] args){

    }
}

class Solution46{
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for(int num : nums){
            output.add(num);
        }
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;

    }

    /**
     *
     * @param n 数组长度
     * @param output 其中一种排列情况的数组
     * @param res 所有排列情况的数组
     * @param first
     */
    /*
        回溯过程示意（nums = [1,2,3]）：
                [1,2,3]
               /    |    \
         [1,2,3] [2,1,3] [3,2,1]
           |         |        |
         [1,3,2] [2,3,1] [3,1,2]

        核心逻辑：
        1. swap(first, i)   —— 做出选择
        2. backtrack(...)   —— 递归探索
        3. swap(first, i)   —— 撤销选择（回溯）
     */
    /*
    第一层递归
    | i | 交换操作    | 结果output| 含义       |
    | 0 | swap(0,0) | [1,2,3]  | 第一个位置放1 |
    | 1 | swap(0,1) | [2,1,3]  | 第一个位置放2 |
    | 2 | swap(0,2) | [3,2,1]  | 第一个位置放3 |
    第二层递归

     */
    private void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first){
        if (first == n)
            res.add(new ArrayList<>(output));  //这里不是add(output)否则 res 中保存的是对同一output的引用，最后都会变为同一个排列
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrack(n, output, res, first + 1);
            Collections.swap(output, first, i); //回溯
        }
    }
}
