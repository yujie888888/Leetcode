/**这道题是P70爬楼梯的进阶题,LC上没有原题
 * 假设你正在爬楼梯，需要n阶你才能到达楼顶。
 * 每次你可以爬至多m (1 <= m < n)个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 输入 n=3 m=2 输出 3
 * 输入 n=8,m=6，输出 61
 * 提示：
 * 当 m = 2，n = 3 时，n = 3 这表示一共有三个台阶，m = 2 代表你每次可以爬一个台阶或者两个台阶。
 * 此时你有三种方法可以爬到楼顶。
 * 1 阶 + 1 阶 + 1 阶段
 * 1 阶 + 2 阶
 * 2 阶 + 1 阶
 */
package ALG_DynamicProgramming;

public class LC70_ClimbingStairsII {
    /**DP(一维数组)
     * O(m*n)
     * O(n)
     * Idea:
     * 这道题不要定义dp[0]=0，因为你不知道到了第i层的时候是不是可以直接从第0层爬上来
     * 对于I是因为只有两种爬法，所以初始化dp[1]和dp[2]直接把dp[0]的作用消除掉
     * 1.dp[i]: 爬到第i阶楼梯有多少种方法
     * 2.dp[i] = dp[i-1]+dp[i-2]+...+dp[i-m] //每阶楼梯有m种可能的情况
     */
    public static void main(String[] args) {
        int n = 8;
        int m = 6;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m && j<=i; j++){
                dp[i] += dp[i-j];
            }
        }
        System.out.println(dp[n]);
    }
}
