/**
 * Given an integer array nums, return true if you can partition the array into two subsets
 * such that the sum of the elements in both subsets is equal or false otherwise.
 * Example 1:
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * Constraints:
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
package ALG_DynamicProgramming;

public class LC416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5};
        System.out.println(canPartition(nums));
    }
    /**DP(01Bags Apply)
     * O(n^2) Beats 90%
     * O(n) Beats 90%
     * 思路:
     * 套用01Bags模板
     * 1.首先找到背包容量:
     *      因为只分成两组，所以用(target)sum/2，就是背包容量
     *      这里如果不能整除直接返回false
     * 2.然后找到物品的w[]和v[]
     *      w[],v[]都是nums[i]的值
     * 3.物品不可重复-01Bags
     * 4.如果从nums中的所有物品中任选，其和正好是target，那么就说明可以均分
     * DP五部曲:
     * 1.dp[j]:背包总容量为j,从前i个物品(num)中任选,能构成的最大和为dp[j]
     * 2.dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]); 套用01Bags公式
     * 3.dp[j] = 0;
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum+=num;
        int target = sum/2;
        if(sum%2 != 0) return false;
        int[] dp = new int[target+1];
        for(int i=0; i<nums.length; i++){
            for(int j=target; j>=nums[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target] == target;
    }
}
