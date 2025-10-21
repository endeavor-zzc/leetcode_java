package TraceBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 */
public class leetcode39 {
    public static void main(String[] args){

    }
}

class Solution39{
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        backtrack(candidates, target, result, output, 0);
        return result;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> output, int index){
        if (target == 0){
            result.add(new ArrayList<>(output));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i])
                continue;
            output.add(candidates[i]);
            backtrack(candidates, target - candidates[i], result, output, i); //这里不是i+1是因为可以有重复数字  不能是index是因为不能出现相同的数字组合，比如223 232
            output.removeLast();
        }
    }
}