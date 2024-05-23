/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The answer is guaranteed to fit into a signed 32-bit integer.
 * Example 1:
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 * Input: amount = 10, coins = [10]
 * Output: 1
 * Constraints:
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * All the values of coins are unique.
 * 0 <= amount <= 5000
 */
package ALG_DynamicProgramming;
public class CoinChangeII518 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(change(amount,coins));
    }
    /**DP
     * O(n^2) Beats 100%
     * O(n) Beats 80%
     * 思路：
     * 求组合数，如果求组合数就是外层for循环遍历物品，内层for遍历背包
     * 求组合类问题的公式，都是类似这种：dp[j] += dp[j - nums[i]]
     * 1.dp[j] amount为j时，有多少种组合使得sum为amount
     * 2.dp[0] = 1
     * 3.dp[j] += dp[j-coin]
     * 对于" If that amount of money cannot be made up by any combination of the coins, return 0"已经在create dp时默认dp[i]=0时实现了
     */
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int j=coin; j<=amount; j++){
                dp[j] += dp[j-coin];
            }
        }
        return dp[amount];
    }
}
