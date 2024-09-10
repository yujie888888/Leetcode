package Topic_ClassDesign;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**这道题的重点在于所有的方法的时间复杂度O(1)
 * Ideas:
 * 根据题目，必须
 *  1.要有一个hash来判断；根据getRandom的定义,如果只有hash也不可以，因为hash没有index没有办法返回random index
 *  2.所以要有一个有index结构的数据结构，这里用ArrayList，比较方便添加删除
 *  3.如果只用HashSet也不行，因为ArrayList在remove的时候时间复杂度是O(n),因为remove index为i的值之后，后面的值也要依次变动
 *      所以为了满足O(1)的要求，想到每次只删除list的结尾的element
 *      但是实际上我们要删除的是val的值，所以加一步替换即可
 *          将tail元素替换到val的index的位置，再将tail删除
 *          这里就用到了要怎么才能知道val的index呢？用hashMap存。
 *          list使用set()function + remove(tail.index) 实现了在O(1)的时间复杂度内删除元素
 *          这里元素的相对顺序并不重要，因为返回都是random的
 *          list和hashMap都要进行维护，hashMap中当list完成替换后，也要将对应的两个元素的key-value对进行替换
 *  不难，只是第一次比较难想到
 */
class RandomizedSet {
    HashMap<Integer,Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            //add()方法将元素添加到末尾，O(1)
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }
        else return false;
    }

    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            int last = list.get(list.size()-1);
            list.set(index, last);
            list.remove(list.size()-1);
            map.put(last, index);
            map.remove(val);
            return true;
        }
        else return false;
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}

public class LC380_InsertDeleteGetRandom {
}
