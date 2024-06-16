/**
 * There are n developers working at the company where the developer has the experience points xp[i].
 * The company decided to pair the developers by iteratively pairing the developers with the highest and lowest remaining experience points for a hackathon.
 * The combined experience of a pair is the average of the experience points of the two developers.
 * Find the number of unique values among the combined experience of the pairs formed
 * Function Description
 * Complete the function getExperience in the editor.
 * getExperience has the following parameter:
 * int xp[n]: the experience points for each developer
 * Returns
 * int: the number of unique values among the combined experience points of the pairs formed
 * Example 1:
 * Input:  xp = [1, 4, 1, 3, 5, 6]
 * Output: 2
 * Explanation:
 * There are n = 6 developers. The pairs formed are (1, 6), (1, 5), and (4, 3) making their experience points 3.5, 3, and 3.5 respectively.
 * There are 2 distinct values, 3 and 3.5, so return 2 as the answer.
 * Example 2:
 * Input:  xp = [1, 1, 1, 1, 1, 1]
 * Output: 1
 * Explanation:
 * The developers will be paired up as follows (by index): (0, 1), (2, 3), and (4, 5). Each pair has a combined experience of 1.
 * Example 3:
 * Input:  xp = [1, 100, 10, 1000]
 * Output: 2
 * Explanation:
 * The developers are paired as follows (by index): (0, 3), (1, 2). The pairs have combined experience points of 500.5, and 55 respectively.
 * Constraints:
 * 2 ≤ n ≤ 10^5
 * 0 ≤ xp[i] ≤ 10^9
 * n is an even number
 */
package Company_Amazon;
import java.util.Arrays;
import java.util.HashSet;

public class P19_GetDistinctExperience {
    public static void main(String[] args) {
        int[] xp = {1, 4, 1, 3, 5, 6};
        System.out.println(getExperience(xp));
    }
    /**
     * O(nlogn)
     * Ideas:
     * 1.sort
     * 2.从两端向中间遍历找pair
     * 3.用double[] 替换 int[] 保持精度
     * 4.把sum/2 add set()
     */
    private static int getExperience(int[] xp){
        Arrays.sort(xp);
        int n = xp.length;
        double[] arr = new double[n];
        for(int i=0; i<n; i++) arr[i] = xp[i];
        HashSet<Double> set = new HashSet<>();
        int i=0, j=n-1;
        while(i<j){
            set.add((arr[i]+arr[j])/2);
            i++;
            j--;
        }
        return set.size();
    }
}
