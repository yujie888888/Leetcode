package Struc_string;

import java.util.Scanner;

/**
 *
 */
public class PalindromeNumber9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input the number:");
        int x = sc.nextInt();
        System.out.println(isPalindrome1(x));

    }
    /**1、(推荐)String + two points
     * O(n) Beats 75%
     */
    public static boolean isPalindrome1(int x) {
        if(x<0) return false;
        //String
        String S_x = String.valueOf(x);
        int left = 0;
        int right = S_x.length()-1;
        while(left<right){
            if(S_x.charAt(left) != S_x.charAt(right)) return false;
            right--;
            left ++;
        }
        return true;
    }

    /**2、StringBuilder自带的reverse方法
     *
     */
    public static boolean isPalindrome2(int x) {
        if(x < 0) return false;
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }

    /**3、数学解法
     * O(logn) + O(1)
     * 整数的位数与其大小的对数关系:一个整数n 自位数可以通过对n 取对数得到。具体来说，如果n是一个d位数，则n>10^d-1。取以10为底的对数，我们得到log10(n)>d-1。这意味着一个数的位数大致等于log10(n)。
     * 判断回文数的是通过反复除以 10(以去除最低位)和取模操作(以获得最低位)来处理整数。
     * 因此，每一步作都涉及到整数的一位。当处理到整数的-约等于整数位数的一半时，算法就会停止。
     * 也就是说，处理的步数大时间复杂度的推导:由于整数的位数是log10(n)，算法处理的步数大约为log10(n)/2。
     * 因此，算法的时间复杂度是O(log10(n))。
     */
    public static boolean mathIsPalindrome(int x) {
        //base case
        if(x<0 || (x%10 == 0 && x!= 0)) return false;
        int reversed_x = 0;
        while(x>reversed_x){
            reversed_x = reversed_x*10 + x%10;
            x = x/10;
        }
        //pay attention of return value
        if(reversed_x == x || reversed_x/10 == x) return true;
        else return false;
    }

}
