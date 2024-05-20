/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * Constraints:
 * 0 <= word1.length, word2.length <= 500
 * word1 and word2 consist of lowercase English letters.
 */
package ALG_DynamicProgramming;

public class EditDistance72 {
    public static void main(String[] args) {
        String word1 = "asdfcvsad";
        String word2 = "asdhsdfja";
        System.out.println(minDistance(word1,word2));
    }

    /** DP(二维数组)
     * O(m*n) Beats 80%
     * O(m*n) Beats 80%
     * 思路:
     * 其实依旧没有透彻理解，只是能按照DP思路半抄半理解写下来了而已
     * 不容易理解，一看题以为很复杂，其实做题逻辑来说还好
     * 最重要的就是知道dp[i][j]的含义
     * 然后从前向后进行
     * 1. dp[i][j]: word1的前i长度和word2的前j长度的minimum edit minDistance
     * 2. if(word1[i-1] == word2[j-1]) dp[i][j] = dp[i-1][j-1];
     *    else 有三种操作：insert,delete,replace
     *      insert: dp[i][j] = dp[i][j-1]+1
     *      delete: dp[i][j] = dp[i-1][j]+1
     *      replace: dp[i][j] = dp[i-1][j-1]+1;
     *      操作的递推不好理解，举个例子想一想就明白了
     * 注意事项：
     * dp[i][j]和word[i][j]不一样，word小一个单位
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int i=1; i<=m; i++) dp[i][0] = dp[i-1][0]+1;
        for(int i=1; i<=n; i++) dp[0][i] = dp[0][i-1]+1;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(arr1[i-1] == arr2[j-1]) dp[i][j] = dp[i-1][j-1];
                else{
                    int temp = Math.min(dp[i][j-1],dp[i-1][j-1]);
                    dp[i][j] = Math.min(temp,dp[i-1][j])+1;
                }
            }
        }
        return dp[m][n];
    }
}
