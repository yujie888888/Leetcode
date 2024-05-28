/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 * Constraints:
 * 1 <= n <= 104
 */
package ALG_DynamicProgramming;
import java.util.Arrays;

public class PerfectSquares279 {
    public static void main(String[] args) {
        System.out.println(numSquares1(9999));
    }
    /**(推荐)DP(一维数组)
     * O(n*sqrt(n)) Beats 80%
     * O(n) Beats 95%
     * 思路:
     * 完全背包问题的变题
     * 关键在于找到nums[]物品列表
     * 其实就是在背包容量为n时，从nums[]中选择使得和为n的最小的物品数
     * 而nums[]其实就是从1->根号(n)的数的平方，就是perfect square数的集合
     * 1.dp[i]: 当sum为i时最少需要的perfect square数
     * 2.dp[j] = Math.min(dp[j],dp[j-nums[i]]+1);
     * 3.dp[0] = 0;
     */
    public static int numSquares1(int n) {
        int max = (int)Math.sqrt(n);
        int[] nums = new int[max+1];
        for(int i=1; i<=max; i++){
            nums[i] = i*i;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0] = 0;
        for(int i=0; i<=max; i++){
            for(int j=nums[i]; j<=n; j++){
                dp[j] = Math.min(dp[j],dp[j-nums[i]]+1);
            }
        }
        return dp[n];
    }
    /**DP(二维数组)
     * O(n^2) Beats 5%
     * O(n) Beats 95%
     * 思路:
     * 1.dp[i]: 当sum为i时最少的perfect square数
     * 2.dp[x] = 1; 其中x是小于sqrt(n)的整数，举个例子也就是把n=13 13.sqrt=3 1->3的dp命名为1
     * 3.dp[i] = Math.min(dp[i],dp[j]+dp[i-j])
     *   把i分成两部分，一部分是从1开始，一部分是从i-1开始
     *   比如dp[6] = min(dp[6],dp[1]+dp[5]) 直到j==i
     *   确保一定能获得最小值
     */
    public static int numSquares2(int n) {
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            dp[i] = (int)Math.pow(10,4)-1;
        }
        int sqrt = (int)Math.sqrt(n);
        for(int i=1; i<=sqrt; i++){
            dp[i*i] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<i; j++){
                dp[i] = Math.min(dp[i],dp[j]+dp[i-j]);
            }
        }
        return dp[n];
    }
}
