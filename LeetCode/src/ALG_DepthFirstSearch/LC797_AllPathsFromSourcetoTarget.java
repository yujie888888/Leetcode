/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1,
 * find all possible paths from node 0 to node n - 1 and return them in any order.
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
 * (i.e., there is a directed edge from node i to node graph[i][j]).
 * Example 1:
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Example 2:
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * Constraints:
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 */
package ALG_DepthFirstSearch;
import java.util.ArrayList;
import java.util.List;

public class LC797_AllPathsFromSourcetoTarget {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> resL = new ArrayList<>();
    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        int[][] graph1 = {{4,3,1},{3,2,4},{},{4},{}};
        res.clear();
        resL.clear();
        resL.add(0);
        dfs(graph, 0);
        System.out.println(res);
    }
    /**DFS
     * O(指数级) Beats 99%
     *      最坏的情况下，除了最后一个结点，每个节点都有n-1(除了结点本身)个选择；除了最后一个结点不指向任何结点; 时间复杂度在(n-1)^(n-1)级别
     * O(n + pk) Beats 80%
     *      n是递归树的深度
     *      p是平均路径数，k是平均路径长度；最坏的情况下p=n,k=n;
     * 思路：
     * 1.很容易想到DFS，从结点0出发，搜到最后一个结点
     * 2.终止条件：当前结点是否已经到达graph的最后一个结点；到达终止条件后，才将resL加入res中
     * 3.递归逻辑：遍历当前graph[node]，将选定的val加入resL，直到到达终止条件；
     * 4.确定参数：这里传node比较合适
     * 注意事项：
     * 1.一开始看这个二维数组的定义可能看不懂，其实就是说graph的第1个结点指向int[]里面的那些结点
     * 2.因为是从结点0出发，但是dfs开始是从结点0的int[]开始的，也就是加的是结点0之后的结点val，所以在最开始的时候就add(0)
     * 3.记得clear res和resL
     */
    public static void dfs(int[][] graph, int node){
        if(node == graph.length - 1){
            res.add(new ArrayList<>(resL));
            return;
        }
        for(int i : graph[node]){
            resL.add(i);
            dfs(graph,i);
            resL.remove(resL.size()-1);
        }
    }
}
