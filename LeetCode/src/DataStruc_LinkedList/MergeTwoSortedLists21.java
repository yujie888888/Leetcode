/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
package DataStruc_LinkedList;
import Class_ListTree.ListNode;
public class MergeTwoSortedLists21 {
    public static void main(String[] args) {
        int[] list1 = {1,2,4};
        int[] list2 = {1,3,4};
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode pre1 = dummy1;
        ListNode pre2 = dummy2;
        for(int num : list1){
            pre1.next = new ListNode(num);
            pre1 = pre1.next;
        }
        for(int num : list2){
            pre2.next = new ListNode(num);
            pre2 = pre2.next;
        }
        ListNode res = mergeTwoLists(dummy1.next,dummy2.next);
        System.out.print("[");
        while(res!=null){
            System.out.print(res.getVal()+",");
            res = res.next;
        }
        System.out.print("]");
    }

    /**
     * O(m+n) Beats 100%
     * 思路:
     * 用两个指针，逐个比较数值大小
     * 用dummy作为res，指向下一个要加入的node
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while(node1!=null && node2!=null){
            if(node1.getVal() <= node2.getVal()){
                pre.next = node1;
                node1 = node1.next;
            }
            else{
                pre.next = node2;
                node2 = node2.next;
            }
            pre = pre.next;
        }
        while(node1!=null){
            pre.next = node1;
            node1 = node1.next;
            pre = pre.next;
        }
        while(node2!=null){
            pre.next = node2;
            node2 = node2.next;
            pre = pre.next;
        }
        return dummy.next;
    }

}
