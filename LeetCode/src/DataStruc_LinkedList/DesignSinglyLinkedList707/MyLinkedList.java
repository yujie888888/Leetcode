package DataStruc_LinkedList.DesignSinglyLinkedList707;

/**
 * 在链表类中实现这些功能：
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为val的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 */

public class MyLinkedList {
    int size;
    ListNode dummy;

    //无参构造器，初始化链表
    public MyLinkedList(){
        size = 0;
        //dummy.next为空 要赋值，不然dummy不是一个结点
        dummy = new ListNode();
    }

    //Add Head
    public ListNode addAtHead(int val){
        return addAtIndex(0,val);
    }

    public ListNode addAtTail(int val){
        return addAtIndex(size,val);
    }

    public ListNode addAtIndex(int index, int val){
        if(index>size) return dummy.next;
        //找到index对应的位置
        ListNode pre = searchLocation(index);
        //插入值
        ListNode newNode = new ListNode(val);
        // 在addhead的情况下，pre.next是null。
        // .next为空是没有关系的，但是如果cur.next情况下，cur为空，就会报错了。
        newNode.next = pre.next;
        pre.next = newNode;
        size++;

        return dummy.next;
    }

    public int get(int index){
        if(index>=size) return -1;
        //找到位置
        ListNode pre = searchLocation(index);
        //get value
        return pre.next.getVal();
    }

    public ListNode deleteAtIndex(int index){
        if(index>=size || index<0) return dummy.next;
        //找删除的位置
        ListNode pre = searchLocation(index);
        //删除
        pre.next = pre.next.next;
        size--;
        return dummy.next;
    }

    public ListNode searchLocation(int index){
        ListNode pre = dummy;
        for (int i = 0; i < index; i++) pre = pre.next;
        return pre;
    }
}
