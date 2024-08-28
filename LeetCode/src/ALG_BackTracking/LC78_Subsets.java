/**
 * Given an integer array nums of unique elements, return all possible
 * subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 * Input: nums = [0]
 * Output: [[],[0]]
 * Constraints:
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;

/**BackTracking
 * O(2^n)
 * O(n)
 * Ideas:
 * 也是用回溯求，但是和组合不同的是求subsets需要的结果是树的所有结点，组合是要所有的叶子结点
 */
public class LC78_Subsets {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> resL = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        res.clear();
        backtracking(nums,0);
        System.out.println(res);
    }
    private static void backtracking(int[] nums, int start){
        res.add(new ArrayList<>(resL));
        for(int i=start; i<nums.length; i++){
            resL.add(nums[i]);
            backtracking(nums,i+1);
            resL.remove(resL.size()-1);
        }
    }
}
