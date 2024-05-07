/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 * Example 1:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 * Constraints:
 * 1 <= s1.length, s2.length <= 104
 * s1 and s2 consist of lowercase English letters.
 */
package Struc_hash;
import java.util.HashMap;
import java.util.Map;

public class PermutationString567 {
    public static void main(String[] args) {

    }

    /** Hashmap + fixed window */
    public boolean checkInclusion(String s1, String s2) {
        //hashmap+slide window
        if (s1.length() > s2.length()) return false;
        int[] freq = new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a'] ++;
        }

        int left = 0;
        int count = 0;
        for(int right=0; right<s2.length(); right++){
            int rindex = s2.charAt(right) - 'a';
            if(freq[rindex] > 0){
                count ++;
            }
            freq[rindex] --;

            if(right-left+1 == s1.length()){
                if(count == s1.length()) return true;
                int lindex = s2.charAt(left) - 'a';
                if(freq[lindex]>=0){
                    count--;
                }
                freq[lindex]++;
                left++;
            }
        }
        return false;
    }

    /** HashMap + fixed slide window **/
    public boolean checkInclusion2(String s1, String s2) {
        Map<Character,Integer> s1_freq = new HashMap<>();
        for(char c: s1.toCharArray()){
            s1_freq.put(c, s1_freq.getOrDefault(c,0)+1);
        }
        int left = 0;
        int right = 0;
        while(right < s2.length()){
            if(s1_freq.containsKey(s2.charAt(right))){
                s1_freq.put(s2.charAt(right), s1_freq.get(s2.charAt(right))-1);
            }
            if(right-left+1 == s1.length()){
                if(checkHashMap(s1_freq)){
                    return true;
                }
                if(s1_freq.containsKey(s2.charAt(left))){
                    s1_freq.put(s2.charAt(left), s1_freq.get(s2.charAt(left))+1);
                }
                left ++;
            }
            right ++;
        }
        return false;
    }
    public boolean checkHashMap(Map<Character,Integer> hashmap){
        for(int i : hashmap.values()){
            if(i>0) return false;
        }
        return true;
    }
}
