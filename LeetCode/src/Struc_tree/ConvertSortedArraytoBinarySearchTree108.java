package Struc_tree;

public class ConvertSortedArraytoBinarySearchTree108{
    public static void main(String[] args) {

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return buildPart(0,nums.length-1,nums);
    }
    public TreeNode buildPart(int left, int right, int[] nums){
        if(left > right) return null;
        int mid = left+(right-left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildPart(left,mid-1,nums);
        node.right = buildPart(mid+1,right,nums);
        return node;
    }
}
