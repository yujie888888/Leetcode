/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 * Example 1:
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * Example 2:
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 * Constraints:
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 */
package ALG_DynamicProgramming;

public class UniquePathsII63 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    /** DP(二维数组)
     * O(m*n) Beats 100%
     * O(m*n) Beats 55%
     * 思路:
     * 1.dp[i][j] 表示到坐标(i,j)有多少条路
     * 2.if(grid[i][j]==1) dp[i][j] = 0;
     *   if(grid[i][j]==0) dp[i][j] = dp[i-1][j]+dp[i][j-1];
     * 3.初始化：初始化最左和最上的列和行，⚠️注意，如果起点为1(障碍),或者最左列和最上行的前一个为1，
     *   那么其下和右的格子是没有办法走过去的，所以包括这个格子和其余受影响的格子的dp[x][y]=0;
     * 注意事项:
     * 1.和62思路是一样的，只是注意初始化怎么处理障碍物即可
     * 2.对于一开始的位置就是1的情况，直接输出0
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;//行数
        int n = obstacleGrid[0].length;//列数
        int[][] dp = new int[m][n];
        int i = 0;
        while(i<n){
            if(obstacleGrid[0][i] == 1){
                int j = i;
                while(j<n){
                    dp[0][j] = 0;
                    j++;
                }
                i = j;
            }
            else{
                dp[0][i] = 1;
                i++;
            }
        }
        i = 1;
        while(i<m){
            if(obstacleGrid[i][0] == 1){
                int j = i;
                while(j<m){
                    dp[j][0] = 0;
                    j++;
                }
                i = j;
            }
            else{
                dp[i][0] = 1;
                i++;
            }
        }
        for(int i1=1; i1<m; i1++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i1][j] == 1) dp[i1][j] = 0;
                else dp[i1][j] = dp[i1-1][j] + dp[i1][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
