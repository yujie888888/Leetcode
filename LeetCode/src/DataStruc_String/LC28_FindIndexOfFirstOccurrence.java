package DataStruc_String;

public class LC28_FindIndexOfFirstOccurrence {
    public static void main(String[] args) {
        String haystack = "leetcode", needle = "cod";
        System.out.println(strStr2(haystack,needle));
    }

    /**
     * O(1) + O(m*n)
     * Idea：
     * 直接用string自带的方法.indexOf()返回第一次出现的needle的位置
     */
    public static int strStr1(String haystack, String needle) {
        if (!haystack.contains(needle)) return -1;// O(m*n)
        return haystack.indexOf(needle);// O(1)
    }

    /**实现.valueOf()底层逻辑
     * O(nm)
     *    .contains() O(n*m)，其中 n 是字符串的长度，m 是子字符串的长度
     *    substring() O(n)
     * 思路：
     * 1.处理base case
     * 2.In haystack, 遍历，从每个位置开始，进行比较：固定needle长度的substring VS needle
     * 3.只要匹配到，就返回i的值，这就是needle第一次出现的位置
     * 注意事项：
     * 1.在进行遍历的时候，要明确范围，在haystack.length() - needle.length()的位置i也是满足条件的
     */
    public static int strStr2(String haystack, String needle) {
        // O(m*n)
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
