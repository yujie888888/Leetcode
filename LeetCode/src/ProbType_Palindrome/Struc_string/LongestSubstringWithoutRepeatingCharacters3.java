/**
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Constraints:
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
package ProbType_Palindrome.Struc_string;
import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        //System.out.println(lengthOfLongestSubstring1(s));
        System.out.println(lengthOfLongestSubstring2(s));
    }

    /** HashSet + slide window
     * O(n) Beats 70%
     * 思路:
     * 1.用滑动窗口，设置一个maxLen，然后更新
     * 2.双指针left负责减，right负责加
     * 3.用HashSet存放滑动窗口内的值
     */
    public static int lengthOfLongestSubstring1(String s) {
        //base case
        if(s.length() == 0 || s.length() == 1) return s.length();

        HashSet<Character> freq = new HashSet<>();
        int left = 0;
        int right = 0;
        int max_len = 0;

        char[] c = s.toCharArray();
        while(right<c.length){
            while(freq.contains(c[right])){
                freq.remove(c[left]);
                left ++;
            }
            freq.add(c[right]);
            max_len = Math.max(max_len,right-left+1);
            right ++;
        }
        return max_len;
    }

    /**Array + slide window
     * O(n) beats 98%
     * 1.优化hashset，用array代替hashset
     * 2.SA[128]存放slide window中的值的个数(ASCII码包括了基本的英文字母、数字、标点符号以及一些控制字符,所以遇到需要用Array替换的题直接用128长度，不会出错)
     * 3.如果值>1，说明重复了，也就是替换contains(val)这一步
     * !!4.Array和Hashset最大的不同是，hashset不需要先赋值，因为不赋值也可以进行判断，但是Array需要先赋值，不然影响判断。在纸上写两遍就懂了。
     */
    public static int lengthOfLongestSubstring2(String s) {
        //base case
        if (s.length() == 0 || s.length() == 1) return s.length();
        //初始化时所有元素的初始值会自动设为 0
        int[] SA = new int[128];
        int left = 0;
        int right = 0;
        int maxLen = 0;
        char[] SC = s.toCharArray();
        while (right < s.length()) {
            SA[SC[right]]++;
            while (SA[SC[right]] > 1) {
                SA[SC[left]]--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}
