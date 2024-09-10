/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
package DataStruc_Heap;
import java.util.*;

/**
 * 一开始想到用map做，但是map.value不知道怎么排序
 * 引入Min Heap和Max Heap做法解决
 * 先用map存val-count key-vale pairs
 * use MinHeap or Max Heap都可以
 * 按照key.count频率从高到低排序
 * 将keyl存入MaxHeap,实现从大到小排序
 * poll()前k个节点
 * Note
 * (a, b) -> freq.get(b)- freq.get(a)是maxHeap
 * (a, b) -> freq.get(a)- freq.get(b)是minHeap
 */
public class TopKFrequentElements347 {
    public static void main(String[] args) {

    }
    /**maxHeap Beats 75%
     * O(n)
     * O(k)
     * 思路：
     * 1.用maxHeap
     * 2.自定义maxHeap的排序逻辑，根据freq(key)，按maxHeap排
     * 3.存入所有key值
     * 4.取前k个key值
     */
    public int[] maxHeaptopKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }
        //自定义maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> freq.get(b)- freq.get(a));
        //把freq的所有keyset存入maxHeap
        //O(n)
        maxHeap.addAll(freq.keySet());
        int[] res = new int[k];
        //取前k个key值
        //O(n)
        int i = 0;
        while(!maxHeap.isEmpty()){
            res[i] = maxHeap.poll();
            i++;
            k--;
        }
        return res;
    }

    /** MinHeap beats 50%
     * O(n) 改进了一下存值，只需要维护k长度就可以
     */
    public int[] minHeap2topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i, 0)+1);
        }
        //customize minHeap
        //fa-fb>0 means b<a a should be after b
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> freq.get(a) - freq.get(b));
        //维持k
        for(int key : freq.keySet()){
            //维持k的时候一定是先add再poll，保证每次poll出去的就是最小的
            if(minHeap.size() < k){
                minHeap.add(key);
            }
            else{
                minHeap.add(key);
                minHeap.poll();
            }
        }
        /*
        minHeap.addAll(freq.keySet());
        int num = freq.size() - k;
        while(num > 0){
            minHeap.poll();
            num --;
        }
        */
        int[] result = new int[k];
        int i=0;
        while(!minHeap.isEmpty()){
            result[i++] = minHeap.poll();
        }
        return result;
    }

























}
