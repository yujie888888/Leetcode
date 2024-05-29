/**
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
 * Example 1:
 * Input: root = [3,2,3,null,3,null,1]
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * Input: root = [3,4,5,1,3,null,1]
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * 0 <= Node.val <= 104
 */
package ALG_DynamicProgramming;
import Class_ListTree.TreeNode;

public class HouseRobberIII337 {
    public static void main(String[] args) {
        // Example 1 输出应该为 7
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(1);

        // Example 2 输出应该为 9
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);

        int res[] = robHelper(root1);
        System.out.println(Math.max(res[0], res[1]));
    }
    /**DP+TreeTraversal
     * O(n) Beats 100%
     * O(2n) Beats 50%
     * 思路:
     * 太懵逼了，看着答案写的
     * 树形dp的入门题目
     * 1.dp含义:
     *   node[0]: 不选择当前node所能抢的max money
     *   node[1]: 选择当前node所能抢的max money
     * 2.状态转移:
     *   from bottom to top: 后续遍历; 并将每个节点的max money存下来
     *   在递归的过程中，系统栈会保存每一层递归的参数
     * 3.初始化: if(node == null) return new int[2];
     * 4.遍历顺序
     *   使用后序遍历，因为要通过递归函数的返回值来做下一步计算
     *     通过递归左节点，得到左节点偷与不偷的金钱
     *     通过递归右节点，得到右节点偷与不偷的金钱
     * 5.单层递归逻辑
     *   如果是偷当前节点，那么左右孩子就不能偷 node.getVal()+left[0]+right[0];
     *   如果不偷当前节点，那么左右孩子就可以偷也可以不偷，选一个最大的 res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
     */
    public static int[] robHelper(TreeNode node){
        if(node == null) return new int[2];

        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);

        int[] res = new int[2];
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        res[1] = node.getVal()+left[0]+right[0];

        return res;
    }
}
