/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * Constraints:
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
package Topic_Sum;
import java.util.HashMap;
import java.util.Map;
public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(nums,target);
        System.out.println("["+res[0]+","+res[1]+']');
    }
    /**HashMap
     * O() Beats 60%
     * O() Beats 80%
     * 思路:
     * 难点在于怎么排除当前遍历的num，因为一个数不能用两次
     * 因为只存在一个解，所以遍历每一个数num，找diff:target-num是否存在于nums中
     * 注意事项:
     * 1.diff的index不能和当前被遍历的数一样，避免重复使用同一个数,但是containsKey(diff)是遍历了的num，所以要单独加一个判断i!=map.get(diff)
     * 2.map中的key-value pairs are value-index,因为
     *      containsKey() O(1)
     *      containsValue() O(n)
     * 3.hashmap中的key一定是unique的
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i=0; i<nums.length; i++){
            int diff = target-nums[i];
            if(map.containsKey(diff)){
                if(i!=map.get(diff)) return new int[]{i,map.get(diff)};
            }
        }
        return new int[2];
    }
}
