package ALG_recursion;

public class FibonacciNumber509 {
    public static void main(String[] args) {

    }

    /** recursive 不建议这么做，重复计算太多，会导致堆栈溢出
     * O(2^n) Beats 10%
     */
    public int fib1(int n) {
        return cal(n);
    }
    public int cal(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return cal(n-1) + cal(n-2);
    }
    /** dynamic programming
     *  O(n) Beats 100%
     *  使用动态规划可以避免递归的重复计算，通过建立一个数组存储已经计算过的斐波那契数，每次计算新的斐波那契数时直接利用数组中的结果
     */
    public int fib2(int n) {
        //dynamic programming
        if(n<2) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
