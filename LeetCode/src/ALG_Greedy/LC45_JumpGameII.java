package ALG_Greedy;
import java.util.Arrays;

public class LC45_JumpGameII {
    public static void main(String[] args) {

    }
    /**Greedy
     * O(n)
     * Ideas:
     * 不太好理解
     * 这个一定是有答案的
     * 然后先从i=0出发，记录一个curMax，which means if you depart from i, the furthest location you can arrive
     * 然后在这个furthest的范围内，依次更新nextMax的值，which means if we select one of the index that among the [i to curMax], the furthest index we can arrive
     * 有点像从curMax这个范围出发，然后找下一个从该范围内出发某个点，这个点能到达的最远位置，把这个curMax范围内的点看做是一个整体
     * ->如果i到达了curMax，res++，Greedy思想，找从curMax范围内的点出发的，最大的nextMax的位置，也就是每次都找nextMax最大的点
     */
    public static int jump1(int[] nums) {
        // Must has a res so select the best answer every jump
        int n = nums.length;
        if(n == 1) return 0;
        int res = 0;
        int curMax = 0;
        int nextMax = 0;
        for(int i=0; i<n; i++){
            nextMax = Math.max(i+nums[i], nextMax);
            if(i == curMax){
                res++;
                curMax = nextMax;
            }
            if(curMax == n-1){
                return res;
            }
        }
        return res;
    }

    /**DP
     * O(n^2)
     */
    public static int jump2(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp,n);
        dp[0] = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[j] + j >= i){
                    dp[i] = Math.min((dp[j]+1),dp[i]);
                    // System.out.println("dp["+i+"]= "+dp[i]);
                }
            }
        }
        return dp[n-1];
    }
}
