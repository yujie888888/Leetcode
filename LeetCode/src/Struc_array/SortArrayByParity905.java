package Struc_array;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByParity905 {
    public static void main(String[] args) {

    }
    //方法1。用了两个arraylist
    //O(n) Beats 60%
    public int[] sortArrayByParity1(int[] nums) {
        if(nums.length == 1) return nums;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int num : nums){
            if(num%2 == 0) list1.add(num);
            else list2.add(num);
        }
        for(int i=0; i<list1.size();i++){
            nums[i] = list1.get(i);
        }
        for(int j=list1.size(); j<list1.size()+list2.size(); j++){
            nums[j] = list2.get(j-list1.size());
        }
        return nums;
    }
    //方法2 双指针法
    //O(n) Beats 100%
    public int[] sortArrayByParity2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            if(nums[left]%2 == 0){
                left++;
            }
            else{
                while(left<right && nums[right]%2 != 0){
                    right--;
                }
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            }
        }
        return nums;
    }
}
