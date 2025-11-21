package DynamicProgramming;

import java.lang.classfile.constantpool.IntegerEntry;
import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class leetcode118 {
    public static void main(String[] args){

    }
}

class Solution118{
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> partResult = new ArrayList<>(i + 1);
            partResult.add(1);
            for (int j = 1; j < i; j++) {
                partResult.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            partResult.add(1);
            result.add(partResult);
        }
        return result;
    }
}
