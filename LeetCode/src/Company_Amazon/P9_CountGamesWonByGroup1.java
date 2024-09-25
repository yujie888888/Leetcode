/**
 * Amazon games is organizing a tournament of pair games where two teams of two players each compete against one another.
 * There are two groups group1 and group2 of size n each.
 * The skill levels of the i-th players of groups are group1[i] and group2[i],
 * For each pair of indices, (i,j) (0<=i<j<n), the pair of players(group1[i], group1[j]) compete in the pair game with (group2[i], group2[j]).
 * The winner of the game is group1 if group1[i] + group1[j]> group2[i]+ group2[j], and vice-versa.
 * Given group 1, and group2, find the number of games group1 will win. Since the answer can be large, report it modulo 10^9+ 7.
 * Example
 * Suppose n=3, group1=[1,2,3], and group2 =[3,2,1]
 * Function Description:
 * Complete the function countGamesWonByGroup1 in the editor below
 * countGamesWonByGroup1 takes the following arguments.
 * int group1[n]: The skills of the players of group1
 * int group2[n]: The skills of the players of group2
 * Returns:
 * int: The number of games won by group1 modulo 10^9+ 7
 * Constraints
 * 2<= n <=10^5
 * 1<=group1[i], group2[i]<=10^9
 */
package Company_Amazon;
import java.util.Arrays;

public class P9_CountGamesWonByGroup1 {
    public static void main(String[] args) {

//        int[] group1 = new int[n], group2 = new int[n];
//        for(int i=0; i<n; i++){
//            group1[i] = (int)Math.pow(10,9);
//            group2[i] = (int)Math.pow(10,9)-1;
//        }

//        // 测试用例 1 //1
//        int[] group1 = {1,2,3};
//        int[] group2 = {3,2,1};
//        int n = 3;

//        // 测试用例 2: 所有差值为负 // 预期输出: 0
//        int[] group1 = {1, 2, 3};
//        int[] group2 = {4, 5, 6};
//        int n = 3;

//        // 测试用例 3: 所有差值为正 // 预期输出: 3
//        int[] group1 = {4, 5, 6};
//        int[] group2 = {1, 2, 3};
//        int n = 3;

//        // 测试用例 4: 有正有负，但总和为零 // 预期输出: 3 (组合 (3,5), (3,7), (5,7) 赢)
//        int[] group1 = {1, 3, 5, 7};
//        int[] group2 = {2, 4, 6, 4};
//        int n = 4;

        // 测试用例 5: 大规模输入 // 预期输出: 1
        int n = 100000;
        int[] group1 = new int[n];
        int[] group2 = new int[n];
        for (int i = 0; i < n; i++) {
            group1[i] = (int)Math.pow(10,9);
            group2[i] = (int)Math.pow(10,9)-1;
        }

//        // 测试用例 6: 边界情况 - 只有一个正差值 // 预期输出: 3 (组合 (10,1), (10,2), (10,3) 赢)
//        int[] group1 = {1, 2, 3, 10};
//        int[] group2 = {2, 3, 4, 5};
//        int n = 4;

        //System.out.println(countGamesWonByGroup1(n, group1, group2));
        System.out.println(countGamesWonByGroup2(n, group1, group2));
        //countGamesWonByGroup12(n, group1, group2);
    }
    /**Double-Loop
     * O(n^2)
     * O(1)
     * Ideas:
     * 拿来检查2跑的对不对
     * Every compete team only has two players
     * So we only need to find how much this kind of teams we have and sum the skill score and compare with group2
     */
    private static int countGamesWonByGroup1(int n, int[] group1, int[] group2){
        double count = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(group1[i]+group1[j] > group2[i]+group2[j]){
                    count++;
                }
            }
        }
        return (int)(count % (Math.pow(10,9)+7));
    }

    /**
     * O(nlogn)
     * O(n)
     * Ideas:
     * 把g1和g2转换成diff
     * 只要diff中存在两个值相加>0就说明可以赢
     * 但是直接找时间复杂度也是O(n^2)
     * 所以：
     *  1.排序
     *  2.找征服临界点。0包含在负里
     *  3.从临界点向两边扩
     *  4.细节看注释
     */
    private static int countGamesWonByGroup2(int n, int[] group1, int[] group2){
        //当 n 是 int 类型时，即使我们在计算中使用 long，表达式 n * (n-1) 仍然会在 int 范围内进行计算，然后才转换为 long
        // 这可能导致中间结果溢出
        long longN = n;
        int[] diff = new int[n];
        for(int i=0; i<n; i++){
            diff[i] = (group1[i]-group2[i]);
        }
        Arrays.sort(diff);

        // 找到临界点 k, diff[]中第一个正数的位置
        int k = -1;
        for (int i = 0; i < n; i++) {
            if (diff[i] > 0) {
                k = i;
                break;
            }
        }
        // System.out.println(k);
        // case1 diff中不存在正数
        if(k == -1){
            return 0;
        }

        // case2 diff中的第1个数就是正数
        if(k == 0){
            long res = ((longN*(longN-1)/2) % 1000000007);
            return (int)res;
        }

        // case3
        // 使用两个指针 i 和 j 线性扫描
        int i = k-1;
        int j = k;
        long res = 0;

        // 开始双指针扫描
        while (i >= 0 && j < n) {
            // 赢不了
            if(diff[i] + diff[j] <= 0) {
                // 移动j指针增大diff
                j++;
            }
            // 能赢
            else {
                res += (longN-j);//这一步把i能组队的可能全算上了
                // 换i
                i--;
            }
        }

        // 加上所有非负的组合
        res += (longN-k)*(longN-k-1)/2;

        // 返回结果并取模
        return (int)(res % (Math.pow(10,9)+7));
    }
}
