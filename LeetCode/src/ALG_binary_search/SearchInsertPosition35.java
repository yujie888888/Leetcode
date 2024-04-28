package ALG_binary_search;

import java.util.Scanner;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
public class SearchInsertPosition35 {
    /**
     * 稍微修改一下二分法，注意当数不存在的时候，返回的位置应该是left
     * 这个是试出来的
     * 1、insert value比最小的还要小
     * 2、insert value比最大的还要打
     * 3、insert value在中间值
     * 这几种情况对应的insert的位置都是left对应的位置
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input array:");
        String inputLine = sc.nextLine();
        String[] inputArray = inputLine.split(",");
        Integer[] array = new Integer[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            array[i] = Integer.parseInt(inputArray[i]);
        }
        System.out.println("The target num is in the "+ (search(array)+1) +"-th");
    }
    public static int search(Integer[] array){
        System.out.println("Please input the target:");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        int right = array.length-1;
        int left = 0;
        int mid;
        while(left<=right){
            mid = left+(right-left)/2;
            if(array[mid] == target){
                return mid;
            }
            else if(array[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        // the index of insert num should be left
        // 演示一下就知道了
        return left;
    }
}
