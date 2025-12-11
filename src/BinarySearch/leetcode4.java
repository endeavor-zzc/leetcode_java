package BinarySearch;

public class leetcode4 {
    public static void main(String[] args){

    }
}

class Solution {

    /**
     * 主函数：寻找两个正序数组的中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int totalLength = length1 + length2;

        // 核心思想：把找“中位数”转化为找“第 k 小的数”

        // 情况 1：总长度是奇数
        // 比如总长 5，中位数就是第 3 小的数 (5/2 + 1 = 3)
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            // 注意：k 是从 1 开始数的，所以要 +1
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        }
        // 情况 2：总长度是偶数
        // 比如总长 4，中位数是第 2 小和第 3 小的平均值
        else {
            int midIndex1 = totalLength / 2 - 1;
            int midIndex2 = totalLength / 2;
            // 分别找出这两个数，求平均值
            // 注意：因为计算结果可能有小数，所以除以 2.0
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) +
                    getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    /**
     * 核心辅助函数：在两个排序数组中找到第 k 小的元素
     * @param nums1  数组1
     * @param nums2  数组2
     * @param k      我们要找“第 k 小”（k >= 1）
     * @return       第 k 小的那个数的值
     */
    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        // index1 和 index2 是两个数组的“起跑线”
        // 随着排除过程，起跑线会不断往后移
        int index1 = 0, index2 = 0;

        while (true) {
            // === 边界情况（递归/循环出口） ===

            // 1. 如果 nums1 已经被排除空了，那第 k 小肯定在 nums2 里
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            // 2. 如果 nums2 已经被排除空了，那第 k 小肯定在 nums1 里
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            // 3. 如果 k 变成了 1，说明我们要找当前的“最小者”
            // 只要比较两个数组现在的排头，取最小的即可
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // === 正常排除逻辑 ===

            // 我们尝试每边排除 k/2 个元素
            int half = k / 2;

            // 计算新的比较位置（pivot）：
            // Math.min 是为了防止数组越界。如果数组剩余长度不够 k/2，就直接取最后一个元素。
            // 这里的 -1 是为了把“第几个”转换成“数组下标”
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;

            // 取出两个“代表”进行 PK
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];

            // 比较并淘汰较小的一方
            if (pivot1 <= pivot2) {
                // pivot1 更小，说明 nums1 从 index1 到 newIndex1 这段都不可能是第 k 小
                // 1. 更新 k：减去被排除掉的元素个数 (数量 = 结束下标 - 开始下标 + 1)
                k -= (newIndex1 - index1 + 1);
                // 2. 更新起跑线：移到被排除元素的后面
                index1 = newIndex1 + 1;
            } else {
                // pivot2 更小，逻辑同上，排除 nums2 的这一段
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
