package DataStruc_StackQueue;
import java.util.Deque;
import java.util.ArrayDeque;

public class LC2390_RemovingStarsFromAString {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }
    /**Stack
     * O(n)
     * Ideas:
     * 用stack模拟删除过程，挺简单的
     */
    public static String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        int delete = 0;
        while(!stack.isEmpty()){
            if(stack.peek() != '*'){
                if(delete > 0){
                    delete --;
                    stack.poll();
                }
                else{
                    sb.append(stack.poll());
                }
            }
            while(!stack.isEmpty() && stack.peek() == '*'){
                delete ++;
                stack.poll();
            }
        }
        //System.out.println(sb.reverse());
        return sb.reverse().toString();
    }
}
