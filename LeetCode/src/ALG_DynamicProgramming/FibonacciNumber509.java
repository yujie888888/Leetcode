/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 * Example 1:
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 * Constraints:
 * 0 <= n <= 30
 */
package ALG_DynamicProgramming;
public class FibonacciNumber509 {
    public static void main(String[] args) {
        System.out.println(fib(40));
    }
    /** DP(一维数组)
     * O(n) Beats 100%
     * O(n) Beats 85%
     * 非常非常简单的DP
     * 思路：
     * 1.F[n]
     * 2.F[n] = F[n-1] + F[n-2];
     * 3.F[0] = 0; F[1] = 1;
     * 注意事项：
     * 1.注意base case，如果n==0，那么F[1]赋值的时候会超出界限，所以提前base case
     */
    public static int fib(int n) {
        //base case
        if(n == 0) return 0;
        int[] F = new int[n+1];
        F[0] = 0;
        F[1] = 1;
        for(int i=2; i<=n; i++){
            F[i] = F[i-1] + F[i-2];
        }
        return F[n];
    }
}
