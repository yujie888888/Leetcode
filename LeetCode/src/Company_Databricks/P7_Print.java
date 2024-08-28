/**
 * 给定一个整数 `n`，你的任务是创建一个大小为 `n` 的方形框架，表示为一个字符串数组。
 * 该框架应由空格组成，并由 `*` 字符组成的线条包围，如下所示：
 * ********
 * *      *
 * *      *
 * *      *
 * *      *
 * *      *
 * *      *
 * ********
 * 注意
 * 你不需要提供最优解，但时间复杂度不应超过 `O(n^3)`，以确保在执行时间限制内。
 * 示例
 * - 对于 `n = 8`，输出应为：
 * solution(n) = [
 *  "********",
 *  "*      *",
 *  "*      *",
 *  "*      *",
 *  "*      *",
 *  "*      *",
 *  "*      *",
 *  "********"
 * ]
 */
package Company_Databricks;

public class P7_Print {
    /**代码逻辑题
     * O(n^2)
     * O(1)
     * 思路：
     * 1.法1按照逻辑写
     * 2.法2，用.repeat()方法
     */
    public static void main(String[] args){
        int n = 20;
//        for(int i=0; i<n; i++){
//            int j=0;
//            while(j<n){
//                if(i==0 || i==n-1){
//                    System.out.print("*");
//                }
//                else{
//                    if(j==0 || j==n-1){
//                        System.out.print("*");
//                    }
//                    else{
//                        System.out.print(" ");
//                    }
//                }
//                j++;
//            }
//            System.out.println();
//        }
        for(int i=0; i<n; i++){
            if(i==0 || i==n-1){
                System.out.println("*".repeat(n));
            }
            else{
                System.out.println("*"+" ".repeat(n-2)+"*");
            }
        }
    }
}
