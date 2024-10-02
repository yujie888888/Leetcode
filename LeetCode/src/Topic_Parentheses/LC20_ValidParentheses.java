/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 * Example 1:
 * Input: s = "()"
 * Output: true
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
package Topic_Parentheses;
import java.util.Stack;
public class LC20_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("([{()[]{}}])"));
    }
    /**Stack
     * O(n) Beats 99%
     * O(n)
     * 思路:
     * 对称匹配问题想到用stack做，由于栈结构的特殊性，非常适合做对称匹配类的题目
     * fasle存在三种情况
     * 1、括号type不匹配
     * 2、多了右括号(少了左括号)
     * 3、少了右括号(多了左括号)
     * 因为括号肯定是满足顺序条件和数量条件的，所以用栈的先进先出特性，就能确保一对括号的匹配
     * Steps：
     * 遇到左括号，push进相应的[右括号]
     * 遍历时只需要比较当前字符和栈顶元素是否匹配
     * 如果不匹配，说明type对不上-1
     * 如果遍历的时候，发现栈已经为空了，说明多了右括号-2
     * 如果遍历完，发现栈不为空，说明少了右括号-3
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(') stack.push(')');
            else if(c=='[') stack.push(']');
            else if(c=='{') stack.push('}');
            else{
                if(!stack.isEmpty()){
                    if(c==stack.peek()) stack.pop();
                    else return false;
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
}

