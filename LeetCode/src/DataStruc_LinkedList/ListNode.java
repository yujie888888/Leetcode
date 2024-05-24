package DataStruc_LinkedList;

public class ListNode{
    ListNode next;
    int val;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.next = next;
        this.val = val;
    }
    public int getVal(){
        return this.val;
    }
    public void setVal(int val){
        this.val = val;
    }
}
