/**
 * Given two arrays a[] and b[] of equal length n. The task is to pair each element of array a to an element in array b, such that sum S of absolute differences of all the pairs is minimum.
 * Suppose, two elements a[i] and a[j] (i != j) of a are paired with elements b[p] and b[q] of b respectively,
 * then p should not be equal to q.
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
