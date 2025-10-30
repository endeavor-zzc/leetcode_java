package DoublePointer;

/**
 * 接雨水
 */
public class leetcode42 {
    public static void main(String[] args){

    }
}

class Solution42{
    /**
     * 只要左右两边的最大高度比另一方的大，那么一定有雨水可以接
     * @param height
     * @return
     */
    public int trap(int[] height){
        int ans = 0;
        int left = 0;  //左指针
        int right = height.length - 1;  //右指针
        int leftMax = 0; //左指针路过的最大高度
        int rightMax = 0;  //右指针路过的最大高度
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]){
                ans += leftMax - height[left];
                left++;
            }else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
