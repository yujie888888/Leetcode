package ALG_DynamicProgramming;

public class LC1062_LongestRepeatingSubstring {
    public static void main(String[] args) {

    }
    /**DP
     * 一知半解状态，太难想了
     * O(n^2)
     * O(1)
     * Ideas:
     * [0,i]为一部分，[i+1,n-1]为一部分
     * i代表在第一个部分中以char[i]结尾的string
     * j代表在第二个部分中以char[j]结尾的string
     * dp[i][j] 表示字符串 s 中以位置 i 和位置 j 结尾的最长公共子串的长度
     * 对于连续的sub-xxx, 不满足条件的就直接不用管或者重置为0即可，类似P718 P1143
     * 只要找到char[i] == char[j]就调dp[i][j]，dp[i][j]里面存的就是不包含当前char的时候最长重复子串的长度
     */
    public static int longestRepeatingSubstring(String s) {
        int n = s.length();
        int max = -1;
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    max = Math.max(max,dp[i+1][j+1]);
                }
            }
        }
        return max = max == -1? 0 : max;
    }
}
