/**
 * Given an integer array nums and an integer k, modify the array in the following way:
 * choose an index i and replace nums[i] with -nums[i].
 * You should apply this process exactly k times. You may choose the same index i multiple times.
 * Return the largest possible sum of the array after modifying it in this way.
 * Example 1:
 * Input: nums = [4,2,3], k = 1
 * Output: 5
 * Explanation: Choose index 1 and nums becomes [4,-2,3].
 * Example 2:
 * Input: nums = [3,-1,0,2], k = 3
 * Output: 6
 * Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
 * Example 3:
 * Input: nums = [2,-3,-1,5,-4], k = 2
 * Output: 13
 * Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
 * Constraints:
 * 1 <= nums.length <= 104
 * -100 <= nums[i] <= 100
 * 1 <= k <= 104
 */
package Topic_Others;
import java.util.Arrays;

public class LC1005_MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        int[] nums = {-4,-2,-3};
        int k = 4;
        System.out.println(largestSumAfterKNegations(nums,k));
    }
    /**代码逻辑细节题
     * O(k+nlogn)
     * O(1)
     * Ideas:
     * 按照题目要求写逻辑就行
     */
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        for(;i<k && i<nums.length; i++){
            if(nums[i]<0) nums[i] = -nums[i];
            else if(nums[i] == 0) return calSum(nums);
            else break;
        }
        Arrays.sort(nums);
        if((k-i)%2 == 1) nums[0] = -nums[0];
        return calSum(nums);
    }
    private static int calSum(int[] nums){
        int sum = 0;
        for(int num : nums) sum+=num;
        return sum;
    }
}
