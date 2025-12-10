package MultidimensionalDynamicProgramming;

/**
 * 编辑距离
 */
public class leetcode72 {
    public int minDistance(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        //有一个字符串为空串
        if (n * m == 0){
            return n + m;
        }
        //dp[i][j]表示把word1的前i个字母变成word2的前j个字母，需要几步
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;  //表示word1的前i个字母变成空需要几步，进行删除操作
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;   //表示把空变成word2的前i个字母需要几步，进行添加操作
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int left = dp[i - 1][j] + 1; //删除  把word1的前i-1个字母变成了word2的前j个字母，word1的第i个字母直接删掉
                int down = dp[i][j - 1] + 1;  //插入  把word1的前i个字母变成了word2的前j-1个字母，那么再插入就可以
                int left_down = dp[i - 1][j - 1]; // 替换或匹配
                if (word1.charAt(i - 1) != word2.charAt(j - 1)){
                    left_down += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[m][n];
    }
}
