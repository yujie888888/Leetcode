package Topic_Graph;
import kotlin.Pair;
import java.util.*;

public class P2308_AddEdges {
    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(3,4),
                Arrays.asList(1,4)
        );
        System.out.println(isPossible(n,edges));
    }
    /**
     * 代码逻辑题
     * Ideas:
     * 1.统计每个点的degree
     * 2.HashSet存边
     * 2.如果点的degree为奇数的个数
     *      是0，直接返回true
     *      大于4，直接返回false
     *      是2或4，说明可以添加边
     * 点的degree为奇数肯定是成对出现的，比如0，2，4，6...
     * 3.对于2或4的情况，检查是否可以添加1或2条边使得奇数degree的个数变成偶数
     *      对于为2的情况
     *          看是否能直接添加边u,v
     *          看有没有一个中间结点w,能添加u,w和w,v
     *      对于为4的情况
     *          看是否能在四个点uvwy，添加两条边，分别两两组和
     */
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
