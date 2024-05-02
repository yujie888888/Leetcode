/**
 * Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Example 2:
 * Input: root = [3,9,8,4,0,1,7]
 * Output: [[4],[9],[3,0,1],[8],[7]]
 * Example 3:
 * Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
 * Output: [[4],[9,5],[3,0,1],[8,2],[7]]
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
package ALG_DepthFirstSearch;
import List_Tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeVerticalOrderTraversal314 {
    public static void main(String[] args) {
        TreeNode n9 = new TreeNode(4);
        TreeNode n8 = new TreeNode(7);
        TreeNode n7 = new TreeNode(8);
        TreeNode n6 = new TreeNode(0);
        TreeNode n5 = new TreeNode(2,n8,n9);
        TreeNode n4 = new TreeNode(6);
        TreeNode n3 = new TreeNode(1,n6,n7);
        TreeNode n2 = new TreeNode(5,n4,n5);
        TreeNode n1 = new TreeNode(3,n2,n3);

    }
    /**BFS做法
     *
     */

    /**DFS思想
     * 硬做，但是最后就差一个问题就完美了，但是还是无法保证访问的垂直顺序😭
     * 从root开始，一直往left的方向搜，直到left为空，设置最后一个非空位置为第一列
     * 这里想到引入偏移量作为标记，偏移量是以root为中心，偏移量对应resL
     * 对每个节点进行遍历，更新结点的偏移量，根据偏移量放入对应的resL
     * 得先确定maxLeft才能确定resL是res中的哪一列
     * 要用两个递归，一个递归确定最左的偏移量；一个递归用来存储结果；
     * 第一个递归：
     * 1.结束条件：root == null
     * 2.递归逻辑：往左走，index-1；往右走，index+1;  dfs(root.left) root dfs(root.right);
     * 3.参数：return farLeft; root,index,farLeft
     * 第二个递归：
     * 1.结束条件：root == null
     * 2.递归逻辑：往左走，index-1；往右走，index+1;  dfs(root.left) root dfs(root.right);
     * 3.参数：root,index,res,resL
     */
    static List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        res.clear();
        int farLeft = findmaxLeft(root,0,0);
        addValue(root,0,farLeft);
        return res;
    }
    //find Farrest Left index
    public static int findmaxLeft(TreeNode root, int index, int farLeft){
        if(root == null) return farLeft;

        farLeft = Math.min(index,farLeft);
        int farLeft1 = findmaxLeft(root.left, index-1, farLeft);
        int farLeft2 = findmaxLeft(root.right, index+1, farLeft);
        return Math.min(farLeft1,farLeft2);
    }
    public static void addValue(TreeNode root, int index,int farLeft){
        if(root == null) return;

        while(index-farLeft >= res.size()){
            List<Integer> resL = new ArrayList<>();
            res.add(resL);
        }
        res.get(index-farLeft).add(root.getVal());
        addValue(root.left, index-1, farLeft);
        //这里不需要对index回溯。递归的性质确定了index在不同的level之间是不能传递值的，所以对于root来说。root.left和root.right
        addValue(root.right, index+1, farLeft);
    }
}
