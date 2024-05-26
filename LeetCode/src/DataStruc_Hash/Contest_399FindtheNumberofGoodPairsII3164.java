/**
 * You are given 2 integer arrays nums1 and nums2 of lengths n and m respectively. You are also given a positive integer k.
 * A pair (i, j) is called good if nums1[i] is divisible by nums2[j] * k (0 <= i <= n - 1, 0 <= j <= m - 1).
 * Return the total number of good pairs.
 * Example 1:
 * Input: nums1 = [1,3,4], nums2 = [1,3,4], k = 1
 * Output: 5
 * Explanation:
 * The 5 good pairs are (0, 0), (1, 0), (1, 1), (2, 0), and (2, 2).
 * Example 2:
 * Input: nums1 = [1,2,4,12], nums2 = [2,4], k = 3
 * Output: 2
 * Explanation:
 * The 2 good pairs are (3, 0) and (3, 1).
 * Constraints:
 * 1 <= n, m <= 10^5
 * 1 <= nums1[i], nums2[j] <= 10^6
 * 1 <= k <= 10^3
 */
package DataStruc_Hash;
import java.util.HashMap;

public class Contest_399FindtheNumberofGoodPairsII3164 {
    public static void main(String[] args){
        int[] nums1 = {1,2,4,12};
        int[] nums2 = {2,4};
        int k = 3;
        System.out.println(numberOfPairs(nums1,nums2,k));
    }
    /**HashMap代码逻辑题
     * O(m * √max(nums1))
     * O(n)
     * 思路:
     * 要注意取值范围，用简单的two-forloop肯定过不了
     * 想到用HashMap来降低时间复杂度
     * 1.用map存nums2的key-val (val-freq)值 -->减少一点时间复杂度
     * 2.题目要求寻找num1的约数，那么从1开始到√num1,逐个寻找num1的约数，然后查看"约数"和"num1/约数"是不是在map中  -->大大减少时间复杂度
     */
    public static long numberOfPairs(int[] nums1, int[] nums2, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            nums2[i] = nums2[i] * k;
            map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
        }
        long count = 0;
        for(int num1 : nums1){
            for(int divisor = 1; divisor*divisor <= num1; divisor++){
                if(num1 % divisor == 0){
                    int fac1 = divisor;
                    int fac2 = num1/divisor;
                    if(map.containsKey(fac1)) count += map.get(fac1);
                    if(fac1 != fac2 && map.containsKey(fac2)) count += map.get(fac2);
                }
            }
        }
        return count;
    }
}
