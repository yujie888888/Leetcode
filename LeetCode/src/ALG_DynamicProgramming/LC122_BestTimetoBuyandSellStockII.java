package ALG_DynamicProgramming;

public class LC122_BestTimetoBuyandSellStockII {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));
    }
    /**Greedy
     * O(n)
     * O(1)
     * Ideas：
     * Greedy method is that we need to catch every profit
     * 和contest一道题很像，将总利润分解成子利润
     *      假如第 0 天买入，第 3 天卖出，那么利润为：prices[3] - prices[0]
     *      相当于 (prices[1] - prices[0]) + (prices[2] - prices[1]) + (prices[3] - prices[2])
     *      第0天买第1天卖 + 第1天买第2天卖 + 第2天买第3天卖
     * 题目要求我们找到几个交易的最大利润的和，其实就是将n天分解
     * 但是我们不知道起点和终点在哪里，但是从分解的式子能看出
     *    (prices[3] - prices[2])这种小部分肯定是>0才会被加入，才会使利润更大
     * 所以分解成子问题，就是收集每两天的正利润，加起来就是最终利润
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
     * 不大推荐这个做法，运行太慢；DP实际上的思想和Greedy都是一样的
     * 1.dp[i][0] 第i天结束时未持股票的最大利润
     *   dp[i][1] 第i天结束时持有股票的最大利润
     * 2.状态转移/递推公式:
     *      未持有股票的状态 dp[i][0] 可以从两种情况转移而来：
     *          昨天也未持有股票，今天什么也不做：dp[i][0] = dp[i-1][0]
     *          昨天持有股票，今天卖出股票：dp[i][0] = dp[i-1][1] + prices[i]
     *      持有股票的状态 dp[i][1] 也可以从两种情况转移而来：
     *          昨天也持有股票，今天什么也不做：dp[i][1] = dp[i-1][1]
     *          昨天未持有股票，今天买入股票：dp[i][1] = dp[i-1][0] - prices[i]
     * 3.初始化
     *      dp[0][0] = 0：第 0 天结束时未持有股票的最大利润为 0
     *      dp[0][1] = -prices[0]：第 0 天结束时持有股票的最大利润为负的股票价格，因为我们买入了股票
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
