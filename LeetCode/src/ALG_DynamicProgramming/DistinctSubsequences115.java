/**
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 * The test cases are generated so that the answer fits on a 32-bit signed integer.
 * Example 1:
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from s.
 * rabbbit
 * rabbbit
 * rabbbit
 * Example 2:
 * Input: s = "babgbag", t = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from s.
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * Constraints:
 * 1 <= s.length, t.length <= 1000
 * s and t consist of English letters.
 */
package ALG_DynamicProgramming;

public class DistinctSubsequences115 {
    public static void main(String[] args) {
        String s = "Rabbbit";
        String t = "Rabbit";
        System.out.println(numDistinct(s,t));
    }
    /**DP
     * O(m*n) Beats 90%
     * O(m*n) Beats 80%
     * 思路：
     * Edit Distance的删除题型
     *   就是求s包含多少==t的子序列
     *   既然t是确定的，也就是看s中的char能组成多少==t的串
     *   t是确定的，t中的每一个char都是要匹配的，那么对s进行删除操作
     *   在匹配的时候，如果s[i]==t[j]
     *     那么s[i]这个char可以用来去组成t，也就是dp[i+1][j+1] = dp[i][j]这里就是默认拿s[i]去组成t
     *     但是也可以不用s[i]去组成t，可以选s[i]之前的char，这个char==t[j]，去组成t，也就是dp[i+1][j+1] = dp[i][j+1]
     *     合起来就是dp[i+1][j+1] = dp[i][j] + dp[i][j+1]
     *   如果s[i]!=t[j]，也就是s[i]不能用来组成t，那么从前i-1长度中找能组成t的char
     *   这整个过程就是在s中找能组成t的char的组合
     * 1.dp[i+1][j+1]: 前i长度的s包含多少前等于j长度的t的子序列
     * 2.if(s[i] == t[j]) dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
     *   else dp[i+1][j+1] = dp[i][j+1];
     * 3.dp[i][0] = 1;前i长度的s包含null的个数为1
     * 4.剪枝: if(i<j) continue;
     */
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m; i++) dp[i][0] = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i<j) continue;
                if(s.charAt(i) == t.charAt(j)) dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
                else dp[i+1][j+1] = dp[i][j+1];
            }
        }
        return dp[m][n];
    }
}
