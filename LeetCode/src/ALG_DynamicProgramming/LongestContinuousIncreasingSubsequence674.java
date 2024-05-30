/**
 * Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). The subsequence must be strictly increasing.
 * A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].
 * Example 1:
 * Input: nums = [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
 * Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated by element
 * 4.
 * Example 2:
 * Input: nums = [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
 * increasing.
 * Constraints:
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */
package ALG_DynamicProgramming;
import java.util.Arrays;
public class LongestContinuousIncreasingSubsequence674 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,3};
        System.out.println(findLengthOfLCIS1(nums));
        System.out.println(findLengthOfLCIS2(nums));
    }
    /**Greedy
     * O(n) Beats 99%
     * O(1)
     * 思路:
     * 1.set Len & maxLen
     *   Len负责存储每一个连续递增子序列的长度
     *   maxLen负责存储所有连续子序列的最大长度
     * 2.遍历nums，记录每一个连续递增子序列
     *   一旦nums[i]<nums[i-1]，也就是当前子序列作废，开始记录新的子序列
     */
    public static int findLengthOfLCIS1(int[] nums) {
        int n = nums.length;
        int Len = 1;
        int maxLen = 1;
        for(int i=1; i<n; i++){
            if(nums[i]>nums[i-1]){
                Len++;
                maxLen = Math.max(maxLen,Len);
            }
            else Len = 1;
        }
        return maxLen;
    }
    /**DP
     * O(n) Beats 40%
     * o(n)
     * 思路：
     * 和P300一样，只是这里只需要判断nums[i-1]和nums[i]的关系，因为是连续的
     * 连续递增的子序列只跟前一个状态有关
     */
    public static int findLengthOfLCIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;
        Arrays.fill(dp,1);
        for(int i=1; i<n; i++){
            if(nums[i]>nums[i-1]){
                dp[i] = dp[i-1]+1;
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
