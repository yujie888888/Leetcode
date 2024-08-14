/**
 * 您给定了以下操作数组，数组包含以下两种类型的操作：
 * [0, a, b] - 创建并保存一个大小为 a × b 的矩形；
 * [1, a, b] - 回答问题：“之前保存的所有矩形是否都能放入一个大小为 a × b 的盒子里”。矩形可以旋转 90 度；即：尺寸为 a × b 的矩形可以旋转成 b × a。
 * 注意：我们尝试将每个矩形分别放入盒子里（不是同时放入）。
 * 您的任务是返回一个布尔值数组，表示按顺序出现的第二种操作的答案。
 * 注意，操作应按顺序进行，因此当执行 operations[i] 时，只有之前的操作结果可用。
 * 示例：
 * 对于 operations = [[1, 1, 1]]，输出应为 solution(operations) = [true]。
 * 没有矩形，所以它们都可以放入任何盒子里。
 * 对于 operations = [[0, 1, 3], [0, 4, 2], [1, 3, 4], [1, 3, 2]]，输出应为 solution(operations) = [true, false]
 */
package Company_Uber;
import java.util.ArrayList;
import java.util.List;

public class P6_Rectangle {
    public static void main(String[] args){
        int[][] operations = {{0, 1, 3},{0, 4, 2},{1, 3, 4},{1, 3, 2}};
        System.out.println(solution(operations));
    }
    /**Greedy
     * 对于矩形来说，存在一条长边，一条短边
     * 看矩形能不能通过盒子只需要看盒子的短边能不能通过矩形的短边；盒子的长边能不能通过矩形的长边
     */
    private static List<Boolean> solution(int[][] opt){
        List<Boolean> res = new ArrayList<>();
        int maxW = 0;
        int maxL = 0;
        for(int[] o : opt){
            if(o[0] == 0){
                maxL = Math.max(maxL,Math.max(o[1],o[2]));
                maxW = Math.max(maxW,Math.min(o[1],o[2]));
            }
            else{
                int width = Math.min(o[1],o[2]);
                int length = Math.max(o[1],o[2]);
                if(length>=maxL && width>=maxW){
                    res.add(true);
                }
                else res.add(false);
            }
        }
        return res;
    }
}
