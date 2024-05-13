/**
 * In a mystic dungeon, n magicians are standing in a line. Each magician has an attribute that gives you energy. Some magicians can give you negative energy, which means taking energy from you.
 * You have been cursed in such a way that after absorbing energy from magician i, you will be instantly transported to magician (i + k). This process will be repeated until you reach the magician where (i + k) does not exist.
 * In other words, you will choose a starting point and then teleport with k jumps until you reach the end of the magicians' sequence, absorbing all the energy during the journey.
 * You are given an array energy and an integer k. Return the maximum possible energy you can gain.
 * Example 1:
 * Input: energy = [5,2,-10,-5,1], k = 3
 * Output: 3
 * Explanation: We can gain a total energy of 3 by starting from magician 1 absorbing 2 + 1 = 3.
 * Example 2:
 * Input: energy = [-2,-3,-1], k = 2
 * Output: -1
 * Explanation: We can gain a total energy of -1 by starting from magician 2.
 * Constraints:
 * 1 <= energy.length <= 105
 * -1000 <= energy[i] <= 1000
 * 1 <= k <= energy.length - 1
 */
package ALG_DynamicProgramming;
public class Contest397_TakingMaximumEnergy3147 {
    public static void main(String[] args) {
        int[] energy = {5,2,-10,-5,1};
        int k = 3;
        System.out.println(maximumEnergy1(energy,k));
        System.out.println(maximumEnergy2(energy,k));
    }
    /**Dynamic Programming
     * O(n) Beats 100%
     * O(n) Beats 100%
     * 思路:
     * 1.dp[i]:到第i个魔法师，能获取的最大能量
     * 2.dp[i][j] = Max(energy[i][j],dp[i-k]+energy[i])
     *      因为可以从任意一个点出发，所以有两种选择:1.从第i个魔法师开始 2.从第i-k个魔法师传送过来
     * 3.初始化：前k个位置的dp[i]的值就是energy[i]本身
     * 最后，从第len-k个位置开始，遍历dp寻找max，因为最终点只可能在len-k->len之间
     */
    public static int maximumEnergy1(int[] energy, int k) {
        int len = energy.length;
        int[] dp = new int[len];
        for(int i=0; i<k; i++){
            dp[i] = energy[i];
        }
        for(int i=k; i<len; i++){
            dp[i] = Math.max(dp[i-k]+energy[i],energy[i]);
        }
        int max = (int) -Math.pow(10,8);
        for(int i=len-k; i<len; i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    /**iterate method(DP逆向思维)
     * O(n) Beats 100%
     * O(1) Beats 100%
     * 思路：
     * 1.对于每个魔法师，除了最后k个魔法师，选择其余的魔法师的话肯定会跳到某个魔法师处
     * 2.逆向思维，从第len-k-1个魔法师开始，这个魔法师是最后一个会跳跃的魔法师，如果选择这个魔法师，那么一定会获得e[i]+e[i+k]这么多的魔法值
     * 3.继续往前推，对于第x个魔法师，选择第x魔法师开始，那么一定会获得e[x]+e[x+k]这么多的魔法值
     * 不用设置dp[],直接用energy[]本身去存储就可以
     * 到最后energy[x]表示的就是选择x这个位置的魔法师开始，一定会获得多少魔法值
     * 最后比较energy[]中的最大值即可
     */
    public static int maximumEnergy2(int[] energy, int k) {
        for(int i=energy.length-1-k; i>=0; i--){
            energy[i] = energy[i] + energy[i+k];
        }
        int max = -1001;
        for(int num : energy){
            max = Math.max(max,num);
        }
        return max;
    }
}
