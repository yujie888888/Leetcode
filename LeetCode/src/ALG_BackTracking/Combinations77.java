/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 * Example 1:
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 * Constraints:
 * 1 <= n <= 20
 * 1 <= k <= n
 */
package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;
/**BackTracking
 * O(k*(n^k)) k是树的深度，n^k只是估计值，剪枝之后肯定比这个小 Beats 98%
 * O(k + C(n,k)) Beats 75%
 * 思路：
 * 1.先画出树形结构，确定回溯（递归）逻辑
 * 2.确定终止条件，当内list size == k
 * 3.确定回溯逻辑，
 *   一个for循环，从i/start位置到n为止，加入当前i的值
 *   调用BT()，判断是否是一个满足条件的值
 *      如果是，就将list加入res
 *      如果不是，就继续进入for循环的回溯逻辑
 *   对于到达最后条件的resL，要pop出最后一个数，回溯的核心思想
 * 4.确定要用到的参数，n，k，start(start就是在array中的位移)
 * 5.进行剪枝操作
 *   这个剪枝是为了减少遍历到一半发现长度根本不够的情况
 *   已经选择的元素个数：path.size();
 *   还需要的元素个数为: k - path.size();
 *   在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
 *   为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
 *   举个例子，n = 4，k = 3， 目前已经选取的元素为0（path.size为0），n - (k - 0) + 1 即 4 - ( 3 - 0) + 1 = 2。
 *   从2开始搜索都是合理的，可以是组合[2, 3, 4]。
 * 注意事项：
 * 1.对于用到的参数resL，res，n，k，start，除了start是每次传入要变化以外，其他参数都可以定义成全局的
 * 2.i就是数字，不是索引，所以要从1开始
 * 3.在添加每一个满足条件的list的时候，要new Arraylist<>(resL)，不是直接add resL
 * 4.由于resL和res被定义为全局变量，所以每次用resL和res之前要clear()
 */
public class Combinations77 {
    static List<Integer> resL = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int n = 4, k = 2;
        resL.clear();
        res.clear();
        backTracking(n,k,1);
        System.out.println(res);
    }
    public static void backTracking(int n, int k, int start){
        if(resL.size() == k){
            res.add(new ArrayList<>(resL));
            return;
        }
        for(int i=start; i<=n-(k-resL.size())+1; i++){
            resL.add(i);
            backTracking(n, k, i+1);
            resL.remove(resL.size()-1);
        }
    }
}
