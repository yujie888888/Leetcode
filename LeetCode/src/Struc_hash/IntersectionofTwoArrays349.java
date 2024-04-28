package Struc_hash;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection
 * Each element in the result must be unique and you may return the result in any order.
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class IntersectionofTwoArrays349 {
    public static void main(String[] args) {

    }
    //O(m+n)
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> intersec = new HashSet<>();
        for(int i : nums1){
            // hashset本来就是唯一值，所以在添加之前不用检查hashset.contains(i)
            // 直接添加元素到HashSet中，如果元素已经存在，HashSet会自动忽略它。
            intersec.add(i);
        }
        ArrayList<Integer> re = new ArrayList<>();
        for(int j : nums2){
            if(intersec.contains(j)){
                re.add(j);
                // 移除已添加的元素，防止重复添加
                intersec.remove(j);
            }
        }
        int[] result = new int[re.size()];
        int i=0;
        for(int j : re){
            result[i++] = j;
        }
        return result;
    }
}
