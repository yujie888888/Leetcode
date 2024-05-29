/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * Example 1:
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Constraints:
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 */
package ALG_DynamicProgramming;
public class BestTimetoBuyandSellStockIV188 {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println(maxProfit(k,prices));
    }
    /**DP
     * O(n*k) Beats 80%
     * O(n*k) Beats 50%
     * P123的进阶版
     * 思路：
     * 除了这个方法，还可以定义一个三维数组dp[i][j][p]，第i天，第j次买卖，p表示买还是卖的状态，从定义上来讲是比较直观
     * 下面这个方法是用k表示买入还是卖出的状态
     * 1.dp[][]含义：
     *   dp[i][j]: 第i天的状态为j，获得的最大利润dp[i][j]
     *   j的状态表示为：
     *     0 表示不操作
     *     1 第一次买入
     *     2 第一次卖出
     *     3 第二次买入
     *     4 第二次卖出
     *     .....
     *     发现规律：除了0以外，偶数就是卖出，奇数就是买入
     *     然后用k表示j是偶数还是奇数
     *       2k+1
     *       2k+2
     * 2.状态转移：
     *   dp[i][1] = max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
     *       操作一：第i天买入股票了，那么dp[i][1] = dp[i - 1][0] - prices[i]
     *       操作二：第i天没有操作，而是沿用前一天买入的状态，即：dp[i][1] = dp[i - 1][1]
     *   dp[i][2] = max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
     *       操作一：第i天卖出股票了，那么dp[i][2] = dp[i - 1][1] + prices[i]
     *       操作二：第i天没有操作，沿用前一天卖出股票的状态，即：dp[i][2] = dp[i - 1][2]
     * 3.初始化
     *   dp[0][i] = -prices[0];
     * 4.return
     *   dp[n-1][2k] 第i天，第k次不持有股票的状态下，获得的最大利润
     */
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k+1];
        for(int i=1; i<=2*k; i+=2) dp[0][i] = -prices[0];
        for(int i=1; i<n; i++){
            for(int j=0; j<k; j++){
                dp[i][2*j+1] = Math.max(dp[i][2*j]-prices[i], dp[i-1][2*j+1]);
                dp[i][2*j+2] = Math.max(dp[i][2*j+1]+prices[i], dp[i-1][2*j+2]);
            }
        }
        return dp[n-1][2*k];
    }
}
