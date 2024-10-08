package ALG_BreadthFirstSearch;
import Class_ListTree.TreeNode;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class LC102_BinaryTreeLevelOrderTraversal {
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

        levelOrder(n1);
        System.out.println(levelOrder(n1));
    }
    /**BFS借助队列
     * O(n) n is number of tree node
     * O(n) queue的储存空间为n res的储存空间为n
     * Idea:
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
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while(!queue.isEmpty()){
            res.add(new ArrayList<>());
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                res.get(res.size()-1).add(node.getVal());
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return res;
    }
    /**DFS
     * O(n)
     * O(n+n)
     *   递归栈的深度最差是n，最好是logn
     *   存储空间是n
     * Ideas:
     * 用deep标记所在层数，也行，但不如queue直观
     * 用dfs遍历每个结点，用deep标记结点是哪一层
     * 1.终止条件：root == null
     * 2.递归逻辑：遍历所有结点；根据结点的deep值将结点的val add进不同的内list中
     *          需要注意的是，resL的创建和使用，我们是不知道tree有多少层的，所以我们根据每个结点的deep和res.size进行比较
     *          根据比较结果决定是不是创建一个新的内list
     * 3.参数确定：root，deep
     */
//    public static void levelOrder2(TreeNode root, int deep) {
//        if(root == null) return;
//
//        if(deep >= res2.size()){
//            List<Integer> resL = new ArrayList<>();
//            res2.add(resL);
//        }
//        res2.get(deep).add(root.getVal());
//        levelOrder2(root.left,deep+1);
//        levelOrder2(root.right,deep+1);
//    }
}
