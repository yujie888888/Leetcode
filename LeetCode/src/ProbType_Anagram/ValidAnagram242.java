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
        System.out.println(isAnagram1(s,t));
    }

    /**Arrays.sort()方法巧用
     * O(nlogn) Beats 90%
     * 思路：
     * 1.把s和t转换成array格式
     * 2.Arrays.sort方法进行sort
     * 3.Arrays.equals()方法进行比较
     * 4.如果是Anagram拍完序之后肯定是一样的
     * 注意事项：
     * 1.Array.equals用来比较两个数组的内容是否相等；.equals()方法对array来说，实际上是比较两个数组对象的引用，而不是数组的内容
     */
    public static boolean isAnagram1(String s, String t) {
        //base case
        if(s.length() != t.length()) return false;

        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        //O(nlogn)
        Arrays.sort(S);
        Arrays.sort(T);
        //O(n)
        return Arrays.equals(S, T);
    }

    /**array代替hashmap法
     * O(n) Beats 90%
     * O(1) Beats 99%
     * 思路：
     * 1.想到可以用hashmap，把字母和字母频率记录下来
     * 2.因为s和t都只包含小写字母，所以可以用数组S和T模拟HashMap
     * 3.对于s.chatAt(i)位置的char，-'a'就是在S[]中的位置
     * 4.O(n) 对S和T进行赋值
     * 5.O(n) 比较两个数组是否相等
     */
    public boolean isAnagram2(String s, String t) {
        //base case
        if(s.length() != t.length()) return false;

        int[] S = new int[26];
        int[] T = new int[26];
        for(int i=0; i<s.length(); i++){
            S[s.charAt(i)-'a'] ++;
        }
        for(int i=0; i<t.length(); i++){
            T[t.charAt(i)-'a'] ++;
        }
        return Arrays.equals(S,T);
    }

    /**对一个数组先加后减法
     * O(n) Beats 99.81%
     * O(1) Beats 75%
     */
    public static boolean isAnagram3(String s, String t) {
        //base case
        if(s.length() != t.length()) return false;

        int[] array = new int[26];
        //加
        for(char c : s.toCharArray()){
            array[c-'a'] ++;
        }
        //减
        for(char c : t.toCharArray()){
            array[c-'a'] --;
        }
        //判断
        for(int i : array){
            if(i != 0) return false;
        }
        return true;
    }
}
