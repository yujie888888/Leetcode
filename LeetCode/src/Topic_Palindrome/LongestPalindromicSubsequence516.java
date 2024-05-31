package Topic_Palindrome;

public class LongestPalindromicSubsequence516 {
    public static void main(String[] args) {
        String s = "bbbabsadddwasabbbb";
        System.out.println(longestPalindromeSubseq(s));
    }
    /**DP
     * O(n^2) Beats 70%
     * O(n^2) Beats 60%
     * 思路:
     * 这道题如果找的是substring，那么用P647的做法没问题，但是这道题是subsequence
     * 1.dp[i][j]:在i-j范围内的，最长的回文子序列的长度
     *   注意这里和P647连续回文子串的定义区别
     * 2.if(s[i]==s[j]) 分三种情况
     *       i==j  ==1
     *       i+1==j  ==2
     *       j-i>=2  ==dp[i+2][j] + 2
     *   else 分两种情况
     *       忽略s[i] dp[i+2][j+1]
     *       忽略s[j] dp[i+1][j]
     * 3.确定遍历顺序
     *       [i+1][j]    ->
     *       [i][j-1]    ->   [i][j]
     *       [i+1][j-1]  ->
     *       i： 下->上
     *       j： 左->右
     */
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i == j) dp[i+1][j+1] = 1;
                    else if (j-i == 1) dp[i+1][j+1] = 2;
                    else dp[i+1][j+1] = dp[i+2][j] + 2;
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i+2][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[1][n];
    }
}
