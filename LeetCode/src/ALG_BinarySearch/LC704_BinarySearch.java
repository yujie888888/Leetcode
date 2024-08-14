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
public class LC704_BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search(nums,target));
    }
    /**Binary Search
     * O(nlogn) Beats 100%
     * O(1)
     *  Beats 90%
     *  局部变量在每次循环迭代时被分配到相同的内存位置;也就是说，即使 mid 变量在循环内部每次都会重新声明，它仍然只会占用一块固定的内存，不会随着循环次数的增加而增加额外的内存使用
     * 思路:
     * Binary Search经典题
     * 用Binary Search的前提是1.数组是排好序的 2.数组的itme是unique的
     * 注意事项：
     * mid防止溢出用(end-start)/2+start
     */
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = (end-start)/2+start;
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
