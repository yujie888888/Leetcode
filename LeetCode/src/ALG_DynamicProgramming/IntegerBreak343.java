/**
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 * Return the maximum product you can get.
 * Example 1:
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * Constraints:
 * 2 <= n <= 58
 */
package ALG_DynamicProgramming;
public class IntegerBreak343 {
    public static void main(String[] args) {
        System.out.println(integerBreak1(10));
        System.out.println(integerBreak2(10));
    }

    /**
     * DP
     * O(n^2) Beats 50%
     * O(n) Beats 50%
     * 思路:
     * 最重要的是能够找出所有的拆分情况，有两种可能的拆分情况
     * 1.dp[i]: 分拆数字i，可以得到的最大乘积为dp[i]
     * 2.状态转移，对于dp[i]:
     * 1.可以是j*(i-j)得到
     * 2.可以是j*dp[i-j]得到
     * 举个例子n=4
     * 对于1.有1*3 2*2 3*1
     * 对于2.有1*dp[3] 2*dp[2] 3*dp[1]
     * 这两种情况就包括了dp[i]所有可能的拆分情况的乘积
     * 因为内循环是遍历j次才找到最大值，所以公式是max(dp[i],j*(i-j),j*dp[i-j])
     * 3.初始化dp[1]=1;
     */
    public static int integerBreak1(int n) {
        //dp[i]: 分拆数字i，可以得到的最大乘积为dp[i]
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int temp = Math.max(j * dp[i - j], j * (i - j));
                dp[i] = Math.max(dp[i], temp);
            }
        }
        return dp[n];
    }
    /**
     * Greedy
     * O(n) Beats 100%
     * O(1)
     * 思路:
     * 需要数学验证，但是这不重要，直接用结论即可
     * 1.贪心选择每次尽量拆分成3，因为拆分成3可以使得乘积最大化
     * 2.根据拆分后的剩余部分进行处理，如果剩下1，需要调整拆分方式
     *      如果剩余部分是0，直接返回结果。
     *      如果剩余部分是1，将一个3换成2和2，保证乘积最大化。
     *      如果剩余部分是2，直接乘以结果
     * Steps:
     * 1.如果 n <= 3，直接返回 n - 1，因为对于 n = 2 和 n = 3，直接拆分成 1 + 1 或 1 + 2，最大乘积分别是1和2。
     * 2.如果 n > 3，不断拆分出3，直到剩余部分小于等于3
     */
    public static int integerBreak2(int n) {
        if(n<=3) return n-1;
        int sum = 1;
        while(n>=3){
            n -= 3;
            sum *= 3;
        }
        if(n==1){
            sum = sum/3 * 4;
        }
        if(n==2)sum *= 2;
        return sum;
    }
}
