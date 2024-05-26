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
        Scanner sc = new Scanner(System.in);
        System.out.println("Pleaase input the number that you want fine its square root:");
        int target = sc.nextInt();

        //System.out.println(rootSearch1(target));
        System.out.println(rootSeaerch2(target));
        //System.out.println(rootSeaerch3(target));
    }

    /**简单遍历法
     * O(x^(1/2)) 时间复杂度太大
     * 注意溢出问题
     */
    private static int rootSearch1(int target){
        if(target == 0) return 0;
        //target是int类型，当取int范围内的最大值2147483647时，i在取46341时就会超出int范围，所以i需要long定义
        long i = 1;
        while(i*i <= target){
            if(i*i == target) return (int)i;
            else i++;
        }
        return (int)i-1;
    }


    /**Binary Search
     * 有点强行使用感,但是很通用
     * 注意溢出问题
     * O(longn/2)
     */
    private static int rootSeaerch2(int target){
        int start = 0;
        int end = target/2;
        int mid;
        while(start <= end){
            mid = start + (end - start)/2;
            //miid防止int溢出
            long miid = (long)mid*mid;
            if(miid == target) return mid;
            if(miid < target) start = mid+1;
            else end = mid-1;
        }
        // 这里不能返回mid，因为mid的值定义在while内部
        // 和SearchInsertPosition不一样，这里返回的是right
        // 演示得知
        return end;
    }



    /**牛顿迭代法Newton's iteration method
     * 数学解法
     * 注意溢出问题
     * r=(r+x/r)/2 迭代数次，r会倾向于x的平方根
     * 接近于O(1)
     */
    private static int rootSeaerch3(int target){
        if(target < 1) return target;
        long r = target;
        //因为r是int，所以r*r自动变异成int，r*r显然会溢出int值，所以要long定义
        //long类型的数据和int类型的数据可以直接比较大小
        //target被自动转换为long类型
        while(r*r > target){
            // r不断向root缩进
            r = (r+(target/r))/2;
        }
        return (int)r;
    }
}
