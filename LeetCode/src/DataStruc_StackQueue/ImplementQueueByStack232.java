package DataStruc_StackQueue;

import java.util.Stack;

/** 用stack模拟queue
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue
 * (push, peek, pop, and empty).
 * Implement the MyQueue class:
 * void push(int x) Pushes element x to the back of the queue.
 * int pop() Removes the element from the front of the queue and returns it.
 * int peek() Returns the element at the front of the queue.
 * boolean empty() Returns true if the queue is empty, false otherwise.
 * Notes:
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue)
 * as long as you use only a stack's standard operations.
 * Example 1:
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * Constraints:
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, peek, and empty.
 * All the calls to pop and peek are valid.
 * Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity?
 * In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
 */
public class ImplementQueueByStack232 {
    public static void main(String[] args) {

    }
}

/**使用两个栈（stack1 和 stack2）来模拟队列的操 100%
 * 1.初始化 (MyQueue)
 *      栈1 (stack1): 负责处理所有的入队 (push) 操作。新元素总是被推入 stack1。
 *      栈2 (stack2): 负责处理所有的出队 (pop) 和查看队首元素 (peek) 操作。
 *          当 stack2 为空，从 stack1 中转移元素到 stack2 来进行出队或查看操作,没有必要每次都转移。
 * 2.入队 (push)
 *      直接将元素推入 stack1。这是一个 O(1) 的操作，非常高效。
 * 3.出队 (pop)
 *      如果 stack2 为空，则将 stack1 中的所有元素依次弹出并推入 stack2。
 *          这样做的目的是反转 stack1 中元素的顺序，使得最先进入 stack1 的元素移动到 stack2 的顶部，从而可以首先被弹出，符合队列的先进先出 (FIFO) 特性。
 *      然后从 stack2 弹出和返回顶部元素作为出队结果。
 *      这个操作在均摊分析下是 O(1)，因为每个元素只会被移动两次（一次进入 stack1，一次转移到 stack2）。
 * 4.查看队首元素 (peek)
 *      类似于 pop 操作，如果 stack2 为空，则从 stack1 转移所有元素到 stack2，以确保 stack2 的顶部元素是最先进入队列的元素。
 *      返回 stack2 的顶部元素，但不从栈中移除它。
 *      这个操作也是均摊 O(1)。
 * 5.检查队列是否为空 (empty)
 *      如果 stack1 和 stack2 都为空，则队列为空，返回 true。
 *          检查两个都为空才可以是因为如果stack2为空，stack1不为空的情况下，只是stack1还没将内容压进stack2而已
 *      否则，返回 false。
 */
class MyQueue {
    //用两个stack实现queue的操作
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    //初始化
    public MyQueue() {
        //1负责入队
        stack1 = new Stack<>();
        //2负责出队
        stack2 = new Stack<>();
    }
    //入队
    public void push(int x) {
        stack1.push(x);
    }
    //出队
    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public int peek() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    public boolean empty() {
        if(stack1.empty() && stack2.empty()) return true;
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
