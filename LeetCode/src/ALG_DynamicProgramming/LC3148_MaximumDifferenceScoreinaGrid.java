package ALG_DynamicProgramming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC3148_MaximumDifferenceScoreinaGrid {
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(9, 5, 7, 3));
        grid.add(Arrays.asList(8, 9, 6, 1));
        grid.add(Arrays.asList(6, 7, 14, 3));
        grid.add(Arrays.asList(2, 5, 3, 1));
        System.out.println(maxScore(grid));
    }
    /**Dynamic Programming
     * O(mn)
     * O(mn)
     * Ideas:
     * 关键:
     *      Move from c1 to ck with path c1,c2,..,ck, res = (c2 - c1) + (c3 - c2) + .... = ck - c1
     *      所以不论是走一步还是走多步，都可以简化成ck-c1这个公式
     *      所以问题就变成从任意一个位置出发，move至少一步到certain position，这样的max score
     *      所以想到直接找"from区域的最小值”，在grid[i][j]这个位置，能形成的max score就是 grid[i][j]-minValue
     * Pay attention：
     * 1.不是一步一步走的，是随意走几步都可以, 所以状态不是从上一个方格来的，而是从上一个“区域”来的
     * 2.任意选择起点 -> 所以只需要知道"from区域"内的最小值，不关心它的位置
     * 3.这道题不能简单地找区域内的 min和max，太多情况需要考虑到，太麻烦，用dp[][]来模拟更好
     *     在grid[i][j]这里，上一个位置可以从上方，左方或者左上方来，所以只需要找到在这三个区域内的最小值
     *     不包含grid[i][j]，因为只要要有一个move，要是包含会出现不move的情况
     *     要想包含着三个区域，就比较grid[i-1][j], grid[i][j-1] 和 dp[i-1][j], dp[i][j-1]
     *          这样就囊括了在grid[i][j]左上方的整个区域，不包含grid[i][j]
     * DP三部曲：
     * 1.dp[i][j]:在(i,j)这个坐标的左上方的区域内的最小的值，不包括grid[i][j]本身
     * 2.dp[i][j]初始化:对于第0行和第0列进行初始化，区域内的最小值，对于最左和最上的列和行只存在上或者左的区域，只用比较其上/其左的值就可以
     * 3.dp[i][j]推导:dp[i][j]=min( min(dp[i-1][j],dp[i][j-1]), min(grid[i-1][j],grid[i][j-1])
     * 注意事项：
     * 在给dp[][] assign value 的时候就可以比，在初始化的时候也要找 max Value，因为max Value也有可能出自第一行或第一列，所以不要漏了
     */
    public static int maxScore(List<List<Integer>> grid) {
        int row = grid.size();
        int col = grid.get(0).size();
        int[][] dp = new int[row][col];
        int res = Integer.MIN_VALUE;
        dp[0][0] = grid.get(0).get(0);
        for(int i=1; i<row; i++){
            dp[i][0] = Math.min(grid.get(i-1).get(0), dp[i-1][0]);
            res = Math.max(res, grid.get(i).get(0)-dp[i][0]);
        }
        for(int j=1; j<col; j++){
            dp[0][j] = Math.min(grid.get(0).get(j-1), dp[0][j-1]);
            res = Math.max(res, grid.get(0).get(j)-dp[0][j]);
        }

        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                int min1 = Math.min(grid.get(i-1).get(j), grid.get(i).get(j-1));
                int min2 = Math.min(dp[i-1][j], dp[i][j-1]);
                dp[i][j] = Math.min(min1, min2);
                res = Math.max(res, grid.get(i).get(j)-dp[i][j]);
            }
        }
        return res;
    }
}
