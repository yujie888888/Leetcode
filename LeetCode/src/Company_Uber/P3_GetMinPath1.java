/**
 * Problem Statement
 * Uber HCVs (High Capacity Vehicles) runs across the city of UberLand. UberLand has N stops where the HCVs pickup or drop the passengers. There Is a network of M bidirectional roads tnat connects various stops. Each road has a particular length attached to it.
 * The Uber developers have Introduced a weird feature of credits where each stop has some assigned credits c[i] (0<=i<N) which the HCV can collect when it reaches the stop. These credits are used to travel on a road and number of credits used for travelling on a road is equal to the length of the road. So a HCV can travel on a road If it has credits equal or more than the length of the road.
 * You want to travel from a given source stop S (0<=S<N) to a destination stop D (0<=0<N) with minimum distance travelled.
 * Calculate the minimum distance that you need to travel or return -1 if there is no way possible.
 * Assume the HCV starts at the source stop S and has credits equal to the credits of S at the start.
 * Input:
 * Each test case has several lines.
 * The first line contains an integer N which represent the number of stops in UberLand.
 * The second line contains an array C of N Integers which represents credits for each stop.
 * The third line contains an integer M which represent the number of roads in UberLand.
 * Then the following M lines each contain three Integers X (0<=X<N) ,Y (0<=-Y<N) ,Z (1<=Z<=100) which means there is road connecting stops X and Y with length Z where X != Y
 * Then the last 2 lines contains one Integer respectively, S and D which represent the source and the destination stop.
 * Constraints:
 * 1<=N<=50
 * 0<=M<=100
 * 0<=C[i]<=100
 * 1<=Length of each road<=100
 * Sample Input:
 * 5
 * 2 10 5 100 3
 * 8
 * 0 1 2
 * 0 3 5
 * 0 2 1
 * 1 3 10
 * 1 4 15
 * 2 3 7
 * 2 4 90
 * 3 4 80
 * 0
 * 4
 * Sample Output:
 * 19
 * Explanation:
 * Starting at Node0, we have a Credit of 2, We can travel to Node1 with a distance to '2' and lose 2 Credits and gain 10 credits there. Next in order to Travel to Node4 we need a Credit to 15 but we have 10 at this point.
 * We can take a different route indicated in Green.
 * Start from Node0 (Credit =2, Distance Travelled =0)
 * Move to Node2 (Credit= 2-1+5, Distance Travelled= 1)
 * Move to Node0 (Credit= 6-1+2, Distance Travelled= 2)
 * Move to Node1 (Credit=7-2+10, Distance Travelled= 4)
 * Move to Node4 (Credit= 15-15, Distance Travelled= 19)
 */
package Company_Uber;
import java.util.*;

public class P3_GetMinPath1 {
    public static void main(String[] args) {
        int n = 5; //represent the number of stops
        int[] credit = new int[]{2,10,5,100,3}; //an array C of N Integers which represents credits for each stop
        int roadNum = 8; //represent the number of roads in UberLand
        int[][] roads = {{0,1,2},{0,3,5},{0,2,1},{1,3,10},{1,4,15},{2,3,7},{2,4,90},{3,4,80}}; //road connecting stops X and Y with length Z where X != Y
        int src = 0;
        int dest = 4;
        System.out.println(getMinDistance(n,credit,roadNum,roads,src,dest));
    }
    /**Dijistra
     * Ideas:
     * 图论题太繁琐了
     * 约束条件:
     * 1.能够到达目的地
     * 2.在条件1下，距离最短的路径
     * 主要思路就是根据预估总距离，每次都poll出预估总距离最小的node，然后检查node是不是dest，如果是，就直接输出当前path累积的distance
     * 贪心思想，深究费脑
     * Steps:
     * 1.构建邻接图
     *      用int[x][y]就行；表示x可以访问的结点
     *      这里要注意二维数组的结构，它是int[x]={}这种格式，也就是如果有(x,y1)(x,y2),那么int[x] = {y1,y2};
     * 2.构建距离图
     *      用int[x][y]就行
     *      这里的距离图表示的是任意两个点之间的最短距离
     *      用Floyd构建，先忽略credit限制，这个限制在Dijistra里会解决的
     * 3.构建minHeap
     *      minHeap按照预估总距离进行排序，也就是graph[src][k]+dist[k][dest]
     */
    private static int getMinDistance(int n, int[] credit, int roadNum, int[][] roads, int src, int dest){
        //1.邻接表，双向图
        //结构：HashMap<nodeX,{nodeY,dist of nodeX to nodeY}>
        //注意这里的结构是List<int[]>这样写的，不是直接int[]
        int[][] graph = new int[n][n];
        for(int[] temp : graph){
            Arrays.fill(temp,-1);
        }
        for(int[] road : roads){
            graph[road[0]][road[1]] = road[2];
            graph[road[1]][road[0]] = road[2];
        }

        //2.dist[][]数组
        //结构：int[n][n]
        int[][] dist = new int[n][n];
        int max = Integer.MAX_VALUE;
        for(int[] temp : dist){
            Arrays.fill(temp,max);
        }
        for(int i=0; i<n; i++){
            dist[i][i] = 0;
        }
        for(int[] road : roads){
            dist[road[0]][road[1]] = road[2];
            dist[road[1]][road[0]] = road[2];
        }
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dist[i][k]!=max && dist[k][j]!=max
                            && dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j] = dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        //System.out.println(Arrays.deepToString((dist)));

        //3.minHeap,需要初始化
        //结构：PriorityQueue<{nodeX, totalDistance, 剩余credit}>
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->(a[1]-b[1]));//minHeap根据边大小排序
        for(int i=0; i<graph.length; i++){
            if(graph[src][i] != -1 && credit[src]>=graph[src][i]){
                //src,totalDistance,credit
                minHeap.add(new int[]{i, graph[src][i]+dist[i][dest], credit[src]-graph[src][i], graph[src][i]});
            }
        }

        //4.Dijistra，根据预估总距离进行排序
        while(!minHeap.isEmpty()){
            int[] curPair = minHeap.poll();
            int curNode = curPair[0];
            int curTotalDist = curPair[1];
            int curCredit = curPair[2]+credit[curNode];
            int curDistance = curPair[3];

            if(curNode == dest) return curDistance;

            for(int i=0; i<graph[curNode].length; i++){
                if(graph[curNode][i] != -1 && curCredit >= dist[curNode][i]){
                    minHeap.add(new int[]{i, graph[curNode][i]+dist[i][dest], curCredit-graph[curNode][i], curDistance+graph[curNode][i]});
                }
            }
        }
        //System.out.println(Arrays.deepToString((dist)));
        return -1;
    }
}
