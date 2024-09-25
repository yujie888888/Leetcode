/**
 * 假设你正在爬楼梯。需要n 阶你才能到达楼顶。
 * 每次你可以爬 1 个台阶，2 个台阶，3 个台阶，……，直到m 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * Ex1.
 * n=3 output 4
 * Ex2.
 * n=4 output 8
 */
package ALG_DynamicProgramming;
public class LC70_ClimbingStairsIII {
    /**DP
     * O(n^2)
     * O(n)
     * Ideas:
     * 这道题和I的不同之处在于每一层，都可以从第0层爬上来，所以一定只能设置dp[0]=1;
     * 和II是一样的
     */
    public static void main(String[] args) {
        int n = 4;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i] += dp[i-j];
            }
        }
        System.out.println(dp[n]);
    }
}
