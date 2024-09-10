package ALG_DepthFirstSearch;
import java.util.*;

public class LC743_NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times,n,k));
    }
    /**
     1.构建neighbor table  HashMap<Integer,List<Integer>>
     2.初始化
     距离数组：存的是从起点节点到每个其他节点的最短路径长度
     优先队列：用于选择当前最短路径估计值最小的节点进行扩展
     3.Dijistra算法
     */
    public static int networkDelayTime(int[][] times, int n, int k) {
        //1.构建邻接表，表示各个点的到达关系
        //结构：HashMap<Integer,List<int[]>>. Integer表示结点,List<int[]>表示这个结点可到达的结点的List，这个List存的是可到达结点和到达距离
        HashMap<Integer,List<int[]>> neighbors = new HashMap<>();
        for(int[] time : times){
            if(!neighbors.containsKey(time[0])) neighbors.put(time[0],new ArrayList<>());
            neighbors.get(time[0]).add(new int[]{time[2],time[1]});
        }
        //2.构建距离数组，存的是当前，每个结点到出发点的最小距离
        //结构：int[]数组. 初始化为无穷大;出发点的dist设为0
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        dist[k] = 0;
        //3.构建最小堆. Dijkstra算法的核心思想是贪心算法,每次选择距离最小的节点进行扩展，意味着在该节点被处理时，从起点到该节点的最短路径已经确定
        //结构:PriorityQueue<int[]>. 最小堆，存的是node和node到出发点的距离
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a,b) -> (a[0]-b[0])
        );
        minHeap.add(new int[]{0,k});

        //循环遍历minHeap，直到minHeap为空，也就是所有可到达的点都被计算过了
        while(!minHeap.isEmpty()){
            //先把当前距离出发点最小的点poll出来
            int[] curPair = minHeap.poll();
            int curDist = curPair[0];
            int curNode = curPair[1];
            //如果dist[curNode](该结点离出发点的最小距离)比minheap中存的距离小，就不用继续找了，也就是说经过这个结点的距离比不经过这个结点的距离大，没必要走这条
            if(curDist > dist[curNode]) continue;
            //如果curNode这个结点没有邻接点，就不用继续了
            if(!neighbors.containsKey(curNode)) continue;
            //curNode有邻接点，遍历curNode的邻接点，将所有邻接点放进minHeap中
            //把curNode对应的邻接表找出来
            List<int[]> neighbor = neighbors.get(curNode);
            for(int i=0; i<neighbor.size(); i++){
                int nextDist = neighbor.get(i)[0];
                int nextNode = neighbor.get(i)[1];
                //如果当前路径的累积距离比dist[]中记载的该结点到出发点的距离小，就更新dist[node]
                //这一步也是判断nextCur这个node是不是被访问过
                /*如果当前路径的累积距离比dist数组中记录的该节点到起点的距离小，
                说明通过当前路径可以到达nextNode更短的距离，所以需要更新dist[nextNode]并将其加入优先队列等待进一步处理。
                这个判断同时确保了我们不会再处理已经确定最短路径的节点，因为如果一个节点已经通过更短的路径访问过，
                那么dist[nextNode]会比nextDist + curDist小，这样就会跳过这个节点的更新。*/
                if(nextDist + curDist < dist[nextNode]){
                    dist[nextNode] = nextDist + curDist;
                    //把该邻接点push进minHeap中，等待被使用
                    minHeap.offer(new int[]{dist[nextNode],nextNode});
                }
            }
        }
        int max = 0;
        System.out.println(Arrays.toString(dist));
        for(int num : dist){
            if(max<num) max = num;
        }
        if(max == Integer.MAX_VALUE) return -1;
        else return max;
    }
}
