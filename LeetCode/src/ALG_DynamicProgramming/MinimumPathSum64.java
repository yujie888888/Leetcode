/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * Example 1:
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 */
package ALG_DynamicProgramming;
public class MinimumPathSum64 {
    public static void main(String[] args) {
        //二维数组直接赋值
        int[][] grid = {{1,2,3}, {4,5,6}};
        System.out.println(minPathSum(grid));
    }
    /**Dynamic Programming经典题
     * O(m*n) Beats 70%
     * O(1)
     * 思路:
     * 感觉和robot差不多，都是用dp[][]存
     * robot存的是路径数，这道题存的是最小值，所以每次存值都要进行比较，确保存的是最小值
     * 1.确定含义: dp[i][j]表示从0,0到i,j的最小路径和
     * 2.递推公式: dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
     * 3.初始化:
         dp[0][0] = grid[0][0];
         dp[0][j] = dp[0][j-1] + grid[0][j];
         dp[i][0] = dp[i-1][0] + grid[i][0];
     * 注意事项:
     * 1.注意一下怎么获取二维数组的行数和列数
     */
    public static int minPathSum(int[][] grid) {
        int[][]dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=1; i<grid.length; i++) dp[i][0] = dp[i-1][0] + grid[i][0];
        for(int j=1; j<grid[0].length; j++) dp[0][j] = dp[0][j-1] + grid[0][j];
        for(int i=1; i<grid.length; i++){
            for(int j=1; j<grid[0].length; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
