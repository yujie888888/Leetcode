/**
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
 * It is -1 if there is no cycle. Note that pos is not passed as a parameter.
 * Do not modify the linked list.
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: no cycle
 * Explanation: There is no cycle in the linked list.
 * Constraints:
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 */
package DataStruc_LinkedList.CycleLinkedList142;
public class FindCycleStart {
    /**本地做不了，没法处理输入
     * 这道题有点特殊，有专门的解题思路
     * 1、设两个指针fast和slow
     * 2、两个指针都从head出发，slow走一步，fast走两步
     * 3、这样，只要链表中有环，这两个指针就一定会在环中相遇(到这里为止，就是判断一个链表有没有环的步骤)
     * 4、假设环之前有x个节点，相遇点和环的起始点之间有y个节点，那么slow肯定走了x+y
     * 5、我试了几种情况，slow肯定是在第一次进入环的时候和fast相遇
     * 6、fast与slow相遇之前，走了x+y+n(y+z),z是环内从相遇点到环起始点的节点数，n是fast在环内走了几圈
     * 7、由于fast比slow快两倍，所以 x+y+n(y+z)=2(x+y)
     * 8、化简：x=n(y+z)-y -> x=(n-1)(y+z)+z
     * 9、理解这个公式，也就是说当n为1，!!相遇点到环起始点的节点数量z==x!!
     * 10、其实当n!=1的时候也是一样的，环多少圈不影响这个推导
     */
    public static void main(String[] args) {
        /*
        public class Solution {
            public ListNode detectCycle(ListNode head) {
                ListNode slow = head;
                ListNode fast = head;
                //要进行检查，如果fast==null或者fast.next==null，也就是是一个空链表或者只存在一个元素
                //那么没必要进行环路检查，肯定是不存在环路的
                //对于这些输入，这时直接返回(-1)no cycle就可以，但是先不着急返回，后面还有，当然在这里写了，后面再写也没事
                //环路检查
                while(fast != null && fast.next != null){
                    slow = slow.next;
                    fast = fast.next.next;
                    if(slow == fast){
                        break;
                    }
                }
                //检查结束后，如果不存在环路，那么fast==null或者fast.next==null，和前面输入的情况一样，直接一起return null。
                if(fast == null || fast.next ==null) return null;

                //对于存在环路，也就是找到了meet的点的情况下，从head和相遇点进行对向操作，相遇的点就是start环的位置
                ListNode index1 = head;
                ListNode index2 = slow;
                while(index1!=index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
         */


    }

















}
