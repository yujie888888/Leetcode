/**
 * 将一个字符串中的所有单词，单独回文，返回结果
 * Ex:
 * String s = "this is a word"
 * return "siht si a drow"
 */
package Company_China;
import java.util.Arrays;
/**String
 * O(n)
 * 将s按照空格分成一个string[]，然后单独将每个单词进行reverse
 */
public class P2_SingleWordPalindrome {
    public static void main(String[] args) {
        String s = "this is a word";
        String[] str = s.split(" ");
        for(int i=0; i<str.length; i++){
            StringBuilder sb = new StringBuilder(str[i]);
            str[i] = sb.reverse().toString();
        }
        System.out.println(Arrays.toString(str));
    }
}
