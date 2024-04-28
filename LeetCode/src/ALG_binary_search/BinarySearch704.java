package ALG_binary_search;
/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 */

import java.util.Scanner;

public class BinarySearch704 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input array, use ',' to split array");
        String inputLine = sc.nextLine();
        //System.out.println(inputLine);

        //Split
        String[] inputArray = inputLine.split(",");
        //System.out.println(inputArray.length);

        //set value
        Integer[] input = new Integer[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            input[i] = Integer.parseInt(inputArray[i]);
        }

        //Binary Search
        System.out.println("please input the target:");
        int target = sc.nextInt();
        int right = input.length-1;
        int left = 0;
        //Prevent Overflow
        int mid;

        //[left,right]
        while(left<=right){
            mid = left+(right-left)/2;
            if(input[mid] > target){
                right = mid - 1;
            }
            else if(input[mid] < target){
                left = mid + 1;
            }
            else if(input[mid] == target){
                System.out.println(input[mid]+" exists in array and its index is "+mid);
                return;
            }
        }
        System.out.println(target+" does not exists in array");
    }
}
