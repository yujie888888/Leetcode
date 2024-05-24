/**
 * A word is considered valid if:
 * It contains a minimum of 3 characters.
 * It consists of the digits 0-9, and the uppercase and lowercase English letters. (Not necessary to have all of them.)
 * It includes at least one vowel.
 * It includes at least one consonant.
 * You are given a string word.
 * Return true if word is valid, otherwise, return false.
 * Notes:
 * 'a', 'e', 'i', 'o', 'u', and their uppercases are vowels.
 * A consonant is an English letter that is not a vowel.
 * Example 1:
 * Input: word = "234Adas"
 * Output: true
 * Explanation:
 * This word satisfies the conditions.
 * Example 2:
 * Input: word = "b3"
 * Output: false
 * Explanation:
 * The length of this word is fewer than 3, and does not have a vowel.
 * Example 3:
 * Input: word = "a3$e"
 * Output: false
 * Explanation:
 * This word contains a '$' character and does not have a consonant.
 * Constraints:
 * 1 <= word.length <= 20
 * word consists of English uppercase and lowercase letters, digits, '@', '#', and '$'.
 */
package DataStruc_String;
import java.util.Arrays;

/**代码逻辑题
 * O(n) Beats 100%
 * O(1) Beats 100%
 * 思路：
 * 一步步满足题目要求：
 * 1.长度>=3
 * 2.不能包括除了xx，xx和xx以外的char -> consistsVaild(){根据ASCII码，不满足条件的char一出现就false}
 * 3.至少包含一个元音，将元音值设置为21，因为word最大长度是20，所以设置为21确保了只要sum值>20,那么说明肯定存在元音
 * 4.至少包含一个辅音：将辅音的值设置为1，只看辅音的sum是不会超过21的，所以将word所有char的值加起来(sum),只要sum % 21存在余数，说明是存在辅音的
 * 注意事项：
 * 1.在求3和4的时候，需要把数字部分的值设置为0，用不到的部分怎么设置都无所谓;
 */
public class Contest396_ValidWord3136 {
    public static void main(String[] args) {
        String word = "a3$e";
        if(word.length() >=3 && consistsVaild(word) && hasVowelConsonant(word)) System.out.println(true);
        else System.out.println(false);
    }
    public static boolean consistsVaild(String word){
        for(char c : word.toCharArray()){
            if( (c>=48 && c<=57) || (c>=65 && c<=90) || (c>=97 && c<=122) ){
                //System.out.println(c-0);
            }
            else return false;
        }
        return true;
    }
    public static boolean hasVowelConsonant(String word){
        int[] array = new int[128];
        Arrays.fill(array,1);
        for(int i=48; i<=57; i++){
            array[i] = 0;
        }
        array[65] = 21;
        array[97] = 21;
        array[69] = 21;
        array[101] = 21;
        array[73] = 21;
        array[105] = 21;
        array[79] = 21;
        array[111] = 21;
        array[85] = 21;
        array[117] = 21;
        int sum = 0;
        for(char c : word.toCharArray()){
            sum += array[c];
        }
        if(sum > 20 && sum%21 != 0) return true;
        else return false;
    }
}
