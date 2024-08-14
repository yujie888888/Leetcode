/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 * Example 1:
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations.
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 * Constraints:
 * 2 <= k <= 9
 * 1 <= n <= 60
 */
package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;
/**Back Tacking1
 * O(C(n,3))/ O(n*2^n) Beats 100%
 * O(k+ k*C(n,3))
 * 思路:
 * 从1-9中，选k个，和为n的组合有多少
 * 1.终止条件 resL.size==k
 *   加入res条件：sum==n
 * 2.递归逻辑
 *   每一层可以选1-9任意一个数字，把这个数字加入resL
 *   然后进入下一层，因为是组合，所以用i+1表示下一层start的位置
 * 3.剪枝
 *   如果传的是sum，那么用sum更好，但是这里用i来剪枝也可以
 *   if(i>n)没有必要再继续这一个组合
 */
public class P216_CombinationSumIII {
    public static void main(String[] args) {
        int n = 7, k=3;
        res.clear();
        backtarcking(k, n, 1);
        System.out.println(res);
        //方法2
        System.out.println(combinationSum3(k,n));
    }
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> resL = new ArrayList<>();
    private static void backtarcking(int k, int n, int start){
        if(resL.size() == k){
            int sum = 0;
            for(int num : resL) sum += num;
            if(sum == n) res.add(new ArrayList(resL));
            return;
        }
        for(int i=start; i<=9 && i<n; i++){
            resL.add(i);
            backtarcking(k, n, i+1);
            resL.remove(resL.size()-1);
        }
    }

    /**Back Tacking2
     * Ideas:
     * 和1一样，只是用sum传递
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {
        res1.clear();
        backtracking1(k,n,1,0);
        return res1;
    }
    static List<Integer> resL1 = new ArrayList<>();
    static List<List<Integer>> res1 = new ArrayList<>();
    private static void backtracking1(int k, int n, int start, int sum){
        if(resL1.size() == k){
            if(sum == n){
                res1.add(new ArrayList<>(resL1));
            }
            return;
        }
        for(int i=start; i<=9; i++){
            if(sum < n){
                resL1.add(i);
                sum += i;
                backtracking1(k,n,i+1,sum);
                sum -= i;
                resL1.remove(resL1.size()-1);
            }
        }
    }
}

