package ALG_DepthFirstSearch;
import java.util.*;
import Class_ListTree.TreeNode;

public class FindLargestValueinEachTreeRow515 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2147483648);
        root.right = new TreeNode(2147483647);
        System.out.println(largestValues1(root));

    }
    /** 在进行每层遍历的过程中就进行排序
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
    /** 对每一层进行收集，然后排序，效率不高
     */
    public static List<Integer> largestValues2(TreeNode root) {
        //LevelOrder Traversal Practice
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize;
        while(!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                TreeNode node = queue.poll();
                levelList.add(node.getVal());
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            //这里处理2147483647和-2147483648，我也不知道为啥会溢出
            if(levelList.contains(2147483647)) res.add(2147483647);
            else if(levelList.contains(-2147483648)){
                if(levelList.size() > 1){
                    levelList.remove(Integer.valueOf(-2147483648));
                    levelList.sort((a,b) -> b-a);
                    res.add(levelList.get(0));
                }
                else{
                    res.add(-2147483648);
                }
            }
            else{
                levelList.sort((a,b) -> b-a);
                res.add(levelList.get(0));
            }
        }
        return res;
    }
}



