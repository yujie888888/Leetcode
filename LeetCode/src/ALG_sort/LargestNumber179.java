package ALG_sort;

import java.util.Arrays;
import java.util.Comparator;

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
/**Steps:
 * 感觉这道题以我目前的水平只能记住做法
 * 转换：首先将所有整数转换为字符串，因为这将使得比较操作变得简单。
 * 自定义排序：然后根据一种特殊的方式来对字符串数组进行排序。具体而言，如果有两个字符串a和b，我们将它们进行拼接，形成ab和ba，然后比较这两个组合后的字符串。如果ab > ba，则在排序后的数组中a应该位于b之前，反之亦然。这样可以保证组合出的数字是最大的。
 * 拼接：将排序后的字符串数组拼接起来，形成一个大的字符串。
 * 去除前导零：最后，需要注意的是，如果最终的字符串以0开头，那么只返回"0"。例如，输入为[0, 0]的情况。
 */
public class LargestNumber179 {
    public static void main(String[] args) {
        String[] strs = {"3","30","34","5","9"};
        // Comparator<String>(){自定义compare方法} 这个对象作为一个参数传入sort(T[] a, Comparator<? super T> c)方法
        // a是要排序的数组，c是排序规则
        // sort(T[] a, Comparator<? super T> c)方法接受Comparator对象，也就是说规则只能是实现Comparator接口的compare方法
        Arrays.sort(strs,new Comparator<String>(){
            @Override
            // compare() returns:
            // a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
            public int compare(String a, String b){
                String order1 = a + b;
                String order2 = b + a;
                //.compareTo() compares two strings lexicographically. it is based on the Unicode value of each character in the strings.
                // 数字0的Unicode编码是U+0030，字母A的Unicode编码是U+0041，字母a的Unicode编码是U+0061
                // a.compareTo(b) (lexicographically)a<b return integer(<0); a=b return 0; a>b return integer(>0)
                // 用compareTo()进行字典序比较，if b+a(order2 9+3)的字典序大于a+b(order1 3+9)的字典序，那么返回大于0的整数
                // compare()方法本身返回值代表的是，如果返回值大于0，说明a>b，那么a要在b后，也就是3在9后
                // 这样排完就是9,5,34,3,30
                return order2.compareTo(order1);
            }
        });
        //也可以用lamada
        //Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        //去除前导零，也就是如果第一个char是0，就返回0
        if (strs[0].equals("0")) {
            System.out.println("0");
            return;
        }
        //拼接
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        System.out.println(sb.toString());
    }
}
