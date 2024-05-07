/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * Eg1.
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * Example 2:
 * Input: head = []
 * Output: []
 * Example 3:
 * Input: head = [1]
 * Output: [1]
 * Constraints:
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */
package Struc_linked_list;
import java.util.Scanner;

public class SwapNodesinPairs24 {
    public static void main(String[] args) {
        // 递归swap(pre,cur)
        // 为了保持操作的一致性，在头和尾增加两个dummy(不用，只加一个头dummy就可以)
        // 执行的操作是：交换，并且前后的元素的指向也要改变，大约有四步(其实是三步，这三步很容易搞不清楚)

        Scanner sc = new Scanner(System.in);
        System.out.println("Please input line:");
        String inputLine = sc.nextLine();
        if(inputLine == ""){
            System.out.println("[]");
            return;
        }
        String[] line = inputLine.split(",");

        ListNode head = new ListNode(Integer.parseInt(line[0]));
        ListNode dummy = new ListNode();
        dummy.next = head;

        //值存入listNode
        ListNode cur = head;
        for (int i = 1; i < line.length; i++) {
            cur.next = new ListNode(Integer.parseInt(line[i]));
            cur = cur.next;
        }

        swap(dummy);
        printList(dummy);
    }

    //传一个节点就能知道四个节点了
    private static void swap(ListNode pre){
        if(pre.next == null || pre.next.next == null) return;
        /* 交换值cur和cur.next  改变交换值的两侧的指向
        这种多个值进行数据交换的时候，很容易逻辑不清晰，可以先打个草稿，看看会改变的是哪几个变量的值，后续是不是会用到这些变量，是就存temp
        first和second不仅仅是用来临时存储原始数据的节点，它们实际上是参与交换的两个相邻节点，只是起了个名字，用起来比较方便而已
        通过改变节点间的链接（即它们的next指针），而不是修改节点内的数据，来实现节点的交换
        交换顺序必须按照这个原则：
        保持链表的完整性：这个顺序确保在交换过程中，链表的其他部分不会丢失或断开
        */
        ListNode first = pre.next;
        ListNode second = first.next;

        //这个b顺序不能改变
        first.next = second.next;
        second.next = first;
        pre.next = second;

        /*错误演示
        ListNode temp1,temp2;
        temp1 = pre.next.next;
        temp2 = pre.next.next.next;//temp2有可能为空，为空就为空，应该不会报错
        pre.next.next = temp2;
        //不能这样写，pre.next.next已经是temp2，这时如果pre.next.next.next再去赋值就出错了
        pre.next.next.next = pre.next;
        pre.next = temp1;
         */
        swap(pre.next.next);
    }

    private static void printList(ListNode dummy){
        ListNode cur = dummy.next;
        while(cur!=null){
            System.out.print(cur.next == null ? cur.getVal() : cur.getVal()+",");
            cur = cur.next;
        }
    }
}
