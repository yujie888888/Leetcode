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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P12_CountDistinctPasswords {
    public static void main(String[] args) {
        String password = "aabcdsadfadadsadaszaaaaa";
        System.out.println(countDistinctPasswords1(password));
        System.out.println(countDistinctPasswords2(password));
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
     * 总数-重复的string数
     * 1.先通过找规律得到1+2+...+(n-1)  +1 就是如果char不重复的情况下所有reverse后不同的substring数量
     * 2.找reverse后和之前的结果有重复的情况，也是找规律，发现如果有2个重复的char，那么将会有1个substring被重复计数，
     *   同上n=1,p=0;n=2,p=1;n=3,p=3;n=4,p=6;n=5,p=10;n=6,p=15;
     *   可以发现p的值对应于n−1的三角数
     *     三角数是通过从1累加到n−1的自然数所得的和，公式为 n*(n-1)/2;
     */
    private static long countDistinctPasswords1(String password){
        int n = password.length();
        int sum = 1 + (n*(n-1)/2);
        int[] map = new int[26];
        for(char c : password.toCharArray()){
            map[c-'a']++;
        }
        int removed = 0;
        for(int num : map){
            if(num>1){
                removed += ((num*(num-1))/2);
            }
        }
        return sum-removed;
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
