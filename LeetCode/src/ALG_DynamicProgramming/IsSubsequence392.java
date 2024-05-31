/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 * Example 1:
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 * Constraints:
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
 * and you want to check one by one to see if t has its subsequence.
 * In this scenario, how would you change your code?
 */
package ALG_DynamicProgramming;

public class IsSubsequence392 {
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence1(s,t));
        System.out.println(isSubsequence2(s,t));
    }
    /**double points
     * O(n) Beats 65%
     * O(1) Beats 90%
     * 思路:
     * 用len计算s和t中相同的char的个数，如果len==s.len
     * 也就是s和t中相同的char的个数是s的长度，那么s就是t的subsequence
     */
    public static boolean isSubsequence1(String s, String t) {
        int i = 0;
        int j = 0;
        int len = 0;
        while(i<s.length() && j<t.length()){
            if(s.charAt(i) == t.charAt(j)){
                len++;
                i++;
                j++;
            }
            else j++;
        }
        return len==s.length();
    }
    /**DP
     * O(m*n)
     * O(m*n)
     * 思路：
     * 编辑距离的入门题，只涉及删除操作
     * 相当于在t中找能组成s的char
     *   if(s[i] == t[j]) t中找到了一个字符能组成s
     *   if(s[i] != t[j]) t[j]不能用来组成s，那就在t中删除这个元素
     *   这样的递推是包含了字符的顺序
     * 最后比较能组成s的char的number是不是s的长度
     * 1.dp[i+1][j+1]: 长度为i的s和长度为j的t的LCS
     * 2.if(s.charAt(i) == t.charAt(j)) dp[i+1][j+1] = dp[i][j] + 1;
     *   else dp[i+1][j+1] = dp[i+1][j];
     *   如果相等就+1
     *   如果不相等，就”删除“t的第j个char
     * 注意事项:
     * 1.这道题用双指针肯定更简单，但是用编辑记录做也很好的为后面开端
     * 2.这道题重点在于理解"删除"操作
     */
    public static boolean isSubsequence2(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m>n) return false;
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }
                else{
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
        }
        return dp[m][n] == m;
    }
}
