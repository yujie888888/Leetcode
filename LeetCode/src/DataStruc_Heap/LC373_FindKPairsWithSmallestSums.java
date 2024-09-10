package DataStruc_Heap;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LC373_FindKPairsWithSmallestSums {
    public static void main(String[] args) {

    }

    /**
     * O(n)
     * O(n)
     * Ideas:
     * 这道题难点在于时间复杂度不能超过O(nlogn)
     * 根据Greedy思想，nums1和nums2中靠前的num之和肯定是最小的，所以先add一层进去 O(n)
     * 然后在minHeap每次poll的时候，再add一个新的进去，这样时间复杂度就保持在O(k)
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0]+a[1] - b[0]-b[1]));
        //最小的sum肯定是从前面出的，也就是从nums1 和 nums2 的前面出
        //先把nums1[i]和nums2[0]加入minHeap -> 这里后续直接判断进入过minHeap的值是不是有k个就行了
        for(int i=0; i<m; i++){
            minHeap.add(new int[]{nums1[i], nums2[0], 0}); //这个0表示我取到了nums2中的哪个位置
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int j=0; j<k && !minHeap.isEmpty(); j++){
            int[] cur = minHeap.poll();
            res.add(new ArrayList<>(Arrays.asList(cur[0], cur[1])));

            int curIndex = cur[2];
            if(cur[2] < n-1){
                minHeap.add(new int[]{cur[0], nums2[curIndex+1], curIndex+1});
            }
        }
        return res;
    }
}
