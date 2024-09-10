package ALG_TwoPointers;

public class LC80_RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(nums));
    }

    /**Two Pointers
     * O(n)
     * Ideas:
     * 和P26 P27一样的思路，多一个判断times
     * 我真nb，随便写几下竟然就成功了
     */
    public static int removeDuplicates(int[] nums) {
        int times = 1;
        int slow = 1;
        int fast = 1;
        while(fast < nums.length){
            if(times < 2 && nums[fast] == nums[fast-1]){
                times++;
                nums[slow] = nums[fast];
                slow ++;
                fast ++;
            }

            while(fast<nums.length && times == 2 && nums[fast] == nums[fast-1]){
                fast++;
            }

            times = 0;
            if(fast<nums.length && nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                times++;
                slow++;
                fast++;
            }
        }
        return slow;
    }
}
