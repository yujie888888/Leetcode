/**
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * Example 1:
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 * Input: n = 1
 * Output: [[1]]
 * Constraints:
 * 1 <= n <= 20
 */
package DataStruc_Array;
/**考察代码逻辑
 * 思路：
 * 就是模拟螺旋矩阵的set value的过程，不难，注意细节和步骤就可以
 * 1.找两个例子比如n=3,4; 进行模拟，然后总结出setValue规律
 * 2.按照每一层四个循环的思路写，注意n为奇数的时候要放入中心点的值
 * 注意事项:
 * 1.做题的时候脑子不清醒，搞混了i和j，我发现我做题的时候经常搞混i和j，下次一定要明确好了i和j再做题
 */
public class SpiralMatrixII59 {
    public static void main(String[] args) {
        int n = 3;

        int maxLayer = n/2;
        int[][] res = new int[n][n];
        int num = 1;
        for(int layer=0; layer<maxLayer; layer++){
            int j = layer;
            while(j<=n-1-layer){
                res[layer][j] = num++;
                //System.out.println(res[i][layer]);
                j++;
            }
            j -= 1;
            int i = layer+1;
            while(i<=n-1-layer){
                res[i][j] = num++;
                //System.out.println(res[i][j]);
                i++;
            }
            j = n-1-1-layer;
            i -= 1;
            while(j >= layer){
                res[i][j] = num++;
                //System.out.println(res[i][j]);
                j--;
            }
            j += 1;
            i = n-1-1-layer;
            while(i >= layer+1){
                res[i][j] = num++;
                //System.out.println(res[i][j]);
                i--;
            }
        }
        if(n%2!=0){
            res[n/2][n/2] = num;
        }
        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(res[i][j]+",");
            }
            System.out.println();
        }
    }
}
