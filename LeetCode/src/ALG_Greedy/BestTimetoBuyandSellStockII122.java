/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * Example 2:
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 * Example 3:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 * Constraints:
 * 1 <= prices.length <= 3 * 104
 * 0 <= prices[i] <= 104
 */
package ALG_Greedy;

public class BestTimetoBuyandSellStockII122 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));
    }
    /**Greedy
     * O(n) Beats 95%
     * O(n) Beats 50%
     * 思路：
     * 和contest一道题很像，将总利润分解成子利润
     *      假如第 0 天买入，第 3 天卖出，那么利润为：prices[3] - prices[0]
     *      相当于(prices[3] - prices[2]) + (prices[2] - prices[1]) + (prices[1] - prices[0])
     * 所以不管选哪天买入选哪天卖出，最终都是按天为单位来进行
     * 我们需要收集正利润就可以，加起来就是最终利润
     */
    public static int maxProfit1(int[] prices) {
        int totalProfit = 0;
        for(int i=0; i<prices.length-1; i++){
            int profit = prices[i+1]-prices[i];
            if(profit>0){
                totalProfit += profit;
            }
        }
        return totalProfit;
    }
    /**DP
     * O(n) Beats 5%
     * O(n) Beats 80%
     * 思路:
     * 1.dp[i][0] 第i天结束时未持股票的最大利润
     *   dp[i][1] 第i天结束时持有股票的最大利润
     * 2.初始化
     *      dp[0][0] = 0：第 0 天结束时未持有股票的最大利润为 0
     *      dp[0][1] = -prices[0]：第 0 天结束时持有股票的最大利润为负的股票价格，因为我们买入了股票
     * 3.状态转移/递推公式:
     *      未持有股票的状态 dp[i][0] 可以从两种情况转移而来：
     *          昨天也未持有股票，今天什么也不做：dp[i][0] = dp[i-1][0]
     *          昨天持有股票，今天卖出股票：dp[i][0] = dp[i-1][1] + prices[i]
     *      持有股票的状态 dp[i][1] 也可以从两种情况转移而来：
     *          昨天也持有股票，今天什么也不做：dp[i][1] = dp[i-1][1]
     *          昨天未持有股票，今天买入股票：dp[i][1] = dp[i-1][0] - prices[i]
     */
    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return dp[n-1][0];
    }
}
