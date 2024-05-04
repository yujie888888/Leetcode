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
package ALG_BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**BFS
 * O(m*n) Beats 30%
 * O(m*n) Beats 45%
 * 思路：
 * 和 p200 bfs一样
 */
public class MaxAreaofIsland695 {
    public static void main(String[] args) {
        int[][] grid ={{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int max = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(bfs(grid,i,j),max);
                }
            }
        }
        System.out.println(max);
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
