/**
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 * Example 1:
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Example 2:
 * Input: nums = [9], target = 3
 * Output: 0
 * Constraints:
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 * Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?
 */
package ALG_DynamicProgramming;

public class LC377_CombinationSumIV {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println(combinationSum4(nums,target));
    }
    /**DP(一维数组)
     * O(n*target) Beats 80%
     * O(target) Beats 80%
     * 思路:
     * 很显然是完全背包的求排列数的变题
     * 1.dp[j]: 当target为j时，nums的前i个数字所能构成的排列数
     * 2.dp[j] += dp[j-coin];
     *   求排列数/组合数常用的状态转移方程；
     *   就是两种选择，选coin和不选coin
     * 3.dp[0] = 1;
     * 注意事项:
     * 1.完全背包求排列数，外循环是背包，内循环是物品
     * 2.完全背包的一维数组做法，内循环用正向
     * 3.这道题只是求一个数，如果要列出所有的组合的情况，比如P39，P40，就要用回溯做了
     */
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int j=1; j<=target; j++){
            for(int i=0; i<nums.length; i++){
                if(j>=nums[i]) dp[j] += dp[j-nums[i]];
            }
        }
        return dp[target];
    }

    /**BT
     * 超时了
     */
    static int res2 = 0;
    static int sum2 = 0;
    public static int combinationSumBT(int[] nums, int target) {
        res2 = 0;
        sum2 = 0;
        backtracking(nums, target);
        return res2;
    }
    private static void backtracking(int[] nums, int target){
        if(sum2 == target){
            res2++;
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(sum2 + nums[i] > target) continue;
            sum2 += nums[i];
            backtracking(nums, target);
            sum2 -= nums[i];
        }
    }
}
