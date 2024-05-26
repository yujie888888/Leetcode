/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * Constraints:
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
package DataStruc_Hash;
import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate217 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate1(nums));
        System.out.println(containsDuplicate2(nums));
    }
    /**Arrays.sort()
     * O(nlogn)+O(n) Beats 10%
     * O(1) Beats 90%
     * 思路：
     * sort之后前后比较，只要存在一个重复的数，就true
     */
    public static boolean containsDuplicate1(int[] nums) {
        if(nums.length == 1) return false;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]) return true;
        }
        return false;
    }
    /**HashSet
     * O(n) Beats 90%
     * O(n) Beats 70%
     * 思路:
     * 1.让num中的数字依次加入hashset
     *   在加入的过程中，如果遇到重复的数，直接返回true
     * 注意事项:
     *1.一开始看到1<=nums.length<=10^5 不敢用hash
     *  但其实这道题用hashSet没问题，最坏也不会超过10^5
     *  用hashmap保存频率后遍历频率是否>1 肯定不行，memory会超
     *  但是用hashmap模拟hashset做肯定也可以，但没必要
     */
    public static boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
