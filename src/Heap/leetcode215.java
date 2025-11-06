package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 数组中第k个最大元素
 */
public class leetcode215 {
    public static void main(String[] args){

    }
}

class Solution{
    /**
     * 快速排序
     * @param nums
     * @param k
     * @return
     */
    private int quickSelect(List<Integer>nums, int k){
        Random rand = new Random();
        int pivot = nums.get(rand.nextInt(nums.size())); //随机选择一个数字作为基准值pivot
        List<Integer> big = new ArrayList<>(); //所有大于基准值的元素
        List<Integer> small = new ArrayList<>(); //所有小于基准值的元素
        List<Integer> equal = new ArrayList<>(); //所有等于基准值的元素
        for (int num : nums){
            if (num > pivot){
                big.add(num);
            } else if (num < pivot) {
                small.add(num);
            }else {
                equal.add(num);
            }
        }
        if (k <= big.size()){  //第k大元素在big里
            return quickSelect(big, k);
        }
        if (k > nums.size() - small.size()){  //第k大元素在small和big里
            return quickSelect(small, k - (nums.size()-small.size()));  //k - (nums.size()-small.size())表示排除了big和equal，只需要在small里找
        }
        return pivot;
    }

    public int findKthLargest(int[] nums, int k){
        List<Integer> numList = new ArrayList<>();
        for (int num : nums)
            numList.add(num);
        return quickSelect(numList, k);
    }
}

/**
 * 基于堆排序
 */
class Solution215{
    public int findKthLargest(int[] nums, int k){
        int heapsize = nums.length;
        buildHeap(nums, heapsize);
        //取出前k-1个最大元素
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, i, 0);   //把当前堆顶移到末尾
            heapsize--;   //减小堆范围
            maxHeapify(nums, 0, heapsize); //重新建立最大堆
        }
        // 第k个大元素就是堆顶
        return nums[0];
    }

    /**
     * 建立堆
     * @param nums
     * @param heapsize
     */
    private void buildHeap(int[] nums, int heapsize) {
        for (int i = heapsize / 2 - 1; i >= 0; i--) {  //从最后一个非叶子节点heapsize / 2 - 1开始，然后向上执行
            maxHeapify(nums, i, heapsize);
        }
    }

    private void maxHeapify(int[] nums, int i, int heapsize) {
        int l = 2 * i + 1;  //左叶子节点
        int r = 2 * i + 2; //右叶子节点
        int largest = i;
        //找出当前节点与左右叶子节点中最大的那个
        if (l < heapsize && nums[l] > nums[largest]){
            largest = l;
        }
        if (r < heapsize && nums[r] > nums[largest]){
            largest = r;
        }
        //如果最大值不是当前节点（子节点比父节点大），那么交换
        if (largest != i){
            swap(nums, largest, i);
            maxHeapify(nums, largest, heapsize);
        }
    }

    private void swap(int[] nums, int largest, int i) {
        int temp = nums[i];
        nums[i] = nums[largest];
        nums[largest] = temp;
    }

}
