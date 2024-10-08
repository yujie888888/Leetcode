package ALG_BackTracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90_SubsetsII {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
    /**BackTracking
     * O(n!)
     * O(n!)
     * Ideas:
     * 1.排序
     *      是为了排除相同val的element生成相同的subsets，在bk中排除nums[i] == nums[i-1]的值
     *          不太好理解，但是比如[1,1,2,2]这种，第一个1就已经可以生成第二个1所能生成的所有subset了，所以如果再考虑第二个1就会duplicate
     * 2.在每一层进行检查：如果在这一层，i和i-1对应的num一样，就不用继续了，因为继续下去肯定是重复的
     *      注意，一定是本层对比，也就是i-1>=start
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        return bk(0, res, new ArrayList<>(), nums);
    }
    private static List<List<Integer>> bk(int start, List<List<Integer>> res, List<Integer> resL, int[] nums){
        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i] == nums[i-1]) continue;
            resL.add(nums[i]);
            res.add(new ArrayList<>(resL));
            bk(i+1, res, resL, nums);
            resL.remove(resL.size()-1);
        }
        return res;
    }
}
