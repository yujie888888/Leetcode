/**
 * Given an undirected graph graph that is represented by its adjacency matrix, return whether or not
 * is it possible to add no more than two edges to this graph in order to make all the degrees of nodes even.
 * Keep in mind that in the resulting graph there should be at most one edge between any pair of nodes.
 * graph：一个整数矩阵，表示图的邻接矩阵。graph[i][j] 为 1 表示节点 i 和节点 j 之间有一条边，为 0 则表示没有边。
 * Ex1:
 * graph = [
 *     [0, 1, 0, 1],
 *     [1, 0, 1, 0],
 *     [0, 1, 0, 0],
 *     [1, 0, 0, 0]
 * ]
 * True
 * Ex2:
 * graph = [
 *     [1, 1, 1],
 *     [1, 1, 1],
 *     [1, 1, 1]
 * ]
 * False
 */
package Company_Uber;
import kotlin.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P2_LC2308_AddEdges {
    public static void main(String[] args) {
        //见Leetcode 2308
        int n = 4;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(3,4),
                Arrays.asList(1,4)
        );
        System.out.println(isPossible(n,edges));
    }
    public static boolean isPossible(int n, List<List<Integer>> edges) {
        //内存超出限制，用hashset来寸边
        HashSet<Pair<Integer,Integer>> set = new HashSet<>();
        int[] degree = new int[n];
        for(List<Integer> edge : edges){
            set.add(new Pair(edge.get(0)-1, edge.get(1)-1));
            set.add(new Pair(edge.get(1)-1, edge.get(0)-1));
            //存每个node的degree
            degree[edge.get(0)-1]++;
            degree[edge.get(1)-1]++;
        }
        //把odd node整理出来
        List<Integer> nodes = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(degree[i] %2 != 0){
                nodes.add(i);
            }
        }
        //遍历完之后，检查nodes的数量，如果为0，直接返回true;
        if(nodes.size() == 0) return true;
        else if(nodes.size() > 4) return false;
        else if(nodes.size() == 2){
            int node1 = nodes.get(0);
            int node2 = nodes.get(1);
            //如果node1和node2之间没有边
            if(!set.contains(new Pair(node1,node2))) return true;
            else{
                for(int i=0; i<n; i++){
                    if(i==node1 || i==node2) continue;
                    if(!set.contains(new Pair(node1,i)) && !set.contains(new Pair(node2,i))) return true;
                }
            }
        }
        else{
            int node1 = nodes.get(0);
            int node2 = nodes.get(1);
            int node3 = nodes.get(2);
            int node4 = nodes.get(3);
            if((!set.contains(new Pair(node1,node2)) && !set.contains(new Pair(node3,node4))) ||
                    (!set.contains(new Pair(node1,node3)) && !set.contains(new Pair(node2,node4))) ||
                    (!set.contains(new Pair(node1,node4)) && !set.contains(new Pair(node2,node3)))){
                return true;
            }
        }
        return false;
    }
}
