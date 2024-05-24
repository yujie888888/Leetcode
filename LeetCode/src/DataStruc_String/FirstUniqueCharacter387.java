/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 * Constraints:
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
package DataStruc_String;

public class FirstUniqueCharacter387 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar2(s));
    }

    /**double for-loop + flag
     * O(n^2) Beats 65%
     * 思路：
     * 1.关键在于flag，遍历每个char
     * 2.如果在这个char之后存在一样的char，就把这个char的flag设置为1
     * 3.在外循环中，进行完内循环之后，只要flag不为1，那么返回此时的i就是最早出现的non-repat char
     * 注意事项：
     * 1.内循环内只要找到一个重复的就可以break了，减少runtime
     */
    public static int firstUniqChar1(String s) {
        int res = -1;
        int flag;
        char[] cs = s.toCharArray();
        for(int i=0; i<cs.length; i++){
            flag = 0;
            for(int j=0; j<cs.length; j++){
                if(cs[i] == cs[j] && i != j){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) return i;
        }
        return res;
    }

    /**HashMap
     * O(n) Beats 100%
     * O(1)
     * 思路：
     * 将无序的hashmap变成"有序"的
     * 1.先把每个char的freq存起来,这里用array代替hashmap
     * 2.!按照输入的字符串的顺序遍历freq[]，比较freq[char c]是否为1，如果为1，那么这个肯定是第一个出现的不重复的char
     */
    public static int firstUniqChar2(String s) {
        int[] freq = new int[26];
        char[] cs = s.toCharArray();
        for(char c : cs){
            freq[c-'a']++;
        }
        for(int i=0; i<s.length();i++){
            if(freq[cs[i]-'a'] == 1) return i;
        }
        return -1;
    }
}
