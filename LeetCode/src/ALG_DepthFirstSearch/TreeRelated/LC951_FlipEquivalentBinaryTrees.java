package ALG_DepthFirstSearch.TreeRelated;

import Class_ListTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC951_FlipEquivalentBinaryTrees {
    public static void main(String[] args) {

    }

    /**DFS
     * O(N1+N2)
     * O(N1+N2)
     * Ideas:
     * 需要 1.检查value 2.检查结构
     * 用一个dfs遍历两棵树，在遍历的时候检查left和right的值，按照统一的order放入树
     * 这样检查list1和list2是否相等就可以
     * 在dfs中检查完每一层add一个null，这样就完成了检查结构
     */
    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }
    public static void dfs(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.getVal());

        int left = root.left == null ? -1 : root.left.getVal();
        int right = root.right == null ? -1 : root.right.getVal();

        if(left < right){
            dfs(root.left, list);
            dfs(root.right, list);
        }
        else{
            dfs(root.right, list);
            dfs(root.left, list);
        }
        list.add(null);
    }
}
