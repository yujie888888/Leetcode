package ALG_doublepoints;

import java.util.Scanner;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * Custom Judge:
 * The judge will test your solution with the following code:
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * int k = removeDuplicates(nums); // Calls your implementation
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Constraints:
 * 1 <= nums.length <= 3 * 104
 * -100 <= nums[i] <= 100
 * nums is sorted in non-decreasing order.
 */
public class RemoveDuplicates26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the array, use ',' as separator:");
        String inputLine = sc.nextLine();
        String[] line = inputLine.split(",");
        int[] array = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            array[i] = Integer.parseInt(line[i]);
        }
        duplicate(array);
    }

    /**双指针法
     * 这是有序数组，所以可以采取思路：从左向右遍历，slowindex对应的每个数都是不同时期的target
     * 这是哪个鬼才想的呢，不懂，脑子抽筋了
     */
    private static void duplicate(int[] array){
        int slowindex = 1;
        for (int fastindex = 1; fastindex < array.length; fastindex++) {
            if(array[fastindex] != array[slowindex-1]){
                array[slowindex++] = array[fastindex];
            }
        }
        System.out.println("The length after remove elements is "+ slowindex);
        System.out.print("The array after removing is: ");
        System.out.print("[");
        for (int i = 0; i < slowindex; i++) {
            System.out.print(i==slowindex-1 ? array[i] : array[i]+",");
        }
        System.out.println("]");

    }
}
