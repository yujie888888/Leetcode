package DataStruc_Tree;
import java.util.List;
import java.util.ArrayList;

class Node{
    int val;
    Node left;
    Node right;

    public Node(){}
    public Node(int val){
        this.val = val;
    }
    public Node(int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class LC426_ConvertBinarySearchTree {
    public static void main(String[] args) {
        Node node3 = new Node(1);
        Node node4 = new Node(3);
        Node node1 = new Node(2,node3,node4);
        Node node2 = new Node(5);
        Node root = new Node(4,node1,node2);

        treeToDoublyList(root);

        //循环链表，这里就不输出了
    }

    /**
     * 先中序遍历
     * 在手动构建双向链表
     */
    static List<Node> list = new ArrayList<>();
    public static Node treeToDoublyList(Node root) {
        if(root == null) return null;
        list.clear();
        dfs(root);
        list.forEach(node -> System.out.print(node.val));

        Node dummy = new Node();
        Node cur = list.get(0);
        dummy.right = cur;

        for(int i=1; i<list.size(); i++){
            Node node;
            node = list.get(i);
            //System.out.println("cur is: "+cur.val);
            cur.right = node;
            //System.out.println("cur left is: "+node.val);
            node.left = cur;
            if(cur.right != null) cur = cur.right;
        }
        cur.right = dummy.right;
        dummy.right.left = cur;

        return dummy.right;
    }

    private static void dfs(Node node){
        if(node == null){
            return;
        }

        dfs(node.left);
        list.add(node);
        dfs(node.right);
    }
}
