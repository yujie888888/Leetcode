/**
 * You are given an array of binary strings strs and two integers m and n.
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 * A set x is a subset of a set y if all elements of x are also elements of y.
 * Example 1:
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
 * Example 2:
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 * Constraints:
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 */
package ALG_DynamicProgramming;

public class OnesandZeroes474 {
    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 5;
        int n = 3;
        System.out.println(findMaxForm(strs,m,n));
    }

    /**DP(一维数组)
     * O(len*m*n) Beats 60%
     * O(m*n) Beats 60%
     * 思路:
     * 01Bags Apply, 重量是两个维度
     * 虽然用了dp[][]但实际上是因为有两种要满足的条件，所以实际上依旧是01Bags的一维数组的做法
     * DP五部曲:
     * 1.dp[p][q]: 当背包容量为p个0和q个1时，背包能装入的最大strs数
     * 2.dp[p][q] = Math.max(dp[p][q],dp[p-str[i][0]][q-str[i][1]]+1);
     * 3.dp[p][q] = 0;
     * 注意事项:
     * 1.因为是要满足两个条件，给的strs[]不太好进行条件判断，所以将strs[]变成str[][]二维数组来保存每个String的0和1的个数
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] str = new int[strs.length][2];
        for(int i=0; i<strs.length; i++){
            int[] strL = new int[2];
            int x = 0;
            int y = 0;
            for(int j=0; j<strs[i].length(); j++){
                if(strs[i].charAt(j) == '0') x++;
                else y++;
            }
            strL[0] = x;
            strL[1] = y;
            str[i] = strL;
        }
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<strs.length; i++){
            for(int p=m; p>=str[i][0]; p--){
                for(int q=n; q>=str[i][1]; q--){
                    dp[p][q] = Math.max(dp[p][q],dp[p-str[i][0]][q-str[i][1]]+1);
                }
            }
        }
        return dp[m][n];
    }
}
