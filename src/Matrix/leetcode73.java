package Matrix;

import java.util.Arrays;

/**
 * 矩阵置零
 */
public class leetcode73 {
    public static void main(String[] args){

    }
}

class Solution73{
    /**
     * 采用两个数组，用来记录位置是否为0 为0记为1
     * @param matrix 要判断的矩阵
     *
     */

    public void setZeroes(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    row[i] = col[j] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
class Solution73_2{
    public void setZeroes(int[][] matrix){
        int m = matrix.length;  //行数
        int n = matrix[0].length;  //列数
        //记录第一行是否包含0
        boolean firstRow = false;
        for (int x : matrix[0]){
            if (x == 0){
                firstRow = true;
                break;
            }
        }

        //记录第一列是否包含0
        boolean firstCol = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }

        //用第一列保存某一行是否存在0
        //用第一行保存某一列是否存在0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //跳过第一行第一列，留到最后再修改
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstCol){
            for (int[] row : matrix){
                row[0] = 0;
            }
        }
        if (firstRow){
            Arrays.fill(matrix[0], 0);
        }

    }
}
