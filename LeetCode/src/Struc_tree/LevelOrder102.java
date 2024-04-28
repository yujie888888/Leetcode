package Struc_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class LevelOrder102 {
    public static void main(String[] args) {

    }
    //iterative method
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        //dont forget this
        queue.offer(root);
        TreeNode node;
        int sizeLevel;
        while(!queue.isEmpty()){
            List<Integer> resLevel = new ArrayList<>();
            //must store queue.size here
            sizeLevel = queue.size();
            for(int i=0; i<sizeLevel; i++){
                node = queue.poll();
                resLevel.add(node.val);
                //here the queue.size will change
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(resLevel);
        }
        return res;
    }
}
