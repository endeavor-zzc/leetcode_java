package Skill;

import java.util.HashMap;
import java.util.Map;

/**
 * 多数元素
 */
public class leetcode169 {
    public int majorityElement(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        int MaxCount = 0;
        int result = Integer.MIN_VALUE;
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()){
            if (map.get(key) > MaxCount){
                MaxCount = map.get(key);
                result = key;
            }
        }
        return result;
    }
}

class Solution{
    public int majorityElement(int[] nums){
        /**
         * 我用「擂台赛」打比方：
         *
         * 擂主登场：nums[0] 成为初始擂主，生命值为 1。
         * 挑战者出现：遍历后续元素，作为挑战者。
         * 比武：如果挑战者与擂主属于同一门派（值相同），那么擂主生命值加 1，否则擂主生命值减 1。
         * 擂主更迭：如果比武后，擂主生命值降为 0（同归于尽），那么下一个挑战者成为新的擂主，生命值为 1。
         * 最后在擂台上的那人，便是武林盟主（严格众数）。
         */
        int ans = 0;
        int hp = 0;
        for (int num : nums){
            if (hp == 0){
                ans = num;
                hp = 1;
            }else {
                hp += num == ans ? 1 : -1;
            }
        }
        return ans;
    }
}
