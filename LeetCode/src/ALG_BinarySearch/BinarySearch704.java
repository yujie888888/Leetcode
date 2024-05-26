/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 */
package ALG_BinarySearch;
public class BinarySearch704 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));
    }
    /**Binary Search
     * O(nlogn) Beats 100%
     * O(1) Beats 90%
     * 思路:
     * Binary Search经典题
     * 1.set start&end
     * 2.tarverse nums
     *      set mid
     *      judgement
     *      set interval
     * 注意事项:
     * 1.mid防止溢出用(end-start)/2+start
     */
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int mid;
        while(start<=end){
            mid = (end-start)/2+start;
            if(target<nums[mid]){
                end = mid-1;
            }
            else if(target>nums[mid]){
                start = mid+1;
            }
            else return mid;
        }
        return -1;
    }
}
