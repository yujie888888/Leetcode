package ALG_TwoPointers;
import java.util.Arrays;

public class LC26_RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(Arrays.toString(removeDuplicates(nums)));
    }
    /**Two Pointers
     * O(n)
     * O(1)
     * 思路：
     * fast找新元素时，如果是重复的元素就跳过；如果不是就赋值slow
     */
    private static int[] removeDuplicates(int[] nums){
        int slow = 1;
        int fast = 1;
        while(fast<nums.length){
            if(nums[fast] == nums[fast-1]){
                fast++;
            }
            else{
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        int[] res = new int[slow];
        for(int i=0; i<slow; i++){
            res[i] = nums[i];
        }
        return res;
    }
}
