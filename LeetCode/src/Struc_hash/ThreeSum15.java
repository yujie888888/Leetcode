package Struc_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * Constraints:
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */

/**
 * 这道题可以用hashset做，转换成2sum类型做，但是去重很麻烦
 */
public class ThreeSum15 {
    public static void main(String[] args) {
    }

    /**双指针法O(n^2) Beats 95%
     * 去重的思路是如果三个数里，确定了两个数，那么只要存在sum=0的情况下，第三个数一定是一样的
     * 解法：先排序 -> 用num[i],nums[left],nums[right]代表三个数 -> 移动left和right的值进行匹配
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // 可以用HashSet，转换成2sum做，但是去重很麻烦
        // 用双指针做去重更简单
        //存结果
        List<List<Integer>> result = new ArrayList<>();
        //先排序，这样方便指针移动寻找sum=0的点
        Arrays.sort(nums);
        // left在值较小的这边找
        int left;
        // right在值较大的这边找
        int right;
        for(int i=0; i<nums.length-2; i++){
            if(nums[i]>0) return result;
            //对a去重，去除 -1,-1,0,1,2 这种情况
            //不能nums[i] == nums[i + 1]这么写，会把三元组中出现重复元素的情况pass掉
            if(i>0 && nums[i] == nums[i-1]) continue;

            //nums[i]是初始值
            left = i+1;
            right = nums.length-1;
            while(left < right){
                //<0说明需要一个更大的数,left++
                if(nums[i] + nums[left] + nums[right] <0){
                    left++;
                }
                else if(nums[i] + nums[left] + nums[right] >0){
                    right--;
                }
                else{
                    // Arrays.asList() 接受泛型参数，可以传单个integer
                    // Arrays.asList() 接受可变参数，你所传递的一系列整数会被自动封装成一个数组，
                    // 然后这个数组被转换成一个固定大小的列表。
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //如果找到之后，right和left不移动，会陷入死循环
                    //对b和c去重，防止 -3,0,0,1,2,2,2,3,3 这种情况
                    while(left<right && nums[left] == nums[left+1]) left++;
                    while(left<right && nums[right] == nums[right-1]) right--;
                    left ++;
                    right --;
                }
            }
        }
        return result;
    }
}
