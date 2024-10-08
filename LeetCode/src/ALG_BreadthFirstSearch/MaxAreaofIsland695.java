package ALG_BreadthFirstSearch;
import java.util.LinkedList;
import java.util.Queue;
public class MaxAreaofIsland695 {
    public static void main(String[] args) {
        int[][] grid1 ={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland2(grid1));
        int[][] grid2 ={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland2(grid2));
    }
    /**DFS(推荐)
     * O(m*n)
     * O(1)
     * Ideas:
     * Island sinking Method
     * 开始
     *   |
     * 遍历网格中的每个单元格
     *   |
     * 检查当前单元格是否为1
     *   |-- 是 --> 调用 DFS 计算岛屿面积
     *   |           |
     *   |         标记当前单元格为已访问
     *   |           |
     *   |         递归访问四个方向的邻居
     *   |           |
     *   |         累积面积
     *   |           |
     *   |         返回岛屿的总面积
     *   |
     * 更新最大面积
     *   |
     * 继续遍历下一个单元格
     *   |
     * 遍历结束
     *   |
     * 返回最大面积
     *   |
     * 结束
     */
    public static int maxAreaOfIsland1(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
        return max;
    }

    public static int dfs(int i, int j, int[][] grid) {
        // return condition
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0)
            return 0;

        // if grid[i][j] == 1
        grid[i][j] = 0;
        int area = 1;
        // four directions
        area += dfs(i, j + 1, grid); // left
        area += dfs(i, j - 1, grid); // right
        area += dfs(i - 1, j, grid); // up
        area += dfs(i + 1, j, grid); // done

        return area;
    }


    /**BFS(不推荐)
     * O(m*n) Beats 30%
     * O(m*n) Beats 45%
     * 思路：
     * 和 p200 bfs一样
     */
    public static int maxAreaOfIsland2(int[][] grid) {
        int max = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(bfs(grid,i,j),max);
                }
            }
        }
        return max;
    }
    public static int bfs(int[][] grid, int i, int j){
        int area = 1;
        grid[i][j] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});

        int[] direction1 = new int[]{-1,1,0,0};
        int[] direction2 = new int[]{0,0,-1,1};
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];
            for(int d=0; d<4; d++){
                int curRow = row + direction1[d];
                int curCol = col + direction2[d];
                if(curRow>=0 && curRow<grid.length && curCol>=0 && curCol<grid[0].length && grid[curRow][curCol] == 1){
                    area ++;
                    grid[curRow][curCol] = 0;
                    queue.offer(new int[]{curRow,curCol});
                }
            }
        }
        return area;
    }
}
