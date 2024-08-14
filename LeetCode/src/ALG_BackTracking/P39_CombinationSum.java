/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 * Input: candidates = [2], target = 1
 * Output: []
 * Constraints:
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 */
package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;

public class P39_CombinationSum {
    /**BackTracking
     * O(n * 2^n) Beats 99%
     * Ideas:
     * 要用startindex，但是startindex不用从i+1开始，可以用i开始
     * startindex是用来防止重复
     * backtracking(i+1)是为了防止ele用超过1次
     */
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        res.clear();
        backtracking(candidates,target,0,0);
        System.out.println(res);
    }
    static List<Integer> resL = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    private static void backtracking(int[] candidates, int target, int sum, int idx){
        if(sum >= target){
            if(sum == target){
                res.add(new ArrayList<>(resL));
            }
            return;
        }
        for(int i=idx; i<candidates.length; i++){
            if(sum+candidates[i] > target) continue;
            sum += candidates[i];
            resL.add(candidates[i]);
            backtracking(candidates, target, sum, i);
            resL.remove(resL.size()-1);
            sum -= candidates[i];
        }
    }
}
