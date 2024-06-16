/**
 * A team of financial analysts at Amazon has designed a stock indicator to
 * determine the consistency of Amazon's stock in delivering returns daily.
 * More formally, the percentage return (rounded off to nearest integer)
 * delivered by the stock each day over the last n days is considered.
 * This is given as an array of integers, stock_prices.
 * The stock's k-consistency score is calculated using the following operations:
 *      1.In a single operation, omit a particular day's return from the stock_prices array
 *        to get have one less element, then rejoin the parts of the array. This can be done at most k times.
 *      2.The maximum number of contiguous days during which the daily return was the same
 *        is defined as the k-consistency score for Amazon's stock. Note that the return may be positive or negative.
 * As part of the team, you have been assigned to determine the k-consistency score for the stock.
 * You are given an array stock_prices of size n representing the daily percentage return delivered by Amazon stock and a parameter k.
 * Determine the k-consistency score.
 * Example:
 * Consider the percentage return delivered by Amazon's Stock in the last 8 days is represented
 * as stock_prices = [1, -2, 1, 1, 3, 2, 1, -2] and k = 3.
 * Returns
 * int: the maximum possible k-consistency score
 * Constraints:
 *   1≤ n ≤3⋅10^5
 *   -10^9≤ stock_prices[i] ≤10^9
 *   0≤ k ≤3⋅10^5
 * Complete in O(n)
 */
package Company_Amazon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class P3_GetKConsistencyScore {
    public static void main(String[] args) {
        int[] stock = {1, -2, 1, 1, 3, 2, 1, -2, 1, 1, 1};
        int k = 0;
        //System.out.println(solution1(stock,k));
        System.out.println(solution2(stock,k));
    }
    /**HashMap<Integer,List<Integer>> + Slide Window
     * O(n)
     * O(m)
     * Ideas:
     * 1.Use Map to store the price and the index of price
     * 2.traverse every unique price of stock
     *     create a slide window of this price, the window's size means continues price of stock
     *     according to the index list of this price, calculate the deleted count and continues length of this price
     *     if deleted count over k, then remove the left of window, and free the deleted count from the next of left to left
     */
    private static int solution1(int[] stock, int k){
        HashMap<Integer, List<Integer>> map = new HashMap();
        for(int i=0; i<stock.length; i++){
           map.computeIfAbsent(stock[i],x->(new ArrayList<>())).add(i);
        }
        int maxLen = 0; int len;
        for(int key : map.keySet()){
            if(map.get(key).size() == 1){
                maxLen = Math.max(maxLen,1);
                continue;
            }
            int i=0, j=1;
            int deleted = 0;
            len = 1;
            while(i<j && j<map.get(key).size()){
                deleted += (map.get(key).get(j)-map.get(key).get(j-1)-1);
                len++;
                while(i<j && k<deleted){
                    len--;
                    deleted -= (map.get(key).get(i+1)-map.get(key).get(i)-1);
                    i++;
                }
                maxLen = Math.max(maxLen,len);
                j++;
            }
        }
        return maxLen;
    }
    /**HashSet + SildeWindow
     * O(m*n) LTE m is the number of unique price of stock
     * O(m)
     * Idea: Force Method, not recommended
     */
    private static int solution2(int[] stock, int k){
        HashSet<Integer> set = new HashSet<>();
        for(int price : stock){
            set.add(price);
        }
        int i, j, len, delete, maxLen=0;
        for(int key : set){
            i=0; j=0; len=0; delete=0;
            while(i<=j && j<stock.length){
                while(k-delete<=0 && i<j){
                    if(stock[i] == key) len--;
                    else delete--;
                    i++;
                }
                if(stock[j] == key){
                    len++;
                    if(len>maxLen) maxLen = len;
                }
                else delete++;
                j++;
            }
        }
        return maxLen;
    }
}
