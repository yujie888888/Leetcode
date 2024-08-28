package ALG_DepthFirstSearch;

public class LC1905_CountSubIslands {
    public static void main(String[] args){
        int[][]grid1 = {
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1}
        };
        int[][] grid2 = {
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0}
    };
        System.out.println(countSubIslands(grid1, grid2));
    }

    /**DFS
     * Beats 98%
     * Ideas:
     * Like LC200
     * 1.find every island in the grid2
     * 2.drown this island
     * 3.when dfs this island, check the grid1, if gird1 has island of this (i,j)
     *      if no: flag = 0;
     *      if yes: flage = 1;
     * 4. res += flag
     */
    static int flag = 1;
    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        for(int i=0; i<grid2.length; i++){
            for(int j=0; j<grid2[0].length; j++){
                flag = 1;
                if(grid2[i][j] == 1){
                    dfs(grid1,grid2,i,j);
                    res += flag;
                }
            }
        }
        return res;
    }
    private static void dfs(int[][] grid1, int[][] grid2, int i, int j){
        if(grid2[i][j] == 0){
            return;
        }

        if(grid1[i][j] == 0){
            flag = 0;
        }
        grid2[i][j] = 0;
        if(i+1 < grid2.length) dfs(grid1,grid2,i+1,j);
        if(i-1 >= 0) dfs(grid1,grid2,i-1,j);
        if(j+1 < grid2[0].length) dfs(grid1,grid2,i,j+1);
        if(j-1 >= 0) dfs(grid1,grid2,i,j-1);
    }
}
