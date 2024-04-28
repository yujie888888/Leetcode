package Struc_string;
/**
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * Constraints:
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 */
public class FindtheIndexoftheFirstOccurrenceinaString28 {
    public static void main(String[] args) {
        String haystack = "leetcode", needle = "cod";
        System.out.println(strStr2(haystack,needle));
    }

    /**
     * 直接调用.valueOf()
     * Beats 100%
     * 直接用string自带的方法.indexOf()返回第一次出现的needle的位置
     */
    public static int strStr1(String haystack, String needle) {
        if (!haystack.contains(needle)) return -1;
        return haystack.indexOf(needle);
    }

    /**
     * (推荐) 自己写.valueOf()的实现逻辑
     * O(n) Beats 100%
     * 思路：
     * 1.处理base case
     * 2.In haystack, 遍历，从每个位置开始，进行比较：固定needle长度的substring VS needle
     * 3.只要匹配到，就返回i的值，这就是needle第一次出现的位置
     * 注意事项：
     * 1.在进行遍历的时候，要明确范围，在haystack.length() - needle.length()的位置i也是满足条件的
     */
    public static int strStr2(String haystack, String needle) {
        if (!haystack.contains(needle)) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            //substring() O(n)
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
