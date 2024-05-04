/**
 *You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 * Constraints:
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
package ALG_Greedy;
public class BestTimeBuySellStock121 {

    public static void main(String[] args) {
        int[] prices = {7, 6, 5, 4, 3, 2};
        System.out.println(greedy(prices));
    }
    /** Greedy ALG
     * O(n) Math.min()的时间复杂度是O(1) Beats 80%
     * O(1) Beats 70%
     * 思路：
     * 其实每一次遍历都是在寻找最低价格和最大利润
     * 1.将当前遍历到的位置之前 遇到的最低价格作为买入价格
     * 2.遍历数组，计算最大利润
     */
    public static int greedy(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-minPrice);
        }
        return maxProfit;
    }
}
