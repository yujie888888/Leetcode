package Struc_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevels637 {
    public static void main(String[] args) {

    }
    public List<Double> averageOfLevels(TreeNode root) {
        //Practice LevelOrder Traversal
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        if(root == null) return res;

        queue.offer(root);
        double levelSize;
        double sum, avg;
        while(!queue.isEmpty()){
            sum = 0;
            levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(sum/levelSize);
        }
        return res;
    }
}
