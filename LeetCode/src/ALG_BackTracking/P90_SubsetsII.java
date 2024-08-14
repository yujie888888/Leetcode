/**
 *
 */
package ALG_BackTracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class P90_SubsetsII {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> resL = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        res.clear();
        resL.clear();
        HashSet<List<Integer>> set = new HashSet<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        backtracking1(nums,0,set);
        //backtracking2(nums,0);
        System.out.println(res);
    }
    /**BackTracking + Set
     * O(2^n)
     * O(n)
     * Ideas:
     * 在P78的基础上加一个去重
     * 为什么用了set还要sort？
     * --因为如果不sort，对于例子4,1,4,4来说，set里4，1，4和1，4，4是不同的，但实际上要求的是组合，所以按照题目要求这两个组合是一样的
     * --所以一定要sort
     */
    private static void backtracking1(int[] nums, int start, HashSet<List<Integer>> set){
        for(int i=start; i<nums.length; i++){
            resL.add(nums[i]);
            if(set.add(new ArrayList<>(resL))){
                res.add(new ArrayList<>(resL));
                backtracking1(nums,i+1,set);
            }
            resL.remove(resL.size()-1);//为什么放在外面？
        }
    }
    /**BackTracking
     * O(2^n)
     * O(n)
     * Ideas:
     * 没用Set，直接是排序后，在每一层进行检查：如果在这一层，i和i-1对应的num一样，就不用继续了，因为继续下去肯定是重复的
     * 注意，一定是本层对比，也就是i-1>=start
     */
    private static void backtracking2(int[] nums, int start){
        for(int i=start; i<nums.length; i++){
            if(i-1>=start && nums[i]==nums[i-1]) continue;
            resL.add(nums[i]);
            res.add(new ArrayList<>(resL));
            backtracking2(nums,i+1);
            resL.remove(resL.size()-1);
        }
    }
}
