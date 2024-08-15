/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 *
 * Custom Judge:
 * The judge will test your solution with the following code:
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 *                             // It is sorted with no values equaling val.
 * int k = removeElement(nums, val); // Calls your implementation
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 * Example 1:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Constraints:
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
package ALG_TwoPointers;
import java.util.Arrays;
public class LC27_RemoveElement {
    /**
     * 前提：
     * 数组的元素在内存地址中是连续的，不能删除数组中的元素，只能覆盖
     */
    public static void main(String[] args) {
        int[] array = new int[]{3,2,2,3};
        int target = 3;
        System.out.println(Arrays.toString(removeElement1(array,target)));

        array = new int[]{3,2,2,3};
        System.out.println(Arrays.toString(removeElement2(array,target)));
    }
    /**Two Pointers
     * O(n)
     * O(1)
     * 思路：
     * 这道题的定义乱七八糟的，其实要的是一个新数组，改造nums之后得到的新数组
     * slow负责找被覆盖的位置，也就是哪些元素将要被覆盖
     * fast负责找覆盖的元素，也就是说fast决定哪些元素可以放进新数组
     */
    private static int[] removeElement2(int[] nums, int val) {
        int slow =0;
        for(int fast=0; fast<nums.length; fast++){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return Arrays.copyOfRange(nums,0,slow);
    }
    /**Brute Force
     * O(n^2)
     * 思路：
     * 1.排序
     * 2.找出有多少个target值
     * 3.移动一次
     */
    private static int[] removeElement1(int[] nums, int val){
        int n = nums.length;
        Arrays.sort(nums);
        int occur = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == val){
                while((i<n) && (nums[i]==val)){
                    occur++;
                    i++;
                }
                for(int j=i; j<n; j++){
                    nums[j-occur] = nums[j];
                }
            }
        }
        return Arrays.copyOfRange(nums,0,n-occur);
    }
}
