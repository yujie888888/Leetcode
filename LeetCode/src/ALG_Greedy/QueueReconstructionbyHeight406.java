/**
 * You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.
 * Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).
 * Example 1:
 * Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * Explanation:
 * Person 0 has height 5 with no other people taller or the same height in front.
 * Person 1 has height 7 with no other people taller or the same height in front.
 * Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
 * Person 3 has height 6 with one person taller or the same height in front, which is person 1.
 * Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
 * Person 5 has height 7 with one person taller or the same height in front, which is person 1.
 * Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
 * Example 2:
 * Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 * Constraints:
 * 1 <= people.length <= 2000
 * 0 <= hi <= 106
 * 0 <= ki < people.length
 * It is guaranteed that the queue can be reconstructed.
 */
package ALG_Greedy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionbyHeight406 {
    public static void main(String[] args) {
        int[][] people = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        int[][] res = reconstructQueue(people);
        System.out.print("[");
        for(int[] resL : res){
            System.out.print("["+resL[0]+","+resL[1]+"]"+",");
        }
        System.out.print("]");
    }
    /**Greedy
     * O(n^2) Beats 95%
     * O(n) Beats 50%
     * 思路:
     * 1.先按照身高从高到矮排，如果身高一样，再按照ki从小到大排
     * 2.然后根据k1开始将person[]插入结果，这里k1肯定是从0开始的(而且还按照ki从小到大排，所以最高的肯定是从0开始的)
     * 3.在遍历people根据ki插入的过程中，肯定会出现ki==kj的情况，但是list.add()方法会将前面的挤到后面，所以后来的person会占据前面person的位置
     * 4.经过神奇的插入过程，最后就能得到结果
     * 我理解的是，按照1的规则拍完序之后，每次根据ki进行插入的时候，在list中的person全是比即将要插入的person高
     * 此时ki用来决定我们选择几个已经插入的person，放在这个即将插入的person前面
     * 也就是，只要已经插入list的person，对后来的person来说都是一样的存在
     * 注意事项:
     * 1.Arraylist只能从0开始add element
     * 2.list.toArray(T[] a) 方法用于将列表中的元素复制到指定类型的数组a中
     *   这里我们传入的是 new int[list.size()][]，即创建的一个行数与 list 大小相同的空的二维数组
     * 3.就算自定义比较器，Arrays.sort 方法的底层实现仍然是基于一种高效的排序算法，时间复杂度是O(nlogn)
     * 4.记住Arrays.sort()自定义的写法
     */
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {//O(nlogn)
            if(a[0] != b[0]) return b[0]-a[0];
            else{
                return a[1]-b[1];
            }
        });
        List<int[]> list = new ArrayList<>();
        for(int[] person : people){//O(n)
            list.add(person[1],person);//O(n)
        }
        return list.toArray(new int[list.size()][]);//O(n)
    }
    /**2
     * 一开始的想法是，按照身高从小到大排，如果身高相等，按照ki从小到大排
     * 然后根据p[1]也就是k1,先确定最矮的人的位置
     * 然后继续p[2..]
     * 但是由于最矮的人的ki不一定是从几开始的，所以在插入的时候不能用List,但是如果用array，又要考虑到位置被占，要重新移动的情况，比较繁琐
     */
}
