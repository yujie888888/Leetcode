package Struc_stackQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
 * We repeatedly make duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.
 * Example 1:
 * Input: s = "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 * Example 2:
 * Input: s = "azxxzy"
 * Output: "ay"
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 */
public class RemoveAllAdjacentDuplicatesInString1047 {
    public static void main(String[] args) {

    }

    /**和20题一样，都是匹配问题，更简单
     * O(n)
     * 这么写其实可以优化，用数组模拟栈会更快，并且省去了string转换
     */
    public String removeDuplicates_1(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> temp = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            //c==null会报错“java.lang.NullPointerException”
            if(stack.peek()!=null && c == stack.peek()){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        while(!stack.isEmpty()){
            temp.push(stack.pop());
        }
        String result = "";
        while(!temp.isEmpty()){
            result += temp.pop();
        }
        return result;
    }

    /**改进版 90%
     * O(n)
     * 用StringBuilder模拟stack
     */
    public String removeDuplicates_2(String s) {
        //用StringBuilder模拟stack，性能更优化
        StringBuilder res = new StringBuilder();
        int top = -1;//模拟peek()
        for(char c : s.toCharArray()){
            if(top>-1 && c == res.charAt(top)){
                res.deleteCharAt(top);
                top--;
            }
            else{
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }
}
