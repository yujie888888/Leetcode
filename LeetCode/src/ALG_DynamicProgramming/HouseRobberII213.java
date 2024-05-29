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
import java.util.Arrays;

/** DP
 * O(n) Beats 100%
 * O(n) Beats 75%
 * 思路:
 * 和P198一样,只是多了个环
 * 抢劫分成三种情况:
 *  1.首尾的房子都不抢
 *  2.抢第一个房子不抢第二个房子
 *  3.抢最后一个房子不抢第一个房子
 * 可以分成两种情况讨论:
 *  1.考虑包含第一个房子(不考虑最后一个房子，第一个房子可以加入也可以不加入)
 *  2.考虑包含最后一个房子(同上)
 *  这两种情况就包含了上述三种情况，按照P198的逻辑去做然后取最大值就可以
 */
public class HouseRobberII213 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int n = nums.length;
        if(n==1){
            System.out.println(nums[0]);
            return;
        }
        int[] nums1 = Arrays.copyOfRange(nums, 0, n-1);
        int[] nums2 = Arrays.copyOfRange(nums,1,n);
        System.out.println(Math.max(robber(nums1), robber(nums2)));
    }
    public static int robber(int[] nums){
        int len = nums.length;
        if(len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2; i<len; i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[len-1];
    }
}
