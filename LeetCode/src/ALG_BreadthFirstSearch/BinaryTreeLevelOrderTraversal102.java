/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 * Input: root = []
 * Output: []
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
package ALG_BreadthFirstSearch;
import Class_ListTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
    static List<List<Integer>> res1 = new ArrayList<>();
    static List<List<Integer>> res2 = new ArrayList<>();
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

        res1.clear();
        levelOrder1(n1);
        System.out.println(res1);

        res2.clear();
        levelOrder2(n1,0);
        System.out.println(res2);
    }
    /**BFS借助队列
     * O(n) n是结点树，对每个结点进行操作(入队+出队) Beats 90%
     * O(kn) queue的储存空间为n res的储存空间为n Beats 50%
     * 思路：
     * 借助队列实现BFS
     * 对于每一层，其实就是，在将当前层的结点放入list的时候，将某一层的左右子结点也放入队列，这样下次遍历队列就是同一层的
     * 这里len非常关键，是区分每一层的flag
     * 1.先把root放进队列
     * 2.如果队列不为空(){ 如果队列为空，说明没有node加入了
     *   记住len
     *   如果队列不为空(within len){
     *      那么依次将内容弹出，
     *      并将其左右结点加入队列
     *      }
     *  }
     */
    public static void levelOrder1(TreeNode root) {
        if(root == null) System.out.println(res1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            List<Integer> resL = new ArrayList<>();
            for(int i=0; i<len; i++){
                TreeNode node = queue.poll();
                resL.add(node.getVal());
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res1.add(resL);
        }
    }
    /**DFS(用deep标记)
     * O(n) 遍历每个结点，对每个结点add操作 Beats 100%
     * O(n+n) Beats 65%
     *   递归栈的深度最差是n，最好是logn
     *   存储空间是n
     * 思路：
     * 用dfs遍历每个结点，用deep标记结点是哪一层
     * 1.终止条件：root == null
     * 2.递归逻辑：遍历所有结点；根据结点的deep值将结点的val add进不同的内list中
     *          需要注意的是，resL的创建和使用，我们是不知道tree有多少层的，所以我们根据每个结点的deep和res.size进行比较
     *          根据比较结果决定是不是创建一个新的内list
     * 3.参数确定：root，deep
     */
    public static void levelOrder2(TreeNode root, int deep) {
        if(root == null) return;

        if(deep >= res2.size()){
            List<Integer> resL = new ArrayList<>();
            res2.add(resL);
        }
        res2.get(deep).add(root.getVal());
        levelOrder2(root.left,deep+1);
        levelOrder2(root.right,deep+1);
    }
}
