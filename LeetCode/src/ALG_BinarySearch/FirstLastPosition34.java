package ALG_BinarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */
public class FirstLastPosition34 {
    /*
    二分找到其中一个target，然后从这个target的两侧开始寻找
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input array:");
        String inputLine = sc.nextLine();
        System.out.println("Please input target:");
        int target = sc.nextInt();
        if(inputLine.isEmpty()){
            System.out.println("The first index and last index are: [-1,-1]");
            return;
        }
        String[] line = inputLine.split(",");
        int[] nums = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }

        //方法1
        //Arrays.toString() 方法将数组转换为字符串，然后输出字符串
        //System.out.println("The first index and last index are: "+Arrays.toString(search(nums,target)));
        //方法2
        System.out.println("The first index and last index are: "+Arrays.toString(firstLastSearch(nums,target)));
    }
    //方法1，nlogn
    //只要找到target的位置，就从这个位置向前和向后找
    public int[] searchRange1(int[] nums, int target) {
        //binart search
        int[] res = {-1,-1};
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while(left <= right){
            mid = left + (right-left)/2;
            if(nums[mid] == target){
                res[0] = res[1] = mid;
                while(mid>0 && nums[mid - 1] == nums[mid]){
                    mid --;
                    res[0] = mid;
                }
                while(mid < nums.length - 1 && nums[mid+1] == nums[mid]){
                    mid ++;
                    res[1] = mid;
                }
                //keypoint, if find the range, break
                break;
            }
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return res;
    }

    /**方法2 logn 没看懂
     * 两次二分法查找
     * findfirst是找到第一个target的location：只要target==nums[mid],right的变化和nums[mid]>targert的情况一样，设置index记录first location的位置
     * find；ast是找到最后一个target的location：只要target==nums[mid],left的变化和nums[mid]<targert的情况一样，设置index记录last location的位置
     */
    public static int[] firstLastSearch(int[] nums, int target){
        int[] index = new int[2];
        index[0] = firstSearch(nums,target);
        index[1] = lastSearch(nums,target);
        return index;
    }

    public static int firstSearch(int[] nums, int target){
        int index = -1;
        int right = nums.length-1;
        int left = 0;
        int mid;
        while(left <= right){
            mid = left+(right-left)/2;
            //Keypoint 往前找
            if(nums[mid]>=target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
            //index记录first target location
            if(nums[mid] == target) index = mid;
        }
        return index;
    }

    public static int lastSearch(int[] nums, int target){
        int index = -1;
        int right = nums.length-1;
        int left = 0;
        int mid;
        while(left <= right){
            mid = left+(right-left)/2;
            //Keypoint 往后找
            if(nums[mid]<=target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
            //index记录first target location
            if(nums[mid] == target) index = mid;
        }
        return index;
    }

    //方法3，用hashmap O(n)
    public int[] searchRange3(int[] nums, int target) {
        int[] res = {-1,-1};
        Map<Integer,Integer> hashmap = new HashMap<>();
        int flag = 1;
        for(int i=0; i<nums.length; i++){
            hashmap.put(nums[i],i);
            if(flag == 1 && hashmap.containsKey(target)){
                res[0] = hashmap.get(target);
                res[1] = res[0];
                hashmap.remove(target);
                flag ++;
            }
            else if(flag > 1 && hashmap.containsKey(target)){
                flag++;
                res[1] = hashmap.get(target);
            }
        }
        return res;
    }

}
