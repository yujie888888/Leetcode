/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * Constraints:
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
package Struc_linked_list;
import Class_ListTree.ListNode;

public class AddTwoNumbers2{
    /**代码逻辑题
     * O(n) Beats 100%
     * O(n) Beats 96%
     * 思路：
     * 在做之前，得注意到The number of nodes in each linked list is in the range [1, 100].这个条件
     * 说明最多会有100位的数字的test case，所以直接将两个值相加对sum操作是行不通的，因为找不到一个类型存储这么大的数
     * 所以一开始的思路是将list转换成int格式，行不通的，超出long的定义范围了
     * 新思路：
     * 由题目的要求能得出，其实就是从l1和l2的头结点开始，依次将结点的值相加；
     * 需要注意l1和l2的长度并不相同，所以要处理l1和l2循环到null的情况
     * 对于0-9的数字相加，存在一个两位数的情况：
     *      1.sum < 10，直接将sum放进l3
     *      2.sum >= 10, 将个位digit放进l3，将进位carry存起来，等待和下一次循环里的结果相加
     * 所以每次计算数的时候num = l1处val+l2处val+上一次循环遗留的carry
     * carry是sum/10得到的，也就是十位上的值
     * 如果l1和l2都到头了，以及carry也到0了，那么说明循环结束了
     * 循环条件就是l1!=null || l2!=null || carry != 0
     */
    public static void main(String[] args) {
        //int[] nums1 = {2,4,9};
        int[] nums1 = {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        //int[] nums2 = {5,6,4,9};
        int[] nums2 = {5,6,4};
        ListNode l1 = buildList(nums1);
        ListNode l2 = buildList(nums2);

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int carry = 0;
        int digit;
        while(l1!=null || l2!=null || carry != 0){
            int num1 = l1 == null ? 0 : l1.getVal();
            int num2 = l2 == null ? 0 : l2.getVal();
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            digit = sum % 10;

            pre.next = new ListNode(digit);
            pre = pre.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        printList(dummy.next);
    }
    public static ListNode buildList(int[] num){
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        for(int n : num){
            pre.next = new ListNode(n);
            pre = pre.next;
        }
        return dummy.next;
    }
    public static void printList(ListNode cur){
        while(cur != null){
            System.out.print(cur.getVal() + ", ");
            cur = cur.next;
        }
    }

}
