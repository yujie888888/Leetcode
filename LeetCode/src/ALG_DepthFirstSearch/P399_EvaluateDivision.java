/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 * Example 1:
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * note: x is undefined => -1.0
 * Example 2:
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 * Constraints:
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
package ALG_DepthFirstSearch;
import java.util.*;

public class P399_EvaluateDivision {
    /**DFS+Hash
     * O(Q(V+E)) Q: number of queries V: number of node  E:number of edge
     * Ideas:
     * 非典型DFS
     * 找可达关系,用DFS直到找到目标
     * 1.构建Node Class，方便后续找关系，Node表示两个点之间的运算结果
     * 2.根据Node Class构建List<Node>数据集,因为start，end这两个点和value是分开的，用list和在一起
     * 3.用HashMap构建关系图/可达图(双向图)
     * 4.用DFS深度搜索，搜target(但是怎么回溯找别的点)
     *      1.用visited hashset标记已经走过的点，防止进入无限循环
     * 5.构建res[]
     * 注意事项：
     * 1.List<List<String>> 不能直接{{}}这样赋值，要用Arrays.asList();
     */
    public static  class Node{
        String start;
        String end;
        double val;
        public Node(String start, String end, double val){
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );
        double[] values = {2.0,3.0};
        List<Node> list = new ArrayList<>();
        //1.构建List<Node>
        for(int i=0; i<equations.size(); i++){
            list.add(new Node(equations.get(i).get(0), equations.get(i).get(1), values[i]));
        }
        //2.构建图
        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for(Node node : list){
            if(!map.containsKey(node.start)) map.put(node.start, new HashMap<String,Double>());
            map.get(node.start).put(node.end,node.val);
            if(!map.containsKey(node.end)) map.put(node.end, new HashMap<String,Double>());
            map.get(node.end).put(node.start,1/node.val);
        }
        //4.构建结果
        double[] res = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if(!map.containsKey(start) || !map.containsKey(end)){
                res[i] = -1.0;
                continue;
            }
            if(start == end){
                res[i] = 1.0;
                continue;
            }
            res[i] = dfs(start, end, map, new HashSet<String>(), 1.0);
        }
        System.out.println(Arrays.toString(res));
    }
    //3.DFS构建路径
    /**
     * 每次输入一个查询对，拿到查询对后，首先在main里已经判断过了相同char和不存在char的situation
     * 这里进来后先把当前node(start)加入visited
     * ret一开始设置为-1
     * 构建map的时候是Map<String, Map>这种格式的
     * 所以直接看map是不是包含end这个点，也就是是不是直接相连的，如果是的就直接返回ret值就可以
     * 如果不是直接相连的就要用dfs找target
     * 直接把累计结果传入下一层，然后当前层的next变成下一层的start(cur),这样一层一层
     * dfs里返回的是ret，因为对ret进行的操作，然后每一层ret返回上一层之后，再由ret这个参数接住
     * 如果ret==-1也就是没找到，没找到就继续下一个node(横向遍历)
     * 如果找到!=-1的值，就可以break循环了，也就是说找到了结果
     */
    public static double dfs(String start, String end, HashMap<String, HashMap<String, Double>> map, HashSet<String> visited, double val){
        visited.add(start);
        double ret = -1;
        if(map.get(start).containsKey(end)){
            ret = val*map.get(start).get(end);
        }
        else{
            for(String next : map.get(start).keySet()){
                if(visited.contains(next)) continue;
                else{
                    ret = dfs(next,end,map,visited,val*map.get(start).get(next));
                    if(ret == -1.0) continue;
                    else break;
                }
            }
        }
        return ret;
    }
}
