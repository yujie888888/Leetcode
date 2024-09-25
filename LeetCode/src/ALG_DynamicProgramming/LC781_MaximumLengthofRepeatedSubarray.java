/**
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 * Example 1:
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * Output: 3
 * Explanation: The repeated subarray with maximum length is [3,2,1].
 * Example 2:
 * Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * Output: 5
 * Explanation: The repeated subarray with maximum length is [0,0,0,0,0].
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 100
 */
package ALG_DynamicProgramming;
public class LC781_MaximumLengthofRepeatedSubarray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        System.out.println(findLength1(nums1, nums2));
        System.out.println(findLength2(nums1, nums2));
    }
    /**DP(二维数组)
     * O(m*n) Beats 85%
     * O(m*n) Beats 60%
     * 思路：
     * Subsequence VS Subarray
     *   Subsequence不连续
     *   Subarray连续，Subarray就是连续版的Subsequence
     * 1.dp[i][j]: 以nums1[i-1]为结尾的subarray和以nums2[j-1]为结尾的subarray的LRS
     * 2.如果nums1[i]==nums2[j],那么dp[i+1][j+1] = dp[i][j]+1;
     * 3.如果nums1[i]!=nums2[j],那么dp[i+1][j+1] = 0;
     *      本来就是0所以不用做什么
     *      因为subarray必须是连续的，所以如果中间断了就必须重置为0
     *      所以res可能藏在中间，所以要用一个max存中间结果
     * 4.return max
     *   nums1和nums2有多个repeated subarray，保存其中长度最长的
     * 注意事项：
     * 1.dp里的ij和numsde ij不一样，dp的ij要比nums的大一
     *   因为如果一样会出现需要额外初始化等额外操作
     */
    public static int findLength1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(nums1[i]==nums2[j]) dp[i+1][j+1] = dp[i][j]+1;
                max = Math.max(max,dp[i+1][j+1]);
            }
        }
        return max;
    }
    /**DP(一维数组)
     * O(m*n) Beats 97%
     * O(n) Beats 95%
     * dp[j] 表示nums1的前i个数和nums2的前j个数的LRS
     * if(dp[i]==dp[j]) dp[j] = 1 + dp[j]
       else dp[j] = 0;
     * 注意事项：
     * 1. 在内循环中，要从后往前找
     *    dp[i][j] = 1 + dp[i-1][j-1] 我要的是上一层的值，所以要从后往前，确保dp[j-1]存的依旧是上一层的值
     */
    public static int findLength2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        int maxLen = 0;
        for(int i=1; i<=m; i++){
            for(int j=n; j>=1; j--){
                if(nums1[i-1] == nums2[j-1]){
                    dp[j] = 1 + dp[j-1];
                    maxLen = Math.max(maxLen, dp[j]);
                }
                else dp[j] = 0;
            }
        }
        return maxLen;
    }
}
