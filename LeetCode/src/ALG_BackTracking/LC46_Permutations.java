package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;

public class LC46_Permutations {
    /**BackTracking
     * O(n! * n)
     *      backtracking tree的结点数是: n*(n-1)*(n-2)*...*1，也就是recursion次数
     *      非叶子结点执行 O(1)的操作，总共有n!/(n-1)!个, 总工作量是n!/(n-1)!
     *      每个叶子节点执行O(n)的操作，总共有n!个叶子节点, 因此，叶子节点的总工作量是 O(n! * n)
     *      综合来看是O(n! * n)
     * O(n! * n)
     *      res：O(n! * n)
     *      resL：O(n)
     *      used：O(n)
     *      递归栈：O(n)
     *          递归的最大深度为 n，因为每次递归都在当前排列中添加一个元素，直到排列长度为 n
     *          每层递归调用占用 O(1) 的空间（除了局部变量，其他如 res, resL, used 都是共享的，不会在每层递归中额外占用空间）
     * 思路：
     * 1.递归终止条件,resL.len == nums.len
     * 2.回溯/递归逻辑：
     *   因为排列问题，每次都要从头开始搜索，
     *   used数组记录此时path里都有哪些元素使用了，一个排列里一个元素只能使用一次
     * 3.used[]要在递归栈中传递
     * 注意事项：
     * 1.和组合不同，排序每次找元素都要从0开始，为了避免重复使用元素，要用used存储当前path使用过的元素
     * 2.当满足条件的情况return之后，跟着used[i] = 0这一步，这样used[i]其实只追踪到resL的倒数到二个元素的位置，这样很巧妙
     *   这里说不明白，想一下这个过程就懂了
     * 3.如果当前i位置的val用过了，那么就continue往后找
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> resL = new ArrayList<>();
        int[] used = new int[nums.length];
        bk(res, resL, nums, used);
        return res;
    }

    public static void bk(List<List<Integer>> res, List<Integer> resL, int[] nums, int[] used) {
        if (resL.size() == nums.length) {
            // O(n)
            res.add(new ArrayList<>(resL));
            return;
        }
        // cannot use used element
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1)
                continue;
            resL.add(nums[i]);
            used[i] = 1; // mark as used
            bk(res, resL, nums, used);
            used[i] = 0; // unmark this element
            resL.remove(resL.size() - 1); // recovery the resL
        }
    }
}
