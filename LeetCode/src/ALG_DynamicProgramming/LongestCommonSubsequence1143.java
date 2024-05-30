/**
 *Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * Constraints:
 * 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 */
package ALG_DynamicProgramming;
public class LongestCommonSubsequence1143 {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }
    /**DP
     * O(m*n) Beats 90%
     * O(m*n) Beats 65%
     * 思路：
     * 1.dp[i+1][j+1]:0->i长度的text1和0->j长度的text2的LCS
     * 2.if(text1[i] == text2[j]) dp[i][j] = 1 + dp[i-1][j-1];
     *   如果是相等的，那么将这个char放进subsequence中
     *   else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
     *   如果是不相等的，那么就找i,j+1 或者 i+1,j
     * 3.dp[0][0] = 0; dp[0][j] = 0; dp[i][0] = 0;
     * 注意事项:
     * 1.和P718一样，注意dp中的ij含义和text中的ij含义，使得代码更简洁
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[m][n];
    }
}
