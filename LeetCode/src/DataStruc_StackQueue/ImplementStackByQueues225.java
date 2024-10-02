
package DataStruc_StackQueue;
import java.util.ArrayDeque;

public class ImplementStackByQueues225 {
    public static void main(String[] args) {

    }
}
/**
 * Ideas:
 * use two queue
 * queue1 used for store data as stack
 * queue2 usde for help queue1
 * core
 *      for the new val
 *          queue2.add(val) 把new val放进queue2
 *          while() {queue2.add(queue1.poll())} 把queue1里的数依次放进queue2
 *          swap queue1 and queue2
 *     这样依次放位置，就实现了stack，演示一下就明白了
 * 初始化：
 *      1.首先定义ArrayDeque<Integer> queue1;
 *      2.然后在Mystack中初始化queue1和queue2
 *      Class MyStack的两个属性，queue1 和 queue2，它们都是 ArrayDeque<Integer> 类型
 *      构造器MyStack()是一个公开的无参数构造器。构造器的主要作用是初始化对象的状态。
 * push()代码逻辑
 *  1.用两个队列queue1和queue2
 *  2.queue2临时存放加进来的元素
 *  3.然后将queue1中的元素加到queue2的尾端
 *  4.然后交换queue1和queue2
 *  经过234,这样在queue1中新加入进来的元素肯定在头部
 *  注意：
 *      如果用这个：
 *          queue1 = queue2;
 *          queue2.clear();
 *      queue1和queue2都会为空，因为指向的同一个queue
 */
class MyStack {

    ArrayDeque<Integer> queue1;
    ArrayDeque<Integer> queue2;
    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }
    /*
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
