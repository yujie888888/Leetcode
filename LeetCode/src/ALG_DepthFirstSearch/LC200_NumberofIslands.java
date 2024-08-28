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
package ALG_DepthFirstSearch;

/**DFS淹没做法
 * O(m*n) Beats 99%
 *      如果grid是一个大岛，那么double-for-loop的语句dfs只执行一次，但是dfs执行m*n次
 *      如果grid是一个很多很多岛组成的，接近于m*n个岛，也就是每个岛只有一个点大小，那么dfs的时间复杂度是1，for时间复杂度是m*n
 *      总的来说，是O(m*n)
 * O(m*n) Beats 80%
 *      递归栈的深度最大为m*n
 *      如果递归可能沿着整个网格展开，那么空间复杂度可能接近O(m×n)，但这种情况非常非典型，特别是对于大多数实际的岛屿形状。
 *      保守估计O(n)
 * 思路：
 * 1.肯定要搜索每一个结点，这里用淹没思路，只要找到一个新的岛，那么将这个岛"沉没"；这样就能保证下次找到的1肯定是一个新岛
 * 2.对每次找到岛的情况下，对这个岛的上下左右进行搜索，直到找到岛的边缘DFS（边缘有两种，一种是到了grid的边界，一种是遇到了0）
 * 3.结束标志：到了this island's 边缘
 * 注意事项：
 * 1.是'0'不是num 0
 * 2.reach the Edge of Map, dont exceed the edge
 */
public class LC200_NumberofIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count ++;
                    dfs(grid,i,j);
                }
            }
        }
        System.out.println(count);
    }
    public static void dfs(char[][] grid, int i, int j){
        if(grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        if(i+1 < grid.length) dfs(grid,i+1,j);
        if(i-1 >= 0) dfs(grid,i-1,j);
        if(j+1 < grid[0].length) dfs(grid,i,j+1);
        if(j-1 >= 0) dfs(grid,i,j-1);
    }
}
