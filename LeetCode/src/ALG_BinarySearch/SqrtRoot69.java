package ALG_BinarySearch;

import java.util.Scanner;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 * Example 1:
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 *
 * Constraints:
 * 0 <= x <= 2^31 - 1
 */
public class SqrtRoot69 {
    public static void main(String[] args) {
        int target = 8;
        System.out.println(mySqrt_BS(target));
    }
    /**Binary Search
     * O(logn)
     * O(1)
     * 思路：
     * x的平方根肯定在1-x之间
     * 先找mid，比较mid*mid和x的值
     *  如果x小，往左半边走
     *  如果x大，往右半边走
     *      在这里，也就是x>mid*mid的时候，这个时候的mid就是一个潜在的root，记录这个root
     *  如果x==，直接返回这个mid，就是root
     */
    public static int mySqrt_BS(int x) {
        //剪枝
        if(x==0) return 0;
        if(x<4) return 1;
        int left = 1;
        int right = x/2;//剪枝
        int sqrt = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            double sqMid = Math.pow(left+(right-left)/2,2);
            if(sqMid>x){
                right = mid-1;
            }
            else if(sqMid<x){
                sqrt = mid;
                left = mid+1;
            }
            else{
                return mid;
            }
        }
        return sqrt;
    }
    /**牛顿迭代法Newton's iteration method
     * 接近于O(1)
     * 公式：r=(r+x/r)/2 迭代数次，r会倾向于x的平方根
     */
    private static int rootSeaerch3(int target){
        if(target < 1) return target;
        long r = target;
        while(r*r > target){
            // r不断向root缩进
            r = (r+(target/r))/2;
        }
        return (int)r;
    }
}
