package DynamicProgramming;

/**
 * 爬楼梯
 */
public class leetcode70 {
    public static void main(String[] args){

    }
}

class Solution70{
    /**
     * 状态转移方程：
     * dp[i] = dp[i - 1] + dp[i - 2]
     * 与递归不同的是：动态规划是自底向上，递归是自顶向下
     * <h1>
     *     动态规划有两种思考方式，一种是<bold>枚举选哪个</bold>  一种是<bold>选或不选</bold> 本题是枚举选哪个
     * </h1>
     * @param n
     * @return
     */
    public int climeStairs(int n){
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
