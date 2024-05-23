/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 * Example 1:
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * Example 2:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 3:
 * Input: nums = [1,2,3]
 * Output: 3
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
package ALG_DynamicProgramming;
/** DP
 * O(n) Beats 100%
 * O(n)
 * 思路:
 * 和P198一样,只是多了个环
 * 直接将问题分成两种情况: 考虑第一个 || 考虑最后一个
 * 和198的逻辑一样，然后计算出两种情况，取最大值
 * 注意事项：
 * 1.在考虑最后一个的情况下，初始化的是dp[1]和dp[2]，所以在一开始要讨论basecase len==2
 * 2.在考虑最后一个的情况下，初始化的是dp[1]和dp[2],因为这时第二个房子和第三个房子才是第一个和第二个
 */
public class HouseRobberII213 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int n = nums.length;
        if(n==1){
            System.out.println(nums[0]);
            return;
        }
        if(n==2){
            System.out.println(Math.max(nums[0], nums[1]));
            return;
        }
        int[] dp = new int[n];
        System.out.println(Math.max(dpFunc(0, n - 1, nums, dp), dpFunc(1, n, nums, dp)));
    }
    public static int dpFunc(int i, int n, int[] nums, int[] dp){
        if(i==0){
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0],nums[1]);
        }
        if(i==1){
            dp[1] = nums[1];
            dp[2] = Math.max(nums[1],nums[2]);
        }
        for(i=i+2; i<n; i++){
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
}
