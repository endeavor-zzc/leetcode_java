package Skill;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字
 */
public class leetcode136 {
    /**
     * <h1>位运算</h1>
     * <p>异或运算：</p>
     * <p>任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。</p>
     * <p>任何数和其自身做异或运算，结果是 0，即 a⊕a=0</p>
     * <p>异或运算满足交换律和结合律</p>
     * 这道题来说，因为出现的次数最多为两次，那么出现两次的数字在异或运算之后为0，最后只留下了出现一次的数字
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums){
        int single = 0;
        for (int num : nums){
            single ^= num;
        }
        return single;
    }
}
