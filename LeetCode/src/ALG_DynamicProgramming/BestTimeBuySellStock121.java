package ALG_DynamicProgramming;

import java.util.Scanner;

public class BestTimeBuySellStock121 {
    public static void main(String[] args) {
        //TODO处理输入
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number of price array:");
        int n = sc.nextInt();
        int[] prices  = new int[n];
        System.out.println("Please input"+n+" Integer of price array:");
        for(int i=0;i<n;i++){
            prices[i] = sc.nextInt();
        }
        System.out.println("The max profit is:"+maxProfit(prices));
    }
    /** Dynamic Programming
     * O(n) Beats99%
     * 遍历股票价格数组，同时记录下遇到的最低价格和当前最大利润
     */
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int profit = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] < minPrice) minPrice = prices[i];
            //当price[i]>=minPrice的时候才会进行这一步判断，如果每次不管是否更新minPrice都要进行判断+更新，runtime有点高
            else if(prices[i] - minPrice > profit) profit = prices[i] - minPrice;
        }
        return profit;
    }
}
