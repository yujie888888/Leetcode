/**
 * In a newly planned city, where a city is located at each integral coordinate in a 2-dimensional plane,
 * there are n Amazon retailers. The ith retailer residing in the city at the coordinate (x[i], y[i]) and can deliver
 * to all the cities covered by the rectangle having the 4 corner points (0, 0), (x[i], 0), (0, y[i]), (x[i], y[i]).
 * We say that a point (a, b) is covered by a rectangle if it lies inside the rectangle or on its boundaries.
 * Note that no 2 retailers reside in the same city.
 * Given q requests of the form (a, b), determine the number of retailers who can deliver to the city at the coordinate (a, b).
 * Function Description
 *  Complete the function countNumberOfRetailers in the editor.
 *  countNumberOfRetailers has the following parameter(s):
 *  int retailers[n][2]: the retailers' coordinates
 *  int requests[q][2]: the coordinates of cities to deliver to
 * Returns
 *  int array[q]: The i-th request can be reachable of array[i] retailers
 * Example 1:
 * Input:  retailers = [[1, 2], [2, 3], [1, 5]], requests = [[1, 1], [1, 4]]
 * Output: [3, 1]
 * Explanation:
 * In this example, We have 3 retailers in the cities (1, 2), (2, 3), and (1, 5).
 * For the first request, all 3 retailers can deliver to the city at the coordinate (1, 1).
 * For the second request, only the third retailer can deliver to the city at the coordinate (1, 4).
 * Hence, the answer for this example will be [3, 1].
 * Constraints:
 *  1 ≤ n, q ≤ 7.5*10^4
 *  1 ≤ retailers[i][0] ≤ 10^9
 *  1 ≤ retailers[i][1] ≤ 100
 *  0 ≤ requests[j][0] ≤ 10^9
 *  0 ≤ requests[j][1] ≤ 100
 *  No two retailers share the same coordinates.
 */
package Company_Amazon;
import java.util.Arrays;

public class P21_CountNumberOfRetailers {
    public static void main(String[] args) {
        int[][] retailers = {{1, 2}, {2, 3}, {1, 5}};
        int[][] requests = {{1, 1}, {1,3}};
        System.out.println(Arrays.toString(countNumberOfRetailers1(retailers,requests)));
    }
    /**穷举法
     * O(n*q)
     */
    private static int[] countNumberOfRetailers1(int[][] retailers, int[][] requests){
        int n = requests.length;
        int[] count = new int[n];
        int[] res = new int[n];
        for(int j=0; j<n; j++){
            for(int i=0; i<retailers.length; i++){
                if((requests[j][0]<=retailers[i][0] && requests[j][1]<=retailers[i][1])){
                        count[j]++;
                }
            }
        }
        return count;
    }
}
