/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
package ALG_DynamicProgramming;
public class LC198_HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob1(nums));
    }
    /**DP1
     * O(n)
     * O(n)
     * Ideas:
     * HouseRobber的题总结一下就是对每个房子有两个状态: 1.偷 2.不偷,dp[]记录每个房子偷与不偷的最大值
     * 1.dp[i]：下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]
     * 2.recursion formula: 对于第i个房子，可以选择偷或者不偷
     *      偷: dp[i] = dp[i-2] + nums[i]  因为只要选择偷第i个房子，那么一定不能偷第i-1个房子，也就是从i-2(包含)个房子之前偷
     *      不偷: dp[i] = dp[i-1]
     * 3.dp[0]=nums[0] dp[1] = Math.max(nums[0],nums[1])
     */
    public static int rob1(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
    /**DP2
     * O(n^2)
     * 思路:
     * dp递推思路是对于第i个房子，检查其前i-2个房子的最大值
     */
    public static int rob2(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int max1 = -1;
        max1 = Math.max(dp[0],dp[1]);
        for(int i=2; i<n; i++){
            int max2 = -1;
            for(int j=0; j<=i-2; j++){
                max2 = Math.max(max2,dp[j]);
            }
            dp[i] = nums[i] + max2;
            max1 = Math.max(max1,dp[i]);
        }
        return max1;
    }
}
