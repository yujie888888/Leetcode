/**
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
package DataStruc_StackQueue;
import java.util.Stack;

public class ImplementQueueByStack232 {
    public static void main(String[] args) {
        MyQueue q1 = new MyQueue();
        q1.push(1);
        q1.push(2);
        System.out.println(q1.peek());
        System.out.println(q1.pop());
        System.out.println(q1.empty());
    }
}
/**使用两个栈来模拟队列的操
 * Beats 100%
 * 思路:
 * s1和s2不可能同时都有值，经过操作后，肯定是只有一个栈包含全部的值
 * 模拟题，记住怎么做就行了
 * 1.初始化 (MyQueue)
 *      stack1: 负责处理所有的入队 (push) 操作,新元素总是被推入 stack1。
 *      stack2: 负责处理所有的出队 (pop) 和查看队首元素 (peek) 操作。
 * 2.入队 (push)
 *      if(s2为空) 直接将元素推入 stack1  O(1)
 *      if(s2不为空) 将s2中的元素依次pop到s1中，在将xpush进s1  O(n)
 * 3.出队 (pop)
 *      if(s2为空)，则将s1中的所有元素依次弹出并推入s2  //
 *          这样做的目的是反转s1中元素的顺序，使得最先进入s1的元素移动到s2的顶部，从而可以首先被弹出，符合队列的先进先出 (FIFO) 特性
 *          s2.pop()
 *      if(s2不为空),则直接s2.pop()即可
 *      这个操作在均摊分析下是 O(1)，因为每个元素只会被移动两次（一次进入 stack1，一次转移到 stack2）。
 * 4.查看队首元素 (peek)
 *      和pop几乎一样
 * 5.检查队列是否为空 (empty)
 *      如果 stack1 和 stack2 都为空，则队列为空，返回 true。
 *          检查两个都为空才可以是因为如果stack2为空，stack1不为空的情况下，只是stack1还没将内容压进stack2而已
 *      否则，返回 false。
 */
class MyQueue {
    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    public void push(int x){
        if(s2.isEmpty()) s1.push(x);
        else{
            while(!s2.isEmpty()) s1.push(s2.pop());
            s1.push(x);
        }
    }
    public int pop(){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }
    public int peek(){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2.peek();
    }
    public boolean empty(){
        return (s1.isEmpty() && s2.isEmpty());
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
