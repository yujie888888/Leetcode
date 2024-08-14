/**
 * Leetcode 3040
 */
package Company_Uber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class P11_Leetcode3040 {
    public static void main(String[] args){
        int[] nums = {3,2,1,2,3,4};
        int max = 0, n = nums.length;
        for (int score : new HashSet<>(List.of(nums[0] + nums[1], nums[0] + nums[n - 1], nums[n - 2] + nums[n - 1]))) {
            max = Math.max(max, dfs(nums, 0, n - 1, score, new HashMap<String, Integer>()));
        }
        System.out.println(max);
    }
    private static int dfs(int[] nums, int lo, int hi, int score, Map<String, Integer> cache) {
        if (hi <= lo) {
            return 0;
        }
        String key = lo + ", " + hi;
        if (!cache.containsKey(key)) {
            int max = 0;
            if (score == nums[lo] + nums[lo + 1]) {
                max = Math.max(max, 1 + dfs(nums, lo + 2, hi, score, cache));
            }
            if (score == nums[lo] + nums[hi]) {
                max = Math.max(max, 1 + dfs(nums, lo + 1, hi - 1, score, cache));
            }
            if (score == nums[hi - 1] + nums[hi]) {
                max = Math.max(max, 1 + dfs(nums, lo, hi - 2, score, cache));
            }
            cache.put(key, max);
        }
        return cache.get(key);
    }
}
