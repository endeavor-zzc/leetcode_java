package GreedyAlgorithm;

/**
 * 买卖股票的最佳时机
 */
public class leetcode121 {
    public static void main(String[] args){

    }
}

class Solution121{
    public int maxProfit(int[] prices){
        int ans = 0;
        int minPrice = prices[0];
        for (int price : prices){
            //先更新利润再计算最低的价格   因为不允许当天买当天卖
            ans = Math.max(ans, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return ans;
    }
}
