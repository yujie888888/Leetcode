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
public class LC19_RemoveNthNode {
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

    /**常规做法
     * O(n) Beats 100%
     * O(1) Beats 90%
     * 思路：
     * 这做法对ListNode的底层逻辑不清楚的话还真要搞死
     * 1.设置两个指针，pre和cur
     * 2.找到要删除的node的位置
     * 3.pre.next = cur.next实现删除node
     * 注意事项：
     * 1.一定要返回dummy.next,如果返回head，如果head也是目标结点，那么不会返回正确值
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;

        int size = 1;
        ListNode node = head;
        while(node.next != null){
            size++;
            node = node.next;
        }

        int index = size - n;
        node = head;
        ListNode pre = new ListNode(-1);
        pre.next = node;
        ListNode dummy = new ListNode(-1);
        dummy = pre;
        int i = 0;
        while(i<index){
            pre = node;
            node = node.next;
            i++;
        }
        pre.next = node.next;
        return dummy.next;
    }

    /**Tow Pointers
     * O(n) Beats 100%
     * O(1) Beats 95%
     * 思路:
     * 不太好想，但其实不难
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
        // 这里如果fast先走n步，当fast再和slow一起走直到fast为null时，slow的位置是正好要删除的位置
        // 但是删除需要一个pre，为了避免再多一个pre的空间，之间定位到要删除的前一个位置，所以这里走了n+1步
        for(int i=0; i<=n; i++){
            fast = fast.next;
        }
        // 找要删除的前一个位置
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        // 删除
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
