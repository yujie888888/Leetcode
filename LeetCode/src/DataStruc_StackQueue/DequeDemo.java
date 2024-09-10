package DataStruc_StackQueue;
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    public static void main(String[] args) {
        //Deque 是双端队列的简称，允许在队列的两端进行插入和删除操作

        //ArrayDeque 是 Java 集合框架中的一个类，它实现了 Deque 接口
        //ArrayDeque 可以作为栈（后进先出，LIFO）或队列（先进先出，FIFO）来使用
        //❗️❗️在 ArrayDeque 中，头 和 尾 是动态的，并且根据插入和移除操作不断变化。头部是指最早被插入的位置，而尾部是指最近被插入的位置❗️❗️

        //add(E e): 在队列的末尾添加元素，如果添加成功则返回 true。如果没有空间，则抛出 IllegalStateException
        //addFirst(E e): 在队列的开头插入元素
        //addLast(E e): 在队列的末尾插入元素（等价于 add(E e)）
        //offer(E e): 类似于 add(E e)，但如果没有空间则返回 false，而不是抛出异常
        //offerFirst(E e): 尝试在队列的开头插入元素，如果成功则返回 true，否则返回 false
        //offerLast(E e): 尝试在队列的末尾插入元素，如果成功则返回 true，否则返回 false
        //remove(): 移除并返回队列头部的元素，如果队列为空则抛出 NoSuchElementException
        //removeFirst(): 移除并返回队列头部的元素（与 remove() 相同）
        //removeLast(): 移除并返回队列尾部的元素
        //poll(): 移除并返回队列头部的元素，如果队列为空则返回 null。
        //pollFirst(): 移除并返回队列头部的元素（与 poll() 相同）。
        //pollLast(): 移除并返回队列尾部的元素，如果队列为空则返回 null
        //peek(): 返回队列头部的元素但不移除它，如果队列为空则返回 null。
        //peekFirst(): 返回队列头部的元素但不移除它（与 peek() 相同）。
        //peekLast(): 返回队列尾部的元素但不移除它


        //Mock Queue
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        queue.add(1);
        queue.add(2);
        //now the head of ArrayDeque is 0, and tail of ArrayDeque is 2
        queue.poll(); //FIFO

        System.out.println(queue);

        //Mock Stack
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(0);
        stack.add(1);
        stack.add(2);
        //now head of ArrayDeque is 0, and tail of ArrayDeque is 2;
        stack.pollLast();//LIFO

        System.out.println(stack);








    }
}
