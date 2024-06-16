/**
 * Amazon Shopping has
 * n items in inventory. Each item has a rating that may be negative. The team wants to work on an algorithm that will suggest combinations of these items that customers might buy, or, combos for short. A combo is defined as a subset of the given
 * n items. The total popularity of a combo is the sum of the popularities of the individual items in the combo. Design an algorithm that can find the
 * k combos with the highest popularities. Two combos are considered different if they have a different subset of items. Return an array of
 * k integers where the
 *   denotes the popularity of the
 *   best combo. Combos should be returned arranged best to worst.
 * Note: You can have an empty subset as a combo as well. The popularity for such a subset is 0.
 * Example:
 * n=3
 * popularity=[3,5,−2]
 * k=3
 * All possible popularities of combos are 0, 3, 5, -2, 8, 6, 1, 6.
 * The best three combos have popularities 8, 6, and 5.
 * The answer is [8, 6, 5].
 */
package Company_Amazon;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P25 {
    public static void main(String[] args) {
        int[] popularity = {3,5,-2};
        int n = 3;
        int k = 3;

        System.out.println();
    }
}















