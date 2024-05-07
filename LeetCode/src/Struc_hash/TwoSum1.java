package Struc_hash;

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

import java.util.HashMap;
import java.util.Map;

/**
 * 这道题不能用滑动窗口做，因为这两个数可能是不连续的
 */
public class TwoSum1 {
    public static void main(String[] args) {

    }
    //hashmap如果要放count数，用到getordefault，但是对于单纯的key-value，直接加就好了，也就是map.put(nums[i], i);这里面一个数对应一个index，而不是对应的数字的数量
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        //value-index
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            //here pay attention
            map.put(nums[i], i);
        }
        int diff;
        for(int j=0; j<nums.length; j++){
            diff = target - nums[j];
            //注意不能找这个数本身
            if(map.containsKey(diff) && map.get(diff) != j){
                res[0] = j;
                res[1] = map.get(diff);
                break;
            }
        }
        return res;
    }


}
