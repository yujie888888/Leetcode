/**
 * You are given a string s, which is known to be a concatenation of anagrams of some string t.
 * Return the minimum possible length of the string t.
 * An anagram is a word or phrase formed by rearranging the letters of a word or phrase, typically using all the original letters exactly once.
 * Example 1:
 * Input: s = "abba"
 * Output: 2
 * Explanation:
 * One possible string t could be "ba".
 * Example 2:
 * Input: s = "cdef"
 * Output: 4
 * Explanation:
 * One possible string t could be "cdef", notice that t can be equal to s.
 * Example 3:
 * s = "xxe"
 * Output: 3
 * Constraints:
 * 1 <= s.length <= 105
 * s consist only of lowercase English letters.
 */
package Topic_Anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Contest396_AnagramConcatenation3138 {
    public static void main(String[] args) {

    }
    /**Anagram
     * O()
     * O()
     * Ideas:
     * 这道题和GCD没关系
     * 先找因子，再找这个因子能不能构成String
     * 细节题，很多细节，略繁琐
     * Steps:
     *      找出字符串长度的所有因子，存储在 factor 列表中
     *      遍历所有可能的子串长度（因子）：
     *          从最小的因子开始，逐一检查,对每个因子长度：
     *              统计第一个子串（长度为 size）中各字符的频率，存储在 map 数组中。
     *              检查其余子串：
     *                  以 size 为步长，遍历剩余的子串。
     *                  对每个子串，统计字符频率存储在 map1 数组中
     *              使用 Arrays.equals() 比较 map 和 map1。
     *              如果map和map1内容不一样，直接break找下一个factor
     *              如果一样就继续，直到j==n-size，也就是说这个size可以覆盖这个string，break并返回结果
     *      如果res != n, 代表找到了一个答案，直接返回res，不用继续下一个factor
     * Attention:
     *  Arrays.equals(map, map1) 是比较两个 int 数组内容是否相同的正确方法。它会比较数组的长度和每个对应位置的元素值
     *  不要用.equals()比较array
     */
    public int minAnagramLength(String s) {
        int n = s.length();
        if (n == 1)
            return 1;

        // find all factors
        List<Integer> factor = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factor.add(i);
            }
        }

        // check the freq of characters of every window
        int res = n;
        for(int size : factor){
            int[] map = new int[26];
            for(int j=0; j<size; j++){
                map[s.charAt(j)-'a']++;
            }
            // System.out.println(map);
            for (int j = size; j < n; j += size) {
                int[] map1 = new int[26];
                for (int i = j; i < j+size; i++) {
                    map1[s.charAt(i)-'a']++;
                }
                // System.out.println(map1);
                if(!Arrays.equals(map, map1)){
                    break;
                }
                if(j == n-size){
                    res = size;
                    break;
                }
            }
            if(res != n) break;
        }
        return res;
    }

}
