package TraceBack;

public class leetcode79 {
    public static void main(String[] args){

    }
}

class Solution79{
    private static final int[][] DIRS ={{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word){
        int m = board.length;  //行数
        int n = board[0].length; // 列数
        char[] w = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(i, j, 0, board, w))
                    return true;
            }
        }
        return false;
    }

    /**
     *
     * @param i 行数
     * @param j 列数
     * @param k 第几个字符
     * @param board 二维网格
     * @param w 单词
     * @return
     */
    private boolean backtrack(int i, int j, int k, char[][] board, char[] w){
        if (board[i][j] != w[k]) //匹配不成功
            return false;
        if (k == w.length - 1) //全都匹配成功
            return true;
        board[i][j] = '0'; //标记被访问过的元素
        for (int[] d : DIRS){
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && backtrack(x, y, k + 1, board, w)){
                return true;
            }
        }
        board[i][j] = w[k];//恢复现场
        return false;
    }
}
