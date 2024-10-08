package ALG_DepthFirstSearch.TreeRelated;
import Class_ListTree.TreeNode;

public class LC110_BalancedBinaryTree {
    public static void main(String[] args) {

    }

    /**DFS
     * O(N)
     * O(N)
     * Ideas:
     * 递归求左右子树的高度
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) == -1 ? false : true;
    }
    public int height(TreeNode node){
        if(node == null) return 0;

        int leftH = height(node.left);
        int rightH = height(node.right);

        if(leftH == -1 || rightH == -1) return -1;
        if(Math.abs(leftH-rightH) > 1) return -1;

        return Math.max(leftH, rightH)+1;
    }
}
