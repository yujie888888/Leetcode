/**
 * 给定两个长度相等的数组 a[] 和 b[]，任务是将数组 a 中的每个元素与数组 b 中的一个元素配对，使得所有配对后对应元素的绝对差的和 S 最小。
 * 具体来说，每个元素 a[i] 必须与 b 中的一个唯一元素配对，不能有重复的配对。
 * 例如，元素 a[i] 和 a[j]（i != j）分别配对 b[p] 和 b[q] 时，要求 p 不等于 q
 */
package Company_Amazon;
import java.util.Arrays;
public class P7_GetMinDistance {
    /**Greedy
     * O(nlogn)
     * O(1)
     * Ideas:
     * 1.for single problem, the minimum difference of c[0] and d[0] is the min num of c[] and min num of d[]
     * 2.Then find every min difference of n num
     * Steps:
     * 1.Sort both the arrays in O (n log n) time.
     * 2.Find absolute difference of each pair of corresponding elements (elements at same index) of both arrays and add the result to the sum S.
     */
    public static void main(String[] args) {
        int[] center = {4, 1, 8, 7};
        int[] destination = {2, 3, 6, 5};
        Arrays.sort(center);
        Arrays.sort(destination);
        int sum = 0;
        for(int i=0; i<center.length; i++){
            sum += Math.abs(center[i]-destination[i]);
        }
        System.out.println(sum);
    }
}
