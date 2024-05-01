/**
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * Input: digits = ""
 * Output: []
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * Constraints:
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;

/**BackTracking
 * O(n*(m^n)) m是每个数字对应的字母长度，第一个n是.toSting(),第二个n是树的深度 Beats 100%
 * O(n+m^n)  m^n表示有多少种结果，n是递归栈 Beats 95%
 * 思路：https://programmercarl.com/0017.%E7%94%B5%E8%AF%9D%E5%8F%B7%E7%A0%81%E7%9A%84%E5%AD%97%E6%AF%8D%E7%BB%84%E5%90%88.html#%E7%AE%97%E6%B3%95%E5%85%AC%E5%BC%80%E8%AF%BE
 * 拿23举例来说，2-abc，3-def
 * 对abc来说可以选a或b或c，然后选完2，再来选3
 * 对于def来说，可以选d或e或f
 * 1.确定终止条件：sb.length() == digits.size();
 * 2.回溯逻辑：对于每个数字来说，遍历它对应的字母；然后再调用BT遍历下一个数字对应的字母
 * 3.确定参数
 * 注意事项：
 * 1.数字和字母如何实现映射
 *   很多种方法，可以用map或二维数组
 *   这里我用的是String[]一维数组
 * 2.注意每次都要clear res
 * 3.sb不用sb.setLength(0);因为回溯逻辑里面sb出来的时候已经是空的了
 * 4.(可选)处理base case，null和empty是不一样的,null表示没有引用；empty有引用，但是为空；这里可选是因为不知道程序要求当这种情况的时候返回什么类型的，是返回null还是返回""。
 * 5.(重点)index ++ 和 ++index 和 index+1的区别
 *   在递归中，如果对index本身++，那么index本身会改变，但是在递归中，其实我只想让下一级的index不同而已，不想改变当前级的index值，所以只能用index+1
 * 6.letters中对于0和1的情况置空
 * 7.选择StringBuilder因为string需要频繁增删，sb效率更高
 */
class LetterCombinationsofaPhoneNumber17{
    static List<String> res = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static String digits = "23";
    static int n = digits.length();
    static String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        res.clear();
        if(digits == null || digits.isEmpty()) System.out.println(res);

        backtracking(0);
        System.out.println(res);
    }
    public static void backtracking(int index){
        if(sb.length() == n){
            //toString() O(n)
            res.add(sb.toString());
            return;
        }
        String str = letters[digits.charAt(index) - '0'];
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            sb.append(c);
            backtracking(index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}


