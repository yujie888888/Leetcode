/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * Since the result may be very large, so you need to return a string instead of an integer.
 * Example 1:
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
package ALG_sort;
import java.util.Arrays;

public class LargestNumber179 {
    /**Override Arrays.sort()
     * O(m*nlogn) Beats 96%
     *     将int[] -> String[]  O(n)
     *     追加str  O(n)
     *     Arrays.sort() 方法对于对象数组（比如字符串数组）默认使用的是归并排序或Timsort算法。这两种算法都是基于比较的排序方法，其时间复杂度在最坏情况下为 O(nlogn)
     *     因为在比较的时候每一个字符都进行了比较，假设str的平均长度为m
     * O(m*n) Beats 90%
     * 依旧是根据答案想思路..
     * 思路：
     * (根据答案想思路..)用int类型是肯定不行的，因为题目是进行拼接，所以用String最合适
     * 想到将String[]里面的str通过某种sort方法，排序成一个连起来就是最大数的String[]
     * 排序方法：将个位数大的排到前面，比如9和30，肯定是930>309;
     *      但是怎么比较"xx"和"yy"类型呢？b.compareTo(a)方法
     *      在字符串的字典序比较中，字符串按照字符逐个比较的方式来确定哪个字符串在字典序中排在前面。
     *      对于两个字符串 "330" 和 "303"，比较的过程是这样的：
     *          首先比较第一个字符：
     *              在 "330" 中，第一个字符是 '3'
     *              在 "303" 中，第一个字符也是 '3'
     *              第一个字符相同，因此需要比较下一个字符。
     *          比较第二个字符：
     *              在 "330" 中，第二个字符是 '3'
     *              在 "303" 中，第二个字符是 '0'
     *              字符 '3' 在 ASCII 码表中的值大于 '0'
     *              因此在字典序中，'3' 排在 '0' 后面
     *      b.compareTo(a)方法
     *          如果字符串 b 在字典序中位于 a 之前，方法将返回一个负整数
     *          如果字符串 b 等于字符串 a（即两个字符串完全相同），方法将返回零
     *          如果字符串 b 在字典序中位于 a 之后，方法将返回一个正整数
     *      重写Arrays.sort()方法按照字典序对两两结合的string进行排序
     *      Arrays.sort(排序对象,(b,a)->(a+b).compareTo(b+a) //Lambda 写法
     *          如果a+b的字典序更大，那么返回正数，告诉前面的b,a参数，b应该排在a之后
     * Steps:
     * 1.转换：首先将所有整数转换为字符串
     * 2.自定义排序：自定义一种特殊的方式来 两两 对字符串数组进行排序
     *      如果有两个字符串a和b，我们将它们进行拼接，形成ab和ba，然后比较这两个组合后的字符串
     *      如果ab > ba，则在排序后的数组中a应该位于b之前，反之亦然。这样可以保证组合出的数字是最大的
     * 3.拼接：将排序后的字符串数组拼接起来，形成一个大的字符串。
     * 注意事项：
     * 1.去除前导零：如果最终的字符串以0开头，那么只返回"0"。例如，输入为[0, 0]的情况
     * 2.在检查最终的字符串以0开头的时候，用的是.equals("0")，而不是"=="
     */
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        String[] strNums = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            strNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        if (strNums[0].equals("0")) {
            System.out.println("0");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strNums) {
            sb.append(str);
        }
        System.out.println(sb);
    }
}
