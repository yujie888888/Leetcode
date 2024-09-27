package DataStruc_StackQueue;

import java.util.Arrays;
import java.util.Stack;

public class LC735_AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = new int[]{-2,-1,1,2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    /**Stack
     * O(n)
     * O(n)
     * Ideas:
     * 用一个栈来模拟小行星的运动和碰撞过程。栈非常适合这个问题，因为我们只需要关注最近添加的小行星。
     * 碰撞检测：
     *    对于每个小行星，检查它是否会与之前的小行星发生碰撞。碰撞只会发生在以下情况：
     *    - 当前小行星向左移动（值为负）&& 栈顶的小行星向右移动（值为正）
     * 碰撞处理：
     *    - 如果当前小行星较大，栈顶小行星被摧毁（出栈），继续检查下一个栈顶元素
     *    - 如果大小相等，两个小行星都被摧毁（当前的不入栈，栈顶出栈）
     *    - 如果栈顶小行星较大，当前小行星被摧毁（不入栈）
     * Pay Attention:
     * 只有当右移（正值）小行星位于左移（负值）小行星的左侧时，才会发生碰撞
     */
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int num : asteroids){
            boolean survive = true;
            while(!stack.isEmpty() && (stack.peek()>0 && stack.peek() * num<0)){
                if(stack.peek() > -num){
                    survive = false;
                    break;
                }
                else if(stack.peek() == -num){
                    stack.pop();
                    survive = false;
                    break;
                }
                else{
                    stack.pop();
                    survive = true;
                }
            }
            if(survive) stack.push(num);
        }
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i--;
        }
        return res;
    }
}
