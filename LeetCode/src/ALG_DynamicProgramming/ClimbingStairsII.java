/**
 * 假设你正在爬楼梯，需要n阶你才能到达楼顶。
 * 每次你可以爬至多m (1 <= m < n)个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 输入示例
 * n=3 m=2
 * 输出示例
 * 3
 * 提示：
 * 当 m = 2，n = 3 时，n = 3 这表示一共有三个台阶，m = 2 代表你每次可以爬一个台阶或者两个台阶。
 * 此时你有三种方法可以爬到楼顶。
 * 1 阶 + 1 阶 + 1 阶段
 * 1 阶 + 2 阶
 * 2 阶 + 1 阶
 */
package ALG_DynamicProgramming;

public class ClimbingStairsII {
    /**DP(一维数组)
     * O(m*n)
     * O(n)
     * 这道题是P70爬楼梯的进阶题
     * 1.dp[i]: 爬到第i阶楼梯有多少种方法
     * 2.dp[i] = dp[i-1]+dp[i-2]+...+dp[i-m]
     *   每阶楼梯有m种可能的情况
     * 3.dp[0] = 1；
     * 注意事项:
     * 1.对于i<m的情况，爬第i阶台阶 要么从i-1的位置爬一层，要么从i-2的位置爬两层...要么从第0层爬i阶
     *   因为i<m，所以j-m<0,所以如果要用一个double for loop，就要在内循环进行一个判断，防止index溢出
     */
    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i-j>=0) dp[i] += dp[i-j];
            }
        }
        System.out.println(dp[n]);
    }
}
