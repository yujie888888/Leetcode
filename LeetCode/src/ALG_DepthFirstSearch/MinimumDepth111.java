package ALG_DepthFirstSearch;
import Class_ListTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth111 {
    public static void main(String[] args) {

    }
    /**递归法
     * 这道题找的是叶子节点
     */
    public int minDepth1(TreeNode root) {

        int minLen = 0;
        if(root == null) return minLen;
        return findMin(root);
    }
    public int findMin(TreeNode node){
        if(node == null) return 0;

        int minLeft = findMin(node.left);
        int minRight = findMin(node.right);
        //要找的是叶子结点
        if(node.left == null && node.right != null){
            return minRight + 1;
        }
        if(node.right == null && node.left != null){
            return minLeft + 1;
        }
        return Math.min(minLeft+1,minRight+1);
    }
    /**迭代法
     * 逻辑更简单，运行也更快
     */
    public int minDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return 0;
        queue.offer(root);
        int minLen = 1;
        int levelSize;
        while(!queue.isEmpty()){
            levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                //从上到下一层层比遍历，只要出现叶子结点，此时deep就是最小的
                if(node.left == null && node.right == null) return minLen;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            minLen++;
        }
        return minLen;
    }
}
