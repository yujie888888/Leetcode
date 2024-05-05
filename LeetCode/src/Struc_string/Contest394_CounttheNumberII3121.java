/**
 * You are given a string word. A letter c is called special if it appears both in lowercase and uppercase in word, and every lowercase occurrence of c appears before the first uppercase occurrence of c.
 * Return the number of special letters in word.
 * Example 1:
 * Input: word = "aaAbcBC"
 * Output: 3
 * Explanation:
 * The special characters are 'a', 'b', and 'c'.
 * Example 2:
 * Input: word = "abc"
 * Output: 0
 * Explanation:
 * There are no special characters in word.
 * Example 3:
 * Input: word = "AbBCab"
 * Output: 0
 * Explanation:
 * There are no special characters in word.
 * Constraints:
 * 1 <= word.length <= 2 * 105
 * word consists of only lowercase and uppercase English letters.
 */
package Struc_string;
public class Contest394_CounttheNumberII3121 {
    public static void main(String[] args) {

    }

    /**置位法
     * O(n) Beats 65%
     * O(1) Beats 99%
     * 思路：
     * 明确会出现的所有情况
     * 1.该小写之前没有该字母，此时值为0，满足继续条件
     * 2.该小写之前有小写，此时值为1，满足继续条件
     * 3.该小写之前有大写，此时值为2，标记为不满足 (其实这种情况在大写的1就处理过了)
     * 4.该小写之前有小写和大写，此时值为3，标记为不满足
     *
     * 1.该大写之前没有字母，此时值为0，标记为不满足
     * 2.该大写之前有小写，此时值为1，满足继续条件
     * 3.该大写之前有大写，标记为不满足
     * 4.该大写之前有小写和大写，此时值为3，标记为不满足
     */
    public static int numberOfSpecialChars(String word) {
        int[] arr = new int[26];
        for(char c : word.toCharArray()){
            if(Character.isLowerCase(c)){
                if(arr[c-'a'] >= 2) arr[c-'a'] = -1;
                else if(arr[c-'a'] == -1) continue;
                else arr[c-'a'] |= 1;
            }
            else{
                if(arr[c-'A'] == 1 || arr[c-'A'] == 3) arr[c-'A'] |= 2;
                else if(arr[c-'A'] == -1) continue;
                else arr[c-'A'] |= -1;
            }
        }
        int count = 0;
        for(int i : arr){
            if(i == 3) count ++;
        }
        return count;
    }
    /**indexOf()法
     *
     * 思路：
     * 在字符串中检查每个字母出现的情况
     * 检查该小写是否存在 && 该小写最后出现的位置是不是在该大写出现位置的前面
     */
    public static int numberOfSpecialChars2(String word) {
        int count = 0;
        for(int i=0; i<26; i++){
            int low = (char) (i+'a');
            int up = (char) (i+'A');
            if(word.indexOf(low) != -1 && word.lastIndexOf(low) < word.indexOf(up)){
                count ++;
            }
        }
        return count;
    }
}
