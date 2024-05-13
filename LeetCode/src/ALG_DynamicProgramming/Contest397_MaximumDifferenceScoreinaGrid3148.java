/**
 * You are given an m x n matrix grid consisting of positive integers. You can move from a cell in the matrix to any other cell that is either to the bottom or to the right (not necessarily adjacent). The score of a move from a cell with the value c1 to a cell with the value c2 is c2 - c1.
 * You can start at any cell, and you have to make at least one move.
 * Return the maximum total score you can achieve.
 * Example 1:
 * Input: grid = [[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]]
 * Output: 9
 * Explanation: We start at the cell (0, 1), and we perform the following moves:
 * - Move from the cell (0, 1) to (2, 1) with a score of 7 - 5 = 2.
 * - Move from the cell (2, 1) to (2, 2) with a score of 14 - 7 = 7.
 * The total score is 2 + 7 = 9.
 * Example 2:
 * Input: grid = [[4,3,2],[3,2,1]]
 * Output: -1
 * Explanation: We start at the cell (0, 0), and we perform one move: (0, 0) to (0, 1). The score is 3 - 4 = -1.
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 1000
 * 4 <= m * n <= 105
 * 1 <= grid[i][j] <= 105
 */
package ALG_DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contest397_MaximumDifferenceScoreinaGrid3148 {
    /**
     * Dynamic Programming
     * 难点：
     * 1.不是一步一步走的，是随意走几步都可以
     * 2.任意选择起点
     */
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(9, 5, 7, 3));
        grid.add(Arrays.asList(8, 9, 6, 1));
        grid.add(Arrays.asList(6, 7, 14, 3));
        grid.add(Arrays.asList(2, 5, 3, 1));
        System.out.println(maxScore1(grid));
    }

    /**
     * DP(正向思维)
     * O(mn) Beats 100%
     * O(mn) Beats 100%
     * 思路：
     * 关键: Move from c1 to ck with path c1,c2,..,ck, res = (c2 - c1) + (c3 - c2) + .... = ck - c1
     * 所以不论是走一步还是走多步，都可以简化成ck-c1这个公式
     * 也就是只要找出最小的c1，就能找到在ck这个位置所能达到的以ck为终点的最大值
     * 最后遍历每个点，将每个点作为终点，取最大值作为结果
     * 1.dp[i][j]:在(i,j)这个坐标的左上方的区域内的最小的值，不包括grid[i][j]本身
     * 2.dp[i][j]初始化:对于第0行和第0列进行初始化，区域内的最小值，对于最左和最上的列和行只存在上或者左的区域，只用比较其上/其左的值就可以
     * 3.dp[i][j]推导:dp[i][j]=min( min(dp[i-1][j],dp[i][j-1]), min(grid[i-1][j],grid[i][j-1])
     * 注意事项：
     * 1.对于每一个点都能找到其dp[i][j],但是我们最后需要的是grid[i][j]-dp[i][j]的值，最后还要遍历每一个点取max值
     * 2.最关键的点是知道一切操作都能简化成ck-c1,这样就不用单独讨论一步还是多步
     * 3.取左上区域内的最小值，只要两个方向取到最小值，就说明取到了区域内的最小值(两个方向内肯定就能取到一个方格区域内的最小值)
     */
    public static int maxScore1(List<List<Integer>> grid) {
        int row = grid.size();
        int col = grid.get(0).size();
        int[][] dp = new int[row][col];
        dp[0][0] = grid.get(0).get(0);
        dp[0][1] = dp[0][0];
        dp[1][0] = dp[0][0];
        for (int i = 2; i < row; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], grid.get(i - 1).get(0));
        }
        for (int j = 2; j < col; j++) {
            dp[0][j] = Math.min(dp[0][j - 1], grid.get(0).get(j - 1));
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int min1 = Math.min(dp[i - 1][j], dp[i][j - 1]);
                int min2 = Math.min(grid.get(i - 1).get(j), grid.get(i).get(j - 1));
                dp[i][j] = Math.min(min1, min2);
                //System.out.println("("+i+","+j+") = "+dp[i][j]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i != 0 || j != 0) {
                    max = Math.max(max, grid.get(i).get(j) - dp[i][j]);
                }
            }
        }
        return max;
    }
}
