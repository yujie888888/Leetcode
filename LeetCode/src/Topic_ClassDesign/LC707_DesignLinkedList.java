package Topic_ClassDesign;

/**Double Linked List
 * O(n)
 * Ideas:
 * 很巧妙的一点，记录size
 */
class MyLinkedList {
    private class DListNode{
        int val;
        DListNode pre;
        DListNode next;

        public DListNode(){}

        public DListNode(int val){
            this.val = val;
        }
    }

    int val;
    int size;
    DListNode head;
    DListNode tail;

    public MyLinkedList(){
        head = new DListNode(-1);
        tail = new DListNode(-1);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int get(int index){
        DListNode node = insertHead(index).next;
        if(node != null) return node.val;
        else return -1;
    }

    public void addAtHead(int val){
        DListNode node = new DListNode(val);
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
        size++;
    }

    public void addAtTail(int val){
        DListNode node = new DListNode(val);
        tail.pre.next = node;
        node.pre = tail.pre;
        tail.pre = node;
        node.next = tail;
        size++;
    }

    public void addAtIndex(int index, int val){
        if(index > size) return;
        DListNode node = new DListNode(val);
        DListNode prev = insertHead(index);
        prev.next.pre = node;
        node.next = prev.next;
        prev.next = node;
        node.pre = prev;
        size++;
    }

    public void deleteAtIndex(int index){
        if(index >= size) return;
        DListNode node = insertHead(index).next;
        if(node != null){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }
    }

    public DListNode insertHead(int index){
        DListNode pre = head;
        for(int i=0; i<index; i++){
            pre = pre.next;
        }
        return pre;
    }
}

public class LC707_DesignLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(4);
        System.out.println(list.get(0));
    }
}
