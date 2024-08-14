/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
package ALG_BinarySearch;

public class LC35_SearchInsertPosition {
    /**Binary Search
     * O(logn)
     * O(1)
     * 思路：
     * 其实就四种情况
     * 1、nums中有这个target，和经典二分法的作用一样-1
     * 2、nums中没有这个target，这时就要找位置
     *  1、insert value在中间值-2
     *  2、insert value比最小的还要小-3
     *  3、insert value比最大的还要打-4
     * 对于情况1，直接返回找到的mid
     * 对于情况234
     * 对于请情况34也可以直接单独判断，和min和max比较，比较的结果直接返回0或nums.len
     */
    public static void main(String[] args) {
        int[] nums = {1,3,3,4,5,6};
        int target = 0;
        System.out.println(search(nums,target));
    }
    public static int search(int[] array, int target){
        int right = array.length-1;
        int left = 0;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(array[mid] < target){
                left = mid + 1;
            }
            else if(array[mid] > target){
                right = mid - 1;
            }
            else{
                return mid;
            }
        }
        return left;
    }
}
