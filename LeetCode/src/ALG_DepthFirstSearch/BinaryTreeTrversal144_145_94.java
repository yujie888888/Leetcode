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
import Class_ListTree.TreeNode;

public class BinaryTreeTrversal144_145_94 {
    static List<Integer> res1 = new ArrayList<>();
    static List<Integer> res2 = new ArrayList<>();
    static List<Integer> res3 = new ArrayList<>();
    public static void main(String[] args) {
        //从底向上build tree
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2,n3,null);
        TreeNode n1 = new TreeNode(1,null,n2);

        pre(n1);
        System.out.println(res1);
        mid(n1);
        System.out.println(res2);
        post(n1);
        System.out.println(res3);

    }
    /**Depth First Search - PreOrder Traversal
     * O(logn) 遍历每一个结点，结点数为n Beats 100%
     * O(n + logn) - O(n + n) Beats 85%
     *      n是结果存储空间
     *      logn - n是树的深度，也是递归栈的深度，logn对应平衡二叉树，n对应完全不平衡树
     * 思路：
     * 1.根据 root-left-right 的顺序travers tree
     * 2.分解成子问题就变成 traverse tree -> traverse left-tree + traverse right-tree
     * 3.直到node is null, 到最深处了,end
     * 4.在recursive的过程中只要node不为空，那么就把node.val add List
     */
    public static void pre(TreeNode root){
        if(root == null) return;
        res1.add(root.getVal());
        pre(root.left);
        pre(root.right);
    }
    /** Depth First Search - Inorder Traversal
     */
    public static void mid(TreeNode root){
        if(root == null) return;
        mid(root.left);
        res2.add(root.getVal());
        mid(root.right);
    }
    /** Depth First Search - Inorder Traversal
     */
    public static void post(TreeNode root){
        if(root == null) return;
        post(root.left);
        post(root.right);
        res3.add(root.getVal());
    }
}
