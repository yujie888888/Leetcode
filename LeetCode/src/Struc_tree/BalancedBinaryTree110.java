package Struc_tree;

public class BalancedBinaryTree110 {
    public static void main(String[] args) {

    }

    //依旧是递归法
    //求的是高度
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(height(root) == -1) return false;
        else return true;
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
