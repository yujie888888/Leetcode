package ALG_BreadthFirstSearch;
import Class_ListTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC515_FindLargestValueinEachTreeRow {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2147483648);
        root.right = new TreeNode(2147483647);
        System.out.println(largestValues1(root));

    }
    /** BFS
     * O(n) n is the number of nodes
     * O(n) 就是树的深度，因为res根据层数存的数据，对平衡二叉树是O(logn),对二叉树最差是O(n)
     * Ideas:
     * Level Order Traverse the Tree
     */
    public static List<Integer> largestValues1(TreeNode root) {
        //LevelOrder Traversal Practice
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize;
        int max;
        while(!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            levelSize = queue.size();
            max = Integer.MIN_VALUE;
            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                max = max > node.getVal() ? max : node.getVal();
                levelList.add(max);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(max);
        }
        return res;
    }
}



