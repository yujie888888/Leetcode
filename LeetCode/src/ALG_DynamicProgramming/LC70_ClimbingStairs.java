/**Description:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
package ALG_DynamicProgramming;
public class LC70_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }
    /**Dynamic Programming经典题
     * O(n) Beats 100%
     * O(n) Beats 95%
     * 思路：
     * 这里dp[0]=0是可以的，因为初始化的时候初始化了dp[1]和dp[2];
     * 1.dp[i]:表示爬到第i层有多少种方法
     * 2.dp[i] = dp[i-1] + dp[i-2] 因为爬到第i层的方法要么从i-1的位置爬一层，要么从i-2的位置爬两层
     * 3.dp[1]=1; dp[2]=2; 不初始化dp[0],因为没有意义，直接从1开始，然后初始化dp[1]和dp[2],循环从3开始
     * 注意事项：
     * 1.虽然我们不用dp[0],但是在声明数组的时候长度要n+1,因为我们是从下标1开始用，但是数组是从下标0开始的
     */
    public static int climbStairs(int n) {
        if(n<=2) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
