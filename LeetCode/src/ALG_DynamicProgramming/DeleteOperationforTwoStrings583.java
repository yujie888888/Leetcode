/**
 * Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
 * In one step, you can delete exactly one character in either string.
 * Example 1:
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Example 2:
 * Input: word1 = "leetcode", word2 = "etco"
 * Output: 4
 * Constraints:
 * 1 <= word1.length, word2.length <= 500
 * word1 and word2 consist of only lowercase English letters.
 */
package ALG_DynamicProgramming;

public class DeleteOperationforTwoStrings583 {
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(minDistance(word1,word2));
    }
    /**DP
     * O(m*n) Beats 85%
     * O(m*n) Beats 85%
     * 思路:
     * Edit Distance
     * 就是找word1和word2中相同的char
     *   如果相同就不用管，不进行任何操作
     *   如果不同，就删除，删除有三种方法
     *     1.删除i
     *     2.删除j
     *     3.删除i和j
     * 1.dp[i][j]: word1的前i长度和word2的前j长度相同的时候，需要的最少的删除操作数
     * 2.if(word1[i] == word2[j]) dp[i+1][j+1] = dp[i][j];
     *     也就是i和j处的char不需要删除，看i-1和j-1相等需要的操作数
     *   else dp[i+1][j+1] = Math.min(dp[i][j+1]+1,dp[i+1][j]+1,dp[i][j]+2);
     * 3.初始化dp[i][0] = i; dp[0][j] = j;
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++) dp[i][0] = i;
        for(int j=1; j<=n; j++) dp[0][j] = j;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word1.charAt(i) == word2.charAt(j)) dp[i+1][j+1] = dp[i][j];
                else dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1], dp[i+1][j])+1,dp[i][j]+2);
            }
        }
        return dp[m][n];
    }
}
