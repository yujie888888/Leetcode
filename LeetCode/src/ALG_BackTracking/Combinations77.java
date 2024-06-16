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
 * O(k*n^2)) Beats 98%
 * O(k + n^2) Beats 99%
 *   空间复杂度是递归栈空间 + 存储结果空间
 * 思路：
 * 1.先画出树形结构，确定回溯（递归）逻辑
 * 2.终止条件，list.size == k
 * 3.回溯逻辑
 *   遍历i:start到n
 *       先把i加入resL
 *       再将i+1传入BT() 求组合传入i+1保证组合不会重复
 *       BT()出来后恢复resL在这一层的状态
 * 4.确定参数
 * 5.剪枝操作
 *   已经选择的元素个数：resL.size(); 还需要的元素个数为: k-resL.size();
 *   为了保证resL.size能够达到k，n-i+1 >= k-resL.size()    ->    i<=n-(k-resL.size)+1
 * 注意事项：
 * 1.对于用到的参数resL，res，n，k，start，除了start是每次传入要变化以外，其他参数都可以定义成全局的
 * 2.在添加每一个满足条件的list的时候，要new Arraylist<>(resL)，不是直接add resL
 * 3.由于resL和res被定义为全局变量，所以每次用resL和res之前要clear()
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
