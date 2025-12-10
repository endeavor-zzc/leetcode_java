package MultidimensionalDynamicProgramming;

/**
 * 最长回文串
 */
public class leetcode5 {

}

class Solution5{
    /**
     * 如果子串是回文串，那么去除首尾之后还是回文串
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
        int length = s.length();
        //如果字符串长度等于1或者0，那么肯定是一个回文串
        if (length < 2){
            return s;
        }
        //处理一般情况
        int maxLen = 1;
        int begin = 0;
        //dp[i][j]表示从下标i到j是不是回文串
        boolean[][] dp = new boolean[length][length];
        //长度为1肯定是回文串
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        //枚举字串长度
        for (int L = 2; L <= length; L++) {
            //枚举左边界
            for (int i = 0; i < length; i++) {
                //由子串长度和左边界可以确定右边界，j-i+1=L
                int j = L + i - 1;
                if (j >= length)
                    break;
                if (charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else {
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //只要dp[i][L]为真，就表示字串s[i..L]
                if (dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
