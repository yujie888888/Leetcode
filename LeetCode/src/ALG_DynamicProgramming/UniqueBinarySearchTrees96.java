/**
 * Given an integer n, return the number of structurally unique BST's (binary search trees)
 * which has exactly n nodes of unique values from 1 to n.
 * Example 1:
 * Input: n = 3
 * Output: 5
 * Example 2:
 * Input: n = 1
 * Output: 1
 * Constraints:
 * 1 <= n <= 19
 */
package ALG_DynamicProgramming;
public class UniqueBinarySearchTrees96 {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
    /** DP
     * O(n*n) Beats 100%
     * O(n)
     * 思路:
     * 1.dp[i]:节点为i时的unique bst的数量
     * 2.dp[i] = dp[i-1]*dp[0] + dp[i-2]*dp[1] + ... + dp[0]*dp[i-1]
     *      这个部分的关键点在于"BST的每个子树也是一个二叉搜索树"
     *      举个例子：
     *          dp[3]，就是 元素1为头结点搜索树的数量 + 元素2为头结点搜索树的数量 + 元素3为头结点搜索树的数量
     *          元素1为头结点搜索树的数量 = 右子树有2个元素的搜索树数量 * 左子树有0个元素的搜索树数量
     *          元素2为头结点搜索树的数量 = 右子树有1个元素的搜索树数量 * 左子树有1个元素的搜索树数量
     *          元素3为头结点搜索树的数量 = 右子树有0个元素的搜索树数量 * 左子树有2个元素的搜索树数量
     *          有2个元素的搜索树数量就是dp[2]
     *          有1个元素的搜索树数量就是dp[1]
     *          有0个元素的搜索树数量就是dp[0]
     *          所以dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
     * 注意事项：
     * 1.内循环j用来实现累加，由于累加性质，所以初始化时要将除了dp[0]和dp[1]以外的其他未赋值的dp值设置为0
     */
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++) dp[i] = 0;
        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] = dp[i] + dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
}
