/**
 * The price of Amazon common stock is analyzed over a period of several months.
 * A group of k consecutive months is said to be observable if no two months in the group have the same stock price.
 * In other words, all the prices in the period are distinct.
 * The sum of stock prices of an observable group of months is called the cumulative observable sum.
 * Given the price of Amazon stock for n months, find the maximum possible cumulative observable sum among all the observable groups of months.
 * If there is no observable group, return -1.
 * Example1:
 * Monthly stock prices are given as stockPrice = [1, 2, 7, 7, 4, 3, 6]
 * and the number of consecutive months to consider is k=3.
 * Output: 14
 * Example2:
 * stockPrice = [1, 2, 3, 4] k=2
 * Output: 7
 * Completed in O(n) time complexity
 */
package Company_Amazon;
import java.util.HashMap;
import java.util.HashSet;

public class P1_MaxCumulativeObservableSum {
    public static void main(String[] args) {
        int[] stockPrice = {1, 2, 3, 4};
        int k = 2;
        System.out.println(solution2(stockPrice,k));
    }
    /**HashMap + slide window
     * O(n)
     * O(k)
     * Idea:
     * In order to reduce the Time complexity to O(n), use map to store every integer's frequency
     * And maintain the window's length to check the map.size() to judge the integers are unique or not
     * 1. Use Map to store fist k integer's frequency
     *    if(map.size() == k) means the integer of first k are unique, then the sum can be used
     * 2. maintain the window's length
     *    from 1 to n-k
     *      for every integer, delete the i-1 -th integer, add the i+k-1 -th integer
     *      because the window's size is always k, so just need to check the map.size() we can know the integers of window are unique or not
     */
    private static long solution1(int[] stock, int k){
        int n = stock.length;
        if(n<k) return -1;
        HashMap<Integer,Integer> map = new HashMap();
        long sumL = 0, max = -1;
        for(int i=0; i<k; i++){
            map.put(stock[i],map.getOrDefault(stock[i],0)+1);
            sumL += stock[i];
        }
        if(map.size() == k) max = sumL;
        for(int i=1; i<=n-k; i++){
            map.put(stock[i-1],map.get(stock[i-1])-1);
            sumL -= stock[i-1];
            if(map.get(stock[i-1]) == 0) map.remove(stock[i-1]);

            map.put(stock[i+k-1],map.getOrDefault(stock[i+k-1],0)+1);
            sumL += stock[i+k-1];

            if(map.size() == k && max<sumL) max = sumL;
        }
        return max;
    }
    /**
     * 1.prefix sum
     * 2.每次快指针和前一个重复的时候就把慢指针移到快指针处，重置和，慢指针和快指针差k-1就比较取最大，慢指针加一，跑了一下题目的case是ok的，时间复杂度是O(n)
     */
    /**HashSet
     * O(n*k)
     * O(k)
     * Ideas:
     * The length of window is fixed, and in the window, check the elements are unique or not
     *   if not unique, the sumL can not be used
     *   if unique, find max_sumL among all the sumL
     */
    private static int solution2(int[] stockPrice, int k){
        HashSet<Integer> set = new HashSet<>();
        int n = stockPrice.length;
        int sumL = 0, max = -1;
        int t;
        for(int i=0; i<=n-k; i++){
            t=i;
            while(t<=i+k-1){
                if(set.contains(stockPrice[t])){
                    sumL = -1;
                    break;
                }
                else{
                    set.add(stockPrice[t]);
                    sumL += stockPrice[t];
                }
                t++;
            }
            if(max<sumL) max = sumL;
            set.clear();
            sumL = 0;
        }
        return max;
    }
}

