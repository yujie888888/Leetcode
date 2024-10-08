/**
 *Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Constraints:
 * -231 <= x <= 231 - 1
 * Follow up: Could you solve it without converting the integer to a string?
 */
package ALG_DynamicProgramming;
public class LC494_TargetSum {
    static int count = 0;
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        int target = 1;
        count = 0;
        dfs(nums,-1,target,0);
        System.out.println(count);
        System.out.println(dp1(nums,target));
        System.out.println(dp2(nums,target));
    }
    /**BackTracking
     * O(2^n) 有2^n个结点 Beats 35%
     * O(n) Beats 99%
     * 每个数字前都有两个选择的可能性，要么+要么-
     * 建一颗二叉树，每一层的每个结点都有两种选择 +nums[index] || -nums[index]
     * 每个结点代表从最顶层到该层进行多次选择后的不同的sum值
     * 思路：
     * 1.结束条件：当index到最后时return 且在此条件下，sum==target，count++（不是中间有一个target就是一个，而是遍历完所有的==target才是一个）
     * 2.递归逻辑：从一条边遍历到最深
     * 3.参数：nums，index，target，sum
     * 注意事项：
     * 1.我是从index为-1也就是第-1层进去递归的，因为每个数字都有两种选择，从还没有选择的时候进入
     * 2.结束条件写的很巧妙
     */
    public static void dfs(int[] nums ,int index, int target, int sum){
        if(index == nums.length-1){
            if(sum == target){
                count ++;
            }
            return;
        }
        dfs(nums,index+1,target,sum+nums[index+1]);
        dfs(nums,index+1,target,sum-nums[index+1]);
    }
    /**Dynamic Programming(二维数组)
     * 01背包问题应用
     * O(n^2) Beats 90%
     * O(n^2)
     * 思路：
     * 1.dp[i][j]: 前i个数字能组成和为j有多少种办法
     *   把nums分成两部分，一部分是选择+一部分选择-，选择+这部分的sum称为left；又left-(sum-left)=target -> left = (sum+target)/2;
     *   这样只需要考虑选择哪些数字放进+组合中使得其sum为(sum+target)/2即可，原题求的有多少种相加为sum的情况就变成有多少种选择使得left为x的情况
     * 2.状态转移公式: (不选)dp[i][j] = dp[i-1][j]  (选)dp[j] += dp[j - nums[i]];
     * 3.初始化: dp[i][0]=1; i个数字相加为0只有一种可能，都不选
     * 注意事项：
     * 1.dp[i][j]中的i和nums[i]中的i不一样，差1
     * Steps:
     * 开始
     *   |
     *   |
     * 计算数组总和sum
     *   |
     * base cases
     *   |
     * 转换为子集和问题：
     *   left = (sum + target) / 2
     *   |
     * 初始化动态规划表：
     *   |
     * 填充动态规划表：
     *   对于每个元素 i 从 1 到 n:
     *     对于每个子集和目标 j 从 0 到 left:
     *       不选择当前元素：
     *         dp[i][j] = dp[i-1][j]
     *       如果 j >= nums[i-1]:
     *         选择当前元素：
     *           dp[i][j] += dp[i-1][j - nums[i-1]]
     *   |
     * 获取最终结果：
     *   result = dp[n][left]
     *   |
     * 结束
     */
    public static int dp1(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) sum+=num;
        int left = (sum+target)/2;

        // base cases
        if((sum+target) %2 != 0) return 0;
        if(Math.abs(target)>sum) return 0;

        int[][] dp = new int[nums.length+1][left+1];
        for(int i=0; i<= nums.length; i++) dp[i][0] = 1;

        for(int i=1; i<=nums.length; i++){
            for(int j=0; j<=left; j++){
                dp[i][j] = dp[i-1][j];
                if(j>=nums[i-1]) dp[i][j] += dp[i-1][j-nums[i-1]];
            }
        }
        return dp[nums.length][left];
    }
    /**DP(一维数组)
     * O(n^2) Beats 99%
     * O(n) Beats 70%
     * 01Bags应用
     * 思路:
     *  和二维数组一样
     *  (+组) - (-组) = target
     *  +组 = (sum+target)/2;
     * DP五部曲:
     * 1.dp[j] 选择前i个num，其和为j有多少种选择
     * 2.dp[j] = dp[j] + dp[j-nums[i]];
     * 3.dp[0] = 1;
     * 注意事项：
     * 1.if ((target + sum) % 2 == 1) return 0;这个判断只能用(target + sum) % 2，不能用n%2==1,因为n运算后已经取整了
     */
    public static int dp2(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) sum+=num;
        if(Math.abs(target) > sum) return 0;
        if ((target + sum) % 2 == 1) return 0;

        int n = (sum+target)/2;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=0; i<nums.length; i++){
            for(int j=n; j>=nums[i]; j--){
                dp[j] = dp[j] + dp[j-nums[i]];
            }
        }
        return dp[n];
    }
}
