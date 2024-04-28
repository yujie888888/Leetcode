package Struc_string;
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
public class RepeatedSubstringPattern459 {
    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern1(s));
    }

    /**逐个重复比较法
     * O(n^2) Beats 65%
     * O(n) Beats 85%
     * 思路:
     * 1.从1到string长度的一半
     * 2.依次repeat这个子串
     * 3.然后与s进行比较是否一样
     * 注意事项:
     * 1.base case对于""和"a"这种情况，按照题目要求，返回的应该是false。
     */
    public static boolean repeatedSubstringPattern1(String s){
        //base case
        if(s.length() == 0 || s.length() == 1) return false;
        for(int i=0; i<s.length()/2; i++){
            //剪枝
            if(s.length()%(i+1) == 0){
                StringBuilder sb = new StringBuilder();
                String part = s.substring(0,i+1);
                for(int j=0; j<s.length()/(i+1); j++) sb.append(part);
                //toString() O(n) equals(s) O(n)
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }

    /**投机取巧方法
     * O(n) Beats 45%
     * O(1) Beats 85%
     * 思路：
     * 1.将字符串s与其自身连接。这将创建一个新字符串s + s。
     * 2.从双倍字符串中删除第一个和最后一个字符。如果s是abab，则将其加倍abababab，然后删除第一个和最后一个字符即可得到bababa。
     * 3.如果原始字符串s出现在此修改版本中，则由s重复的子字符串组成。
     */
    public static boolean repeatedSubstringPattern2(String s) {
        //base case
        if(s.length() == 0 || s.length() == 1) return false;
        String doubledString = (s+s).substring(1,s.length()*2-1);
        //.contains() O(n)
        return doubledString.contains(s);
    }
}
