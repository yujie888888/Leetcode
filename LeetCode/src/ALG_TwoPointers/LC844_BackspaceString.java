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
package ALG_TwoPointers;
import java.util.ArrayList;
import java.util.Stack;

public class LC844_BackspaceString {
    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(getString(s).equals(getString(t)));
        System.out.println(getStack(s).equals(getStack(t)));
    }
    /**Two Pointers
     * O(n)
     * O(n)
     * 思路:
     * 虽然这道题是双指针做法，但这两个指针对应的不是同一个对象，不是传统双指针的思路
     * 1.指针i负责在arraylist(模拟栈)中删除元素,也就是记录要删掉的元素的位置
     * 2.指针j负责在str中检查元素
     *  1.指针j如果遇到'#',就在arraylist中删除i位置的元素，并让i位置退1
     *  2.如果遇到不是'#'的元素，就在arraylist中添加这个元素，并让i位置进1,在List中不是i控制增加元素，是增加元素控制i的值
     * 要注意的是'#'可能会多出来，也就是本来结果就为空的时候，i<0的时候，不需要进行删除操作
     * 构建新string，i要从-1开始
     */
    public static ArrayList getString(String str){
        ArrayList<Character> res = new ArrayList<>();
        int i = -1;
        for(int j=0; j<str.length(); j++){
            if(str.charAt(j) == '#'){
                if(i>=0){
                    res.remove(i);
                    i--;
                }
            }
            else{
                res.add(str.charAt(j));
                i++;
            }
        }
        return res;
    }
    /**Stack
     * O(n)
     * O(n)
     * 思路:
     * 1.用stack先进先出原理
     * 2.遇到# && stack不为空时，就弹出最上方的char
     * 3.遇到其他的char就push进stack
     * 3.stack就是最后值
     * 4.比较两个stack
     */
    public static Stack getStack(String str) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '#'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(str.charAt(i));
            }
        }
        return st;
    }
}
