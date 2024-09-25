/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 * Constraints:
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
package ALG_BackTracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**BackTracking
 * O(2^n) "Two to the nth power" or "Two to the n"
 * O(n)
 * Ideas:
 * 求组合问题-->不关注顺序
 * 单一集合-->用start
 * 组合中的元素只能用一次-->用i+1使得每次回溯的层数都从i+1的位置开始
 * 组合中的元素会重复但是要求组合不会重复-->排序+去重
 * 注意事项:
 * 1.不用sum直接用target
 * 2.去重的意思是，每一层，不能选择值相同的元素（如果在这一层选择相同的值，后续的操作是一样的，所以一定会出现重复的组合），但是不同层当然可以选择和上一层相同的元素，这个不会导致组合出现重复
 * 3.所以去重操作是：
 *     1.首先对集合进行排序
 *     2.对每一层，每一层的起点是start，进行重复判断，也就是对比i和i-1位置的元素
 *     3.如果元素相同，就跳过
 *     4.如果元素不相同，继续下一层寻找
 * 4.所以去重判断是i>start而不是i>0,为的就是确定每一层的范围
 */
public class P40_CombinationSumII {
    static List<Integer> resL = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        res.clear();
        Arrays.sort(candidates);
        backtracking(candidates,target,0);
        System.out.println(res);
    }
    private static void backtracking(int[] candidates, int target, int start){
        if(target == 0){
            res.add(new ArrayList<>(resL));
            return;
        }
        for(int i=start; i<candidates.length; i++){
            if(i>start && candidates[i] == candidates[i-1]) continue;//去重
            if(target-candidates[i]<0) break; //剪枝
            target -= candidates[i];
            resL.add(candidates[i]);
            backtracking(candidates,target,i+1);//递归
            resL.remove(resL.size()-1);//回溯
            target += candidates[i];//回溯
        }
    }
}
