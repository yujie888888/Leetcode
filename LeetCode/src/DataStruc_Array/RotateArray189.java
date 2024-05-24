package DataStruc_Array;
/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Constraints:
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 */
public class RotateArray189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums,k);
        for(int i : nums){
            System.out.print(i+",");
        }
    }

    /**1、整体+部分旋转法
     * O(n) Beats 100%
     * 注意事项：
     * 1.记住这个解题模板，对于array和string都能做
     * 2.不要加base case if(k == 0 || k%nums.length == 0) return;不知道为什么加了反而提高了runtime
     * 3.注意k的取值，要处理k变成代码能使用的形式
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    /**观察规律
     * O(n) Beats 50%
     */
    private static void findPatternsRotate(int[] nums, int k) {
        if(k == 0) return;
        int len = nums.length;
        k = k % len;
        int[] nums_copy = nums.clone();
        for(int i=0; i<len;i++){
            nums[(i+k)%len] = nums_copy[i];
        }
    }
}
