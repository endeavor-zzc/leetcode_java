package Graph;

/**
 * 岛屿数量
 */
public class leetcode200 {
    public static void main(String[] args){
        char[][] grid = new char[4][5];
        grid[0] = new char[]{'1', '1', '1', '1', '0'};
        grid[1] = new char[]{'1','1','0','1','0'};
        grid[2] = new char[]{'1','1','0','0','0'};
        grid[3] = new char[]{'0','0','0','0','0'};
        char[][] grid1 = new char[][]{{'1', '1', '1', '1', '0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        Solution200 solution200 = new Solution200();
        int result = solution200.numIslands(grid1);
        System.out.println(result);

    }
}
class Solution200{
    /**
     * 使用深度优先搜索策略
     * @param grid
     * @return 岛屿数
     */
    public int numIslands(char[][] grid){
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1'){ //发现新岛屿，开始递归
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j){
        //先判断是否出界
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        /*
        先设置为2，不能写在递归后，防止内部出现无限递归。
         */
        grid[i][j] = '2';//将走过的岛屿设置成2，表示已走过。
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
    }
}
