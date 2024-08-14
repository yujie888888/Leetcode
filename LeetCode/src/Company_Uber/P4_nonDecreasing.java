/**
 * There are n cars standing in a line, and each car has a price on it C1, C2, C3 ....Cn.
 * As a Software Engineering Intern, your mentor has assigned you a task. You have to make the car prices non-decreasing as fast as possible.
 * You can perform the following operation on the cars at the X-th chance:
 * Select some distinct cars, at positions i1, i2, i3,...g (k>=0) which are between 1 and n, and add price 2^(X-1) to each position of the car.
 * Formally C_i = C_i + 2^(X-1)
 * Find the smallest number T such that after T chances you can make car prices non-decreasing.
 *
 * Example-1: You have four cars having price [1,7,6,5]. If you select indices 3,4 at the 1-st chance and 4 at the 2-nd chance, then prices will become [1,7,7,8].
 * There are some other possible ways to make car prices non-decreasing in 2 chances, but you can't do it faster.
 *
 * Example-2: You have two cars having price [6,2]. If you select index 2 at the 1-st chance and select no cars at 2-nd chance and then select index 4 at the 3-rd chance,
 * then prices will become [6,7]. There are some other possible ways to make car prices non-decreasing in 3 chances, but you can't do it faster.
 *
 * You have to answer t independent test cases.
 * [execution time limit] 0.5 seconds (cpp)
 * [memory limit] 1 GB
 * [input] integer t
 * The first line contains single integer t (1<=t<=10^4) the number of test cases.
 * [input] array. array. integer64 carPrices
 * The first line of each test case contains n integers (n>0), C1, C2, C3....Cn, where C_i is the price of i-th car (-10^5 < C_i < 10^5).
 * It is guaranteed that the sum of values of n over all test cases in the input does not exceed 10^6
 * [output] array.integer64
 * For each test case, print the minimum number of chances in which you can make car prices non-decreasing.
 */
package Company_Uber;

public class P4_nonDecreasing {
    public static void main(String[] args){
        int[] cars = {6,2};
        //System.out.println(solution(cars));

    }
    /**
     * 比我想的要复杂
     * 感觉要考虑的条件很多
     */

}














