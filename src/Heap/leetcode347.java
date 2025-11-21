package Heap;

import java.util.*;

/**
 * 前k个高频元素
 */
public class leetcode347 {
    public static void main(String[] args){

    }
}

class Solution347{
    /**
     * 桶排序
     * 首先统计频率，  然后用桶存储相同频率的数字， 最后从高频到低频取前k个元素
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k){
        //统计出现的频率
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums)
            cnt.put(x, cnt.getOrDefault(x,0) + 1);
        int maxcnt = Collections.max(cnt.values());  // 记录出现次数的最大值

        //构造桶结构
        List<Integer>[] buckets = new ArrayList[maxcnt + 1];  //这里要加1是因为 数组下标是从0开始的
        Arrays.setAll(buckets, i -> new ArrayList<>());
        /*
        上面的代码相当于
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
         */
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()){
            buckets[entry.getValue()].add(entry.getKey());
        }

        //遍历桶结构
        int[] ans = new int[k];
        int j = 0;
        for (int i = maxcnt; i >= 0 && j < k; i--) {
            for (int x : buckets[i]){
                ans[j] = x;
                j++;
            }
        }
        return ans;
    }

    public int[] topKFrequent_Heap(int[] nums, int k){
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums)
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        //定义最小堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //遍历哈希表，维护堆中前k个频率最高的数
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k){
                if (queue.peek() != null && queue.peek()[1] < count) { //与堆顶比较，如果当前出现的次数大于堆顶，那么就将堆顶弹出
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            }else {
                queue.offer(new int[]{num, count}); //如果元素个数没有k个，则直接弹出
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++){
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}
