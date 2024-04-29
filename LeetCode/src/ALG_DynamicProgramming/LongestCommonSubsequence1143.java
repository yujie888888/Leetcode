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
        System.out.println(longestCommonSubsequence1(text1, text2));
    }
    /**经典DP问题
     * O(m*n) Beats 90%
     * 思路：
     * 从后往前考虑，对于s1和s2的最后一个位置开始，如果字符相等，那么dp[i][j] = 1 + dp[i-1][j-1] 很好理解；
     * 如果不相等，那么要么舍弃s1的最后一个char，要么舍弃s2的最后一个char
     * 1.其实求什么问题，dp含义就是什么：dp[i][j] 表示text1[0,i-1]和text2的[0,j-1]的LCS
     * 2.if(text1[i] == text2[j]) dp[i][j] = 1 + dp[i-1][j-1];
         else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
     * 3.dp[0][0] = 0; dp[0][j] = 0; dp[i][0] = 0;
     * 注意事项：
     * 1.其实我依旧没有深入理解else的逻辑，目前来看就是说只要不相等就往前找相等的，依次加1这样，直到到最后也就是到头
     */
    public static int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][]dp = new int[m+1][n+1];
        for(int i=1; i<m; i++) dp[i][0] = 0;
        for(int j=1; j<n; j++) dp[0][j] = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
