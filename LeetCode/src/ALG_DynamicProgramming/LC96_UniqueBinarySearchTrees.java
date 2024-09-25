package ALG_DynamicProgramming;
public class LC96_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
    /** DP
     * O(n^2)
     * O(n)
     * Ideas:
     * BST的特征是在root右边的肯定比root大，在root左边的肯定比root小
     * 依次以从1到n作为root，然后看能构成多少个不同的bst；
     * 比如以3为root，n为6，那么可以得出当3为root的时候bst的个数可以是 dp[2] * dp[3]
     *      因为在3左边(较小的)个数有2个，在3右边(较大)的个数有3个，它们分别可以形成的bst的乘积就是3为root的时候bst的个数
     * 在写代码的时候其实我们不需要单独指出当前的root是什么，只需要forloop去遍历所有的可能性相加即可
     * Steps:
     * 1.dp[i]:节点为i时的unique bst的数量
     * 2.dp[i] = dp[i-1]*dp[0] + dp[i-2]*dp[1] + ... + dp[0]*dp[i-1]
     *      这个部分的关键点在于"BST的每个子树也是一个二叉搜索树"
     *      也就是根据j，将i分成三个部分：1.root 2.left 3.right
     *      left有j个node，right有i-j-1个node，然后将left*right就是当前j的分类下，有多少种bst的情况
     *      依次累加，就是最后的值
     *      举个例子：
     *          dp[3]，就是元素1为头结点搜索树的数量 + 元素2为头结点搜索树的数量 + 元素3为头结点搜索树的数量
     *          元素1为头结点搜索树的数量 = 右子树有2个元素的搜索树数量 * 左子树有0个元素的搜索树数量
     *          元素2为头结点搜索树的数量 = 右子树有1个元素的搜索树数量 * 左子树有1个元素的搜索树数量
     *          元素3为头结点搜索树的数量 = 右子树有0个元素的搜索树数量 * 左子树有2个元素的搜索树数量
     *          有2个元素的搜索树数量就是dp[2]
     *          有1个元素的搜索树数量就是dp[1]
     *          有0个元素的搜索树数量就是dp[0]
     *          所以dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
     */
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
}
