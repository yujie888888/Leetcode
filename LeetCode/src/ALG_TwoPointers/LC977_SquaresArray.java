/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 */
package ALG_TwoPointers;
import java.util.Arrays;

public class LC977_SquaresArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
    /**Two Pointers
     * O(n)
     * O(n)
     * 思路：
     * 1.新建一个res存放结果
     * 2.绝对值最大的肯定是从两边出现的，所以left=0,right=len-1，从两边往中间找
     * 3.res的指针k也指向最后一个位置，依次存放结果
     */
    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[nums.length];
        int index = nums.length-1;
        while(left<=right){
            if(Math.abs(nums[left])>=Math.abs(nums[right])){
                res[index] = nums[left]*nums[left];
                left++;
                index--;
            }
            else{
                res[index] = nums[right]*nums[right];
                right--;
                index--;
            }

        }
        return res;
    }
}
