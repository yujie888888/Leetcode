package ALG_BinarySearch;

public class LC1802_MaximumValue {
    public static void main(String[] args) {
        int n = 4, index = 2,  maxSum = 6;
        System.out.println(maxValue(n,index,maxSum));
    }
    /**Greedy + Binary Search
     * O(logn)
     * O(1)
     * Ideas:
     * 像这种很考验细节的题，一定要好好捋明白推导的过程
     * 要想nums[index]的值最大，就尽可能让其他的值最小
     * 根据maxSum这个条件，去找最大的可能的nums[index]的值
     * nums[index]的取值范围是从 1 到 maxSum
     * 如果用for找时间复杂度为O(n),应该也能过，但是用二分法找更块
     * 二分法找nums[index]的值，并且判断是否满足sum<=maxSum
     *  如果不满足，说明index大了
     *  如果满足，记录这个nums[index]的值
     * 其中求sum用数学方法：
     * 传入参数: n,index,value
     *   sum = 左+右+nums[index]的值
     *   根据Greedy思想，让左右的sum尽可能小，也就是每一个相邻的值都-1
     *     左边的长度是：[0,index]: leftLen: index+1
     *     右边的长度是：[index, n-1]: rightLen: n-index
     *     这里要进行判断是否是一个能递减到1
     *     左边：
     *         可以: leftLen >= val： 用 val*(val+1)/2 + (leftLen-val+1)
     *         不可以: leftLen < val：exceedLen = val-leftLen   val*(val+1)/2 - exceedLen*(exceedLen+1)/2
     *     右边:
     *         可以: rightLen >= val：用 (val*(val+1)/2 + (rightLen-val+1)
     *         不可以: rightLen < val：exceedLen = val-rightLen   val*(val+1)/2 - exceedLen*(exceedLen+1)/2
     */
    public static int maxValue(int n, int index, int maxSum) {
        if(n == 1) return maxSum;

        int res = -1;
        int left = 1;
        int right = maxSum;
        while(left <= right){
            int mid = left + (right-left)/2;
            long sum = leftSum(index-1, mid-1, n) + rightSum(index+1, mid-1, n) + mid;
            if(sum > maxSum){
                right = mid-1;
            }
            else{
                res = Math.max(res,mid);
                left = mid + 1;
            }
        }
        return res;
    }
    private static long leftSum(int index, long val, int n){
        long leftLen = index+1;
        long sum;
        if(leftLen >= val){
            sum = val*(val+1)/2 + (leftLen-val);
        }
        else{
            long exceedLen = val-leftLen;
            sum = val*(val+1)/2 - exceedLen*(exceedLen+1)/2;
        }
        //System.out.println("left sum is:" + sum);
        return sum;
    }
    private static long rightSum(int index, long val, int n){
        long rightLen = n-index;
        long sum;
        if(rightLen >= val){
            sum = val*(val+1)/2 + (rightLen-val);
        }
        else{
            long exceedLen = val - rightLen;
            sum = val*(val+1)/2 - exceedLen*(exceedLen+1)/2;
        }
        //System.out.println("right sum is:" + sum);
        return sum;
    }
}
