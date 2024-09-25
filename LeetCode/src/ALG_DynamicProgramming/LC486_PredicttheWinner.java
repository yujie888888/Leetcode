package ALG_DynamicProgramming;

public class LC486_PredicttheWinner {
    public static void main(String[] args) {

    }

    /**
     * O(n^2)
     * Ideas:
     * 不需要一直记录玩家1和玩家2的分数，只需要记录分差
     * dp[i][j]表示在区间[i,j]内玩家1进行最优选择后和玩家2的分差
     * 注意一下内外循环的顺序，看状态转移方程就能看出来
     */
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) dp[i][i] = nums[i];
        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){
                // key: 每次玩家1可以选择nums[i]也可以选择nums[j]
                // 选择之后剩下的是玩家2选，玩家2也会按照最优策略进行选择，也就是在区间[x,y]里选也就是dp[i][j]
                // DP真的容易想进死胡同，别多想，能做出来就行
                dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }
}
