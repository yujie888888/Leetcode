package ALG_DynamicProgramming;

public class LC97_InterleavingString {
    public static void main(String[] args) {

    }

    /**DP dp[][]
     * O(n1*n2)
     * O(n1*n2)
     * 初步检查：
     * 首先计算 s1 和 s2 的长度，以及 s3 的长度。
     * 如果 s3 的长度不等于 s1 和 s2 的长度之和，直接返回 false。因为如果 s3 的长度和 s1、s2 加起来不一样，那 s3 不可能由 s1 和 s2 交错组成。
     *
     * 创建动态规划数组：
     * 创建一个二维布尔数组 dp，大小为 (n1 + 1) x (n2 + 1)，用于保存从 s1 和 s2 到 s3 的组合情况，其中 n1 和 n2 分别是 s1 和 s2 的长度。
     * dp[i][j] 表示 s1 的前 i 个字符和 s2 的前 j 个字符能否交错组成 s3 的前 i + j 个字符。
     *
     * 初始化动态规划数组：
     * 将 dp[0][0] 设为 true，表示空字符串可以交错组成空字符串。
     * 初始化第一列：只使用 s1 来匹配 s3。
     * 对于 dp[i][0]，如果前一个状态 dp[i-1][0] 为 true，且 s1 的第 i 个字符与 s3 的第 i 个字符相同，则 dp[i][0] 为 true。
     * 初始化第一行：只使用 s2 来匹配 s3。
     * 对于 dp[0][j]，如果前一个状态 dp[0][j-1] 为 true，且 s2 的第 j 个字符与 s3 的第 j 个字符相同，则 dp[0][j] 为 true。
     *
     * 填充动态规划数组：
     * 使用双重循环填充 dp 数组。
     * 对于每个 dp[i][j]：
     * 如果 s1[i-1] == s3[i+j-1] 且 dp[i-1][j] 为 true，那么 dp[i][j] 为 true，表示从 s1 继续匹配成功。
     * 如果 s2[j-1] == s3[i+j-1] 且 dp[i][j-1] 为 true，那么 dp[i][j] 为 true，表示从 s2 继续匹配成功。
     * 如果两种情况中的任意一种成立，则 dp[i][j] 为 true
     */
    public boolean isInterleave1(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 + n2 != s3.length())
            return false;
        boolean dp[][] = new boolean[n1 + 1][n2 + 1];
        // dp[i][j]: s1[0,i) and s2[0,j) can constitute s3[0,i+j)

        dp[0][0] = true;
        for (int i = 1; i <= n1; i++) {
            if (dp[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1)) {
                dp[i][0] = true;
            }
        }
        for (int j = 1; j <= n2; j++) {
            if (dp[0][j - 1] && s3.charAt(j - 1) == s2.charAt(j - 1)) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                if (s2.charAt(j - 1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }

            }
        }
        return dp[n1][n2];
    }
    /**DP dp[]
     * O(mn)
     * O(n)
     */
    public static boolean isInterleave2(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m+n != s3.length()) return false;
        boolean dp[] = new boolean[n+1];
        dp[0] = true;
        for(int j=1; j<=n; j++){
            if(dp[j-1] && s2.charAt(j-1) == s3.charAt(j-1)){
                dp[j] = true;
            }
        }
        for(int i=1; i<=m; i++){
            dp[0] = dp[0] && s1.charAt(i-1) == s3.charAt(i-1);
            for(int j=1; j<=n; j++){
                dp[j] = (s1.charAt(i-1) == s3.charAt(i+j-1)) && dp[j];
                dp[j] = (s2.charAt(j-1) == s3.charAt(i+j-1)) && dp[j-1] || dp[j];
            }
        }
        return dp[n];
    }
}
