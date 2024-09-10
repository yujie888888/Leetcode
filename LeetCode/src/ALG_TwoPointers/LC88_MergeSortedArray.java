package ALG_TwoPointers;
import java.util.PriorityQueue;

public class LC88_MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge1(nums1,m,nums2,n);
        //merge2(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + ",");
        }
    }
    /**minHeap
     * 偷懒做法but我感觉这道题没啥必要太复杂
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i=0; i<m; i++){
            minHeap.add(nums1[i]);
        }
        for(int num : nums2){
            minHeap.add(num);
        }
        for(int i=0; i<m+n; i++){
            nums1[i] = minHeap.poll();
        }
    }

    /**
     * 3 points(merge sort)
     * O(m+n) Beats 100%
     * O(n) Beats 55%
     * 思路：
     * 1.和mergesort的逻辑一样，mergersort的逻辑就是将一个数组分割成两个，直到len==1，然后将分割的数组里的数依次比较，直到递归回到一开始的那一层
     * 2.这里的题目nums1和nums2本身就是sorted的，所以只需要执行一次mergesort的逻辑
     * 3.mergesort里，left和right都事先存好了两部分的值，nums本身相当于一个盒子存放比较后的值
     * 4.这道题没有这个盒子，所以要创建一个
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] nums = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k] = nums1[i];
                i++;
                k++;
            } else {
                nums[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            nums[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            nums[k] = nums2[j];
            j++;
            k++;
        }
        //进行一次copy是因为题目要求将结果存到nums1中
        System.arraycopy(nums, 0, nums1, 0, m + n);
    }

    /**
     * 3 points(without extra space)
     * O(m+n) Beats 100%
     * O(1) Beats 95%
     * 思路：
     * 1.从nums1和nums2的尾巴开始，p1=m-1;p2=n-1;
     * 2.再从nums1的长度-1设置k指针，k指针负责存放排序好的值
     * 3.谁的数大谁放在k的位置
     * 4.这样不用额外的辅助空间，演示一下就懂了
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
                k--;
            } else {
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
        while (i >= 0) {
            nums1[k] = nums1[i];
            i--;
            k--;
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
