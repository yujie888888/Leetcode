package Company_icc;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode() {}
   TreeNode(int val) { this.val = val; }
   TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
   }
}
public class BeaconFire {
   public static void main(String[] args) {

   }
   public boolean isSameTree(TreeNode p, TreeNode q) {
       return dfs(p, q);
   }
   public static boolean dfs(TreeNode node1, TreeNode node2){
       // check structure
       // check node.val
       if((node1 == null && node2 != null) || (node2 == null && node1 != null) || node1.val != node2.val){
           return false;
       }

       boolean left = dfs(node1.left, node2.left);
       boolean right = dfs(node1.right, node2.right);
       if(left == false || right == false){
           return false;
       }

       return true;
   }

}
