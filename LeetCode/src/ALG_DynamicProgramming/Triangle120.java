/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 * Example 1:
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output:11
 * Explanation: The triangle looks like:
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * Example 2:
 * Input: triangle = [[-10]]
 * Output: -10
 * Constraints:
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 */
package ALG_DynamicProgramming;
import java.util.List;
public class Triangle120 {
    public static void main(String[] args) {
        //给List<List<Integer>>格式赋值
        //Java 9的List.of()来创建一个完全不可变的结构
        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3,4),
                List.of(6,5,7),
                List.of(4,1,8,3)
        );
        System.out.println(minimumTotal1(triangle));
    }
    /**(推荐)Dynamic Programming(二维数组, bottom->top)
     * O(n^2) Beats 70%
     * O(m*n) Beats 85%
     * 思路：
     * 1.含义: dp[i][j]从最底层到这个位置的最小的sum值
     * 2.递推公式: dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j+1], dp[i+1][j])
     * 3.初始化值: dp[i][n-1] = List最后一个子List中对应的值;
         m是三角形的宽度，n是三角形的深度；
         m == List最后一个子List的的长度；
         n == List.size();
     * 4.Math.min(dp[m-1][j]);
     * 注意事项：
     * 1.递推公式不要写错，不要搞混triangle和dp
     * 2.注意List的各种操作
     * 3.这道题top->bottom 或者 bottom->top都可以，但是从底向上比较简单
     */
    public static int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        //set value
        int[][] dp = new int[m][n];
        //set初始值
        for(int i=0; i<m; i++) dp[n-1][i] = triangle.get(n-1).get(i);
        //递推公式
        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
    /**Dynamic Programming(一维数组, bottom->top)
     * O(n^2) Beats 75%
     * O(n) Beats 90%, n is number of rows in the triangle
     * 思路：
     * 1.每次from bottom to top, 用完一次的值其实就没用了，这里一维数组的思想就是覆盖没用的位置，将其替换成新的位置
     * 注意事项：
     * 1.j一定要从左到右，因为如果从右到左，原来的值会被更改，演示一下就懂了
     */
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int level = triangle.size();
        int[] dp = new int[level];
        for(int i=0; i<level; i++){
            dp[i] = triangle.get(level-1).get(i);
        }
        for(int i=level-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}
