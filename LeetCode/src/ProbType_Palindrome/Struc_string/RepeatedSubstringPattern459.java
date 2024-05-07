/**
 * Given a string s, check if it can be constructed by taking a substring of it and appending multiple
 * copies of the substring together.
 * Example 1:
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * Example 2:
 * Input: s = "aba"
 * Output: false
 * Example 3:
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 */
package ProbType_Palindrome.Struc_string;

public class RepeatedSubstringPattern459 {
    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern1(s));
    }
    /**逐个重复加法
     * O(n^2) Beats 65%
     *      toString() O(n)
     *      equals(s) O(n)
     * O(n) Beats 85%
     * 思路:
     * 1.从1到string长度的一半
     * 2.依次repeat这个子串
     * 3.然后与s进行比较是否一样
     * 注意事项:
     * 1.base case: 对于""和"a"这种情况，按照题目要求，返回的应该是false
     * 2.s.length()%(i+1) == 0这一步剪枝，也就是当整除不开的时候没有必要进行重复检查
     */
    public static boolean repeatedSubstringPattern1(String s){
        if(s.length() == 0 || s.length() == 1) return false;
        for(int i=0; i<s.length()/2; i++){
            if(s.length()%(i+1) == 0){
                String part = s.substring(0,i+1);
                String whole = part.repeat(s.length() / (i+1));
                //System.out.println(whole);
                if(whole.equals(s)) return true;
            }
        }
        return false;
    }

    /**投机取巧方法
     * O(n) Beats 45%
     *      .contains() O(n)
     * O(n) Beats 85%
     * 思路：
     * 1.将字符串s与其自身连接。这将创建一个新字符串s + s。
     * 2.从双倍字符串中删除第一个和最后一个字符。如果s是abab，则将其加倍abababab，然后删除第一个和最后一个字符即可得到bababa。
     * 3.如果原始字符串s出现在此修改版本中，则由s重复的子字符串组成。
     */
    public static boolean repeatedSubstringPattern2(String s) {
        if(s.length() == 0 || s.length() == 1) return false;
        String doubledString = (s+s).substring(1,s.length()*2-1);
        return doubledString.contains(s);
    }
}
