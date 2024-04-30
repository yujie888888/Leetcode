/**
 * You are given two binary trees root1 and root2.
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 * Return the merged tree.
 * Note: The merging process must start from the root nodes of both trees.
 * Example 1:
 * Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * Output: [3,4,5,5,4,null,7]
 * Example 2:
 * Input: root1 = [1], root2 = [1,2]
 * Output: [2,2]
 * Constraints:
 * The number of nodes in both trees is in the range [0, 2000].
 * -104 <= Node.val <= 104
 */
package ALG_DepthFirstSearch;
import List_Tree.TreeNode;
public class MergeTwoBinaryTrees617 {
    public static void main(String[] args) {
        TreeNode n14 = new TreeNode(5);
        TreeNode n13 = new TreeNode(2);
        TreeNode n12 = new TreeNode(3,n14,null);
        TreeNode n11 = new TreeNode(1,n12,n13);

        TreeNode n25 = new TreeNode(7);
        TreeNode n24 = new TreeNode(4);
        TreeNode n23 = new TreeNode(3,null,n25);
        TreeNode n22 = new TreeNode(1,null,n24);
        TreeNode n21 = new TreeNode(2,n22,n23);

        System.out.println(mergeTrees(n11, n21).getVal());
    }

    /**DFS
     * O(logn) Beats 100%
     * O(n)
     * 思路：
     * 合并就是将每个结点的值都要遍历一遍，而且遍历的对象是两个树一起
     * 1.想到遍历，就用DFS，先root，再left，再right
     * 2.内部就是每个节点要进行的处理，这里用改变root1的值来存放结果
     * 3.我做到这为止，浅浅总结一下
     *   1.确定递归逻辑
     *   2.确定递归return type
     *   3.确定end处理操作
     *   4.确定子问题处理步骤
     *   5.对左右子树进行递归
     */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        root1.setVal(root1.getVal() + root2.getVal());
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }
}
