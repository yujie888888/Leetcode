/**
 * 给一个matrix和一个operations数列q，
 * q[i]等于0是clockwise旋转90度，
 * 等于1是沿主对角线（\）reflect，
 * 等于2沿辅对角线（/）reflect，
 * return经过整个q系列操作后的matrix
 */
package Company_Databricks;
import java.util.Arrays;

public class P11 {
    /**代码逻辑题
     * O(q*m*n)
     * 思路：
     * 1.技巧：按时钟方向顺时针转90度 == 先将矩阵上下翻转 + 沿主对角线反射
     */
    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        int[] operations = new int[]{0,1,2};
        for(int opt : operations){
            switch(opt){
                case 0:
                    reverseClock(matrix);
                    System.out.println("After "+opt+" is: "+Arrays.deepToString(matrix));
                    break;
                case 1:
                    reflectMain(matrix);
                    System.out.println("After "+opt+" is: "+Arrays.deepToString(matrix));
                    break;
                case 2:
                    reflectSec(matrix);
                    System.out.println("After "+opt+" is: "+Arrays.deepToString(matrix));
            }
        }
        System.out.println("Final is: "+Arrays.deepToString(matrix));
    }
    private static int[][] reverseClock(int[][] nums){
        int m = nums.length;
        int n = nums[0].length;
        for(int i=0; i<m/2; i++){
            for(int j=0; j<n; j++){
                int temp = nums[i][j];
                nums[i][j] = nums[m-1-i][j];
                nums[m-1-i][j] = temp;
            }
        }
//        System.out.println("After reverse is: "+Arrays.deepToString(nums));
        return reflectMain(nums);
    }
    private static int[][] reflectMain(int[][] nums){
        int m = nums.length;
        int n = nums[0].length;
        for(int i=0; i<m; i++){
            for(int j=i+1; j<n; j++){
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }
        return nums;
    }
    private static int[][] reflectSec(int[][] nums){
        int m = nums.length;
        int n = nums[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n-1-i; j++){
                int temp = nums[i][j];
                nums[i][j] = nums[n-1-j][m-1-i];
                nums[n-1-j][m-1-i] = temp;
            }
        }
        return nums;
    }
}
