/**
 *Given an integer x, return true if x is a
 * palindrome
 * , and false otherwise.
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Constraints:
 * -231 <= x <= 231 - 1
 * Follow up: Could you solve it without converting the integer to a string?
 */
package ALG_DynamicProgramming;
public class TargetSum494 {
    static int count = 0;
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
        int target = 1;
        //dfs
        count = 0;
        dfs(nums,-1,target,0);
    }
    /**(推荐)Dynamic Programming
     *
     *
     */





    /**DFS
     * O(2^n) 有2^n个结点 Beats 35%
     * O(n) Beats 99%
     * 每个数字前都有两个选择的可能性，要么+要么-
     * 建一颗二叉树，每一层的每个结点都有两种选择 +nums[index] || -nums[index]
     * 每个结点代表从最顶层到该层进行多次选择后的不同的sum值
     * 思路：
     * 1.结束条件：当index到最后时return 且在此条件下，sum==target，count++（不是中间有一个target就是一个，而是遍历完所有的==target才是一个）
     * 2.递归逻辑：从一条边遍历到最深
     * 3.参数：nums，index，target，sum
     * 注意事项：
     * 1.我是从index为-1也就是第-1层进去递归的，因为每个数字都有两种选择，从还没有选择的时候进入
     * 2.结束条件写的很巧妙
     */
    public static void dfs(int[] nums ,int index, int target, int sum){
        if(index == nums.length-1){
            if(sum == target){
                count ++;
            }
            return;
        }
        dfs(nums,index+1,target,sum+nums[index+1]);
        dfs(nums,index+1,target,sum-nums[index+1]);
    }
}
