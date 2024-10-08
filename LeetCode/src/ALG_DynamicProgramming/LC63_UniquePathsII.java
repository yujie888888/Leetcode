package ALG_DynamicProgramming;
import java.util.Arrays;

public class LC63_UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles1(obstacleGrid));
        System.out.println(uniquePathsWithObstacles2(obstacleGrid));
    }

    /** DP(二维数组)
     * O(m*n)
     * O(m*n)
     * 思路:
     * 1.dp[i][j] 表示到坐标(i,j)有多少条路
     * 2.if(grid[i][j]==1) dp[i][j] = 0;
     *   if(grid[i][j]==0) dp[i][j] = dp[i-1][j]+dp[i][j-1];
     * 3.初始化：初始化最左和最上的列和行
     *      ⚠️注意，如果起点为1(障碍),或者最左列和最上行的前一个为1，
     *        那么其下和右的格子是没有办法走过去的，所以包括这个格子和其余受影响的格子的dp[x][y]=0;
     * 4.Base Case: 对于一开始的位置就是1的情况，直接输出0
     */
    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            if(obstacleGrid[i][0] != 1) dp[i][0] = 1;
            else{
                while(i<m){
                    dp[i][0] = 0;
                    i++;
                }
            }
        }
        for(int j=0; j<n; j++){
            if(obstacleGrid[0][j] != 1) dp[0][j] = 1;
            else{
                while(j<n){
                    dp[0][j] = 0;
                    j++;
                }
            }
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    /**DP(一维数组)
     * O(m*n) Beats 100%
     * O(n) Beats 70%
     * 思路:
     * 1.dp[j] 到达第i行第j列有多少种方法
     * 2.if(!=1)dp[j] = dp[j] = dp[j] + dp[j-1];
     *   if(==1)dp[j] = 0; 这条路直接堵死
     * 3.初始化好jb难繁琐
     *   初始化第一行：对于第一行，要看j列的值是不是1，如果是1，那么dp[j]->dp[n] 全部为0，因为路堵死了
     *   初始化第一列：第一列的初始化放在双重循环里面，因为用的是一维数组；
     *      在初始化的时候也要判断第0列是不是1，
     *      如果是，dp=0；如果不是，dp[0]=dp[0]!!不是dp[0] = 1; 因为如果上面的路堵死了，也是过不来的，不管你本身的是0还是1都无所谓，所以直接从上一行的值传过来就可以
     * 注意事项:
     * 1.处理base case obstacleGrid[0][0] == 1的时候，直接为0
     */
    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;//行
        int n = obstacleGrid[0].length;//列
        int[] dp = new int[n];
        int p = 0;
        while(p<n){
            if(obstacleGrid[0][p] == 1){
                Arrays.fill(dp, p, n, 0);
                p = n;
            }
            else{
                dp[p] = 1;
                p++;
            }
        }
        for(int i=1; i<m; i++){
            if(obstacleGrid[i][0] == 1) dp[0] = 0;
            else dp[0] = dp[0];
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }
                else{
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
}
