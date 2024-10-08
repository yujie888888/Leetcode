package ALG_DepthFirstSearch.TreeRelated;
import Class_ListTree.TreeNode;

public class LC112_PathSum {
    public static void main(String[] args) {

    }
    /**DFS
     * O(N) N is the number of TreeNode
     * O(N)
     * 简化版
     */
    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }
    public static boolean dfs(TreeNode root, int target, int sum){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(sum + root.getVal() == target){
                return true;
            }
        }

        return dfs(root.left, target, sum + root.getVal()) || dfs(root.right, target, sum + root.getVal());
    }

    /**DFS
     * 这个写法更简洁，但不好理解
     * 隐式递归
     */
    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        // 如果根节点为空，直接返回 false
        if (root == null) {
            return false;
        }

        // 更新 targetSum，减去当前节点的值
        targetSum -= root.getVal();

        // 如果当前节点是叶子节点，检查更新后的 targetSum 是否为 0
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        // 递归检查左子树和右子树是否存在满足条件的路径
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    /**DFS
     * O(N)，其中 N 是树中节点的总数
     * 空间复杂度为 O(H)，其中 H 是树的高度, the recursion stask space
     * Ideas:
     * tree的dfs还挺复杂
     * 首先题目要求是的是从root到leaf的sum
     * base case: root == null  and  root is the only node of the Tree
     * dfs{
     *  if(root == null) return false; //不要null，要的是leaf
     *  return condition should consider the node is a leaf or not
     *
     *  dfs(node.left)
     *  dfs(node.right)
     * }
     * Pay Attention:
     *  1.sum的变化
     *  2.遇到true直接一串到顶返回
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(targetSum == root.getVal()) return true;
            else return false;
        }
        return bk(root, targetSum, 0);
    }

    public static boolean bk(TreeNode root, int targetSum, int sum) {
        if(root == null) return false;
        // is a leaf?
        if(root.left == null && root.right == null){
            if(sum+root.getVal() == targetSum){
                return true;
            }
            return false;
        }

        boolean res1 = bk(root.left, targetSum, sum+root.getVal());
        if(res1) return true;
        boolean res2 = bk(root.right, targetSum, sum+root.getVal());
        if(res2) return true;

        return false;
    }
}
