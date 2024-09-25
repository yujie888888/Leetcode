package DataStruc_StackQueue.ALG_MonotonicStack;
import java.util.Arrays;
import java.util.Stack;

public class LC739_DailyTemperatures {
    /**Monotonic Stack
     * O(n)
     * O(n)
     * 思路：
     * 这道题本质上求的是对于temperature数组中的每一个元素，求这个元素右边第一个比它大的元素的位置
     * 要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置，此时我们就要想到可以用单调栈了
     * 单调栈实际上就是用空间换时间
     * 1.首先，有一个stack
     *      明确stack是后进先出，也就是stack.pop()是最后一个进来的元素；
     *      stack.peek()是最后一个元素；
     *      stack的栈头是最后一个元素加入的地方，栈尾是指最先被加入的元素的位置
     * 从栈头到栈尾一定是递增的，换句话说，从栈尾到栈头是递减的；
     * 因为只有这样才知道栈顶元素遇到的下一个比它大的元素是右边第一个比它大的元素
     *      同理，如果求元素右边第一个比它小的元素，栈顶到栈底就是递减的
     * 2.遍历元素
     *      当前遍历的元素T[i]小于栈顶元素T[st.top()]的情况：直接push进stack
     *      当前遍历的元素T[i]等于栈顶元素T[st.top()]的情况：直接push进stack
     *      当前遍历的元素T[i]大于栈顶元素T[st.top()]的情况：记录res[stack.peek()]=i 并将栈顶元素弹出stack.pop()，表示已经找到了栈顶元素的结果
     * 3.可以先把0push进stack，也可以在遍历的时候包含进去；
     *      但是因为栈在遍历的过程中会出现空栈的情况，所以正确做法是在遍历的时候把!stack.isEmpty()这个加入判断条件
     */
    public static void main(String[] args){
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] res = new int[n];
        Arrays.fill(res,0);

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                res[stack.peek()] = i-stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
    }
}
