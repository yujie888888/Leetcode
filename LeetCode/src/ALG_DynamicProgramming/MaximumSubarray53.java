/**
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
package ALG_DynamicProgramming;
public class MaximumSubarray53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray1(nums));
        System.out.println(maxSubArray2(nums));
    }

    /**Greedy
     * O(n) Beats 99%
     * O(1) Beats 85%
     * 思路：
     * 1.局部最优：当前“连续和”为负数的时候立刻放弃，从下一个元素重新计算“连续和”，因为负数加上下一个元素 “连续和”只会越来越小。
     * 2.全局最优：选取最大“连续和”
     */
    public static int maxSubArray1(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int i = 0;
        while(i < nums.length){
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
            if(sum < 0) sum = 0;
            i++;
        }
        return maxSum;
    }
    /**DP
     * O(n) Beats 99%
     * O(n)
     * 思路:
     * 1.dp[i]: 以nums[i]为结尾的subarray的最大和
     * 2.dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
     *   递推公式思路和P718是一样的，都是只关心i-1的状态，并且如果不相等就要将当前的连续subarray置为1/nums[i]
     *   理解一下其中的联系就懂我在说什么了
     */
    public static int maxSubArray2(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1; i<n; i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if(dp[i]>max) max = dp[i];
        }
        return max;
    }

}
