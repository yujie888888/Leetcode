/**
 * Amazon shopping periodically has offers to attract more customer.
 * It recently launched an offer for n items in its inventory, where the ithitem offered
 * reward[i]reward points to the customer purchasing the item. Every time an offer-bearing
 * item is purchased, the customer gains the reward points associated with that item.
 * Then the reward points of the remaining items are reduced by 1 unless it will reduce the points below 0.
 * Note
 * Each item can be purchased at most once, in other words, reward[i] becomes 0 after the ith item is purchased.
 * Function Description
 * Complete the function getMaxRewardPointsin the editor.
 * getMaxRewardPointshas the following parameter(s):
 * int reward[n]: the reward points of each item
 * Returns
 * long_int: the maximum reward points which can be collected
 */
package Company_Amazon;
import java.util.Arrays;

public class P8_GetMaximumReward {
    public static void main(String[] args) {
        int[] reward = {3, 3, 3, 3, 3};
        System.out.println(getMaxRewardPoints(reward));
    }
    /**Greedy
     * O(n)
     * O(1)
     * Ideas:
     * 这道题其实直接从第1个拿，不用排序应该也行，不过太简单没什么讨论价值
     * 1.First select the max reward -> one by one -> The max sum
     * 2.use reduce as the reward-1 after every time
     */
    public static long getMaxRewardPoints(int[] reward) {
        Arrays.sort(reward);
        long sum = 0;
        long reduce = 0;
        for(int i=reward.length-1; i>=0; i--){
            if(reward[i]-reduce <= 0) break;
            sum = sum + (reward[i] - reduce);
            reduce ++;
        }
        return sum;
    }
}
