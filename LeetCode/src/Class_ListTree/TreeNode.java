package Class_ListTree;

public class TreeNode {
    private int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public int getVal(){
        return this.val;
    }
    public void setVal(int val){
        this.val = val;
    }
}
