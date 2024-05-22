/**
 * 假设你是一名小偷，计划偷窃某个商店。你带了一个可容纳固定重量的背包。商店里有多种不同的商品，每种商品有其重量和价值。
 * 你可以选择偷走某些商品，但每种商品只能偷一次。你的目标是在不超过背包容量的前提下，使背包中的商品总价值最大。
 * 输入:
 * weights: 一个整数列表，表示每个商品的重量。
 * values: 一个整数列表，表示每个商品的价值。
 * capacity: 一个整数，表示背包的最大容量。
 * 输出:
 * 返回一个整数，表示背包能够装载的最大价值。
 * 示例
 * 假设有5种商品，其重量和价值如下：
 * 商品 A：重量 1，价值 1
 * 商品 B：重量 2，价值 6
 * 商品 C：重量 5，价值 18
 * 商品 D：重量 6，价值 22
 * 商品 E：重量 7，价值 28
 * 背包的最大容量为11。
 */
package ALG_DynamicProgramming;
/** Classical Dynamic Programming
 * 思路：
 * https://programmercarl.com/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-1.html#%E6%80%9D%E8%B7%AF
 * 1.dp[i][j]含义: dp[i][j] 表示从下标为[0-i]的物品里"任意取"，放进容量为j的背包，最大总价值是多少
 * 2.recursion formula: dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
 *      不放物品i：
 *          由dp[i - 1][j]推出，即背包容量为j，里面不放物品i的最大价值，此时dp[i][j]就是dp[i - 1][j]
 *          其实就是当物品i的重量大于背包j的重量时，物品i无法放进背包中，所以背包内的价值依然和前面相同。
 *      放物品i：
 *          由dp[i - 1][j - weight[i]]推出，dp[i - 1][j - weight[i]] 为背包容量为j - weight[i]的时候不放物品i的最大价值，
 *          那么dp[i - 1][j - weight[i]] + value[i] ，就是背包放物品i得到的最大价值
 * 3.dp[][]初始化
 *      首先从dp[i][j]的定义出发，如果背包容量j为0的话，即dp[i][0]，无论是选取哪些物品，背包价值总和一定为0
 *      对于只放物品1的时候，要看容量大小进行初始化
 * 4.确定遍历顺序，有两个遍历的维度：物品与背包重量
 *      先遍历谁都可以，但是先遍历物品比较容易理解
 */
public class Bags_01 {
    public static void main(String[] args) {
        int[] weights = {1, 2, 5, 6, 7};
        int[] values = {1, 6, 18, 22, 28};
        int len = weights.length;
        int capacity = 11;
        //最大价值为 40 (取商品 B, C, D)

        int[][]dp = new int[len][capacity+1];
        for(int i=0; i<len; i++) dp[i][0] = 0;
        for(int j=1; j<=capacity; j++){
            if(j>=weights[0]) dp[0][j] = values[0];
            else dp[0][j] = 0;
        }
        for(int i=1; i<len; i++){
            for(int j=1; j<=capacity; j++){
                if(j >= weights[i]){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i]]+values[i]);
                }
                else dp[i][j] = dp[i-1][j];
            }

        }
        System.out.println(dp[len-1][capacity]);
    }
}
