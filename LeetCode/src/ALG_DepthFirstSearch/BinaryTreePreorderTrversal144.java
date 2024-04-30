/**
 *Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * Example 2:
 * Input: root = []
 * Output: []
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
package ALG_DepthFirstSearch;
import java.util.ArrayList;
import java.util.List;
import List_Tree.TreeNode;

public class BinaryTreePreorderTrversal144 {
    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        //从底向上build tree
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2,n3,null);
        TreeNode n1 = new TreeNode(1,null,n2);

        rec(n1,res);
        System.out.println(res);
    }
    /**Depth First Search(Recursive)
     * O(logn) Beats 100%
     * O(n) Beats 85%
     * 思路：
     * 1.根据 root-left-right 的顺序travers tree
     * 2.分解成子问题就变成 traverse tree -> traverse left-tree + traverse right-tree
     * 3.直到node is null, 到最深处了,end
     * 4.在recursive的过程中只要node不为空，那么就把node.val add List
     */
    public static void rec(TreeNode root, List<Integer> res){
        if(root == null) return;
        res.add(root.getVal());
        rec(root.left,res);
        rec(root.right,res);
    }
}
