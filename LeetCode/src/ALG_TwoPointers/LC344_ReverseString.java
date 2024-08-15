/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
package ALG_TwoPointers;

public class LC344_ReverseString {
    /**Two Pointers
     * O(n)
     * 思路：
     * 从头到中间，逐个交换位置
     */
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        int i=0;
        int j=s.length-1;
        while(i<j){
            char temp;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
