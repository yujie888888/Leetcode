/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
 * and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * Constraints:
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */
package ALG_Sort;
public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        //merge1(nums1,m,nums2,n);
        merge2(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + ",");
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
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
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
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
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
