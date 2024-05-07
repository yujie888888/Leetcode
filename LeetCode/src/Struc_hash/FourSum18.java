package Struc_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]]
 * such that:0 <= a, b, c, d < n a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * Example 1:
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 * Constraints:
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */
public class FourSum18 {
    public static void main(String[] args) {

    }

    /** 双指针法 Beats 80%
     * O(n^3)
     *  需要注意的细节很多：
     *      1、关键第一步是要排序
     *      2、j是i+1，不是0+1
     *      3、base case和剪枝操作可以减少runtime
     *      4、对每一个数字都要去重
     *      5、注意sum的溢出问题
     *      6、对left和right去重用while，以及要注意right>left条件
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // !!Step1:sort()
        Arrays.sort(nums);
        int left;
        int right;
        long sum;
        List<List<Integer>> result = new ArrayList<>();
        //base case
        if(nums.length < 4) return result;
        for(int i=0; i< nums.length-3; i++){
            //剪枝
            if(nums[i] > 0 && nums[i] > target) continue;
            // 每个数字都要去重
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j< nums.length-2; j++){
                // 每个数字都要去重
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                left = j+1;
                right = nums.length - 1;
                while(left < right){
                    // nums[i] + nums[j] + nums[left] + nums[right] > target int会溢出,所以用long
                    sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target) right--;
                    else if(sum < target) left ++;
                    else {
                        result.add(Arrays.asList(nums[i], nums[j],nums[left],nums[right]));
                        // 每个数字都要去重
                        while(left< right && nums[left] == nums[left+1]) left ++;
                        // 每个数字都要去重
                        while(left< right && nums[right] == nums[right-1]) right --;
                        left ++;
                        right --;
                    }
                }
            }
        }
        return result;
    }
}
