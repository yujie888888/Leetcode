/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * Constraints:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 */
package ALG_TwoPointers;

public class LC283_MoveZero {
    /**Two Pointers
     * O(n)
     * O(1)
     * 思路：
     * Two Pointers经典题把target换成0
     */
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        int slow = 0;
        for(int fast=0; fast<nums.length; fast++){
            if(nums[fast]!=0){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        for(int i=slow; i<nums.length; i++){
            nums[i] = 0;
        }
    }
}
