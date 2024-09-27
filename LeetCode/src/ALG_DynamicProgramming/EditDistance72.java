package ALG_DynamicProgramming;
public class EditDistance72 {
    public static void main(String[] args) {
        String word1 = "asdfcvsad";
        String word2 = "asdhsdfja";
        System.out.println(minDistance(word1,word2));
    }
    /** DP
     * O(m*n) Beats 80%
     * O(m*n) Beats 80%
     * 思路:
     * Edit Disttance
     * 让word1变成word2，只对word1进行操作
     * if(word1[i] == word2[j]) 不操作
     * else 可以进行
     *   1.delete dp[i+1][j+1] = dp[i][j+1]+1;
     *   2.insert dp[i+1][j+1] = dp[i+1][j]+1; word1插入相当于word2删除
     *   3.replace dp[i+1][j+1] = dp[i][j]+1;
     *   找出三种情况对应的递推公式
     * 1. dp[i][j]: 如果word1的前i长度和word2的前j长度相同，需要的minimum edit minDistance
     * 2. if(word1[i-1] == word2[j-1]) dp[i][j] = dp[i-1][j-1];
     *    else 有三种操作：insert,delete,replace
     *      insert: dp[i][j] = dp[i][j-1]+1
     *      delete: dp[i][j] = dp[i-1][j]+1
     *      replace: dp[i][j] = dp[i-1][j-1]+1;
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++) dp[i][0] = i;
        for(int j=1; j<=n; j++) dp[0][j] = j;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word1.charAt(i) != word2.charAt(j)){
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1],dp[i+1][j]),dp[i][j])+1;
                }
                else dp[i+1][j+1] = dp[i][j];
            }
        }
        return dp[m][n];
    }
}
