/**
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val,
 * and return the new head.
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * Example 2:
 * Input: head = [], val = 1
 * Output: []
 * Example 3:
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 * Constraints:
 * The number of nodes in the list is in the range [0, 104].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
package Struc_linked_list;
public class RemoveElements203 {
    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        /**给ListNode赋值
         * O(n)
         * 思路：
         * 1.设置一个虚拟结点，设置一个cur结点
         * 2.cur=dummy
         * 3.依次创建cur.next结点,这一步实现创建新结点以及建立关系
         * 4.移动cur
         */
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for(int num : nums){
            // create new node && set link relationship
            cur.next = new ListNode(num);
            // move to the next
            cur = cur.next;
        }
        ListNode head = removeElements(dummy.next,6);
        while(head != null){
            if(head.next == null) System.out.println(head.val);
            else System.out.print(head.val+",");
            head = head.next;
        }
    }

    /**常规做法
     * O(n) Beats 92%
     * 思路:
     * 1.遍历每个node
     * 2.对node.val==val的点,将pre.next指向cur.next
     * 注意事项：
     * 1.dummy一定要和head连起来
     * 2.return的值一定是dummy.next，不然遇到head = [7,7,7,7], val = 7这种情况会出问题
     */
    public static ListNode removeElements(ListNode head, int val) {
        //base case
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = cur.next;
            }
            else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}




