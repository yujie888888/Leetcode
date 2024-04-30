/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced
 *  binary search tree.
 * Example 1:
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * Example 2:
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */
package Struc_tree;
public class ConvertSortedArraytoBinarySearchTree108{
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        //if(nums.length == 0) return;
        buildPart(0,nums.length-1,nums);
    }
    public static TreeNode buildPart(int left, int right, int[] nums){
        if(left > right) return null;
        int mid = left+(right-left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildPart(left,mid-1,nums);
        node.right = buildPart(mid+1,right,nums);
        return node;
    }
}
