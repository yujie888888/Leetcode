/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 * Constraints:
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;

public class P46_Permutations {
    /**BackTracking
     * O(n*n) n=nums.length() Beats 95%
     * O(n + n*n!) n!表示n的阶乘,表示结果个数 *n表示每个结果的长度(可选) Beats 92%
     * 思路：
     * 1.递归终止条件,resL.len == nums.len
     * 2.回溯/递归逻辑：
     *   因为排列问题，每次都要从头开始搜索，
     *   used数组记录此时path里都有哪些元素使用了，一个排列里一个元素只能使用一次
     * 3.递归函数参数: used[]
     * 注意事项：
     * 1.和组合不同，排序每次找元素都要从0开始，为了避免重复使用元素，要用used存储当前path使用过的元素
     * 2.当满足条件的情况return之后，跟着used[i] = 0这一步，这样used[i]其实只追踪到resL的倒数到二个元素的位置，这样很巧妙
     *   这里说不明白，想一下这个过程就懂了
     * 3.如果当前i位置的val用过了，那么就continue往后找
     */
    static List<Integer> resL = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    static int[]nums = {1,2,3};
    public static void main(String[] args) {
        resL.clear();
        res.clear();
        int[] used = new int[nums.length];
        backtracking(used);
        System.out.println(res);
    }
    public static void backtracking(int[] used){
        if(resL.size() == nums.length){
            res.add(new ArrayList<>(resL));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(used[i] == 1) continue;
            resL.add(nums[i]);
            used[i] = 1;
            backtracking(used);
            resL.remove(resL.size()-1);
            used[i] = 0;
        }
    }
}
