package BinarySearch;

/**
 * 搜索二维矩阵
 */
public class leetcode74 {
    public static void main(String args[]){

    }
}

class Solution74{
    public boolean searchMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if (matrix[mid / n][mid % n] == target)
                return true;
            if (matrix[mid / n][mid % n] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
}