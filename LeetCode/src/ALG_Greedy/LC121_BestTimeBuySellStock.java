package ALG_Greedy;
public class LC121_BestTimeBuySellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(greedy(prices));
    }
    /** Greedy ALG
     * O(n) Math.min()的时间复杂度是O(1) Beats 99%
     * O(1) Beats 95%
     * 思路：
     * 其实每一次遍历都是在寻找最低价格和最大利润
     * 1.将当前遍历到的位置之前 遇到的最低价格作为买入价格
     * 2.遍历数组，计算利润,并将最大利润记录下来
     */
    public static int greedy(int[] prices) {
        int buy = (int)Math.pow(10,4)+1;
        int maxProfit = -(int)Math.pow(10,4)-1;
        for(int i=0; i<prices.length; i++){
            buy = Math.min(buy,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-buy);
        }
        return maxProfit;
    }
}
