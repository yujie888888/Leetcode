/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * Example 1:
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * Constraints:
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 105
 */
package ALG_DynamicProgramming;
public class BestTimetoBuyandSellStockIII123 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }
    /**DP
     * O(n) Beats 50%
     * O(5n) Beats 90%
     * 1.dp[][]含义：
     *   1.dp[i][0]: 第i天之前，一次都不持有股票，获得的最大利润
     *   2.dp[i][1]: 第i天之前，第一次持有股票，获得的最大利润
     *   3.dp[i][2]: 第i天之前，第一次不持有股票，获得的最大利润
     *   4.dp[i][3]: 第i天之前，第二次持有股票，获得的最大利润
     *   5.dp[i][4]: 第i天之前，第二次不持有股票，获得的最大利润
     * 2.状态转移
     *   dp[i][1] = Math.max(dp[i][0]-prices[i], dp[i-1][1]);
     *       操作一：第i天买入股票了，那么dp[i][1] = dp[i-1][0] - prices[i]
     *       操作二：第i天没有操作，而是沿用前一天买入的状态，即：dp[i][1] = dp[i - 1][1]
     *   dp[i][2] = Math.max(dp[i][1]+prices[i], dp[i-1][2]);
     *       操作一：第i天卖出股票了，那么dp[i][2] = dp[i - 1][1] + prices[i]
     *       操作二：第i天没有操作，沿用前一天卖出股票的状态，即：dp[i][2] = dp[i - 1][2]
     *   dp[i][3] = Math.max(dp[i][2]-prices[i], dp[i-1][3]);
     *       同理
     *   dp[i][4] = Math.max(dp[i][3]+prices[i], dp[i-1][4]);
     *       同理
     * 3.初始化
     *   根据转移方程可以知道，需要初始化 dp[0][1] dp[0][2] dp[0][3] dp[0][4]
     *   还有dp[1][0],但是本身就初始化为0，和一开始dp数组创建的时候一样所以不用额外初始化
     * 4.return
     *   最大的时候一定是卖出的状态，而两次卖出的状态现金最大一定是最后一次卖出
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for(int i=1; i<n; i++){
            dp[i][1] = Math.max(dp[i][0]-prices[i], dp[i-1][1]);
            dp[i][2] = Math.max(dp[i][1]+prices[i], dp[i-1][2]);
            dp[i][3] = Math.max(dp[i][2]-prices[i], dp[i-1][3]);
            dp[i][4] = Math.max(dp[i][3]+prices[i], dp[i-1][4]);
        }
        return dp[n-1][4];
    }

}
