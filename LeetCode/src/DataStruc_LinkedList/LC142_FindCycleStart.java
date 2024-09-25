package DataStruc_LinkedList;
import java.util.HashSet;

public class LC142_FindCycleStart {
    public static void main(String[] args) {

    }
    /**HashSet
     * O(n)
     * 看入点是否出现了两次
     */
    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) {
                return cur;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }
    /**特殊解法
     * O(1)
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
    public ListNode detectCycle2(ListNode head) {
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
