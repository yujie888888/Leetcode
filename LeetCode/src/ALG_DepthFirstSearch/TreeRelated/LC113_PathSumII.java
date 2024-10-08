package ALG_DepthFirstSearch.TreeRelated;

import Class_ListTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC113_PathSumII {
    public static void main(String[] args) {


    }
    /**DFS
     * O(N)
     * O(N)
     * Ideas:
     * 和112一样
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res.clear();
        dfs(root, targetSum, 0, new ArrayList<>());
        return res;
    }
    static List<List<Integer>> res = new ArrayList<>();
    public static void dfs(TreeNode root, int target, int sum, List<Integer> resL){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(sum + root.getVal() == target){
                resL.add(root.getVal());
                res.add(new ArrayList<>(resL));
                resL.remove(resL.size()-1);
                // 这里要移除，就像一般的回溯一样，原理是一样的，如果不恢复原样，会影响上一层；
                // 因为res是通过引用传递给所有递归调用
            }
            return;
        }

        resL.add(root.getVal());
        dfs(root.left, target, sum + root.getVal(), resL);
        dfs(root.right, target, sum + root.getVal(), resL);
        resL.remove(resL.size()-1);
    }
}
