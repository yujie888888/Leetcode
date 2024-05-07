package Struc_hash;

public class SubarraySumEqualsK560 {
    //TODO
    public static void main(String[] args) {

    }
    // double loop
    // O(n^2) Beats 20%
    public int subarraySum1(int[] nums, int k) {
        int sum;
        int count = 0;
        for(int left=0; left<nums.length;left++){
            //要重置sum
            sum = 0;
            for(int right=left;right<nums.length;right++){
                sum += nums[right];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
    // Prefix Sum + HashMap
    // 有空理解
}
