/**
 * You are given two integer arrays nums1 and nums2.
 * From nums1 two elements have been removed, and all other elements have been increased (or decreased in the case of negative) by an integer, represented by the variable x.
 * As a result, nums1 becomes equal to nums2. Two arrays are considered equal when they contain the same integers with the same frequencies.
 * Return the minimum possible integer x that achieves this equivalence.
 * Example 1:
 * Input: nums1 = [4,20,16,12,8], nums2 = [14,18,10]
 * Output: -2
 * Explanation:
 * After removing elements at indices [0,4] and adding -2, nums1 becomes [18,14,10].
 * Example 2:
 * Input: nums1 = [3,5,5,3], nums2 = [7,7]
 * Output: 2
 * Explanation:
 * After removing elements at indices [0,3] and adding 2, nums1 becomes [7,7].
 * Constraints:
 * 3 <= nums1.length <= 200
 * nums2.length == nums1.length - 2
 * 0 <= nums1[i], nums2[i] <= 1000
 * The test cases are generated in a way that there is an integer x such that nums1 can become equal to nums2 by removing two elements and adding x to each element of nums1.
 */
package Struc_array;
import java.util.Arrays;

public class Contest395_FindtheIntegerII3132 {
    public static void main(String[] args) {
        int[] nums1 = {4,20,16,12,8};
        int[] nums2 = {14,18,10};
        System.out.println(minimumAddedInteger(nums1, nums2));
    }
    /**代码逻辑题(细节爆炸)
     * O(n) 70%
     * O() 91%
     * 直接给我做吐了，逻辑细节太多了
     * 整理别人的解法思路:
     * 1.外循环：从nums1[0]出发，依次移动两次(这个两次是固定的，是nums1和nums2的长度差值)
     * 2.内循环：从nums2[0]出发，匹配nums2[0]-nums1[i]的差
     *      如果i+1和i+2都不满足==diff,说明删除这两个元素也不满足要求，不能继续删除了，退出，移动i的位置
     * 4.每次从内循环出来，只要nums2进行到最后一个且"remove"的次数不超过2，说明此时的差值diff是一个满足条件的diff
     * 5.取diff的最小值
     * 注意事项：
     * 1.要提前sort nums1和nums2
     */
    public static int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        int res = 1001;
        for(int displs=0; displs<=2; displs++){
            int diff = nums2[0] - nums1[displs];
            //displs其实也是移除了displs个元素的意思
            int rm = displs;
            int j = 1;
            for(int i=displs+1; i<m & j<n; i++){
                if(nums2[j] - nums1[i] != diff && rm == 2) break;
                if(nums2[j] - nums1[i] != diff){
                    rm ++;
                }
                //j不能放在for里直接无条件++，因为要保证所有满足条件的情况下j在nums2的最后一个位置
                else j++;
            }
            if(j == n){
                res = Math.min(res,diff);
            }
        }
        return res == 1001 ? 0 : res;
    }
}
