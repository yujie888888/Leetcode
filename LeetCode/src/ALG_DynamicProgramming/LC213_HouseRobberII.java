package ALG_DynamicProgramming;

public class LC213_HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int n = nums.length;
        if(n == 1){
            System.out.println(nums[0]);
            return;
        }
        if(n == 2){
            System.out.println(Math.max(nums[0], nums[1]));
            return;
        }
        System.out.println(Math.max(getMoney(nums, 0, n - 1), getMoney(nums, 1, n)));
    }
    /**DP
     * O(n)
     * O(n)
     * Ideas:
     * P198进阶版
     * 其实就是3种情况: '选头','选尾','都不选'
     * 分别求出这3种情况的值取较大值即可
     * Details:
     * 1. 把DP单独封装
     *      DP内部的逻辑是对于传入的index判断选不选头
     *          如果选头
     *              那么dp[0] = nums[0]; dp[1] = dp[0];
     *              尾肯定不选，所以把长度控制在n-1，这样就不会选中第n-1个house
     *          如果不选头
     *              那么 dp[0] = 0; dp[1] = nums[1];
     *              尾可选可不选，长度依旧是n
     * 2. 传入参数
     *      对于选头，传入index 0 和 length n-1
     *      对于不选头，传入index 1 和 length n
     *          对于不选头这个情况，其实也包含了不选头不选尾的情况，所以只计算这两种情况就可以
     */
    private static int getMoney(int[] nums, int index, int n){
        int[] dp = new int[n];
        if(index == 0){
            dp[0] = nums[0];
            dp[1] = dp[0];
        }
        else{
            dp[0] = 0;
            dp[1] = nums[1];
        }

        for(int i=2; i<n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }

        return dp[n-1];
    }

}
