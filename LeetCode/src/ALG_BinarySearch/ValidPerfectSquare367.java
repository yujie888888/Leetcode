package ALG_BinarySearch;

import java.util.Scanner;

/**
 * Given a positive integer num, return true if num is a perfect square or false otherwise.
 * A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
 * You must not use any built-in library function, such as sqrt.
 *
 * Example 1:
 * Input: num = 16
 * Output: true
 * Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
 * Example 2:
 * Input: num = 14
 * Output: false
 * Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
 * Constraints:
 * 1 <= num <= 2^31 - 1
 */
public class ValidPerfectSquare367 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the target:");
        int target = sc.nextInt();
        System.out.println(search(target));
    }

    private static boolean search(int target){
        if(target == 1) return true;
        int start = 0;
        int end = target/2;
        long mid;
        while(start<=end){
            mid = start + (end-start)/2;
            if(mid*mid == target) return true;
            else if(mid*mid < target) start = (int)mid + 1;
            else end = (int)mid - 1;
        }
        return false;
    }
}
