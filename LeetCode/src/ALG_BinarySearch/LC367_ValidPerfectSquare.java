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
package ALG_BinarySearch;

public class LC367_ValidPerfectSquare {
    public static void main(String[] args) {
        int target = 808201;
        System.out.println(search(target));
    }
    /**Binary Search
     * P69的低配版
     * 注意数据范围
     *  int: -2^31 到 2^31 - 1
     *  long: -2^63 到 2^63 - 1
     *  short: -2^15 到 2^15 - 1
     *  float: 1.4E-45 到 3.4E+38
     *  double: 4.9E-324 到 1.7E+308
     */
    private static boolean search(int num){
        if(num<4){
            if(num == 1) return true;
            else return false;
        }
        long left = 1;
        long right = num/2;
        while(left<=right){
            long mid = left+(right-left)/2;
            long sqMid = mid*mid;
            if(sqMid>num){
                right = mid-1;
            }
            else if(sqMid<num){
                left = mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
