/**
 *Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 * Constraints:
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
package ALG_Greedy;
public class MaximumSubarray53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    /** Greedy Algorithm(Kadane Algorithm)
     * O(n) Beats 99%
     * O(1) Beats 95%
     * 思路：
     * 说实话，我自己真的想不到，但这道题是一个经典案例，记住这种解题方法Kadane
     * 一旦当前sum < 0, 那么就从下一个位置开始
     *      从它继续累加得到的子数组和不会比从下一个元素重新开始计算得到的子数组和更大
     *      如果当前子数组的和 current_sum 为负数，那么继续累加当前子数组只会减小整体的和，因为负数会拉低子数组的和
     *      所以只要sum为负数，不如直接从下一个开始
     * 这个思想也囊括全负array，只需要每次更新sum的时候记录即可
     * 注意事项：
     * 1.要有一个maxSum存放最大值，因为array可能有多个满足条件的情况
     * 2.maxSum要在每次sum更新的时候更新，因为遇到全负的数组不至于返回sum=0
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = - (int)Math.pow(10,9)-1;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            maxSum = Math.max(sum,maxSum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }
}
