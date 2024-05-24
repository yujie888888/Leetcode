package DataStruc_LinkedList.DesignSinglyLinkedList707;


public class Design {
    public static void main(String[] args) {
        MyLinkedList test = new MyLinkedList();

        //add head value
        System.out.println("***After Add Head Value***");
        printResult(test.addAtHead(1));//应该是：dummy->1
        System.out.println("----------------------------");

        //add tail value
        System.out.println("***After Add Tail Value***");
        printResult(test.addAtTail(3));//应该是：dummy->1->3
        System.out.println("-----------------------------");

        //add value in index
        System.out.println("***After Add Index Value***");
        printResult(test.addAtIndex(1,2));//应该是：dummy->1->2->3
        printResult(test.addAtIndex(3,4));//应该是：dummy->1->2->3->4
        printResult(test.addAtIndex(5,4));//应该是：dummy->1->2->3->4
        System.out.println("-----------------------------");

        //get value
        System.out.println("***The Value of Index***");
        System.out.println(test.get(0));//应该是1
        System.out.println(test.get(1));//应该是2
        System.out.println(test.get(2));//应该是3
        System.out.println(test.get(3));//应该是4
        System.out.println("-----------------------------");

        //delete value
        System.out.println("***After Delete Index Value***");
        printResult(test.deleteAtIndex(0));//应该是：dummy->2->3->4
        printResult(test.deleteAtIndex(1));//应该是：dummy->2->4
        printResult(test.deleteAtIndex(1));//应该是：dummy->2
        System.out.println("------------------------------");
    }

    public static void printResult(ListNode node) {
        while(node != null){
            System.out.print(node.next == null ? node.getVal() : node.getVal()+",");
            node = node.next;
        }
        System.out.println("");
    }


}
