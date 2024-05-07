package ALG_DepthFirstSearch;
import Class_ListTree.TreeNode;

public class SearchinBST700 {
    public static void main(String[] args) {

    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || val == root.getVal()) return root;
        if(val < root.getVal()) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
}
