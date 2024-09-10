package DataStruc_LinkedList;

public class LC92_ReverseLinkedListII {
    private static class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        int n = 5;
        ListNode dummy = new ListNode(-1);
        ListNode head = new ListNode(1);
        dummy.next = head;
        for(int i=2; i<=n; i++){
            head.next = new ListNode(i);
            head = head.next;
        }
        int left = 3;
        int right = 4;
        ListNode res = reverseBetween(dummy.next,left,right);
        while(res != null){
            System.out.print(res.val+" ");
            res = res.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || right == left) return head;
        ListNode preStart = null;
        ListNode cur = head;
        for(int i=0; i<left-1; i++){
            preStart = cur;
            cur = cur.next;
        }
        ListNode startNode = cur;

        ListNode pre = null;
        for(int i=0; i<=right-left; i++){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        ListNode endNode = pre;
        ListNode afterEndNode = cur;

        if(preStart == null){
            startNode.next = afterEndNode;
            return endNode;
        }
        preStart.next = endNode;
        startNode.next = afterEndNode;
        return head;
    }
}
