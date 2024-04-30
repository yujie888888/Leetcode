package ALG_Recursive;
import List_Tree.ListNode;
public class ReverseLinkedList206 {
    /**给testcase赋值
     * 注意事项：
     * 1.要事先声明一个head，方便下面将linkedlist作为参数传进方法
     * 2.每次存入值，都要新建一个ListNode；并且必须声明指向关系: pre.next
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = new ListNode(arr[0]);
        ListNode pre = head;
        for (int i=1; i<arr.length; i++) {
            pre.next = new ListNode(arr[i]);
            pre = pre.next;
        }
        //printList(Reverse1(head));
        printList(Reverse2(null,head));
    }

    /**直接改变两个node的指向关系(Two points)
     * O(n) Beats 100%
     * O(n) Beats 80%
     * 思路：
     * 1.reverse就相当于改变两两node之间的指向关系
     * 2.所以设置两个point，pre和cur，pre一开始是null的(?)，cur是head
     * 3.然后依次将cur.next -> pre, 注意在这一步之后，cur.next如果不存一下，就丢失了
     * 4.pre和cur往前进1，pre = cur; cur = temp;
     *   为什么这里pre不直接=pre.next，因为两个node之前的指向关系已经改变了，不能再沿着之前的next找到cur了；
     *   所以这里pre进1必须在cur进1之前操作，不然cur进1之后，pre无法找到之前cur的位置了
     * 注意事项：
     * 1.注意pre的初始值赋值是null，如果pre存在值，那么最后返回的结果中一定会包含这个值
     * 2.pre不用指向head，因为每次reverse point指向的时候，pre.next其实都用不着
     * 3.注意存每次操作之后会丢失，但是我们要用到的值
     * 4.listnode的特点使得在循环的时候可以用.next != null 来进行，比for好用
     * 5.注意返回值是pre;由于这道题是返回pre，所以不用设置dummy点，或者说dummy点就是pre点
     */
    private static ListNode Reverse1(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        ListNode temp;

        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**Reverse1递归形式
     * O(n) Beats 100%
     * O(n) Beats 100%
     * 递归会带来重复计算和性能问题
     * 思路：
     * 写完Reverse1之后再修改成递归的格式会比较容易理解
     * 递归可以将复杂的问题简化为更小的子问题，每个子问题都是原始问题的一个缩小版。
     * 想到用递归修改原方法是因为每一步的操作几乎都是一样的，可以直接用递归来简化代码
     * 1.传入的pre和cur可以直接在main里赋值null和head
     * 2.return type不能是void，因为cur和pre都是在recursive方法内定义的，无法在方法外发挥；只能是在方法内操作完之后返回最后的pre
     * 3.递归是这样，真的不好理解；return Reverse2(cur,temp);这一步就是保证又=有一个return，但其实每次return又是调用依次方法
     */
    public static ListNode Reverse2(ListNode pre,ListNode cur) {
        if(cur == null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return Reverse2(cur,temp);
    }

    private static void printList(ListNode cur){
        System.out.print("[");
        while(cur!=null){
            System.out.print(cur.next != null ? cur.getVal()+"," : cur.getVal());
            cur = cur.next;
        }
        System.out.print("]");

    }
}
