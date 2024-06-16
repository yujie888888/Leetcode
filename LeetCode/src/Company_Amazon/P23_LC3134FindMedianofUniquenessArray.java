/**
 * In an Amazon coding marathon, the following challenge was given.
 * The uniqueness of an array of integers is defined as the number of distinct elements present.
 * For example, the uniqueness of [1, 5, 2, 1, 3, 5] is 4, element values 1, 2, 3, and 5.
 * For an array arr of n integers, the uniqueness values of its sub arrays is generated and stored in another array,
 * call it subarray_uniqueness for discussion. Find the median of the generated array subarray_uniqueness.
 * Notes:
 * The median of a list is defined as the middle value of the list when it is sorted in non-decreasing order.
 * If there are multiple choices for median, the smaller of the two values is taken.
 * For example, the median of [1, 5, 8] is 5, and of [2, 3, 7, 11] is 3.
 * A subarray is a contiguous part of the array. For example, [1, 2, 3] is a subarray of [6, 1, 2, 3, 5] but [6, 2] is not.
 * Function Description
 *   Complete the function findMedianOfSubarrayUniqueness in the editor.
 *   findMedianOfSubarrayUniqueness has the following parameter:
 *   int arr[n]: the array
 * Returns
 *   int: the median of the generated array subarray_uniqueness
 * Constraints
 *   1 ≤ n ≤ 10^5
 *   1 ≤ arr[i] ≤ n
 * Example 1:
 * Input: arr = [1, 1]
 * Output: 1
 * Explanation:
 * The subarrays along with their uniqueness values are:
 * [1]: uniqueness = 1
 * [1, 1]: uniqueness = 1
 * [1]: uniqueness = 1
 * subarray_uniqueness is [1, 1, 1].
 * Example 2:
 * Input:  arr = [1, 2, 3]
 * Output: 1
 * Explanation:
 * Given n = 3 and arr = [1, 2, 3], the subarrays along with their uniqueness values are:
 * [1]: uniqueness = 1
 * [1, 2]: uniqueness = 2
 * [1, 2, 3]: uniqueness = 3
 * [2]: uniqueness = 1
 * [2, 3]: uniqueness = 2
 * [3]: uniqueness = 1
 * subarray_uniqueness is [1, 2, 3, 1, 2, 1], and after sorting it is [1, 1, 1, 2, 2, 3].
 * Example 3:
 * Input:  arr = [1, 2, 1]
 * Output: 1
 * Explanation:
 * The subarrays with their uniqueness values are:
 * [1]: uniqueness = 1
 * [1, 2]: uniqueness = 2
 * [1, 2, 1]: uniqueness = 2
 * [2]: uniqueness = 1
 * [2, 1]: uniqueness = 2
 * [1]: uniqueness = 1
 * The subarray_uniqueness array is [1, 2, 2, 1, 2, 1]. After sorting, the arr is [1, 1, 1, 2, 2, 2]. The choice is between the two bold values. Return the min of the two, 1.
 * [1]: uniqueness = 1
 */
package Company_Amazon;
import java.util.HashMap;

public class P23_LC3134FindMedianofUniquenessArray {
    /**Binary Search + Slide Window
     * O(nlogn)
     * O(n)
     * Ideas:
     * 看unique char的数量最多为k的时候，有多少subarray，然后根据数量看和median的举例
     *   如果超过median的位置，那么unique char的数量多了，就减少k，也就是往前的范围找
     *   如果没到median的位置，就往后的范围内找
     * 1. findKUniqueCharSubarrayis sliding window algo, to findout the number of subarray with at most k different numbers
     * 2.There are n * (n + 1) // 2 subarrays in total, We can binary search the smallest k that statisfy findK(k) >= total-findK(k),
     *   then k in the median based on the definition.
     */
    public static void main(String[] args) {
        int[] nums = {91,64,76,18,61,55,46,93,65,99};
        int n = nums.length;
        long target = (long)n*(n+1)/2;
        int left=1, right=n; //1表示unique char数量为1，n表示unique char数量为n
        while(left<right){
            int mid = (left+right)/2;
            if(findKUniqueCharSubarray(nums, mid)*2 >= target){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        System.out.println(left);
    }
    private static long findKUniqueCharSubarray(int[] nums, int k){
        long res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0;
        for(int j=0; j<nums.length; j++){
            if(!map.containsKey(nums[j])) k--;
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(k<0){
                if(map.get(nums[i]) == 1){
                    map.remove(nums[i]);
                    k++;
                }
                else{
                    map.put(nums[i],map.get(nums[i])-1);
                }
                i++;
            }
            res += (j-i+1);
        }
        return res;
    }
}
