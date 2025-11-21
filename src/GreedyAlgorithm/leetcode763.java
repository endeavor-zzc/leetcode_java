package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 划分字母区间
 */
public class leetcode763 {
    public static void main(String[] args){

    }
}

class Solution763{
    /**
     * 和合并区间本质是一样的
     * 先统计出字母出现的位置，然后再合并
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s){
        char[] chars = s.toCharArray();
        int n = s.length();
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[chars[i] - 'a'] = i;  //记录每个字母最后出现的下标
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[chars[i] - 'a']);
            if (end == i){
                ans.add(end - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}