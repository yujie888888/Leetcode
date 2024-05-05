/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
package ALG_DepthFirstSearch;
import Class_ListTree.TreeNode;

public class MaximumDepthofBinaryTree104 {
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(7);
        TreeNode n4 = new TreeNode(15);
        TreeNode n3 = new TreeNode(20,n4,n5);
        TreeNode n2 = new TreeNode(9);
        TreeNode n1 = new TreeNode(3,n2,n3);
        System.out.println(findMax(n1));
    }
    /**DFS
     * O(logn) Beats 100%
     * O(n) 递归的空间复杂度要看调用的递归栈的数量
     *      对于一个完全不平衡的二叉树（例如，每个节点只有一个子节点），树的高度等于节点数n
     *      在这种情况下，递归调用栈的最大深度也是n
     *      平衡二叉树是O(logn)
     * 思路：
     * 1.从左右子树出发，再从左右子树的左右子树出发，这样就将问题分解成了多个小问题
     * 2.return Math.max(maxLeft+1,maxRight+1); 确保每次返回的deep值都是 该节点的左右子树的maxDeep + 当前node的deep(1)
     */
    public static int findMax(TreeNode root){
        if(root == null) return 0;
        int maxLeft = findMax(root.left);
        int maxRight = findMax(root.right);
        return Math.max(maxLeft+1,maxRight+1);
    }
}
