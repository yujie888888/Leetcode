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
package Struc_stackQueue;
import java.util.ArrayDeque;

public class ImplementStackByQueues225 {
    public static void main(String[] args) {

    }

}
/**
 * 利用两个队列（queue1 和 queue2）
 * push(int x) - 将元素 x 压入栈顶。
 * 将元素先加入到空的队列（比如 queue2）中，然后将另一个队列（queue1）中的所有元素按顺序加入到 queue2 中。
 * 交换 queue1 和 queue2 的角色，使得 queue1 始终包含栈的所有元素，queue2 用于辅助操作。
 *
 * pop() - 移除栈顶元素，并返回该元素。
 * 直接从 queue1 中移除并返回前端的元素即可。
 *
 * top() - 返回栈顶元素，但不移除它。
 * 直接返回 queue1 的前端元素。
 *
 * empty() - 如果栈为空，返回 true；否则返回 false。
 * 检查 queue1 是否为空。
 */
class MyStack {
    ArrayDeque<Integer> queue1;
    ArrayDeque<Integer> queue2;
    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

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

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
