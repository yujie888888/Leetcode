package DataStruc_Hash;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * Example 1:
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * Example 2:
 * Input: n = 2
 * Output: false
 * Constraints:
 * 1 <= n <= 231 - 1
 */
public class HappyNumber202 {
    public static void main(String[] args) {

    }


    /**ArrayList + HashSet O(kn)
     * 一开始想到的解法，但是runtime和store space很大
     *
     */
    public boolean isHappy(int n) {
        //存每位数数字
        ArrayList<Integer> digits = new ArrayList<>();
        HashSet<Integer> freq = new HashSet<>();
        freq.add(n);
        int digit;
        int sum = n;
        while(sum != 1){
            while(sum>0){
                digit = sum%10;
                digits.add(digit);
                sum = sum/10;
            }
            //重置,获取新sum
            sum = 0;
            for(int i: digits){
                sum += i*i;
            }
            //清空，释放内存. arraylist 和 HashSet都用clear()
            digits.clear();

            //判断循环条件，只要存在一个sum和之前的sum相等，就说明陷入了循环
            if(freq.contains(sum)) return false;
            freq.add(sum);
        }
        return true;
    }

    /**优化掉ArrayList只用HashSet
     *
     */
    public boolean isHappy_2(int n) {
        HashSet<Integer> freq = new HashSet<>();
        freq.add(n);
        int digit;
        int sum = n;
        int temp;
        while(sum != 1){
            temp = 0;
            while(sum>0){
                digit = sum%10;
                temp += digit*digit;
                sum = sum/10;
            }
            sum = temp;
            //判断循环条件，只要存在一个sum和之前的sum相等，就说明陷入了循环
            if(freq.contains(sum)) return false;
            freq.add(sum);
        }
        return true;
    }

    /**
     * 优化掉while内的if判断
     * return的方式很有意思
     */
    public boolean isHappy_3(int n) {
        HashSet<Integer> freq = new HashSet<>();
        int digit;
        int temp;
        int sum = n;
        while(sum != 1 && !freq.contains(sum)){
            //确实有必要在开始循环之前就将初始值 n 添加到 HashSet 中。这是因为：循环的可能起始于 n
            freq.add(sum);
            temp = 0;
            while(sum>0){
                digit = sum%10;
                temp += digit*digit;
                sum = sum/10;
            }
            sum = temp;
        }
        return sum == 1;
    }

    /**Beats 100%
     * Floyd's Cycle Detection Algorithm" (also known as the Tortoise and the Hare approach)
     * 这种方法非常高效，因为它不需要额外的空间来存储以前看到的数字，而是使用两个指针来检测循环
     * 用Floyd's判断是否存在循环是常用的方法比如P142
     * 在存在循环的情况下，slow和fast从同样的位置开始走，slow走一步，fast都两步，如果存在循环，那么这两个指针一定会相遇
     * 在这道题中，如果存在一个n的值和之前的n的值相等，也就是说进入了循环（可以用Floyd's ALG）
     * 这道题注意两个点就可以：
     *  1.slow和fast存的是值，把初始值n的变化画下来，模拟slow和fast的行走轨迹。这里注意每次更新都是更新slow的值和fast的值，不是更新n的值，n只是个初始值
     *  2.跳出循环的条件，不要漏掉每一种情况
     */
    public boolean searchLoopIsHappy(int n) {
        //Floyd's ALG
        //slow+1 fast+2 if slow==fast  -> exsits loop
        int slow = n;
        int fast = n;
        //这里不能用while(slow != 1 && slow != fast)这样来进行循环判断
        //因为当slow==fast的时候，这时出来的slow肯定不是1，这样就把slow和fast都=1的情况错过了
        //A || B -> !(A || B) -> !A & !B
        //(slow != 1 || slow != fast) -> (slow==1 & slow == fast)
        while(slow != 1) {
            //注意这里不是slow = operate(n); 而是slow = operate(slow);
            slow = operate(slow);
            //注意这里不是fast = operate(slow); 而是fast = operate(operate(fast));
            fast = operate(operate(fast));
            //这里不能直接return false，因为如果slow到了1，但是fast也到了1，这时就会输出false，但其实应该是true
            if(slow == fast){
                return slow == 1;
            }
        }
        return true;
    }
    public int operate(int n){
        int digit;
        int sum = 0;
        while(n > 0){
            digit = n % 10;
            sum += digit*digit;
            n /= 10;
        }
        return sum;
    }

}
