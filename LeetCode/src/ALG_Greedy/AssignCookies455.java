/**
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
 * Example 1:
 * Input: g = [1,2,3], s = [1,1]
 * Output: 1
 * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
 * And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
 * You need to output 1.
 * Example 2:
 * Input: g = [1,2], s = [1,2,3]
 * Output: 2
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 * Constraints:
 * 1 <= g.length <= 3 * 104
 * 0 <= s.length <= 3 * 104
 * 1 <= g[i], s[j] <= 231 - 1
 */
package ALG_Greedy;
import java.util.Arrays;
public class AssignCookies455 {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,2,3};
        System.out.println(findContentChildren(g,s));
    }

    /**Greedy Algorithm
     * O(nlogn) Beats 98%
     * 这里时间复杂度怎么计算出来的要明白，虽然看似是嵌套循环，但是实际上内循环只执行s.length次，和外循环没有什么关系。
     * 时间复杂度就是看执行次数最多的那条语句被执行了多少次，不是看别的
     * O(1) Beats 95%
     * 考虑局部最优解，再想一下全局最优解，如果没有反例，就用Greedy试一下
     * 思路：
     * 1.局部最优解: 让最小胃口的人吃最小size的饼干; 其实先满足胃口最大的也可以。
     * 2.全局最优解：想不出来反例
     * 3.先sort g和s
     * 4.外循环循环胃口g，内循环size s
     * 5.对于胃口最小的，选一个满足最小胃口的最小s
     * 6.这个饼干被吃掉之后，下一次外循环到内循环的时候要从被吃掉的这个饼干的下一个开始
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = 0;
        for(int i : g){
            for(int j=start; j<s.length; j++){
                if(s[j] >= i){
                    count ++;
                    start = j+1;
                    break;
                }
            }
        }
        return count;
    }
}
