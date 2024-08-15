package ALG_TwoPointers;

import java.util.Scanner;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 * Constraints:
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class MinimumSizeSubarray209 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the array:");
        String inputLine = sc.nextLine();
        String[] line = inputLine.split(",");
        int[] array = new int[line.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(line[i]);
        }
        System.out.println("Please input the target:");
        int target = sc.nextInt();
        System.out.println("The minimum length is: " + searchMin(array,target) );
    }

    private static int searchMin(int[] array, int target){
        if(array.length == 0) return 0;
        //min_len这里要做处理，如果一直不存在sum>=target的情况下，如果不做处理，min_len的原始值会被直接返回
        int min_len = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right = 0; right< array.length; right++){
            sum += array[right];
            while(sum>=target){
                min_len = min_len<(right-left+1) ? min_len : right-left+1;
                //开始滑动窗口，寻找更多满足条件的情况
                sum -= array[left];
                left ++;//窗口变小
            }
        }
        //这时min_len肯定没有被赋值，也就是不存在满足条件的子数组
        return min_len == Integer.MAX_VALUE ? 0 : min_len;
    }
}
