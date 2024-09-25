package Company_IBM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2602_MinimumOperations {
    public static void main(String[] args) {

    }

    /**Binary Search + prefix
     * 让人不爽的题
     * O(m*nlogn) m是queires的长度，n是nums的长度
     * Ideas:
     * 这道题直观看就是暴力解，时间复杂度是O(m*n^2)
     * 优化做法：
     * 只需要记录比queries[i]这个num值大的和小的有多少（相等的随便包含在哪一边，反正后面都会减掉）
     * 然后分别计算需要add多少需要minus多少
     * 思路并不难，但是写起来要注意很多细节：
     * 1.用long定义一些值，不然会超出范围
     * 2.在计算prefix之间先sort （不需要直到nums的order，反正最后要的只是一个结果）
     * 3.计算prefix是为了在计算结果的时候更快
     */
    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] prefix = new long[n+1];
        for(int i=1; i<=n; i++){
            prefix[i] = prefix[i-1]+nums[i-1];
        }
        // System.out.println(prefix[n]);

        List<Long> res = new ArrayList<>();
        for(int j=0; j<queries.length; j++){
            long num = queries[j];
            int index = findIndex(nums, num);
            //System.out.println(index);

            long smaller = prefix[index];
            long needsAdd = index * num - smaller;
            //System.out.println(needsAdd);

            long larger = prefix[n] - smaller;
            //System.out.println(larger);
            long needsMinus = larger - (n-index)*num;
            //System.out.println(needsMinus);
            res.add(needsAdd + needsMinus);

            //System.out.println();
        }
        return res;
    }
    private static int findIndex(int[] nums, long target){
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] > target){
                right = mid-1;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else{
                return mid;
            }
        }
        return left;
    }
}
