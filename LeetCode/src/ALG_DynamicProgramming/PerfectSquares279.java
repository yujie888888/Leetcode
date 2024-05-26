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
public class PerfectSquares279 {
    public static void main(String[] args) {
        System.out.println(numSquares1(13));
    }
    /**DP1
     * O(n*sqrt(n)) Beats 50%
     * O(n) Beats 95%
     * 思路:
     * 背包问题的变题
     * 1.dp[i]: 当sum为i时最少的perfect square数
     * 2.dp[x] = 1; x from 1 to n, 表示最坏的情况下，所有数都是1的平方和
     * 3.递推公式比较复杂
     *   因为dp[平方根]=1，所以一个数n尽可能包含dp[平方根]的时候sum是最小的
     *   从一个数i的最大的平方根开始，如果包含这个平方根，那么dp[i] = dp[i-j*j]+dp[j*j]; 但是我们没有初始化平方根的dp值，所以这里dp[j*j]直接用1代替即可
     *   然后从平方根逐渐减小到1
     */
    public static int numSquares1(int n) {
        int[] dp = new int[n+1];
        for(int i=0; i<=n; i++){
            dp[i] = i;
        }
        for(int i=1; i<=n; i++){
            int sqrt = (int)Math.sqrt(i);
            for(int j=sqrt; j>0; j--){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
    /**DP2
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
