/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 * Constraints:
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
package ALG_DynamicProgramming;
import java.util.Arrays;

public class CoinChange322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange1(coins,amount));
        System.out.println(coinChange2(coins,amount));
    }
    /**(推荐)DP(一维数组)
     * O(n^2) Beats 99%
     * O(n) Beats 80%
     * 思路:
     * 完全背包问题
     * 求装满背包，最小需要多少coins
     * 1.dp[j]: amount为j时的最小coin数
     * 2.dp[j] = Math.min(dp[j],dp[j-coin]+1)
     * 3.dp[0] = 0;
     * 注意事项:
     * 1.在内循环中，直接从coin开始可以避免判断j>=coin
     * 2.将dp初始化为max，为了判断coins是否能构成amount
     */
    public static int coinChange1(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int coin : coins){
            for(int j=coin; j<=amount; j++){
                dp[j] = Math.min(dp[j],dp[j-coin]+1);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
    /**DP(二维数组)
     * O(n^2) Beats 50%
     * o(n^2) Beats 50%
     * 思路:
     * 完全背包问题
     * 不能构成的时候返回-1
     * 动态规划三部曲:
     * 1.dp[i][j]: amount为j时，fewest number of coins that selected in first i-th to make up this amount
     * 2.dp[i][j] = Math.max(dp[i-1][j],dp[i][j-coin[i]]+1);
     * 3.初始化
     *      dp[i][j] = max; max表示不成立状态，在状态转移的时候不成立状态会传递，由此来判断是否能构成amount
     *      dp[i][0] = 0;
     *      dp[0][j] = j/coins[0];
     */
    public static int coinChange2(int[] coins, int amount) {
        int m = coins.length;
        int max = amount + 1;
        int[][] dp = new int[m][amount+1];
        for(int i=0; i<m; i++){
            for(int j=0; j<=amount; j++){
                dp[i][j] = max;
            }
        }
        for(int i=0; i<m; i++) dp[i][0] = 0;
        for(int j=1; j<=amount; j++){
            if(j%coins[0]==0) dp[0][j] = j/coins[0];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<=amount; j++){
                if(j>=coins[i]){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-coins[i]]+1);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[m-1][amount]==max ? -1 : dp[m-1][amount];
    }
}
