package Matrix;

/**
 * 搜索二维矩阵Ⅱ
 */
public class leetcode240 {
    public static void main(String[] args){

    }
}

class Solution240{
    public boolean searchMatrix(int[][] matrix, int target){
        int i = 0; //表示行
        int j = matrix[0].length - 1; //表示从右上角开始
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] < target){
                i++;  // 表示这一行全部小于target，挪到下一行
            }else {
                j--;  // 表示这一列全部大于target,向前挪一列
            }
        }
        return false;
    }
}
