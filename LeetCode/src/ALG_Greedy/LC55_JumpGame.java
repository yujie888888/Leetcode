package ALG_Greedy;

public class LC55_JumpGame {
    public static void main(String[] args) {

    }
    /**Greedy
     * O(n)
     * Idas:
     * Use a variable furthest to recode the furthest location when iterate the index i,
     * and furthest means when you depart from the index that you have iterated, you furthest location that you can arrive;
     * 用一个furthest记录遍历到当前位置i的时候，包括位置i在内，能从已经走过的位置出发，能到达的最远位置
     */
    public static boolean canJump1(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        if(nums[0] == 0) return false;
        int furthest = 0;
        for(int i=0; i<n; i++){
            if(i <= furthest){
                furthest = Math.max(furthest, i+nums[i]);
            }
        }
        if(furthest >= n-1) return true;
        return false;
    }
    /**DP
     * O(n^2) 不推荐
     */
    public static boolean canJump2(int[] nums) {
        if(nums.length == 1) return true;
        if(nums[0] == 0) return false;
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[j] >= i-j && dp[j] == true){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }
}
