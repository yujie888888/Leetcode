/**
 * Amazon has several warehouses that store piles of boxes containing goods to be shipped.
 * In one such warehouse, there are a total of n piles numbered 1, 2, ..... n, where the ith pile has boxes[i]
 * number of boxes. To have an even distribution of boxes, the caretaker can do the following operation any number of times (possibly zero):
 * Choose two distinct piles, i and j(1 <= i, j <= n), such that boxes[i]> 0.
 * Remove one box from pile i and place it on pile j. More formally, increment boxes[j] by 1 and decrement boxes[i] by 1.
 * For even distribution, the caretaker wishes to minimize the difference between the maximum and the minimum number of
 * boxes in the piles. Call the minimum difference achievable d. The goal is to find the minimum number of operations required
 * to achieve the difference d.
 * Function Description
 * Complete the function findMinimumOperations in the editor.
 * findMinimumOperations has the following parameter:
 * int boxes[n]: the number of boxes in each pile
 * Returns
 * long_int: the min number of operations to achieve the min possible difference
 * Example 1:
 * Input:  boxes = [5, 5, 8, 7]
 * Output: 2
 * Explanation:
 * Consider the number of piles to be n = 4 and the boxes in them are boxes = [5, 5, 8, 7]. The minimum possible difference that
 * can be achieved is 1 by transforming the piles into [6, 6, 7, 6] as below. Hence the answer is 2.
 * Example 2:
 * Input:  boxes = [2, 4, 1]
 * Output: 1
 * Explanation:
 * Move a box from pile 2 to pile 3: [2, 4, 1] -> [2, 3, 2]
 * Example 3:
 * Input:  boxes = [4, 4, 4, 4, 4]
 * Output: 0
 * Constraints:
 * 1 <= n <= 10^5
 * 1 <= boxes[i] <= 10^9
 */
package Company_Amazon;
import java.util.Arrays;

public class P13_findMinimumOperations {
    public static void main(String[] args) {
        int[] boxes = {5,5,8,7};
        int n = boxes.length;
        System.out.println(findMinimumOperations(boxes,n));
    }
    /**Greedy
     * O(n)
     * O(n)
     * Ideas:
     * 1.sort之后，数量少的在前面, 这一步是为了后面最小化分配avg和avg+1的操作次数 (avg+1>avg)
     * 2.求余数，余数意味着有多少个piles需要分配成avg+1，相应的有n-余数个piles分配成avg
     * 3.其实极差最大就是1
     * 4.用target[]存最后分配成的结果
     * 5.计算操作次数，因为操作次数包含-1，+1，所以只计算少的piles加了多少个box就可以
     */
    public static long findMinimumOperations(int[] boxes,int n) {
        Arrays.sort(boxes);
        int sum = 0;
        for(long box : boxes) sum+=box;
        int avg = sum/n;
        int remainder = sum%n;//还有多少个没有办法平均分配，没有办法平均分配的箱子要平均分配给（能平均分配的pile）后面的pile
        int[] target = new int[n];
        for(int i=0; i<n-remainder; i++) target[i] = avg;
        for(int i=n-remainder; i<n; i++) target[i] = avg+1;
        //这样就把所有的箱子分配完了，最大极差就是1
        long res = 0;
        for(int i=0; i<n; i++){
            if(boxes[i] < target[i]){
                res += (target[i]-boxes[i]);
            }
        }
        return res;
    }
}
