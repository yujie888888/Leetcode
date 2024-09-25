package DataStruc_StackQueue;

import java.util.Stack;

public class LC394_DecodeString {
    public static void main(String[] args) {

    }

    /**Stack
     * O(n)
     * O(n)
     * Ideas:
     * 老老实实用Stack，用push()和pop()
     * 不要用while(){},会出问题
     * 用for依次遍历就可以
     * 遇到']'就开始从stack中pop element
     */
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                StringBuilder repeated = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    repeated.append(stack.pop());
                }

                stack.pop();

                int times = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    times = times + (stack.pop() - '0') * base;
                    base *= 10;
                }
                //O(k)
                repeated = repeated.repeat(repeated, times-1);
                for (int j = repeated.length() - 1; j >= 0; j--) {
                    stack.push(repeated.charAt(j));
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
