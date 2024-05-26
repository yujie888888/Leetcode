package DataStruc_Hash;
/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 * Example 1:
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 * Constraints:
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote383 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote,magazine));
    }

    /**HashMap
     * O(m)
     * O(m+n)
     * 思路:
     * 太简单了，没什么好说的
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] ransom = new int[26];
        int[] magaz = new int[26];
        for(char c : ransomNote.toCharArray()){
            ransom[c-'a'] ++;
        }
        for(char c : magazine.toCharArray()){
            magaz[c-'a'] ++;
        }
        for(char c : ransomNote.toCharArray()){
            if(magaz[c-'a'] < ransom[c-'a']) return false;
        }
        return true;
    }
}
