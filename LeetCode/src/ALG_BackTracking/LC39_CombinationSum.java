package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;

public class LC39_CombinationSum {
    public static void main(String[] args) {

    }
    /**BackTracking
     * O()
     * Ideas:
     * 1.保证unique resL  -> for loop start index == start
     * 2.nums[]中的元素可以重复使用  -> pass start index == i
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return bk(new ArrayList<>(), new ArrayList<>(), candidates, target, 0, 0);
    }
    public static List<List<Integer>> bk(List<List<Integer>> res, List<Integer> resL, int[] nums, int target, int sum, int start){
        if(sum == target){
            res.add(new ArrayList<>(resL));
            return res;
        }

        for(int i=start; i<nums.length; i++){
            if(sum+nums[i] > target) continue;
            else{
                resL.add(nums[i]);
                bk(res, resL, nums, target, sum+nums[i], i);
                resL.remove(resL.size()-1);
            }
        }
        return res;
    }
}
