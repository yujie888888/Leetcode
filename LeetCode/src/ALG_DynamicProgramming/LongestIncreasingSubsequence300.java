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
     * O(n^2) Beats 60%
     * O(n) Beats 96%
     * 思路:
     * 关键是想到dp[i]由哪些状态可以推出来，并取最大值
     * 不连续递增子序列的跟前0-i 个状态有关
     * 就是在i之前的子串+1 -> dp[i]
     * 1.dp[i]: i之前包括i的以nums[i]结尾的最长递增子序列的长度
     *   dp[i]的含义是一切的开始，只有这么定义才知道接下来怎么写逻辑
     *   这里以nums[i]结尾是一个非常巧妙的点
     * 2.递推关系
     *   因为子序列是不连续的，所以在下标为i时，对下标从j:0->i-1进行一个判断，是否存在nums[i]>nums[j]
     *   if(nums[i]>nums[j]),说明下标j为结尾的nums[j]的值小于nums[i],也就是可以选择nums[j]为结尾的这一串进入，也可以不选
     *   注意选的是以nums[j]结尾的一连串，不是单选择nums[j]
     *   选择进入的串表示这一串都是满足条件的，而且nums[j]<nums[i]说明，j这一串是可以加入i的
     *   举个例子：
     *      [10,2,4,3,8,9]这个例子中就是当遍历到3的时候，比较3和前面分别以10，2，4结束的串的大小，3大于2，就说明以3为结尾的串的长度可以是以2为结尾的长度+1
     * 3.dp[i]=1; 初始化所有下标
     *   dp[i]初始值是1，也就是子串是有nums[i]自己
     * 注意事项：
     * 1.dp[n-1]不一定是最大值，最大值可能出现在中间位置，所以用max来记录最大值
     * 2.初始化max==1
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
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
