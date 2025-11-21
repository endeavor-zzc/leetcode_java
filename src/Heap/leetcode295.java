package Heap;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 */
public class leetcode295 {
    public static void main(String[] args){

    }
}

class MedianFinder{
    /*
    中位数可以把集合分成相等的左右两个部分
    计算的中位数就来自left中的最大值和right中的最小值
     */
    private final PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);  // 最大堆
    private final PriorityQueue<Integer> right = new PriorityQueue<>(); //最小堆
    public MedianFinder(){

    }

    /**
     * 规定：left的大小和right的大小尽量相等。在元素个数是奇数个的时候，left比right多1个数
     * <p>情况一：当前left的大小和right的大小相等</p>
     *       如果添加的数字 num 比较大，比如添加 7，那么把 7 加到 right 中。
     *       现在 left 比 right 少 1 个数，不符合前文的规定，所以必须把 right 的最小值从 right 中去掉，添加到 left 中。
     *       如此操作后，可以保证 left 的所有元素都小于等于 right 的所有元素。
     *       如果添加的数字 num 比较小，比如添加 0，那么把 0 加到 left 中。
     *       这两种情况可以合并：无论 num 是大是小，都可以先把 num 加到 right 中，然后把 right 的最小值从 right 中去掉，并添加到 left 中。
     * <p>情况二：当前left比right多一个数字</p>
     *       如果添加的数字 num 比较大，比如添加 7，那么把 7 加到 right 中。
     *       如果添加的数字 num 比较小，比如添加 0，那么把 0 加到 left 中。
     *       现在 left 比 right 多 2 个数，不符合前文的规定，所以必须把 left 的最大值从 left 中去掉，添加到 right 中。
     *       如此操作后，可以保证 left 的所有元素都小于等于 right 的所有元素。
     *       这两种情况可以合并：无论 num 是大是小，都可以先把 num 加到 left 中，然后把 left 的最大值从 left 中去掉，并添加到 right 中。
     * @param num
     */
    public void addNum(int num){
        if (left.size() == right.size()){
            right.offer(num);
            left.offer(right.poll());
        }else {
            left.offer(num);
            right.offer(left.poll());
        }
    }

    public double findMedian(){
        if (left.size() > right.size()){
            return left.peek();
        }else
            return (left.peek() + right.peek()) / 2.0;
    }
}
