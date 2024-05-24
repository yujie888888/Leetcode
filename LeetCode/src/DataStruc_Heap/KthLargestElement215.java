/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 * Example 1:
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * Constraints:
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
package DataStruc_Heap;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement215 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        if(k>nums.length) System.out.println(-1);
        //minHeap
        System.out.println(FindKthLargest1(nums,k));
        //minHeap
        System.out.println(FindKthLargest2(nums,k));
        //mergeSort
        mergesort(nums);
        System.out.println(nums[nums.length - k]);
    }

    /**minHeap
     * O(nlogk) Beats 70%
     *      堆的大小固定为k
     *      对插入k个元素的操作O(klogk)
     *      对后续比较后的操作，最坏是O((n-k)logk)
     *      add() O(logk)
     *      poll() O(logk)
     * O(k) Beats 92%
     * 思路：
     * 1.借助PriorityQueue构建最小堆(使用priorityQueue构建heap默认是minHeap)
     * "2".一开始的想法是将所有的数都加进minHeap中，然后将前k-1个数字全部弹出，剩下的peek就是kth largest number; 但是可以剪枝，优化时间复杂度
     * 2.只需要在minheap中保留k个数字，如果进来的数字大于peek，那么就将其放进minHeap中，最后peek的位置就是kth largest的数
     */
    public static int FindKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0;
        for(int num : nums){
            if(i<k){
                minHeap.add(num);
                i++;
            }
            else{
                if(num > minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(num);
                }
            }
        }
        return minHeap.peek();
    }

    /**maxHeap
     * O(nlogn) Beats 25%
     * O(n) Beats 60%
     * 思路:
     * 1.构建maxHap(两种方法)
     * 2.将num全部放进maxHeap
     * 3.将前k-1个数字poll出去
     * 4.peek()的位置就是kth largest
     */
    public static int FindKthLargest2(int[] nums, int k) {
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num : nums) maxHeap.add(num);
        int i=1;
        while(i<k){
            maxHeap.poll();
            i++;
        }
        return maxHeap.peek();

    }

    /**Merge Sort
     * O(nlogn) Beats 75%
     * O(n) Beats 99%
     * 思路：
     * 归并排序后找出nums[len-k]的位置就是kth largest的位置
     */
    public static void mergesort(int[] nums){
        if(nums.length == 1) return;

        int mid = nums.length/2;

        int[] left = new int[mid];
        System.arraycopy(nums, 0, left, 0, mid);
        int[] right = new int[nums.length-mid];
        System.arraycopy(nums, mid, right, 0, nums.length-mid);

        mergesort(left);
        mergesort(right);

        int k=0;
        int i=0;
        int j=0;
        while(i<left.length && j<right.length){
            if(left[i] < right[j]){
                nums[k] = left[i];
                i++;
                k++;
            }
            else{
                nums[k] = right[j];
                j++;
                k++;
            }
        }
        while(i<left.length){
            nums[k] = left[i];
            i++;
            k++;
        }
        while(j<right.length){
            nums[k] = right[j];
            j++;
            k++;
        }
    }
}
