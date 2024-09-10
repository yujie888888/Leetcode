package DataStruc_LinkedList;
import Class_ListTree.ListNode;
public class LC206_ReverseLinkedList {
    /**给testcase赋值
     * 注意事项：
     * 1.要事先声明一个head，方便下面将linkedlist作为参数传进方法
     * 2.每次存入值，都要新建一个ListNode；并且必须声明指向关系: pre.next
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = new ListNode(arr[0]);
        ListNode pre = head;
        for (int i=1; i<arr.length; i++) {
            pre.next = new ListNode(arr[i]);
            pre = pre.next;
        }
        printList(Reverse(head));
    }

    /**
     * O(n) Beats 100%
     * O(1) Beats 80%
     * 思路：
     * 1.循环两两reverse指向关系
     *      reverse就相当于改变两两node之间的指向关系
     *      循环条件是cur!=null
     *      因为cur如果为空，cur.next会报错
     * 2.所以设置两个point，pre和cur
     *      pre是null，cur是head
     *      注意pre的初始值赋值是null，如果pre存在值，那么最后返回的结果中一定会包含这个值
     * 3.将cur和pre之间的指向关系reverse
     *      cur.next -> pre
     *      注意在这一步之后，cur.next如果不存一下，就丢失了
     * 4.pre和cur往前进1，pre = cur; cur = temp;
     *   为什么这里pre不=pre.next，因为pre是没有指向关系的，如果有pre.next=cur,那么会成环，就不是单链表了；
     */
    private static ListNode Reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp;

        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
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
