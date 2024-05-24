/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Example 21:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 * Constraints:
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
package DataStruc_LinkedList;
public class RemoveNthNode19 {
    public static void main(String[] args) {
        //Set Value
        int[] nums = {1,2,3,4,5};
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        //printLine(removeNthFromEnd1(dummy.next,2));
        printLine(removeNthFromEnd2(dummy,2));
    }

    /**(推荐)常规做法
     * O(n) Beats 100%
     * O(1) Beats 90%
     * 思路：
     * 1.设置两个指针，pre和cur
     * 2.找到要删除的node的位置
     * 3.pre.next = cur.next实现删除node
     * 注意事项：
     * 1.一定要返回dummy.next,如果返回head，如果head也是目标结点，那么不会返回正确值
     */
    public static ListNode removeNthFromEnd1(ListNode head,int n){
        //base case
        if(head == null) return null;
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len ++;
            cur = cur.next;
        }
        //base case
        if(n>len) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        cur = head;
        for(int i=0; i<len-n; i++){
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur.next;
        return dummy.next;
    }

    /**双指针找位置法,思路不如上面的方法清晰，不推荐
     * O(n) Beats 100%
     * O(1) Beats 95%
     * 思路:
     * 1.设置两个指针slow和fast
     * 2.fast先走n步
     * 3.slow和fast一起前进直到fast为空
     * 4.此时slow指向的就是要删除的位置的前一个结点位置
     */
    private static ListNode removeNthFromEnd2(ListNode dummy,int n){
        //base case
        if(dummy.next == null) return null;

        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i=0; i<=n; i++){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    private static void printLine(ListNode head){
        ListNode cur = head;
        System.out.print("[");
        while(cur != null){
            System.out.print(cur.next == null? cur.getVal() : cur.getVal()+",");
            cur = cur.next;
        }
        System.out.print("]");
    }
}
