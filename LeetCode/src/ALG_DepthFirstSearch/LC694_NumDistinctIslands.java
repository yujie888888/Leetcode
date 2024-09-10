package ALG_DepthFirstSearch;
import kotlin.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC694_NumDistinctIslands {
    public static void main(String[] args){
        int[][] grid = new int[][]{
            {1,1,0,1,1},
            {1,0,0,0,0},
            {0,0,0,0,1},
            {1,1,0,1,1},
        };
        System.out.println(numDistinctIslands(grid));
    }
    /**dfs
     * O(m*n)
     * O(m*n)
     * Ideas:
     * 唯一的难点是怎么表示一个岛的形状
     *  想到用Set<List<Pair<Integr,Integer>>>
     *  这样找到一个岛之后，先把偏移量算出来，然后将偏移量add进List
     *  这样每一个List都是一个shape模板
     *  然后判断allShape是否包含就可以了
     */
    public static int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        HashSet<List<Pair<Integer,Integer>>> allShapes = new HashSet<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    List<Pair<Integer,Integer>> shape = new ArrayList<>();
                    dfs(grid, i, j, i, j, shape);
                    if(!allShapes.contains(shape)){
                        res++;
                        allShapes.add(shape);
                    }
                }
            }
        }
        return res;
    }
    private static void dfs(int[][] grid, int i, int j, int i0, int j0, List<Pair<Integer,Integer>> shape){
        if(grid[i][j] == 0){
            return;
        }

        grid[i][j] = 0;

        int tx = i-i0;
        int ty = j-j0;
        shape.add(new Pair<>(tx,ty));

        if(i-1>=0) dfs(grid, i-1, j, i0, j0, shape);
        if(i+1<grid.length) dfs(grid, i+1, j, i0, j0, shape);
        if(j-1>=0) dfs(grid, i, j-1, i0, j0, shape);
        if(j+1<grid[0].length) dfs(grid, i, j+1, i0, j0, shape);
    }
}
