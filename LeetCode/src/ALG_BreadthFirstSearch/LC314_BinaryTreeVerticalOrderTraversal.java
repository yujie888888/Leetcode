package ALG_BreadthFirstSearch;
import Class_ListTree.TreeNode;

import java.util.*;

public class LC314_BinaryTreeVerticalOrderTraversal {
    /**DFS
     * O(logn) Beats 97%
     * O(n+n) n is node number, 2nd n is key-value number of hahsmap Beats 93%
     * 引入偏移量作为标记，偏移量是以root为中心，偏移量对应resL
     * 得先确定maxLeft才能确定resL是res中的哪一列，不然偏移量会小于0，这时也没法运行res.get(index)
     * 递归1，递归确定最左的偏移量
     * 对每个节点进行遍历，更新结点的偏移量，根据偏移量放入对应的resL
     * 1.结束条件：root == null
     * 2.递归逻辑：往左走，index-1；往右走，index+1;  dfs(root.left) root dfs(root.right);
     * 3.参数：return farLeft; root,index,farLeft
     * 递归2，存储结果
     * 1.结束条件：root == null
     * 2.递归逻辑：往左走，index-1；往右走，index+1;  dfs(root.left) root dfs(root.right);
     * 3.参数：root,index,res,resL
     * 注意事项：
     * 1.要保证垂直从上到下访问，得到的结果resL必须按照node的deep重新排序,重写sort方法
     * 2.node.val不是唯一的，所以设置hashmap的时候要用treenode而不是node.val
     * 3.因为我一开始定义res的时候没有规定它包含多少个list，可以用index来逐个加入(很巧妙)
     * 4.可以将两个递归合并成一个，但我懒的改了，有空再说
     * 5.其实不求farleft也能做，但是我做了发现时间复杂度很高，所以目前来说还是这个方法最快
     */
    static List<List<TreeNode>> res = new ArrayList<>();
    static HashMap<TreeNode,Integer> hashmap = new HashMap<>();
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

        res.clear();
        int farLeft = findmaxLeft(n1,0,0);
        //System.out.println(farLeft);
        addValue(n1,0,0,farLeft);
        for(List<TreeNode> resL : res){
            //resL.sort 直接在 resL 这个 List 对象上调用 sort 方法
            //resL.sort((key1, key2) -> Integer.compare(hashmap.getOrDefault(key1, -1), hashmap.getOrDefault(key2, -1)));
            //使用 Comparator.comparingInt简化;创建了一个比较器，它按照每个 key 在 hashmap 中对应的整数值（或默认值 -1）进行排序。
            resL.sort(Comparator.comparingInt(key -> hashmap.getOrDefault(key, -1)));
        }
        List<List<Integer>> result = new ArrayList<>(res.size());
        for(List<TreeNode> resL : res){
            List<Integer> resLL = new ArrayList<>(resL.size());
            for( TreeNode node : resL){
                resLL.add(node.getVal());
            }
            result.add(resLL);
        }
        for(List<Integer> resLL : result){
            for(int num : resLL){
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }
    public static int findmaxLeft(TreeNode root, int index, int farLeft){
        if(root == null) return farLeft;

        farLeft = Math.min(index,farLeft);
        int farLeft1 = findmaxLeft(root.left, index-1, farLeft);
        int farLeft2 = findmaxLeft(root.right, index+1, farLeft);
        return Math.min(farLeft1,farLeft2);
    }
    public static void addValue(TreeNode root, int index, int deep, int farLeft){
        if(root == null) return;

        hashmap.put(root, deep);
        while(index-farLeft >= res.size()){
            List<TreeNode> resL = new ArrayList<>();
            res.add(resL);
        }
        res.get(index-farLeft).add(root);
        addValue(root.left, index-1, deep+1, farLeft);
        addValue(root.right, index+1, deep+1, farLeft);
    }
}
