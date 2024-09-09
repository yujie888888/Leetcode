package DataStruc_StackQueue;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class LC23_MergeKSortedLists {
    public static void main(String[] args) {

    }

    /**
     * O(n*m)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        ListNode dummy  = new ListNode(0);

        for (ListNode node : lists) {
            dummy.next = node;
            while(node != null){
                minHeap.add(node);
                node = node.next;
            }
        }
        if(minHeap.isEmpty()) return null;

        ListNode node = new ListNode(minHeap.poll().val);
        dummy.next = node;
        while(!minHeap.isEmpty()){
            node.next = new ListNode(minHeap.poll().val);
            node = node.next;
        }
        return dummy.next;
    }
}

