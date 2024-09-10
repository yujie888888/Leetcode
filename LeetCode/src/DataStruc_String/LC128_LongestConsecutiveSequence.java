package DataStruc_String;
import java.util.Arrays;
import java.util.HashSet;

public class LC128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2,5};
        System.out.println(longestConsecutive1(nums));
        System.out.println(longestConsecutive2(nums));
    }

    /**HashSet
     * O(n)
     * Ideas:
     * 在O(n)内的很巧妙的做法
     * 直接用HashSet去除重复num
     * 然后遍历num，但是遍历的时候要看这个num是不是可以作为某个链的第一个数字
     *      如果可以，才进去遍历然后计算这个链的长度
     *      这样虽然是for(){while(){}}但其实每个num只处理了一次，所以时间复杂度是O(n)
     */
    public static int longestConsecutive1(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet();
        for(int num : nums){
            set.add(num);
        }
        int res = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                int len = 1;
                int i = 1;
                while(set.contains(num+i)){
                    len++;
                    i++;
                }
                res = Math.max(res,len);
            }
        }
        return res;
    }

    /**Sort()
     * O(nlogn) 但这道题其实要求是O(n)
     * Idea:
     * 唯一要关注的点就是在num中不连续的点也可以组成结果
     */
    public static int longestConsecutive2(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums); //O(nlogn)
        //System.out.println(Arrays.toString(nums));
        int res = 0;
        int len = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                continue;
            }
            if(nums[i]+1 == nums[i+1]){
                len++;
            }
            else{
                len = 0;
            }
            res = Math.max(res,len);
        }
        return res+1;
    }
}
