package Topic_ClassDesign;
import java.util.HashMap;

/**Design Class
 * O(1)
 * Ideas:
 * use Double LinkedList to maintain the order of use frequency
 * use HashMap to locate the node
 * 像类的定义这种，注意的点
 * 1.需要定义几个类
 * 2.每个类的构造函数怎么写
 * 基本上这两点确定其他的都是逻辑问题
 *
 */
class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node() {
    }

    public Node(int key, int val) {
        this.val = val;
        this.key = key;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    HashMap<Integer, Node> map;
    Node dummy;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dummy = new Node();
        tail = new Node();
        dummy.next = tail;
        tail.prev = dummy;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        //removeNode
        Node node = map.get(key);
        removeNode(node);
        // update
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // 更新值
            node.setVal(value);
            // 删除旧node的位置
            removeNode(node);
            // update order
            update(node);
        } else {
            if (map.size() == capacity) {
                // remove
                Node node = tail.prev;
                removeNode(node);
                map.remove(node.key);
            }
            map.put(key, new Node(key, value));
            // update order
            update(map.get(key));

        }
    }

    public void update(Node node) {
        Node temp = dummy.next;
        dummy.next = node;
        node.prev = dummy;
        node.next = temp;
        temp.prev = node;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
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
