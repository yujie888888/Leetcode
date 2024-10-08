package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;

public class LC77_Combinations {
    public static void main(String[] args) {

    }
    /**BackTracking
     * O()
     * O()
     * Ideas：
     * 这道题是非常经典的回溯模板做法
     * 1. nums[]元素不重复，元素只能用一次
     * Steps:
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
    public static List<List<Integer>> combine(int n, int k) {
        return bk(n, k, 1, new ArrayList<>(), new ArrayList<>());
    }

    private static List<List<Integer>> bk(int n, int k, int start, List<List<Integer>> res, List<Integer> resL) {
        if(resL.size() == k){
            res.add(new ArrayList<>(resL));
            return res;
        }

        for(int i=start; i<=n; i++){
            resL.add(i);
            bk(n, k, i+1, res, resL);
            resL.remove(resL.size()-1);
        }
        return res;
    }
}
