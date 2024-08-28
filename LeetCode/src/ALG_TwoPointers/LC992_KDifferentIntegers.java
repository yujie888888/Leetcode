/**
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 * A good array is an array where the number of different integers in that array is exactly k.
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 * Example 1:
 * Input: nums = [1,2,1,2,3], k = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
 * Example 2:
 * Input: nums = [1,2,1,3,4], k = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i], k <= nums.length
 */
package ALG_TwoPointers;
import java.util.HashMap;

public class LC992_KDifferentIntegers {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println((findSubarray(nums, k) - findSubarray(nums, k - 1)));
    }
    /**Slide Window
     * O(n)
     * O(k)
     * ideas:
     * 1.定义一个function，这个function返回unique char的数量小于等于k的subarray的数量
     * 2.然后用findSubarray(nums, k) - findSubarray(nums, k - 1)就能得到unique char的数量刚好为k的subarray的数量
     * Steps:
     * 1.Define:
     *   最多有k个不同的char的subarray的数量,k表示还有多少个unique char的名额可以用
     *   map存的就是从i到j的subarray的char的频次，注意这里如果count==0，要remove这个pair
     * 1.findSubarray()用可变的slide window实现，这个slide window的长度由k控制
     *   如果unique char的数量超过k，那么必须缩小窗口
     *     缩小窗口的时候如果要缩小的位置是一个unique char，那么k++，也就是可以加入的unique char的名额增加
     *     如果不是，直接count--；
     *   如果unique char的数量没有超过k，不用缩小窗口
     * 2.用res记录所有unique数量<=k的subarray的数量
     *      假设 left = 0，right = 2，窗口包含的数组是 [1, 2, 3]。
     *      当 right 移动到 2 时，窗口内的数组是 [1, 2, 3]。
     *      符合条件的子数组有：
     *      [1, 2, 3]
     *      [2, 3]
     *      [3]
     *      这个时候，right 对应的数组的所有子数组数量就是 right - left + 1，因为子数组的数量等于这个窗口大小
     *  最后用(k)-(k-1)就是恰好为k的结果
     */
    private static int findSubarray(int[] nums, int k){
        int i=0, j=0;
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(; j<nums.length; j++){
            if(!map.containsKey(nums[j])) k--;
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            while(k<0){
                if(map.get(nums[i]) == 1){
                    k++;
                    map.remove(nums[i]);
                }
                else map.put(nums[i],map.get(nums[i])-1);
                i++;
            }
            res += (j-i+1);
        }
        return res;
    }
}
