/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: [3]
 * Example 2:
 * Input: nums = [1]
 * Output: [1]
 * Example 3:
 * Input: nums = [1,2]
 * Output: [1,2]
 * Constraints:
 * 1 <= nums.length <= 5 * 104
 * -109 <= nums[i] <= 109
 * Follow up: Could you solve the problem in linear time and in O(1) space?
 */
package Topic_Others;
import java.util.ArrayList;
import java.util.List;

public class MajorityElementII229 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,3,1,3,1,1,5,6,3};
        System.out.println(majorityElement(nums));
    }
    /**Boyer-Moore投票算法扩展
     * O(n)
     * O(1)
     * 思路:
     * 只有一个候选者的时候，一个候选者自己就能"战"到最后
     * 但是次数>n/3的数最多存在两个，所以要有两个候选者
     *
     * 1.设置两个candidate;
     *   因为出现次数超过n/3的数最多只有两个
     * 2.遍历的过程就是“保持候选人总是出现次数最多的元素”的过程;
     *   保证candidate1和candidate2是nums中出现次数前两个最多的数
     * 3.遍历的时候不仅要保证c1和c2是前i个num中出现次数top2的数
     *   还要注意判断顺序，要保证c1和c2不能重复
     *   所以num == candidate1/2要放在判断的开始，先紧着现有的c1和c2
     *      举个例子[2,1,1,3,1,4,5,6]
     *      如果让count1 == 0这个判断放在前面，会发现出现c1=1 c2=1的情况，也就是1被分流了
     * 4.遍历结束后
     *   虽然得到了两个candidate，但是不知道candidate1和candidate2是不是超过n/3的数
     */
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        for(int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(num == candidate1) count1++;
            else if(num == candidate2) count2++;
        }
        List<Integer> res = new ArrayList<>();
        if(count1 > n/3) res.add(candidate1);
        if(count2 > n/3) res.add(candidate2);
        return res;
    }
}
