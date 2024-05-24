/**
 * You are given two strings s and t such that every character occurs at most once in s and t is a permutation of s.
 * The permutation difference between s and t is defined as the sum of the absolute difference between the index of the occurrence of each character in s and the index of the occurrence of the same character in t.
 * Return the permutation difference between s and t.
 * Example 1:
 * Input: s = "abc", t = "bac"
 * Output: 2
 * Explanation:
 * For s = "abc" and t = "bac", the permutation difference of s and t is equal to the sum of:
 * The absolute difference between the index of the occurrence of "a" in s and the index of the occurrence of "a" in t.
 * The absolute difference between the index of the occurrence of "b" in s and the index of the occurrence of "b" in t.
 * The absolute difference between the index of the occurrence of "c" in s and the index of the occurrence of "c" in t.
 * That is, the permutation difference between s and t is equal to |0 - 1| + |2 - 2| + |1 - 0| = 2.
 * Example 2:
 * Input: s = "abcde", t = "edbac"
 * Output: 12
 * Explanation: The permutation difference between s and t is equal to |0 - 3| + |1 - 2| + |2 - 4| + |3 - 1| + |4 - 0| = 12.
 * Constraints:
 * 1 <= s.length <= 26
 * Each character occurs at most once in s.
 * t is a permutation of s.
 * s consists only of lowercase English letters.
 */
package DataStruc_Hash;
public class Contest_397PermutationDifference3146 {
    /**Hash
     * 思路:
     * 把每个String的char出现的index用array存起来，然后让两个array相减
     */
    public static void main(String[] args) {
        String s = "abcde";
        String t = "edbac";
        int[] indicesS = new int[26];
        int[] indicesT = new int[26];
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        for(int i=0; i<s.length(); i++){
            indicesS[S[i]-'a'] = i;
            indicesT[T[i]-'a'] = i;
        }
        int permutation_difference = 0;
        for(int j=0; j<26; j++){
            if(indicesS[j]!=0 || indicesT[j]!=0){
                permutation_difference += Math.abs(indicesS[j]-indicesT[j]);
            }
        }
        System.out.println(permutation_difference);
    }
}
