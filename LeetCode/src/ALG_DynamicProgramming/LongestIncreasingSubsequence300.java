/**
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * Constraints:
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
package ALG_DynamicProgramming;
import java.util.Arrays;
public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(lengthOfLIS(nums));
    }
    /**DP
     * O() Beats 60%
     * O() Beats 96%
     * 思路:
     * 1.dp[i]: 以下标i结尾的最长子序列的长度
     * 2.dp[i]=1; 初始化所有下标
     * 3.递推关系
     *   因为子序列是不连续的，所以在下标为i时，对下标从j:0->i-1进行一个判断，是否存在nums[i]>nums[j]
     *   if(nums[i]>nums[j]),说明下标j为结尾的nums[j]的值小于nums[i],也就是可以选择nums[j]为结尾的这一串进入，也可以不选
     *   注意选的是以nums[j]结尾的一连串，不是单选择nums[j]
     * 注意事项：
     * 1.dp[n-1]不一定是最大值，最大值可能出现在中间位置，所以用max来记录最大值
     * 2.base case n==1 要单独写，因为max初始化为0，如果不单独拿出来base case，结果会不对
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
