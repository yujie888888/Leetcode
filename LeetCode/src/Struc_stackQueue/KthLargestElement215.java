package Struc_stackQueue;

import java.util.PriorityQueue;

public class KthLargestElement215 {
    public static void main(String[] args) {

    }

    // minHeap 15%
    // O(n)
    public int minHeapFindKthLargest(int[] nums, int k) {
        //minHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums) minHeap.add(num);
        int count = 0;
        while(count < nums.length -k){
            minHeap.poll();
            count ++;
        }
        return minHeap.peek();
    }
    // min Heap maintains k 50%
    // O(n)
    public int minHeapMaintainKFindKthLargest(int[] nums, int k) {
        //minHeap k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    // maxheap 50%
    // O(n)
    public int maxHeapFindKthLargest(int[] nums, int k) {
        //maxHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> b-a);
        for(int num : nums) minHeap.add(num);
        int count = 0;
        while(count < k-1){
            minHeap.poll();
            count ++;
        }
        return minHeap.peek();
    }
}
