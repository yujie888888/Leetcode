package Company_Uber;
import java.util.*;
public class P3_GetMinPath2 {
        static class Node implements Comparable<Node> {
            int totalDistance;//当前path的距离
            int currNode;
            int currDistance;//
            int currCredits;//当前剩余的credit

            Node(int totalDistance, int currNode, int currDistance, int currCredits) {
                this.totalDistance = totalDistance;
                this.currNode = currNode;
                this.currDistance = currDistance;
                this.currCredits = currCredits;
            }
            @Override
            public int compareTo(Node o) {
                return Integer.compare(this.totalDistance, o.totalDistance);
            }
        }

        public static void main(String[] args) {
            int[] credits = {2, 10, 5, 100, 3};
            int n = credits.length;
            int src = 0;
            int dest = 4;

            int[][] roads = {{0, 1, 2}, {0, 3, 5}, {0, 2, 1}, {1, 3, 10}, {1, 4, 15}, {2, 3, 7}, {2, 4, 90}, {3, 4, 80}};
            //1.邻接表
            //结构int[][]
            //初始化：1.-1表示不可达 2.加入road[]的所有可达边
            int[][] adj = new int[n][n];
            for (int[] row : adj) Arrays.fill(row, -1);
            for (int[] road : roads) {
                adj[road[0]][road[1]] = road[2];
                adj[road[1]][road[0]] = road[2];
            }
            //2.距离表，任意两点之间的最短距离
            //结构int[][]
            //初始化：忽略credit限制 1.所有对初始化为最大值 2.自己到自己距离为0 3.直接可达的点之间的距离 (也可以说123是在为4做初始化)4.Floyd-Warshall方法找每两对之间的最小距离
            int[][] dist = new int[n][n];
            for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);//设置为最大值
            for (int i = 0; i < n; i++) dist[i][i] = 0;//到自己为0
            //直接可达的点之间的距离
            for (int[] road : roads) {
                dist[road[0]][road[1]] = road[2];
                dist[road[1]][road[0]] = road[2];
            }
            //寻找每一对之间的最短距离
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                                && dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }

            //3.minHeap
            //结构PriorityQueue<Node>
            //初始化：所有src可达的点，并且满足credit条件，将这些点到src的距离+这个点到dest的距离作为totalDistance加入Node
            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int i = 0; i < adj[src].length; i++) {
                if (adj[src][i] != -1 && credits[src] >= adj[src][i]) {
                    pq.offer(new Node(adj[src][i] + dist[i][dest], i, adj[src][i], credits[src] - adj[src][i]));
                }
            }

            //4.Dijistra
            while (!pq.isEmpty()) {
                //把预估最短距离的点poll出来
                Node curr = pq.poll();
                int totalDistance = curr.totalDistance;
                int currNode = curr.currNode;
                int currDistance = curr.currDistance;
                int currCredits = curr.currCredits + credits[currNode];

                //在这一步之前，也就是到达curNode(包含curNode),credit都已经是被考虑过的
                if(currNode == dest) {
                    System.out.println(currDistance);
                    return;
                }

                //遍历所有当前node可达的点并且满足credit条件
                for (int i = 0; i < adj[currNode].length; i++) {
                    if (adj[currNode][i] != -1 && currCredits >= adj[currNode][i]) {
                        pq.offer(new Node(currDistance + adj[currNode][i] + dist[i][dest], i,
                                currDistance + adj[currNode][i], currCredits - adj[currNode][i]));
                    }
                }
            }
            System.out.println(-1);
        }
    }
