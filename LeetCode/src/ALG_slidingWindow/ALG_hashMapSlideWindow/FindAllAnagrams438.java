package ALG_slidingWindow.ALG_hashMapSlideWindow;
/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * Example 1:
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * Constraints:
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class FindAllAnagrams438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input s:");
        String s = sc.nextLine();
        System.out.println("Please input p:");
        String p = sc.nextLine();
        System.out.println(findAnagrams(s, p));
    }
    /**
     * 方法1
     * 运行时间高达1500ms的做法hh O(mlogm)+O(mn^2lognn) 简直爆炸
     * 遍历-sorts
     */
    public static List<Integer> findAnagrams(String s, String p) {
        char[] p_array = p.toCharArray();
        // O(mlogm) Arrays.sort
        Arrays.sort(p_array);
        //记录结果
        ArrayList<Integer> result = new ArrayList<>();
        //遍历O(n) n is s.length
        for (int i = 0; i <= s.length() - p.length(); i++) {
            char[] s_sub_array = new char[p.length()];
            //O(m) m is p.length
            for (int j = i; j < i + p.length(); j++) {
                s_sub_array[j - i] = s.charAt(j);
            }
            // O(nlogn) Arrays.sort
            Arrays.sort(s_sub_array);
            //数组的内容比较要用Arrays.sort  不要用== 也不要用.equals 这都是比较引用
            if (Arrays.equals(s_sub_array, p_array)) result.add(i);
        }
        return result;
    }

    /**方法2 Hashmap + fixed window
     * 和p567一模一样，只是在567 return的位置变成add value
     */
    public List<Integer> hashWindowFindAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();

        int[] freq = new int[26];
        for(char c : p.toCharArray()){
            freq[c-'a']++;
        }
        int left = 0;
        int count = 0;
        for(int right=0; right<s.length(); right++){
            int rindex = s.charAt(right)-'a';
            if(freq[rindex] > 0){
                count ++;
            }
            freq[rindex] --;

            if(right-left+1 == p.length()){
                if(count == p.length()){
                    result.add(left);
                }
                int lindex = s.charAt(left)-'a';
                if(freq[lindex]>=0){
                    count --;
                }
                freq[lindex] ++;
                left ++;
            }
        }
        return result;
    }
}