/**
 * You are given a string word of size n, and an integer k such that k divides n.
 * In one operation, you can pick any two indices i and j, that are divisible by k, then replace the
 * substring
 *  of length k starting at i with the substring of length k starting at j. That is, replace the substring word[i..i + k - 1] with the substring word[j..j + k - 1].
 * Return the minimum number of operations required to make word k-periodic.
 * We say that word is k-periodic if there is some string s of length k such that word can be obtained by concatenating s an arbitrary number of times. For example, if word == “ababab”, then word is 2-periodic for s = "ab".
 * Example 1:
 * Input: word = "leetcodeleet", k = 4
 * Output: 1
 * Explanation:
 * We can obtain a 4-periodic string by picking i = 4 and j = 0. After this operation, word becomes equal to "leetleetleet".
 * Example 2:
 * Input: word = "leetcoleet", k = 2
 * Output: 3
 * Explanation:
 * We can obtain a 2-periodic string by applying the operations in the table below.
 * i	j	word
 * 0	2	etetcoleet
 * 4	0	etetetleet
 * 6	0	etetetetet
 * Constraints:
 * 1 <= n == word.length <= 105
 * 1 <= k <= word.length
 * k divides word.length.
 * word consists only of lowercase English letters.
 */
package Struc_string;
import java.util.HashMap;
import java.util.Map;

/**代码逻辑题
 * O(word.length/k)
 * O(word.length/k)
 * 思路：
 * 这道题的题目要求写的真的很模糊，看题看了好久
 * 其实就是给一个k，然后在word里找k长度的子串，看这个子串要多少步才能覆盖word
 * 求的就是最小覆盖次数
 * 1.因为肯定存在一个子串能覆盖word
 * 2.这个长度为k的子串的个数也是有限的，start位置肯定是从0开始，到n.length-k结束
 * 3.所以想到将String str和出现次数存到hashmap里，只需要查看最高的出现次数，那么用n.length/k(也就是长度为k的子串的数量) - maxFreq 就是最小操作次数了
 */
public class Contest396_KPeriodic3137 {
    public static void main(String[] args) {
        String word = "leetcoleet";
        int k = 2;
        Map<String,Integer> hashmap = new HashMap<>();
        int maxFreq = 0;
        int j = k;
        int i = 0;
        while(j<=word.length()){
            String str = word.substring(i,j);
            hashmap.put(str, hashmap.getOrDefault(str,0)+1);
            maxFreq = Math.max(maxFreq,hashmap.get(str));
            i = j;
            j = i + k;
        }
        System.out.println((word.length() / k) - maxFreq);
    }
}
