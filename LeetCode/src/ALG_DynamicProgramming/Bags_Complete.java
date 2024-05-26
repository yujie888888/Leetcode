/**
 * 有n种物品和一个容量为W的背包，每种物品都有无限件。第i种物品的重量是w[i]，价值是v[i]
 * 求解将哪些物品装入背包里使得这些物品的总重量不超过背包的容量，且总价值最大
 */
package ALG_DynamicProgramming;

public class Bags_Complete {
    public static void main(String[] args) {
        int n = 3, W = 5;
        int[] weights = {1, 2, 3};
        int[] values = {6, 10, 12};
        System.out.println(CompleteBags1(weights,values,n,W));
        System.out.println(CompleteBags2(weights,values,n,W));
    }
    /**完全背包(二维数组)
     * O(n*W)
     * O(n*W)
     * 思路:
     * 和01背包的区别的每样物品有无数个
     * 所以选择了某个物品后，依旧可以选择该物品
     * 1.dp[i][j]: 在前i个物品中任选，背包容量为j
     * 2.dp[x][0] = 0;
     * 3.递推公式:if(j>w[i]) dp[i][j] = Math.max(dp[i-1][j], dp[i][j-w[i]]+v[i]);
     * 注意事项:
     * 1.完全背包在初始化时要注意当i=0，也就是只装第一个物品时，由于有无限多个，所以可以多次选取
     */
    public static int CompleteBags1(int[] weights, int[] values, int n, int W){
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
        return dp[n-1][W];
    }
    /**完全背包(一维数组)
     * O(n*W)
     * O(W)
     * 思路:
     * 1.dp[j]: 在前i个物品中任选，背包容量为j
     * 2.dp[j] = 0;
     * 3.递推公式: dp[j] = Math.max(dp[j], dp[j-w[i]]+v[i]);
     * 注意事项:
     * 1.不同于二维数组繁琐的初始化，一维数组实际上不用进行额外的初始化操作，因为dp创建时默认值为0
     * 2.不同于01背包的一维数组做法时，内循环需要倒序遍历，这里只需要正序遍历即可
     *   因为二维数组的递推公式:if(j>w[i]) dp[i][j] = Math.max(dp[i-1][j], dp[i][j-w[i]]+v[i]);
     *   从中可以看出来在当前层(i)，我们不需要上一层的值
     */
    public static int CompleteBags2(int[] weights, int[] values, int n, int W) {
        int[] dp = new int[W+1];
        for(int i=0; i<weights.length; i++){
            for(int j=weights[i]; j<=W; j++){
                dp[j] = Math.max(dp[j],dp[j-weights[i]]+values[i]);
            }
        }
        return dp[W];
    }
}
