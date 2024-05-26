/**
 * You are given an array nums consisting of integers. You are also given a 2D array queries, where queries[i] = [posi, xi].
 * For query i, we first set nums[posi] equal to xi, then we calculate the answer to query i which is the maximum sum of a
 * subsequence
 *  of nums where no two adjacent elements are selected.
 * Return the sum of the answers to all queries.
 * Since the final answer may be very large, return it modulo 109 + 7.
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 * Example 1:
 * Input: nums = [3,5,9], queries = [[1,-2],[0,-3]]
 * Output: 21
 * Explanation:
 * After the 1st query, nums = [3,-2,9] and the maximum sum of a subsequence with non-adjacent elements is 3 + 9 = 12.
 * After the 2nd query, nums = [-3,-2,9] and the maximum sum of a subsequence with non-adjacent elements is 9.
 * Example 2:
 * Input: nums = [0,-1], queries = [[0,-5]]
 * Output: 0
 * Explanation:
 * After the 1st query, nums = [-5,-1] and the maximum sum of a subsequence with non-adjacent elements is 0 (choosing an empty subsequence).
 * Constraints:
 * 1 <= nums.length <= 5 * 104
 * -105 <= nums[i] <= 105
 * 1 <= queries.length <= 5 * 104
 * queries[i] == [posi, xi]
 * 0 <= posi <= nums.length - 1
 * -105 <= xi <= 105
 */
package ALG_DynamicProgramming;

import java.util.Arrays;

public class Contest399_MaximumSumofSubsequence3165 {
    public static void main(String[] args) {

    }

    /**DP(一维数组)
     * O(m*n)
     * O(n)
     * 思路:
     * 其实就是按照queries来改变nums之后，将每次更新后的nums的最大子序列合加起来
     * 1.dp[i]: 以第 i 个元素结尾的、且不包含相邻元素的子序列的最大和
     * 2.dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
     *   只有两种状态，不选择第i个元素||选择第i个元素
     * 3.初始化dp[0],dp[1]
     * 注意事项:
     * 1.因为maxSum可能会过大(题目中提示了)，所以每次拿到maxSum之后都要进行取模操作
     * 2.在循环内每次都要取，不要最后取，避免中间的值超出范围，导致最后结果出错
     */
    public static int maximumSumSubsequence(int[] nums, int[][] queries) {
        int maxSum = 0;
        int[] dp = new int[nums.length];
        for(int[] query : queries){
            nums[query[0]] = query[1];
            Arrays.fill(dp,0);
            dp[0] = Math.max(0,nums[0]);
            if(nums.length>1) dp[1] = Math.max(0,Math.max(nums[0],nums[1]));
            for(int i=2; i<nums.length; i++){
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            }
            maxSum += dp[nums.length-1];
            maxSum = maxSum % (int)(Math.pow(10,9)+7);
        }
        return maxSum;
    }
}
