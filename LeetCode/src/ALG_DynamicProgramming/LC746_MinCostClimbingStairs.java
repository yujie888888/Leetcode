/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 * Example 1:
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 * Constraints:
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
package ALG_DynamicProgramming;
public class LC746_MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
    /**DP
     * O(n)
     * O(n)
     * 思路:
     * 重要的是读懂题目
     * 1.top指的是所有的台阶都走完之后的位置，cost里存放的全是台阶的pay，所以top对应的就是cost最后一个值的下一个值，所以return的是dp[n]
     * 2.pay是说你如果用这个台阶，那么你要pay，如果你不用这个台阶或者只是单纯到从前面跳到了这个台阶，那么是不用pay这个台阶的cost的
     * 3.题目说可以从第0个台阶或者第1个台阶开始，所以dp[0]=dp[1]=0;
     * Steps:
     * 1.dp[i]:爬到第i层时的最小pay
     * 2.dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
     *      对于台阶i来说，有两种抵达的方式：从前前个，或者前个，因为用到这个台阶的时候才会pay，所以pay要放在状态转移方程中
     * 3.dp[0]=dp[1]=0;
     */
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2; i<=n; i++){
            dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }
        return dp[n];
    }
}
