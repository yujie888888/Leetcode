package Topic_ClassDesign;
import java.util.List;

/**Design Class
 * Ideas：
 * 这道题也能用queue，思路都差不多
 */
class ZigzagIterator {
    int p1;
    int p2;
    boolean cur;
    List<Integer> v1;
    List<Integer> v2;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        p1 = 0;
        p2 = 0;
        cur = true;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if (p1 < v1.size() && p2 < v2.size()) {
            if (cur) {
                cur = false;
                return v1.get(p1++);
            } else {
                cur = true;
                return v2.get(p2++);
            }
        }
        else if(p1 >= v1.size()){
            return v2.get(p2++);
        }
        else{
            return v1.get(p1++);
        }
    }

    public boolean hasNext() {
        if( p1>= v1.size() && p2>=v2.size()){
            return false;
        }
        return true;
    }
}

public class LC281_ZigzagIteratorSolved {
}
