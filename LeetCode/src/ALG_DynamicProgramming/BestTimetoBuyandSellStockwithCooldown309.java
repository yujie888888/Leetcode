/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * Example 1:
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * Example 2:
 * Input: prices = [1]
 * Output: 0
 * Constraints:
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 */
package ALG_DynamicProgramming;
public class BestTimetoBuyandSellStockwithCooldown309 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }
    /**DP
     * O(n) Beats 85%
     * O(n) Beats 90%
     * 思路:
     * 1.dp[i][0] 第i天结束时未持股票的最大利润
     *   dp[i][1] 第i天结束时持有股票的最大利润
     * 2.状态转移
     *      dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1]+prices[i]);
     *      第 i 天结束时未持有股票的最大利润有两种情况：(第i天卖了还是没卖)
     *          第 i-1 天未持有股票，今天不进行任何操作，那么 dp[i][0] = dp[i-1][0]。
     *          第 i-1 天持有股票，今天卖出股票，获得利润 prices[i]，那么 dp[i][0] = dp[i-1][1] + prices[i]。
     *          取上述两种情况的最大值，表示第 i 天结束时未持有股票的最大利润。
     *      dp[i][1] = Math.max(dp[i-1][1] , dp[i-2][0]-prices[i]);
     *      第 i 天结束时持有股票的最大利润有两种情况：(第i天买了还是没买 && 买了的话买入条件)
     *          第 i-1 天持有股票，今天不进行任何操作，那么 dp[i][1] = dp[i-1][1]。
     *          第 i-2 天未持有股票，今天买入股票，花费 prices[i]，那么 dp[i][1] = dp[i-2][0] - prices[i]
     *              这里是因为有冷却期，不能在卖出股票后的第二天再次买入，所以 dp[i-2][0] 表示第 i-2 天未持有股票的最大利润
     *          取上述两种情况的最大值，表示第 i 天结束时持有股票的最大利润
     * 3.初始化
     *      dp[0][0] = 0：第 0 天结束时未持有股票的最大利润为 0
     *      dp[0][1] = -prices[0]：第 0 天结束时持有股票的最大利润为负的股票价格，因为我们买入了股票
     *      dp[1][1] = Math.max(dp[0][1],-prices[1]); 第1天结束时持有股票的最大利润为：max（第0天持有股票的最大利润，第1天买入股票）
     *      dp[1][0] = Math.max(dp[0][0],dp[0][1]+prices[1]); 第1天结束时未持有股票的最大利润为：max（第0天未持有股票的最大利润，第1天卖掉股票）
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==1) return 0;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        dp[1][1] = Math.max(dp[0][1],-prices[1]);
        dp[1][0] = Math.max(0,dp[0][1]+prices[1]);

        for(int i=2; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1] , dp[i-2][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}
