/**
 * You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.
 * Return the number of special letters in word.
 * Example 1:
 * Input: word = "aaAbcBC"
 * Output: 3
 * Explanation:
 * The special characters in word are 'a', 'b', and 'c'.
 * Example 2:
 * Input: word = "abc"
 * Output: 0
 * Explanation:
 * No character in word appears in uppercase.
 * Example 3:
 * Input: word = "abBCab"
 * Output: 1
 * Explanation:
 * The only special character in word is 'b'.
 * Constraints:
 * 1 <= word.length <= 50
 * word consists of only lowercase and uppercase English letters.
 */
package Struc_string;
import java.util.HashSet;
import java.util.Set;

public class Contest394_CounttheNumberI3120 {
    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars1("aaAbcBC"));
    }
    /**(推荐)"|="异或方法设置小写字母和大写字母位
     * O(n) Beats 100%
     * O(1) beats 80%
     * 思路：
     * 1.create an array 代表26个字母，每个位置的值代表小写或大写字母是否出现了
     * 2.set 1 表示该字母的小写出现了
     * 3.set 2(二进制11) 表示该字母的大写出现了
     * 4.最后比较该字母位置的值是否为3(二进制11),如果是，则满足条件
     * 注意事项：
     * 1.第一次用异或"|="，异或将左侧变量的当前值与右侧的值，执行位或操作，并将结果赋值回左侧变量
     *   举个例子：int a = 5; // 二进制 0101
     *           a |= 3;    // 3的二进制 0011，|=执行异或操作: 0101+0011 = 0111 (7)
     *   现在 a 的值变成了 7 (二进制 0111)
     * 2.对于"aaAbcBC"重复的情况，|= 只是将出现的情况设置为1，不管是否重复出现
     */
    public static int numberOfSpecialChars1(String word) {
        int[] count = new int[26];
        for(char c : word.toCharArray()){
            if(Character.isLowerCase(c)) count[c-'a'] |= 1;
            else count[c-'A'] |= 2;
        }
        int res = 0;
        for(int i : count){
            if(i == 3) res ++;
        }
        return res;
    }
    /**HashSet (比赛的时候想到的方法)
     * O(n) Beats 30%
     *      set.contains() is O(1)
     *      Character.isUpperCase(c) is O(1))
     */
    public static int numberOfSpecialChars2(String word) {
        Set<Character> set = new HashSet<>();
        for(char c : word.toCharArray()){
            set.add(c);
        }
        int count = 0;
        for(char c : set){
            if( Character.isLowerCase(c) && set.contains(Character.toUpperCase(c)) ){
                count ++;
            }
            else if( Character.isUpperCase(c) && set.contains(Character.toLowerCase(c)) ){
                count ++;
            }
        }
        return count/2;
    }
}
