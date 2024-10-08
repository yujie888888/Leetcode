package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;

/**BackTracking
 * O()
 * O()
 * Ideas:
 *
 */
public class LC78_Subsets {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> subsets(int[] nums) {
        return backtracking(new ArrayList<>(), new ArrayList<>(), nums,0);
    }

    private static List<List<Integer>> backtracking(List<List<Integer>> res, List<Integer> resL, int[] nums, int start){
        // 放在这里和放在loop里的区别就是放在这里会多加一个空list到res
        res.add(new ArrayList<>(resL));
        for(int i=start; i<nums.length; i++){
            resL.add(nums[i]);
            backtracking(res, resL, nums, i+1);
            resL.remove(resL.size()-1);
        }
        return res;
    }
}
