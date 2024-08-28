/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 * Constraints:
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
package ALG_TwoPointers;

public class LC209_MinimumSizeSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        System.out.println(searchMin(nums,target));
    }

    /**Slide Window
     * O(n)
     * O(1)
     * 思路:
     * 1.先扩展right
     * 2.找到满足的值
     * 3.while缩短窗口
     */
    private static int searchMin(int[] nums, int target){
        if(nums.length == 0) return 0;
        int left =0, right = 0;
        int res = nums.length+1;
        int sum = 0;
        while(right<nums.length){
            sum += nums[right];
            while(sum >= target){
                res = Math.min(res,(right-left+1));
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res == nums.length+1 ? 0 : res;
    }
}
