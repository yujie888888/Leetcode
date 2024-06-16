/**
 * An Amazon Fulfillment Associate has a set of items that need to be packed into two boxes.
 * Given an integer array of the item weights (arr) to be packed, divide the item weights into two subsets, A and B,
 * for packing into the associated boxes, while respecting the following conditions:
 *   The intersection of A and B is null.
 *   The union of A and B is equal to the original array.
 *   The number of elements in subset A is minimal.
 *   The sum of A's weights is greater than the sum of B's weights.
 * Return the subset A in increasing order where the sum of A's weights is greater than the sum of B's weights.
 * If more than one subset A exists, return the one with the maximal total weight.
 * Function Description
 * Complete the function minimalHeaviestSetA in the editor below.
 * minimalHeaviestSetA has the following parameter(s):
 * int arr[]: an integer array of the weights of each item in the set
 * Returns
 * int[]: an integer array with the values of subset A
 * Example 1:
 * Input:  arr = [5, 3, 2, 4, 1, 2]
 * Output: [4, 5]
 * Explanation:
 * The subset of A that satisfies the conditions is [4, 5]:
 * A is minimal (size 2)
 * Sum(A) = (4 + 5) = 9 > Sum(B) = (1 + 2 + 2 + 3) = 8
 * The intersection of A and B is null and their union is equal to arr.
 * The subset A with the maximal sum is [4, 5].
 * Example 2:
 * Input:  arr = [4, 2, 5, 1, 6]
 * Output: [5, 6]
 * Explanation:
 * The subset of A that satisfies the conditions is [5, 6]:
 * A is minimal (size 2)
 * Sum(A) = (5 + 6) = 11 > Sum(B) = (1 + 2 + 4) = 7
 * Sum(A) = (4 + 6) = 10 > Sum(B) = (1 + 2 + 5) = 8
 * The intersection of A and B is null and their union is equal to arr.
 * The subset A with the maximal sum is [5, 6].
 * Example 3:
 * Input:  arr = [3, 7, 5, 6, 2]
 * Output: [6, 7]
 * Explanation:
 * The 2 subsets in arr that satisfy the conditions for A are [5, 7] and [6, 7]:
 * A is minimal (size 2)
 * Sum(A) = (5 + 7) = 12 > Sum(B) = (2 + 3 + 6) = 11
 * Sum(A) = (6 + 7) = 13 > Sum(B) = (2 + 3 + 5) = 10
 * The intersection of A and B is null and their union is equal to arr.
 * The subset A where the sum of its weight is maximal is [6, 7].
 * Constraints:
 * 1 ≤ n ≤ 10^5
 * 1 ≤ arr[i] ≤ 10^4 (where 0 ≤ i < n)
 */
package Company_Amazon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P16_OptimizingBoxWeights {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1, 2};
        System.out.println(Arrays.toString(minimalHeaviestSetA(arr)));
    }

    /**Greedy
     * O(nlogn)
     * Ideas:
     * 排序后，尽可能选择大的，这样能让sumA>sumB时，A中的num最少
     */
    private static int[] minimalHeaviestSetA(int[] arr){
        List<Integer> res = new ArrayList<>();
        Arrays.sort(arr);
        int sum = 0;
        for(int num : arr) sum+=num;
        int sumA = 0;
        for(int i=arr.length-1; i>=0; i--){
            sumA += arr[i];
            res.add(arr[i]);
            if(sumA > (sum-sumA)) break;
        }
        int[] res1 = new int[res.size()];
        for(int i=0; i<res1.length; i++) res1[i] = res.get(i);
        Arrays.sort(res1);
        return res1;
    }
}
