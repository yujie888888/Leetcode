package DataStruc_StackQueue;
/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors.'#' means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * Example 1:
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 * Constraints:
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 */
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class BackspaceString844 {
    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompare1(s).equals(backspaceCompare1(t)));
    }

    /**(推荐)双指针法，ArrayList
     * O(n) Beats 80%
     * O(1) Beats 85%
     * 思路：
     *
     * 思路:
     * 1.双指针模拟stack
     * 2.指针j负责在arraylist(模拟栈)中删除元素
     * 3.指针i负责在str中检查元素
     * 4.如果right遇到'#',就在arraylist中删除left位置的元素，并让left位置退1
     * 5.如果遇到不是'#'的元素，就在arraylist中添加这个元素，并让left位置进1
     * 注意事项：
     * 1.在if-else判断中，一定要澄清elseif，而不是直接else.
     *   因为if条件有两个，它对应的条件是cStr[i] != '#' || j < 0
     *   对于j<0的情况下，i依旧有可能走到#的可能，所以不管arr的长度如何，只要遇到!= '#' 的你情况就把这个char加进arr中
     * 2.虽然这道题是双指针做法，但是是模拟栈的做法，这两个指针对应的不是同一个对象，不是传统双指针的思路
     */
    public static ArrayList backspaceCompare1(String str){
        ArrayList<Character> arr = new ArrayList<>();
        int j = -1;
        char[] cStr = str.toCharArray();
        for(int i=0; i<cStr.length; i++){
            if(cStr[i] == '#' && j >= 0){
                arr.remove(j);
                j --;
            }
            else if(cStr[i] != '#'){
                arr.add(cStr[i]);
                j ++;
            }
        }
        return arr;
    }

    /**Stack法
     * 最简单的方法，但是空间复杂度比较高，推荐用arraylist模拟栈的解法，时间和空间复杂度都低
     * O(n) Beats 80%
     * O(n+m) Beats 75%
     * 思路:
     * 1.用stack先进先出原理
     * 2.遇到# && stack不为空时，就弹出最上方的char
     * 3.遇到其他的char就push进stack
     * 3.stack就是最后值
     * 4.比较两个stack
     * 注意事项：
     * 1.注意if-else的条件，按照逻辑写
     */
    public static boolean backspaceCompare2(String s, String t) {
        Deque<Character> stack1 = new LinkedList<>();
        Deque<Character> stack2 = new LinkedList<>();
        for(char c : s.toCharArray()){
            if(c == '#' && stack1.size()>0) stack1.pop();
            else if(c != '#') stack1.push(c);
        }
        for(char c : t.toCharArray()){
            if(c == '#' && stack2.size()>0) stack2.pop();
            else if(c != '#') stack2.push(c);
        }
        return stack1.equals(stack2);
    }
}
