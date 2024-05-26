/**
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * We are playing a game with the stones. On each turn, we choose any two stones and smash them together. Suppose the stones have weights x and y with x <= y. The result of this smash is:
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 * Example 1:
 * Input: stones = [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
 * we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
 * we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
 * we can combine 1 and 1 to get 0, so the array converts to [1], then that's the optimal value.
 * Example 2:
 * Input: stones = [31,26,33,21,40]
 * Output: 5
 * Constraints:
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 */
package ALG_DynamicProgramming;

public class LastStoneWeightII1049 {
    public static void main(String[] args) {
        int[] stones = {31,26,33,21,40};
        System.out.println(lastStoneWeightII(stones));
    }
    /**DP(01Bags Apply)
     * O(n^2) Beats 80%
     * O(n) Beats 80%
     * 思路:
     * 既然要碰撞后的最小值，想到将石头分成两组，一组是+一组-，让两组差最小就是我们想要的结果
     *      因为不论怎么选，最后结果都是一组(+组) - (-组)，也就是将石头分成两组，让这两组的和的差尽量小
     *      为了让差值尽可能最小，那么让其中一组的值尽可能接近sum/2
     * 根据dp[]定义，也就是求dp[sum/2]的最大值，就是说在容量为sum/2的情况下，stones数组所能达到的最大值，也就是最接近sum/2的值
     * DP五部曲:
     * 1.dp[j] 当容量被j时，选择前i个石头所能组成的最大重量和
     * 2.dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
     * 3.dp[j] = 0;
     * 最后返回差值，也就是 sum-dp[sum/2] - dp[sum/2]
     */
    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones) sum+=stone;
        int target = sum/2;
        int[] dp = new int[target+1];
        for(int i=0; i<stones.length; i++){
            for(int j=target; j>=stones[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
                //System.out.println("("+i+","+j+"): "+dp[j]);
            }
        }
        return sum-dp[target]-dp[target];
    }
}
