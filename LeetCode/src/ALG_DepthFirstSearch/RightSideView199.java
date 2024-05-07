/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 * Input: root = []
 * Output: []
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
/**
 *
 */
package ALG_DepthFirstSearch;
import Class_ListTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView199 {
    public static void main(String[] args) {

    }

    /**recursive method
     * Beats 100%
     */
    public List<Integer> recursiveRightSideView(TreeNode root) {
        //终止条件，node==null;
        //递归逻辑，一层加一个
        List<Integer> res = new ArrayList<>();
        findRightest(root,res,0);
        return res;
    }
    public void findRightest(TreeNode node, List<Integer> res, int deep){
        if(node == null) return;
        if(res.size() == deep){
            res.add(node.getVal());
        }
        //deep+1要写在递归方法中，虽然我目前还不理解为什么
        findRightest(node.right,res,deep+1);
        findRightest(node.left,res,deep+1);
    }

    /**levelOrder做法也能做
     * O(mlogn) Beats 70%
     */
    public List<Integer> levelOrderRightSideView(TreeNode root) {
        //levelOrder method
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        int levelSize;
        while(!queue.isEmpty()){
            levelSize = queue.size();
            count = 0;
            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                if(count == 0){
                    res.add(node.getVal());
                    count ++;
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
            }
        }
        return res;
    }
}
