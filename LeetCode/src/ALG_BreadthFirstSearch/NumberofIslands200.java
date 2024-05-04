/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
package ALG_BreadthFirstSearch;
import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands200 {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count ++;
                    bfs(grid,i,j);
                }
            }
        }
        System.out.println(count);
    }
    /**BFS
     * O(m*n) 对每一个格子进行操作 Beats 25%
     * O(m*n) 最坏的情况下需要存储每一个格子 Beats 15%
     * 思路：
     * 一层一层往外扩展
     * 对每次找到的新的岛进行一层一层向外"沉没"
     * DFS是对每次找到的新岛进行一个方向岛尽头的"沉没"
     * 1.双层for循环遍历每个点 2.对每个值为'1'的点，进行bfs"沉没"
     * 相当于，每次找到一个岛，就把这个岛的所有点一层层"沉没"；
     * bfs之外的逻辑是寻找新的岛，bfs之内的逻辑是"沉没"；
     * 所以bfs内的逻辑分成两个部分：1.对岛的第一个结点进行操作 2.对岛的其他结点进行操作
     * bfs逻辑：
     * 1.对于每个为'1'的点，首先将其标记为0，表示已经遍历过
     * 2.然后将其坐标int[]加入queue
     * 3.将坐标poll出
     * 4.只要queue不为空，也就是这个找到的岛还没有到尽头
     *     对这个点的上下左右进行搜索，一旦遇到值为'1'的相邻点
     *         1.将其标记为'0'，表示已经走过
     *         2.将其加入队列
     * 注意事项：
     * 1.在while{for{}}中，必须要将poll的值提前存起来，如果int row = poll()[0]; int col = poll()[1]; 这样实际上就是poll了两次
     * 2.注意0是'0',1是'1'
     * 3.注意边界值是[0,length-1]
     * 4.用了两个direction数组作为改变方向的工具，很巧妙
     */
    public static void bfs(char[][] grid, int i, int j){
        grid[i][j] = '0';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int row = point[0];
            int col = point[1];

            int[] upDown = new int[]{-1,1,0,0};
            int[] leftRight = new int[]{0,0,-1,1};
            for(int d=0; d<4; d++){
                int curRow = row + upDown[d];
                int curCol = col + leftRight[d];
                if(curRow>=0 && curRow<grid.length && curCol>=0 && curCol<grid[0].length && grid[curRow][curCol]=='1'){
                    grid[curRow][curCol] = '0';
                    queue.offer(new int[]{curRow,curCol});
                }
            }
        }
    }
}
