/**
 * Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with
 * at least two elements. You may return the answer in any order.
 * Example 1:
 * Input: nums = [4,6,7,7]
 * Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * Example 2:
 * Input: nums = [4,4,3,2,1]
 * Output: [[4,4]]
 * Constraints:
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 */
package ALG_BackTracking;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P491_NondecreasingSubsequences {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> resL = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        res.clear();
        resL.clear();
        backtracking(nums,0);
        System.out.println(res);
    }
    /**Subsequence BackTracking
     * O(2^n)
     * O(n)
     * Ideas:
     * Subsequence是不连续的，题目找的是不连续的不严格递增组合，而且要去重
     * 对于不严格递增，其实是看当前nums[i]和resL中的最后一个num的大小关系，因为是不连续的，所以不是比较i和i-1
     * 对于去重，每一层设置一个set，这里不能直接i和i-1比是因为不能改变数组的状态；如果这一层的set包含当前值，就不用继续了
     */
    private static void backtracking(int[] nums, int start){
        if(resL.size()>=2) res.add(new ArrayList<>(resL));
        HashSet<Integer> set = new HashSet<>();
        for(int i=start; i<nums.length; i++){
            if(!resL.isEmpty() && nums[i]<resL.get(resL.size()-1)) continue;//add 条件
            if(set.contains(nums[i])) continue;//去重
            set.add(nums[i]);
            resL.add(nums[i]);
            backtracking(nums,i+1);
            resL.remove(resL.size()-1);
        }
    }
}
