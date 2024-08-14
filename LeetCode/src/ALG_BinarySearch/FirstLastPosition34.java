/**
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with ❗️O(log n)❗️ runtime complexity.
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
package ALG_BinarySearch;

public class FirstLastPosition34 {
    /**Binary Search
     * O(logn)
     * O(1)
     * 思路：
     * 注意要求是logn的时间复杂度，目前只能想到二分法
     * 只存在两种情况
     * 1.nums中不存在target
     * 2.nums中存在target
     * 这两种情况可以根据边界的返回值来判断
     * 找边界：
     * 其实就是修改二分法，将其中nums[mid]==target的情况拉出来，沿着==的情况向左向后找位置
     * 1.找左边界
     *  targrt比nums[mid]大的的情况：
     *      left=mid+1
     *  targrt比nums[mid]小的的情况：
     *      right=mid-1
     *  targrt等于nums[mid]的的情况：
     *      right=mid-1
     *      leftBorder=right *Key*
     *  这样找到的左边界+1就是要找的位置
     *      左边界在target存在的情况下最左会到-1的位置
     *      在target不存在的情况下就是leftBorder没有找到
     * 2.找右边界
     *  同理
     * 3.判断
     *  1.如果左边界或者右边界的值==-2 or ==n+1，也就是在nums中没找到对应的target匹配，就返回[-1,-1]
     *  2.否则返回[left+1,right-1]
     */
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        if(nums.length==0) {
            System.out.println("["+-1+','+-1+"]");
            return;
        }
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        if(leftBorder == -2 || rightBorder == nums.length+1){
            System.out.println("["+-1+','+-1+"]");
        }
        else{
            System.out.println("["+(leftBorder+1)+','+(rightBorder-1)+"]");
        }
    }
    private static int getLeftBorder(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int leftBorder = -2;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target>nums[mid]){
                left = mid+1;
            }
            else if(target<nums[mid]){
                right = mid-1;
            }
            else{
                right = mid-1;
                leftBorder = right;
            }
        }
        return leftBorder;
    }
    private static int getRightBorder(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int rightBorder = nums.length+1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target>nums[mid]){
                left = mid+1;
            }
            else if(target<nums[mid]){
                right = mid-1;
            }
            else{
                left = mid+1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }
}
