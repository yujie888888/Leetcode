package DataStruc_LinkedList;
import java.util.HashMap;

/**Design Class
 * O(1)
 * use Double LinkedList to maintain the order of use frequency
 * use HashMap to locate the node
 */
class DListNode {
    int key;
    int val;
    DListNode pre;
    DListNode next;

    public DListNode(){}

    public DListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, DListNode> Map;
    DListNode head;
    DListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        Map = new HashMap<>();
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.pre = head;
    }
    public int get(int key) {
        if(!Map.containsKey(key)){
            return -1;
        }
        DListNode node = Map.get(key);
        remove(node);
        addToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(Map.containsKey(key)){
            remove(Map.get(key));
        }
        DListNode node = new DListNode(key,value);
        if(Map.size() == capacity){
            DListNode deleteNode = tail.pre;
            remove(deleteNode);
        }
        addToHead(node);
    }

    public void remove(DListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        Map.remove(node.key);
    }
    public void addToHead(DListNode node){
        DListNode temp = head.next;
        head.next = node;
        node.pre = head;
        temp.pre = node;
        node.next = temp;
        Map.put(node.key, node);
    }
}
public class LC146_LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,20);
        cache.put(2,30);
        cache.put(3,40);
        cache.get(2);
        cache.get(3);
        cache.put(4,50);
        System.out.println(cache.get(1));
    }
}
