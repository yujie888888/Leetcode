/**
 * 有n种物品和一个容量为W的背包，每种物品都有无限件。第i种物品的重量是w[i]，价值是v[i]
 * 求解将哪些物品装入背包里使得这些物品的总重量不超过背包的容量，且总价值最大
 */
package ALG_DynamicProgramming;
/**完全背包
 * 和01背包的区别的每样物品有无数个
 * 所以选择了某个物品后，依旧可以选择该物品
 * 1.dp[i][j]: 在前i个物品中任选，背包容量为j
 * 2.dp[x][0] = 0;
 * 3.递推公式:if(j>w[i]) dp[i][j] = Math.max(dp[i-1][j], dp[i][j-w[i]]+v[i]);
 * 注意事项:
 * 1.完全背包在初始化时要注意当i=0，也就是只装第一个物品时，由于有无限多个，所以可以多次选取
 */
public class Bags_Complete {
    public static void main(String[] args) {
        int n = 3, W = 5;
        int[] weights = {1, 2, 3};
        int[] values = {6, 10, 12};

        int dp[][] = new int[n][W+1];
        for(int i=0; i<n; i++) dp[i][0] = 0;
        for(int j=0; j<=W; j++) dp[0][j] = values[0] * j/weights[0];
        for(int i=1; i<n; i++){
            for(int j=1; j<=W; j++){
                if(j>=weights[i]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weights[i]]+values[i]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[n-1][W]);
    }
}
