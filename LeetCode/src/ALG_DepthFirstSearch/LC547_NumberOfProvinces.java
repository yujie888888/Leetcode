package ALG_DepthFirstSearch;
import java.util.List;
import java.util.ArrayList;

public class LC547_NumberOfProvinces {
    public static void main(String[] args) {
        int[][] isConnected = new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        System.out.println(findCircleNum(isConnected));
    }
    /**DFS
     * O(n^2) n-squared
     * O(n)
     * Ideas:
     * 题目求的是数量，这里直接升级，把结果打印出来
     * 如果只求数量，只设置一个res变量，在res.add()的时候换成res++即可
     * 先遍历每一个node，然后dfs遍历这个node的连通的最终点
     *
     */
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> resL = new ArrayList<>();
    public static List<List<Integer>> findCircleNum(int[][] isConnected) {
        res.clear();
        int n = isConnected.length;
        int[] visited = new int[n];

        for(int i=0; i<n; i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            resL.add(i+1);
            dfs(isConnected, visited, i);
            res.add(new ArrayList<>(resL));
            resL.clear();
        }
        return res;
    }

    private static void dfs(int[][] isConnected, int[] visited, int row){
        for(int col=0; col<isConnected.length; col++){
            if(isConnected[row][col] == 1){
                if(visited[col] != 1){
                    resL.add(col+1);
                    visited[col] = 1;
                    dfs(isConnected, visited, col);
                }
            }
        }
    }
}
