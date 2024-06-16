/**
 * Given an array A with only positive numbers. We are allowed to negate any entries in the array, (i.e set A[i] = -A[i]).
 * What is the maximum number of entries you can negate in the array such that every prefix sum after the negate operations is positive.
 * Example 1:
 * Input:  A = [4, 1, 1, 1]
 * Output: 3
 * Explanation:
 * We can apply only at-most 3 negate operations, to make A = [4, -1, -1, -1], after the negate operation,
 * The prefix sums of A, p(A) = [4, 3, 2, 1] which are all positive. So that the answer for A is 3.
 * Constraints:
 * N <= 10^5
 * A[i] <= 10^9
 */
package Company_Amazon;
import java.util.PriorityQueue;

public class P24_MaxNumberOfNegateOperations {
    /**Greedy + Heap
     * O(n)
     * Ideas:
     * 这道题不能通过值检查prefix的和>0来遍历,因为对于{4, 3, 1, 1, 1};这种情况，选择111才是最优解
     * 用minHeap和maxHeap实现贪心
     * 1.因为要求是最多的num可以被取反，那么被取反的num值越小，说明count越多
     * 2.因此create两个heap，只要|neg的max值|>|pos的最小值|，也就是现在拿来pos的最小值，肯定是当前最优选择
     *   count不变，但是sum增加了，也就是可以加入neg的num个数会更多
     * 3.在每次加入neg or pos的时候，只要先判断prefix是不是>0,先尝试加入，因为后面还会根据peek()值进行交换
     * 4.交换之后prefix肯定还是满足条件的，因为-大的都能>0,那现在-小的肯定也能>0
     *   也就是neg的大的值换成pos的小的值
     */
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1, 1, 1};
        int n = nums.length;
        PriorityQueue<Integer> minHeapPos = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeapNeg = new PriorityQueue<>((a,b)->(b-a));
        minHeapPos.add((int)Math.pow(10,9));//O(logK)
        maxHeapNeg.add(-(int)Math.pow(10,9));
        int sum = 0;
        int res = 0;
        for(int i=0; i<n; i++){
            //System.out.println(maxHeapNeg.peek());
            //System.out.println(minHeapPos.peek());
            while(maxHeapNeg.peek() > minHeapPos.peek()){
                int pos = minHeapPos.poll();
                int neg = maxHeapNeg.poll();
                sum -= pos;
                sum += neg;
                maxHeapNeg.add(pos);
                minHeapPos.add(neg);
                //System.out.println("-----------");
                //System.out.println("maxNeg "+maxHeapNeg);
                //System.out.println("minPos "+minHeapPos);
                //System.out.println("------------");
            }
            if(sum-nums[i]>0){//当前prefix sum>0,可以尝试把这个数加入neg中
                sum -= nums[i];
                maxHeapNeg.add(nums[i]);
                //System.out.println(nums[i]);
                //System.out.println("maxNeg "+maxHeapNeg);
                res++;
            }
            else{//不然只能做pos
                sum += nums[i];
                minHeapPos.add(nums[i]);
                //System.out.println(nums[i]);
                //System.out.println("minPos "+minHeapPos);
            }
        }
        System.out.println(res);
    }
}
