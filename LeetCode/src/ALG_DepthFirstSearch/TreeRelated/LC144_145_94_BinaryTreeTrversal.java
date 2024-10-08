package ALG_DepthFirstSearch.TreeRelated;
import Class_ListTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC144_145_94_BinaryTreeTrversal {
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
    /**DFS - PreOrder Traversal
     * O(N) N is node number of Tree
     * O(logN) - O(N)
     *      对于balanced tree，recursion stack space is O(logN); for other tree is O(N)
     * Ideas:
     * 抽象一下，就是先access root，再遍历root.left path, 直到leaf
     * 同理right
     * 这三者顺序不同就是不同的遍历模式s
     */
    public static void pre(TreeNode root){
        if(root == null) return;
        res1.add(root.getVal());
        pre(root.left);
        pre(root.right);
    }

    // In-order Traversal
    public static void mid(TreeNode root){
        if(root == null) return;
        mid(root.left);
        res2.add(root.getVal());
        mid(root.right);
    }

    // Post-order Traversal
    public static void post(TreeNode root){
        if(root == null) return;
        post(root.left);
        post(root.right);
        res3.add(root.getVal());
    }
}
