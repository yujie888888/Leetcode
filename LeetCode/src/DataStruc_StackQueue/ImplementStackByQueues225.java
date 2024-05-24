/**
 * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
 * Implement the MyStack class:
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 * You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 * Example 1:
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 * Constraints:
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 * Follow-up: Can you implement the stack using only one queue?
 */
package DataStruc_StackQueue;
import java.util.ArrayDeque;

public class ImplementStackByQueues225 {
    public static void main(String[] args) {

    }
}
/**代码逻辑题
 * 思路：
 * 1.利用两个队列（queue1 和 queue2）
 * 2.实现stack.push(int x) - 将元素 x 压入栈顶。
 * 2.实现stakc.pop() - 移除栈顶元素，并返回该元素。
 *      直接从queue1中移除并返回前端的元素即可。
 * 3.实现stack.top() - 返回栈顶元素，但不移除它。
 *      直接返回 queue1 的前端元素。
 * 4.实现stack.empty() - 如果栈为空，返回 true；否则返回 false。
 *      检查 queue1 是否为空。
 */
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
class MyStack {
    /**初始化
     * 1.首先定义ArrayDeque<Integer> queue1;
     * 2.然后在Mystack中初始化queue1和queue2
     * Class MyStack的两个属性，queue1 和 queue2，它们都是 ArrayDeque<Integer> 类型
     * 构造器MyStack()是一个公开的无参数构造器。构造器的主要作用是初始化对象的状态。
     */
    ArrayDeque<Integer> queue1;
    ArrayDeque<Integer> queue2;
    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }
    /**push()代码逻辑
     * 思路：
     * 1.用两个队列queue1和queue2
     * 2.queue2临时存放加进来的元素
     * 3.然后将queue1中的元素加到queue2的尾端
     * 4.然后交换queue1和queue2
     * 经过234,这样在queue1中新加入进来的元素肯定在头部
     */
    public void push(int x) {
        queue2.add(x);
        while(!queue1.isEmpty()){
            queue2.add(queue1.remove());
        }
        ArrayDeque<Integer> temp;
        //swap重新置空queue2
        temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    public int pop() {
        return queue1.remove();
    }
    public int top() {
        return queue1.peek();
    }
    public boolean empty() {
        return(queue1.isEmpty());
    }
}
