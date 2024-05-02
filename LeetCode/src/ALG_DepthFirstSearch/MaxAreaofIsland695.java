/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * Example 1:
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */
package ALG_DepthFirstSearch;

/**DFS
 * O(m*n) Beats 100%
 * O(m*n) 最坏的情况下，栈深度为m*n，一个从左上角到右下角的岛
 * 思路：
 * 和求岛屿数量思路是一样的，只是这里多了个value存maxArea
 * 对每个岛逐个求面积
 * 注意事项：
 * 1.递归里面我没有写返回值，不知道怎么处理，因为在递归的过程中，area并不能在每一层递归中保持同步
 *   所以定义一个static int存储，记得每次都要更新这个值
 */
public class MaxAreaofIsland695 {
    public static void main(String[] args) {
        int max = 0;
        int[][] grid ={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                IslandArea = 0;
                dfs(grid,i,j);
                max = Math.max(max,IslandArea);
            }
        }
        System.out.println(max);
    }
    static int IslandArea = 0;
    public static void dfs(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) return;

        grid[i][j] = 0;
        IslandArea ++;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
