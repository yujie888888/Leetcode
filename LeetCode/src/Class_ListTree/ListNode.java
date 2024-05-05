package Class_ListTree;

public class ListNode {
    public ListNode next;
    private int val;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
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
