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
public class MaximumLengthofRepeatedSubarray718 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        System.out.println(findLength1(nums1, nums2));
        System.out.println(findLength2(nums1, nums2));
    }
    /**DP(二维数组)
     * O(m*n) Beats 80%
     * O(m*n) Beats 60%
     * 真就是一开始想复杂了，DP就是一个“我随便想一下，写一下，哎怎么对了”的算法
     * 思路：
     * 1.dp[i][j] 表示nums1的前i个数和nums2的前j个数的LRS
     * 2.if(nums1[i] == nums2[j] dp[i][j] = dp[i-1][j-1] + 1;
         else dp[i][j] = 0; //确保连续
     * 3.如果i表示前i个数，那么这里就不用初始化了
     * 注意事项：
     * 1.初始化的时候注意i和j的含义，可以避免初始化
     * 2.这道题和1143最大的区别是1143不连续，718是连续题，所以一旦发现(i,j)的值不相等，那么值应该为0
     *   因为后续还是从前i个数和前j个数出发，中间如果出现了不一样的，肯定要置为0，表示不连续相等
     */
    public static int findLength1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m+ 1][n+1];
        dp[0][0] = 0;
        int maxLen = 0;
        for(int i=1; i<=nums1.length; i++){
            for(int j=1; j<=nums2.length; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLen = Math.max(maxLen,dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }
        return maxLen;
    }
    /**(推荐)DP(一维数组)
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
