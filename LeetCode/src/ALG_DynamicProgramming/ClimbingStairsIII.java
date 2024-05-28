/**
 * 假设你正在爬楼梯。需要n 阶你才能到达楼顶。
 * 每次你可以爬 1 个台阶，2 个台阶，3 个台阶，……，直到m 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * Ex1.
 * n=3
 * 4
 * Ex2.
 * n=4
 * 8
 */
package ALG_DynamicProgramming;
public class ClimbingStairsIII {
    /**DP
     * O(n^2)
     * O(n)
     * 思路：
     * 没什么好说的，比II简单
     */
    public static void main(String[] args) {
        int n = 3;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++) {
                dp[i] += dp[i - j];
            }
        }
        System.out.println(dp[n]);
    }
}
