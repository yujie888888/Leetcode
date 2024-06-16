/**
 * Amazon is developing an efficient string matching library. Develop a prototype service that matches a simple pattern with a text.
 * There are two arrays of strings, text and pat, each of size n.
 * Each string in pat is a regex expression that contains exactly onewildcard character (*).
 * A wildcard character () matches any sequence of zero or more lowercase English letters.
 * A regex matches some string if it is possible to replace the wildcard character with some sequence of characters such that
 * the regex expression becomes equal to the string.No other character can be changed.
 * For example, regex "abcbcd" matches "abcbcd", "abcefbcd" and "abcccbcd" whereas it does not match the strings "abcbcd", "abzbcd", "abcd".
 * For every i from 1 to n, your task is to find out whether pat[i] matches text[i].
 * Return the answer as an array of strings of size n where the i-th string is "YES" if pat[i] matches text[i], and "NO" otherwise.
 * Note: The implementation shall not use any in-built regex libraries.
 * Example:
 * Given n = 2, text = ["code", "coder"], pat = ["co*d", "co*er"],
 * text[0] = "code", pat[0] = "co*d", "NO", the suffixes do not match
 * text[1] = "coder", pat[1] = "co*er", "YES", the prefixes and suffixes match
 * Here prefix of a string is defined as any substring that starts at the beginning of the string and
 * suffix of a string is defined as any substring that ends at the end of the string.
 * Return ["NO", "YES"].
 * Function Description:
 * Complete the function matchStrings in the editor below.
 * matchStrings has the following parameters:
 * string text[n]: the strings to test
 * string pat[n]: the patterns to match
 * Returns
 * string[n]: "YES" or "NO" answers to the queries
 * Constraints:
 *   1≤n≤10
 *   1≤∣text[i]∣,∣pat[i]∣≤10^5
 *   text[i] contains only lowercase English characters.
 *   pat[i] contains exactly one wildcard character and other lowercase English characters.
 */
package Company_Amazon;
import java.util.Arrays;

public class P5_WildcardCharacter {
    public static void main(String[] args) {
        String[] text = {"code", "coder", "abccccddsfabcd"};
        String[] pat = {"co*d", "co*er", "abc*bcd"};
        int n = 3;
        System.out.println(Arrays.toString(matchStrings1(text,pat,n)));
        System.out.println(Arrays.toString(matchStrings2(text,pat,n)));
    }
    /**startsWith() & endsWith()
     * O(n*m) m is the length of text[i]
     * O(n)
     * Ideas:
     * 1. Find the prefix and suffix according to pat[i]
     * 2. use String.startsWith(prefix) and String.endsWith(suffix) to match the prefix and suffix
     * Key points:
     * 1.The use of indexOf()
     * 2.The use of startsWith() and endsWith()
     */
    private static String[] matchStrings1(String[] text, String[] pat, int n){
        String[] res = new String[n];
        String prefix = "", suffix = "";
        for(int i=0; i<n; i++){
            String str = pat[i];
            int end = str.indexOf('*');
            prefix = str.substring(0,end);
            suffix = str.substring(end+1,str.length());
            if(text[i].startsWith(prefix) && text[i].endsWith(suffix)){
                res[i] = "YES";
            }
            else res[i] = "NO";
        }
        return res;
    }
    /**String.split()
     * O(n*m)
     * O(n*m) m is the length of text[i]
     * Ideas
     * use split() to split the string into two parts: prefix and suffix
     * 为了在正则表达式中匹配字符*，*是特殊字符，我们需要在正则表达式中使用 \*
     * 但是，由于反斜杠 \ 本身也是一个特殊字符，所以在 Java 字符串中需要再使用一个\来转义'\*'
     */
    private static String[] matchStrings2(String[] text, String[] pat, int n){
        String[] res = new String[n];
        for(int i=0; i<n; i++){
            String t = text[i];
            String p = pat[i];
            String[] pp = p.split("\\*");
            if(t.startsWith(pp[0]) && t.endsWith(pp[1])) res[i] = "YES";
            else res[i] = "NO";
        }
        return res;
    }
}
