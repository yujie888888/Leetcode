/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * Constraints:
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 */
package ProbType_Anagram;
import java.util.Arrays;
import java.util.Scanner;
public class ValidAnagram242 {
    public static void main(String[] args) {
        String s = "rat", t = "car";
        System.out.println(isAnagram3(s, t));
    }

    /**
     * Arrays.sort()
     * O(nlogn) Beats 90%
     * O(1) Beats 99%
     * 思路：
     * 1.把s和t转换成array格式
     * 2.Arrays.sort方法进行sort
     * 3.Arrays.equals()方法进行比较
     * 4.如果是Anagram拍完序之后肯定是一样的
     * 注意事项：
     * 1.Array.equals用来比较两个数组的内容是否相等；.equals()方法对array来说，实际上是比较两个数组对象的引用，而不是数组的内容
     */
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        //O(nlogn)
        Arrays.sort(S);
        Arrays.sort(T);
        //O(n)
        return Arrays.equals(S, T);
    }

    /**
     * HashMap(equals)
     * O(n) Beats 90%
     * O(1) Beats 99%
     * 思路：
     * 1.想到可以用hashmap，把字母和字母频率记录下来
     * 2.因为s和t都只包含小写字母，所以可以用数组S和T模拟HashMap
     * 3.对于s.chatAt(i)位置的char，-'a'就是在S[]中的位置
     * 4.O(n) 对S和T进行赋值
     * 5.O(n) 比较两个数组是否相等
     * 注意事项：
     * 1.可以先把长度不相等的直接返回false
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] S = new int[26];
        int[] T = new int[26];
        for (int i = 0; i < s.length(); i++) {
            S[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            T[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(S, T);
    }

    /**
     * HashMap(先加后减)
     * O(n) Beats 99.81%
     * O(1) Beats 75%
     * 思路：
     * 1.和isAnagram2思路一样，不过不是用equals来比较freq
     * 2.在将s的freq加入array之后，再遍历t，将t的char位置对应的数字--
     * 3.遍历array，如果还存在不为0的数，那么肯定不相等
     */
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] array = new int[26];
        for (char c1 : s.toCharArray()) {array[c1 - 'a']++;}
        for (char c2 : t.toCharArray()) {array[c2 - 'a']--;}
        for (int i : array) {if (i != 0) return false;}
        return true;
        }
}
