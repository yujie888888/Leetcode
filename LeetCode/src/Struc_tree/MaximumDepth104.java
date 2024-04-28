package Struc_tree;

public class MaximumDepth104 {
    public static void main(String[] args) {

    }

    /**沉默了我30s，只要把三步
     * 1、确定函数返回参数和传入参数
     * 2、确定返回条件
     * 3、确认单步操作逻辑
     * 就写出来了
     * 做出来我都不相信我自己。。
     */
    public int maxDepth(TreeNode root) {
        int maxLen = 0;
        if(root == null) return maxLen;
        return findMax(root);
    }
    public int findMax(TreeNode node){
        if(node == null) return 0;
        int maxLeft = findMax(node.left);
        int maxRight = findMax(node.right);
        return Math.max(maxLeft+1,maxRight+1);
    }
}
