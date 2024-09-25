/**
 * Weak passwords are likely to be hacked and misused. Due to this, developers at Amazon regularly come up with
 * new algorithms to check the health of user passwords. A new algorithm estimates the variability of a password
 * as the number of distinct password strings that can be obtained by reversing any one substring of the original password.
 * Given the original password that consists of lowercase English characters, find its variability.
 * Note: A substring is a contiguous sequence of characters within a string. For example 'bcd', 'a', 'abcd' are substrings
 * of the string 'abcd' whereas the strings 'bd', 'acd' are not.
 * Function Description
 * Complete the function countDistinctPasswords in the editor below.
 * countDistinctPasswords has the following parameter:
 * string password: the original password
 * Returns
 * long integer: the number of distinct password strings that can be formed
 * Example 1:
 * Input:  password = "abc"
 * Output: 4
 * Explanation:
 * The following strings can be formed from password = 'abc':
 * Reversing any substring of length 1 gives the original string "abc".
 * Reversing the substring "ab" gives a new string "bac".
 * Reversing the substring "bc" gives a new string "acb".
 * Reversing the substring "abc" gives a new string "cba".
 * There are 4 distinct password strings that can be obtained from password. Return 4.
 * Example 2:
 * Input:  password = "abaa"
 * Output: 4
 * Explanation:
 * The strings that can be formed are "abaa", "aaba", "baaa" and "aaab".
 * Constraints:
 * All characters in password are lowercase English letters ascii[a-z]
 * 1 ≤ length of password ≤ 10^5
 */
package Company_Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P12_CountDistinctPasswords {
    public static void main(String[] args) {
        String password = "abca";
        System.out.println(countDistinctPasswords1(password));
        //System.out.println(countDistinctPasswords2(password));
    }
    /**
     * 扫一遍，寻找回文子序列，并把找到的回文序列替换成单个字符，词典里不存在的字符，比如数字
     * 重复上述操作直到长度不改变，此时不存在任何回文序列
     * 直接用数学方法计算出当前长度下的结果
     */
    /**找规律
     * O(n)
     * O(26)
     * Ideas:
     * 难，不会 https://leetcode.com/discuss/interview-question/4822297/Amazon-OA-Question
     */
    private static long countDistinctPasswords1(String password){
        int n = password.length();
        Map<Character, Integer> charCount = new HashMap<>();
        // Count the occurrences of each character
        for (char c : password.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        long total = 1; // Start with 1 for the original password
        for (int count : charCount.values()) {
            total += (long) count * (n - count);
            n -= count;
        }
        return total;
    }

    /**StringBuilder
     * O(n^3) LTE
     */
    private static long countDistinctPasswords2(String password){
        int n = password.length();
        HashSet<String> set = new HashSet<>();
        set.add(password);
        for(int i=0; i<n; i++){
            for(int k=i+2; k<=n; k++){
                StringBuilder sb = new StringBuilder(password.substring(i,k));//O(k)
                StringBuilder str = new StringBuilder(password).replace(i,k,sb.reverse().toString());//O(k)
                if(!str.toString().equals(password)) set.add(str.toString());
            }
        }
        return set.size();
    }
}
