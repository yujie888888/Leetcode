/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 * Example 1:
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 * Input: m = 3,n = 2
 * Output: 3
 * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * Constraints:
 * 1 <= m, n <= 100
 */
package ALG_DynamicProgramming;
public class LC62_RobotUniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths1(10,10));
        System.out.println(uniquePaths2(10,10));
    }
    /**DP
     * O(m*n)
     * O(m*n)
     * Ideas:
     * 1.确定dp table以及下标的含义: dp[i][j]表示从（0,0）出发，到(i,j)有dp[i][j]条不同的路径。
     * 2.确定递推公式:到达dp[i][j]只有两种情况，要么从上来，要么从左来,所以推导公式为 dp[i][j] = dp[i-1][j] + dp[i][j-1];
     * 3.dp数组的初始化:
     *   dp[0][0] = 1; dp[0][1] = 1; dp[1][0] = 1;
     *   for(int i=1; i<m; i++) dp[i][0] = 1;
     *   for(int j=1; j<n; j++) dp[0][j] = 1;
     * Attention:
     * 1.dp[0][0] = 1这个基础赋值完全是根据结果来推的 但是其实也用不到
     * 2.不同于爬楼梯，这个图的做法在基础赋值的时候需要把边缘位置的值全部赋值
     * 3.定义二维数组的方法
     */
    public static int uniquePaths1(int m, int n) {
        int[][]dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=1; i<m; i++) dp[i][0] = 1;
        for(int j=1; j<n; j++) dp[0][j] = 1;
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    /**DP(一维数组法)
     * O(m*n)
     * O(n)
     * 思路：
     * 1.dp[j]表示从(0,0)到第*行第j列的路径数
     * 2.dp[j] = dp[j] + dp[j-1];
     * 3.初始化第0行的：dp[j] = 1;
     * 4.遍历从i=1;j=1开始
     *     保证了每个第0列的值都是1 并且 i-1>=0
     */
    public static int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        for(int j=0; j<n; j++) dp[j] = 1;

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }
}
