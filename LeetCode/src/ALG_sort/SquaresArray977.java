package ALG_sort;

import java.util.Scanner;
import java.util.Stack;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * Constraints:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in non-decreasing order.
 */
public class SquaresArray977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input array:");
        String inputLine = sc.nextLine();
        String[] line = inputLine.split(",");
        int[] array = new int[line.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(line[i]);
        }
        sort(array);

    }

     //整一个新栈存放排好序平方好的数
     //最大值肯定是边缘位置，所以从边缘位置向中间靠近
    private static void sort(int[] array){
        Stack<Integer> result = new Stack<>();
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            if(Math.abs(array[left]) >= Math.abs(array[right])){
               //这里不能用队列，队列的话打印出来的结果是反序的
               result.push(array[left]*array[left]);
               left ++;
            }
            else{
                result.push(array[right]*array[right]);
                right --;
            }
        }
        // for-each循环 遍历result中的每个元素，将当前元素赋值给循环变量element，然后执行循环体中的操作
        while(!result.isEmpty()){
            System.out.print(result.size()==1 ? result.pop() : result.pop()+",");
        }
    }
    //双指针法 Beats 100% O(n)
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[nums.length];
        int index = nums.length-1;
        while(left<=right){
            if(nums[left]*nums[left] > nums[right]* nums[right]){
                res[index--] = nums[left]*nums[left];
                left ++;
            }
            else{
                res[index--] = nums[right]*nums[right];
                right --;
            }
        }
        return res;
    }
}
