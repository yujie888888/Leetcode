package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;

public class LC216_CombinationSumIII {
    public static void main(String[] args) {
        int n = 7, k=3;
        System.out.println(combinationSum3(k,n));
    }

    /**Back Tacking
     * O(9!/(9-k)!) 递归了k层，第一层有9种选择,第二层8...第k层有(9-k+1)种选择，化简就是O(9!/(9-k)!)
     * O(k) || O(k*k) Recursion stack depth * the store space of every layer
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
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        return findSum(res, new ArrayList<Integer>(), n, k, 0, 1);
    }
    public static List<List<Integer>> findSum(List<List<Integer>> res, List<Integer> resL, int n, int k, int sum, int start) {
        if (resL.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(resL));
            }
            return res;
        }

        for (int i = start; i <= 9; i++) {
            if (sum + i <= n) {
                resL.add(i);
                findSum(res, resL, n, k, sum + i, i+1);
                resL.remove(resL.size() - 1);
            }
        }

        return res;
    }


}

