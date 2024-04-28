package ALG_doublepoints;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * Constraints:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */

public class MoveZero283 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the array, use ',' as separator:");
        String inputLine = sc.nextLine();
        String[] line = inputLine.split(",");
        int[] array = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            array[i] = Integer.parseInt(line[i]);
        }
        moveZero(array);
    }

    private static void moveZero(int[] array){
        int slowindex = 0;
        for(int fastindex = 0; fastindex < array.length; fastindex++){
            if(array[fastindex] != 0){
                array[slowindex++] = array[fastindex];
            }
        }
        for (; slowindex < array.length; slowindex++) {
            array[slowindex] = 0;
        }
        System.out.print("The array after removing is: "+ Arrays.toString(array));
    }
}
