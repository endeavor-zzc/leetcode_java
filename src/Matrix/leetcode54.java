package Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class leetcode54{
    public static void main(String[] args){

    }
}

class Solution54 {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //首先向右走，然后向下走，然后向左走，然后向上走

    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = 0;
        int dir = 0;
        for (int k = 0; k < m * n; k++) {
            result.add(matrix[i][j]);
            matrix[i][j] = 200;
            int x = i + DIRS[dir][0];
            int y = j + DIRS[dir][1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == 200){
                 dir = (dir + 1) % 4;   // 右转
            }
            i += DIRS[dir][0];
            j += DIRS[dir][1];
        }
        return result;
    }
}
