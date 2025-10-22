package TraceBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class leetcode78 {
    public static void main(String[] args){

    }
}

class Solution78{
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        backtrack(nums, output, res, 0);
        return res;
    }

    /*
        示例（nums = [1,2,3]）：
        []
        ├─ [1]
        │  ├─ [1,2]
        │  │  └─ [1,2,3]
        │  └─ [1,3]
        ├─ [2]
        │  └─ [2,3]
        └─ [3]
        下一个该选哪个
     */
    private void backtrack(int[] nums, List<Integer> output, List<List<Integer>> res, int i){
        //每次进入递归，当前的output表示已经选择的一部分
        res.add(new ArrayList<>(output));
        for (int j = i; j < nums.length; j++) {
            output.add(nums[j]);
            //这里不能是i+1，因为j表示的当前数组的下标，下一层递归应该从下一层开始
            backtrack(nums, output, res, j + 1);
            //移除最后一个元素，寻找下一个可能性
            output.removeLast();
        }
    }


}
