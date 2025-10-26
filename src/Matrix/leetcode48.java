package Matrix;

/**
 * 旋转图像
 */
public class leetcode48 {
   public static void main(String[] args){

   }
}

class Solution48{
    /**
     * 矩阵转置matrix[i][j] ↔ matrix[j][i]
     * 矩阵水平镜像 matrix[i][j] ↔ matrix[i][n-1-j]
     * 矩阵垂直镜像 matrix[i][j] ↔ matrix[m-1-i][j]
     * 矩阵顺时针旋转90度 垂直镜像加转置
     * 矩阵顺时针旋转180度  水平镜像加垂直镜像
     * 逆时针旋转90度  水平镜像加转置
     * @param matrix
     */
    public void rotate(int[][] matrix){
        int n = matrix[0].length;
        int m = matrix.length;
        //转置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {  //只需要遍历对角线下方的元素就可以
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //只需要遍历左半元素就可以
        for (int[] row : matrix){
            for (int i = 0; i < n / 2; i++) {
                int temp = row[i];
                row[i] = row[n - 1 - i];
                row[n - 1 - i] = temp;
            }
        }
    }
}
