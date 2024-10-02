package Topic_Parentheses;
import java.util.Stack;

public class LC1249_MakeValidParentheses {
    public static void main(String[] args) {

    }

    /**
     * O(n^2) worst situation, will not be this Time complexity
     * O(n)
     * Ideas:
     * 不难，难的是怎么处理多余的括号
     * 从左向右遍历，
     *      如果遇到'(',就push进stack,这里push index会更高效
     *      如果遇到')',就看stack是否为空，如果为空，先不删除这个')',因为删除之后影响遍历，先把这个替换成'*'
     *      结束后，如果stack不为空，就要删除stack中存的index的位置的'('
     * 要注意的点就是怎么处理要删除的)
     * 还有StringBuilder.replace()方法， 不包含end index
     */
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else if(c == ')'){
                if(stack.isEmpty()){
                    // O(1)
                    res.setCharAt(i, '*');
                }
                else{
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            // O(n) coz needs to move other elements
            res.deleteCharAt(stack.pop());
        }

        return res.toString().replaceAll("\\*", "");
    }
}
