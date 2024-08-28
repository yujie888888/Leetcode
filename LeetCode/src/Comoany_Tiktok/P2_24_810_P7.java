/**
 * Bytedance, renowned for its innovative products like TikTok, is expanding its financial analytics capabilities to
 * offer more comprehensive insights for its creators and partners.
 * The task is to optimize a data processing pipeline for TikTok's financial analytics platform.
 * The objective is to enhance the module to efficiently identify the longest 'good subarray' of financial metrics meeting a specific criterion.
 * Given an array financialMetrics of size n, where each element represents a numerical financial metric,
 * and a threshold value limit, the goal is to find the maximum length of a non-empty consecutive sequence of data points in financialMetrics
 * that satisfies the following condition:
 * Each data point in the sequence must be greater than (limit / length of the sequence).
 * This sequence is termed a 'good subarray' for analysis.
 * If there is no 'good subarray' in the dataset, the function should return -1.
 * Example:
 * n = 5
 * limit = 6
 * financialMetrics = [1, 3, 4, 3, 1]
 * Let's observe all the subarrays of financialMetrics.
 * Analysis of all Subarrays:
 * Subarray: [1] Comparison: 1 < (6/1 = 6), so, this is not a good subarray. Evaluation: Not a good subarray.
 * Subarray: [1, 3] Comparison: 1 < (6/2 = 3), so, this is not a good subarray. Evaluation: Not a good subarray.
 * Subarray: [1, 3, 4] Comparison: 1 < (6/3 = 2), so, this is not a good subarray. Evaluation: Not a good subarray.
 * Subarray: [3, 4, 3] Comparison: 1 < (6/3 = 2), so, this is not a good subarray. Evaluation: Not a good subarray.
 * Subarray: [1, 3, 4, 3, 1] Comparison: 1 < (6/5 = 1.2), so, this is not a good subarray. Evaluation: Not a good subarray.
 * Thus, the maximum length of a good subarray is 3 and the good subarray is [3, 4, 3].
 * Function Description:
 * Complete the function getMaxGoodSubarrayLength in the editor. getMaxGoodSubarrayLength has the following parameter:
 * int limit:
 * int financialMetrics[n]: an array of length n
 * Returns:
 * int: the maximum length of a good subarray of financialMetrics.
 * Constraints:
 * 1 <= n <= 10^5
 * 1 <= financialMetrics[i] <= 10^9
 * 1 <= limit <= 10^9
 */
package Comoany_Tiktok;
import java.util.Arrays;
import java.util.Stack;
public class P2_24_810_P7 {
    /**Monotonic Stack
     * O(n)
     * O(n)
     * 思路：
     * 1.找连续的subarray，因为最后要的是subarray中最小的值>=target,所以用单调栈找以nums[i]为最小界限的subarray(的长度)
     * 2.依次比较：limit/不同长度的subarray ? nums[i]; 同时更新max
     */
    public static void main(String[] args){
        int[] nums = new int[]{1, 3, 4, 3, 1};
        double limit = 6.0;
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] left = new int[n];
        Arrays.fill(left,0);
        int[] right = new int[n];
        Arrays.fill(right,n-1);
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                right[stack.peek()] = i-1;
                stack.pop();
            }
            stack.push(i);
        }
        System.out.println("Right Edge: "+ Arrays.toString(right));
        stack.clear();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                left[stack.peek()] = i+1;
                stack.pop();
            }
            stack.push(i);
        }
        System.out.println("Left Edge: "+ Arrays.toString(left));
        int max = 0;
        for(int i=0; i<n; i++){
            int len = right[i] - left[i] + 1;
            double target = limit/len;
            if(nums[i] >= target){
                max = Math.max(max,len);
            }
        }
        System.out.println(max);
    }
}
