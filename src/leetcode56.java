import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class leetcode56 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入区间个数");
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        System.out.println("输入每个区间");
        for (int i = 0; i < n; i++){
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }
        Solution56 solution56 = new Solution56();
        int[][] result = solution56.merge(intervals);
        for (int[] res : result)
            System.out.println(res[0] + "," + res[1]);
    }
}

class Solution56{
    /**
     * 核心思想是将排序好的二维数组，将上一个元素的右端点和当前元素的左端点进行对比，来决定是否合并区间
     * @param intervals 操作数组
     * @return 二维数组
     */
    public int [][] merge(int[][] intervals){
        Arrays.sort(intervals, (p, q) -> (p[0] - q[0])); //lambda表达式
        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals){
            int m = ans.size();
            if (m > 0 && p[0] <= ans.get(m - 1)[1])
                ans.get(m - 1)[1] = Math.max(p[1], ans.get(m - 1)[1]); // 比较两个数组的右端点
            else
                ans.add(p); //如果没有则添加新元素，不合并
        }
        return ans.toArray(new int[ans.size()][]); //用toArray转换成二维数组输出
    }
}
