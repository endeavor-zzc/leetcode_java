package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 腐烂的橘子
 */
public class leetcode994 {
    public static void main(String[] args){
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        Solution994 solution994 = new Solution994();
        int result = solution994.orangesRotting(grid);
        System.out.println(result);
    }
}

class Solution994{

    public int orangesRotting(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0; //用来判断还有没有新鲜橘子
        Queue<int[]> q = new ArrayDeque<>(); //用来记录腐烂橘子的位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    fresh++;
                }else if (grid[i][j] == 2){
                    q.add(new int[]{i, j});
                }
            }
        }
        //开始广度优先搜索
        int ans = 0;
        while (fresh > 0 && !q.isEmpty()){
            ans++;
            int num = q.size(); // 每次先更新队列的大小
            for (int i = 0; i < num; i++) {
                int[] orange = q.poll();
                int r = orange[0]; //行
                int c = orange[1]; //列
                //开始污染
                if(r - 1 >= 0 && grid[r - 1][c] == 1){ //向左走
                    grid[r - 1][c] = 2;
                    fresh--;
                    q.add(new int[]{r - 1, c});
                }
                if (r + 1 < m && grid[r + 1][c] == 1){ //向右走
                    grid[r + 1][c] = 2;
                    fresh--;
                    q.add(new int[]{r + 1, c});
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1){ //向上走
                    grid[r][c - 1] = 2;
                    fresh--;
                    q.add(new int[]{r, c -1});
                }
                if (c + 1 < n && grid[r][c + 1] == 1){
                    grid[r][c + 1] = 2;
                    fresh--;
                    q.add(new int[]{r, c + 1});
                }
            }
        }
        if (fresh > 0)
            return -1;
        else
            return ans;
    }
}