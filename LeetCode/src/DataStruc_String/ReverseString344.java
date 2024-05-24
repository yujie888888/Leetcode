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
package DataStruc_String;

import java.util.ArrayDeque;

/**two points
 * O(n) Beats 100%
 * 思路：
 * 双指针，从头到中间，逐个交换位置
 */
public class ReverseString344 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};

        int left = 0;
        int right = s.length - 1;
        char temp;
        while(left<right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
        for(char c : s) {
            System.out.print(c +",");
        }
    }
    /**Beats 5%
     * 用模拟stack输入输出过程方法，不推荐
     */
    public void stackReverseString(char[] s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(char c: s){
            stack.push(c);
        }
        for(int i=0; i<s.length; i++){
            s[i] = stack.pop();
        }
    }
}
