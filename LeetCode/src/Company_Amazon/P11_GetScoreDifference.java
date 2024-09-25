/**
 * Amazon Games has recently launched a two-player game where an array of points of positive integer is given.
 * In each turn, a player picks any integer from the array, adds its value to the score, and removes it from the array.
 * The two players numbered 1 and 2 alternate turns with player 1 going first. The game ends when the array is empty.
 * Both the players wants to maximize their scores.
 * Find the difference between the players' scores if both of them play optimally.
 * Function Description
 * Complete the function getScoreDifference in the editor.
 * getScoreDifference has the following parameter:
 * int points[n]: integers to choose from
 * Returns
 * long integer: the absolute difference between the scores of the two players
 * Example 1:
 * Input:  points = [4, 1, 2, 3]
 * Output: 2
 * Explanation:
 * The game goes as above.
 * Player1 and player2 play in the following way:
 * player1 chooses 4 (got 4 points so far)
 * player2 chooses 3 (got 3 points so far)
 * player1 chooses 2 (got 4 + 2 = 6 points so far)
 * player2 chooses 1 (got 3 + 1 = 4 points so far)
 * the input array now is empty. GAME OVER
 * Hence, the answer is 6 - 4 = 2.
 * Example 2:
 * Input:  points = [4, 1, 1, 4]
 * Output: 0
 * Explanation:
 * The first player picks 4, the second player picks 4, the first player picks 1, and the second
 * player picks 1. The difference in scores is (1 + 4) - (1 + 4) = 0.
 * Constraints:
 * 1 <= n <= 10^5
 * 1 <= points[i] <= 10^9
 */
package Company_Amazon;
import java.util.Arrays;

public class P11_GetScoreDifference {
    public static void main(String[] args) {
        int[] points = {4, 1, 2};
        System.out.println(getScoreDifference(points));
    }
    /**Greedy
     * O(nlogn)
     * Ideas:
     * 这道题太简单，LC468是这道题的进阶版
     */
    private static long getScoreDifference(int[] points){
        Arrays.sort(points);
        long sum1=0, sum2=0;
        for(int i=points.length-1; i>=0; i-=2){
            sum1 += points[i];
            if(i-1>=0) sum2 += points[i-1];
        }
        return sum1-sum2;
    }
}
