/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * Constraints:
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 */
package DataStruc_LinkedList;
import Class_ListTree.ListNode;

public class LinkedListCycle141 {
    public static void main(String[] args) {
        ListNode n4 = new ListNode(-4);
        ListNode n3 = new ListNode(0,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(3,n2);
        n4.next = n2;
        System.out.println(hasCycle(n1));
    }
    /**判断linklist是否成环
     * O(n) Beats 100%
     * O(1) Beats 90%
     * 思路：
     * 1.设置两个指针，从head开始
     * 2.slow走一步，fast走两步
     *      如果成环，那么slow和fast必然会相遇
     *      如果不成环，那么fast一定会指向null
     * 注意事项：
     * 1.因为fast每次走两步，所以如果fast.next==null时fast.next.next没有意义
     *   这时看fast.next会发现如果fast.next==null也能说明并不成环，和fast==null(走到尽头)一样作为判断条件
     */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
