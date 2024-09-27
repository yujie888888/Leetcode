package ALG_DynamicProgramming.Graph;

public class LC221_MaximalSquare {
    public static void main(String[] args) {

    }

    /**DP
     * O(mn)
     * O(mn)
     * Ideas:
     * 真的不好想，争取总结出这种题的规律，照猫画虎
     * 最难的是State transfer equation：
     *  dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
     *  这个state transfer equation ensures that
     *      the minimum length of four edge of square (最短的决定总的)
     *      画个图就能明白，这三个dp[][] + grid[i][j]就确定了这个square能构成的面积
     *          从grid[i][j]出发到左上角，这三个dp[][]全覆盖了
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // include the grid[i][j], the maximum edge of square
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
                    max = Math.max(max,dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return max*max;
    }
}
