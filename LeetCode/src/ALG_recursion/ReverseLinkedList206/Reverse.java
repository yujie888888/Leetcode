package ALG_recursion.ReverseLinkedList206;

import java.util.Scanner;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Ex1：
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Ex2：
 * Input: head = [1,2]
 * Output: [2,1]
 * Ex3：
 * Input: head = []
 * Output: []
 * Constraints:
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 */
public class Reverse {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input list:");
        String inputLine = sc.nextLine();
        //System.out.println("inputLine is:"+inputLine);
        //输入为空的处理
        //注意这里String类型的为空是""
        if(inputLine == ""){
            System.out.println("[]");
            return;
        }

        //处理输入
        String[] line = inputLine.split(",");
        //System.out.println(line[0]);

        //将值存入ListNode,这个操作和对已经存在的ListNode操作不一样，很考验对链表的理解
        //得留个头，不然后面都不知道对谁进行操作
        ListNode pre = new ListNode(Integer.parseInt(line[0]));
        ListNode head = pre;
        for (int i = 1; i < line.length; i++) {
            //每次存入值，都要新建一个ListNode
            //必须声明指向关系: pre.next
            pre.next = new ListNode(Integer.parseInt(line[i]));
            pre = pre.next;
        }
        //检查存入情况
        //printList(head);

        //双指针Reverse
        //printList(Reverse(head));

        //双指针递归Reverse
        printList(reverseList(head));
    }

    //Reverse改变链表指向
    //双指针法O(n)
    private static ListNode Reverse(ListNode head){
        ListNode cur = head;
        //只是一个空的
        ListNode pre = null;
        ListNode temp;

        //必须理清一件事：.next代表指向
        while(cur != null){
            //每次循环只做一次指向变化
            temp = cur.next;
            //cur指向pre
            cur.next = pre;
            //pre和cur要继续移动
            pre = cur;
            cur = temp;
        }
        //这里不能直接返回dummy，因为指向都变了,所以返回pre
        return pre;
    }

    //双指针递归法O(n)
    private static ListNode reverseList(ListNode head){
        return reverseD(null,head);
    }
    private static ListNode reverseD(ListNode pre, ListNode cur){
        if(cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return reverseD(cur,temp);
    }

    private static void printList(ListNode cur){
        System.out.print("[");
        while(cur!=null){
            System.out.print(cur.next != null ? cur.getVal()+"," : cur.getVal());
            cur = cur.next;
        }
        System.out.print("]");

    }
}
