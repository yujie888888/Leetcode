package Struc_stackQueue;

import java.util.ArrayDeque;

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
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */
public class ReverseString344 {
    public static void main(String[] args) {

    }

    /** double points O(n) Beats 100%
     * 直接用two points做，交换数值
     */
    public void reverseString(char[] s) {
        // if can use hashmap, just nend to modify key-value
        // two points
        int left = 0;
        int right = s.length-1;
        char temp;
        while(left<right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
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
