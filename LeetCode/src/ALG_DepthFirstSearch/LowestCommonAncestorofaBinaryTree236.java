/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
 * two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a
 * node to be a descendant of itself).”
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 * Input: root = [1,2], p = 1, q = 2
 * Output: 1
 * Constraints:
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the tree.
 */
package ALG_DepthFirstSearch;

import List_Tree.TreeNode;

/**DFS
 * O()
 * O()
 * 思路：
 * https://programmercarl.com/0236.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.html#%E6%80%9D%E8%B7%AF
 * 看上面的解析的图解更容易理解
 * 这道题真的不简单，要注意的要点太多了
 * 首先想到要遍历这棵树，最好是从底往上，那么只要找到一个公共祖先，这个祖先就是最近公共祖先
 * 要实现从底向上，那么想到二叉树遍历的"左右根"遍历
 * 现在确定了遍历方式，接下来就是想怎么确定一个点是祖先结点
 * 1.要么一个结点的left-tree是p/q，right-tree是p/q
 * 2.要么一个结点的left-tree包含p&q，或者right-tree包含p&q
 * 3.这里还要注意node本身是p或q的情况，但是这种情况可以直接包含在2中
 * 开始递归
 * 1.递归结束条件，只要满足了这些条件，就不用继续往下遍历了
 *   node==null
 *   node==p
 *   node==q
 * 2.递归逻辑：
 *   left = dfs(node.left)
 *   right = dfs(node.right)
 *   以及结束完遍历的比较
 *   if(left !null && right !null) return root; 对应情况1
 *   if(left !null && right null) return left; 对应情况2；前面说情况2包含情况3，就是这个return的值带来的；
 *   if(left null && right !null) return right; 对应情况2
 *   if(left null && right null) return null; 这种情况不会发生，因为肯定存在pq
 * 3.参数：
 *   root,p,q
 *   返回值用TreeNode
 */
public class LowestCommonAncestorofaBinaryTree236 {
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);

        if(leftNode != null && rightNode != null){
            return root;
        }
        else if(leftNode != null){
            return leftNode;
        }
        else if(rightNode != null){
            return rightNode;
        }
        else{
            return null;
        }
    }

}
