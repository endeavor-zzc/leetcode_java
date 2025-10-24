package TraceBack;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 */
public class leetcode51 {
    public static void main(String[] args){

    }
}

class Solution51{
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n){
        int[] path = new int[n];  //用来记录皇后放置的位置
        boolean[] columns = new boolean[n];  //用来记录列是否被选择  默认值都是false
        boolean[] l_diags = new boolean[2 * n - 1];  //用来记录2n-1条左对角线是否被选择过
        boolean[] r_diags = new boolean[2 * n - 1];  //用来记录右对角线
        backtrack(n, 0, path, columns, l_diags, r_diags);
        return result;
    }

    /**
     *
     * @param n 表示棋盘大小是n*n
     * @param r 表示行下标
     */
    private void backtrack(int n, int r, int[]path, boolean[] columns, boolean[] l_diags, boolean[] r_diags){
        if (r == n){
            result.add(build(path, n));
        }
        for (int c = 0; c < n; c++) { //c表示列坐标
            if (!columns[c] && !l_diags[r + c] && !r_diags[r - c + n - 1]){  //(n-1)是因为r-c有时为负数，需要加上n-1让下标从0开始
                path[r] = c;
                columns[c] = l_diags[r + c] = r_diags[r - c + n - 1] = true;
                backtrack(n, r + 1, path, columns, l_diags, r_diags);
                columns[c] = l_diags[r + c] = r_diags[r - c + n - 1] = false;
            }
        }
    }

    //构造答案
    private List<String> build(int[] path, int n){
        List<String> temp = new ArrayList<>();
        for (int p : path){
            char[] str = new char[n];
            for (int i = 0; i < n; i++) {
                if (i == p){
                    str[i] = 'Q';
                }else{
                    str[i] = '.';
                }
            }
            temp.add(new String(str));
        }
        return temp;
    }
}
