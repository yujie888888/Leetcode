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

    /**BackTracking
     * Time Limit Exceeded
     * O()
     * O()
     * Ideas:
     * 元素不重复，元素可重复使用
     * 这里传递int类型的res和传递引用类型的list不一样，res并没有在递归中改变，所以要用static int
     */
    public static int combinationSum2(int[] nums, int target) {
        res = 0;
        bk(nums, target, 0);
        return res;
    }
    static int res = 0;
    public static void bk(int[] nums, int target, int sum){
        if(sum == target){
            res++;
        }

        for(int i=0; i<nums.length; i++){
            if(sum + nums[i] > target){
                continue;
            }
            bk(nums, target, sum+nums[i]);
        }
    }
}
