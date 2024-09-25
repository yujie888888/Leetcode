package DataStruc_Array;

public class LC3105_LongestIncreasingDecreasingSubarray {
    public static void main(String[] args) {

    }

    /**
     * O(n)
     * Ideas:
     * 遍历nums，遇到递增就更新递增的长度重置递减的长度
     * 递减同理
     * 相等全重置为1
     * 至于为什么是1，因为我是从1开始遍历的，下一个是大是小加上前面的都是2，所以init值是1
     */
    public int longestMonotonicSubarray(int[] nums) {
        int i = 1;
        int res = 0;
        int resI = 1;
        int resD = 1;
        // O(n)
        while(i < nums.length){
            if(nums[i] > nums[i-1]){
                resI++;
                resD = 1;
            }
            else if(nums[i] < nums[i-1]){
                resI = 1;
                resD ++;
            }
            else{
                resI = 1;
                resD = 1;
            }
            // 这个res记录放在这里
            res = Math.max(res,Math.max(resI,resD));
            i++;
        }
        return res = res==0 ? 1 : res;
    }
}
