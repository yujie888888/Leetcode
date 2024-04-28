package Struc_tree;

import java.util.ArrayList;
import java.util.List;
//平衡二叉树O(log n)，高度不平衡的树O(n)
//因为递归的时间复杂度是：递归深度*每次递归调用的时间复杂度
public class PreorderTraversal144_145_94 {
    public static void main(String[] args) {
        //preorderTraversal();
        //postorderTraversal();
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        tree1(root,res);
        return res;
    }
    public void tree1(TreeNode root,List<Integer> res){
        if(root == null) return;
        res.add(root.val);
        tree1(root.left,res);
        tree1(root.right,res);
    }

    //postorder
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        tree2(root, res);
        return res;
    }
    public void tree2(TreeNode root, List<Integer> res){
        if(root == null) return;
        tree2(root.left,res);
        tree2(root.right,res);
        res.add(root.val);
    }

    //inorder
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res  = new ArrayList<>();
        tree3(root,res);
        return res;
    }
    public void tree3(TreeNode root, List<Integer> res){
        if(root == null) return;
        tree3(root.left,res);
        res.add(root.val);
        tree3(root.right,res);
    }
}
