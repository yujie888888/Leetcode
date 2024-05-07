/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 *
 * Custom Judge:
 * The judge will test your solution with the following code:
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 *                             // It is sorted with no values equaling val.
 * int k = removeElement(nums, val); // Calls your implementation
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 * Example 1:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Constraints:
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
package ALG_doublepoints;
import java.util.Scanner;

public class RemoveElement27 {
    /**解法思路
     * 数组的元素在内存地址中是连续的，不能单独删除数组中的某个元素，只能覆盖。
     *
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the array, use ',' as separator:");
        String inputLine = sc.nextLine();
        String[] line = inputLine.split(",");
        int[] array = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            array[i] = Integer.parseInt(line[i]);
        }
        System.out.println("Please input the number you want to remove:");
        int target = sc.nextInt();

        //forceloop(array,target);
        doublePointer(array,target);
    }

    /**暴力解法
     * for{for{}}
     * O(n^2)
     */
    private static void forceloop(int[] array, int target){
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if(array[i] == target){
                for (int j = i; j < len-1; j++){
                    array[j] = array[j+1];
                }
                len -= 1;
                //不能漏掉刚到上一个被删除位置的元素
                i -= 1;
            }
        }
        System.out.println("The length after remove elements is "+len);
        System.out.print("The array after removing is: ");
        System.out.print("[");
        //其实本质上数组的长度没有减少，因为数组的长度是固定的，如果想动态修改长度，可以用集合类ArrayList
        for (int i = 0; i < len; i++) {
            System.out.print(i==len-1 ? array[i] : array[i]+",");
        }
        System.out.println("]");
    }

    /**Double pointer method (fast and slow pointer method)
     * 双指针法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * fastindex 负责寻找新元素，新元素就是不包含target的其他原色
     * slowindex 负责更新数组
     * 当fastindex负责找到新元素时，slowindex督责更新元素
     * 当fastindex找到非新元素时，slowindex不动
     * 当fastindex又找到新元素时，先将新元素的值赋值（此时slowindex指向的位置就是(第一个)target出现的位置）给slowindex，将target覆盖；slowindex再移动
     */
    private static void doublePointer(int[] array, int target) {
        int slowindex = 0;
        for (int fastindex = 0; fastindex < array.length; fastindex++) {
            // ==  就变成只剩下target的元素
            if(array[fastindex] != target){
                //slowindex++是先用后加 先赋值给array[slowindex]再将slowindex++
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
