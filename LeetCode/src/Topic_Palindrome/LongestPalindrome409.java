/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 * Example 1:
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 * Constraints:
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 */
package Topic_Palindrome;

public class LongestPalindrome409 {
    public static void main(String[] args) {

    }

    /**HashMap
     * O(n) Beats 85%
     * O(128)
     * 思路:
     * 1.回文串的构建需要字符的成对出现
     *   遇到出现次数为偶数的letter，直接将其加入回文子串
     * 2.如果有字符个数为奇数的情况，那么可以有一个这样的字符位于回文串的中间
     *   遇到出现次数为奇数的letter，将其-1加入回文子串，并且设置flag==1，说明可以有一个letter放在中间
     */
    public static  int longestPalindrome(String s) {
        if(s.length() == 1) return 1;
        int[] map = new int[128];
        for(char c : s.toCharArray()){
            map[c-'A'] ++;
        }
        int flag = 0;
        int len = 0;
        for(int freq : map){
            if(freq!=0){
                if(freq % 2 == 0){
                    len += freq;
                }
                else{
                    len += freq-1;
                    flag = 1;
                }
            }
        }
        if(flag==1) len ++;
        return len;
    }
}
