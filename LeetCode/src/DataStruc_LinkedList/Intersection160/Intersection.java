/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * For example, the following two linked lists begin to intersect at node c1:
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * Note that the linked lists must retain their original structure after the function returns.
 * Ex1.
 * Input: listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
 * Output: Intersected at '8'
 * Ex2.
 * listA = [1,9,1,2,4], listB = [3,2,4]
 * Output: Intersected at '2'
 * Ex3.
 * listA = [2,6,4], listB = [1,5]
 * Output: No intersection
 */
/*
这两个链表不可能在短的那一条链表前面相交
而且自从相交点之后，所有的元素都一样了
所以将后面对齐，也就是指针在一样的位置
然后一对一元素比较，只要找到一样的位置，那么这个位置就是相交点，逻辑都是一样的
 */
package DataStruc_LinkedList.Intersection160;
import java.util.Scanner;
//这道题本地做不了，因为本来是比较两个链表节点是不是一样的，地址是一样的，而不是值是一样的，不知道怎么定义
//为了能在本地做，把这道题改成，第一个值一样的地方为交界点
public class Intersection {
    public static void main(String[] args) {
        //找到差值O(m+n)
        //长的那个，从差值的位置开始
        //两个链表一对一比较，只要找到一样的，后面的都是一样的 O(n)
        Scanner sc = new Scanner(System.in);
        System.out.println("Input linked list A:");
        String inputLineA = sc.nextLine();
        if(inputLineA == ""){
            System.out.println("No intersection");
            return;
        }
        String[] LineA = inputLineA.split(",");

        System.out.println("Input linked list B:");
        String inputLineB = sc.nextLine();
        if(inputLineB == ""){
            System.out.println("No intersection");
            return;
        }
        String[] LineB = inputLineB.split(",");

        ListNode headA = new ListNode(Integer.parseInt(LineA[0]));
        ListNode headB = new ListNode(Integer.parseInt(LineB[0]));

        //赋值
        assignValue(headA,LineA);
        assignValue(headB,LineB);
        //printList(headA);


        //双指针找位置
        ListNode result = searchIntersection(headA, headB);
        if(result == null){
            System.out.println("No intersection");
            return;
        }
        System.out.println("Intersected at "+result.getVal());

        System.out.print("The same part is ");
        printList(result);
    }

    private static void assignValue(ListNode head, String Line[]){
        ListNode cur = head;
        for (int i = 1; i < Line.length; i++) {
            cur.next = new ListNode(Integer.parseInt(Line[i]));
            cur = cur.next;
        }
    }

    private static void printList(ListNode head){
        ListNode cur = head;
        System.out.print("[");
        while(cur!=null){
            System.out.print(cur.next == null ? cur.getVal() : cur.getVal()+",");
            cur = cur.next;
        }
        System.out.print("]");
    }

    private static ListNode searchIntersection(ListNode headA, ListNode headB){
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        int diff = Math.abs(sizeA-sizeB);
        ListNode A = headA;
        ListNode B = headB;
        if(sizeA < sizeB){
            for (int i = 0; i < diff; i++) {
                B = B.next;
            }
        }
        else{
            for (int i = 0; i < diff; i++) {
                A = A.next;
            }
        }
        //A!=null && B!=null 这个判断只有在改了题之后才需要
        //原题是不需要这个判断的，因为就算找不到intersection，A和B都会变成null，null==null
        while(A!=null && B!=null && A.getVal()!=B.getVal()){
            A = A.next;
            B = B.next;
        }
        return A;
    }

    private static int getSize(ListNode head){
        ListNode cur = head;
        int size = 0;
        while(cur!=null){
            cur = cur.next;
            size++;
        }
        return size;
    }
}
