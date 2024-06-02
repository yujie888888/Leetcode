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

class LetterCombinationsofaPhoneNumber17{
    public static void main(String[] args) {
        String digits = "5689";
        System.out.println(letterCombinations1(digits));
        System.out.println(letterCombinations2(digits));
    }
    /**BackTracking(Map-String[])
     * O(n*(4^n)) 100%
     *   第一个n是.toSting(),4是数字对应的字母长度，第二个n是树的深度 Beats
     * O(n + n*4^n) Beats 95%
     *   4^n表示有多少种结果,n表示每个结果的长度，n是递归栈空间
     * 思路:
     * digits代表的就是几层和多少种选择，比如23，可以进行的组合就是先遍历2对应的letter，再遍历3对应的letter
     * 1.设定数字和字母映射
     * 2.确定终止条件：sb.length() == digits.size();
     * 3.回溯逻辑：对于每个数字来说，遍历它对应的字母；然后再调用BT遍历下一个数字对应的字母
     * 4.确定参数
     * 注意事项：
     * 1.每次都要clear res
     * 2.(重点)index ++ 和 ++index 和 index+1的区别
     *   在递归中，如果对index本身++，那么index本身会改变，但是在递归中，其实我只想让下一级的index不同而已，不想改变当前级的index值，所以只能用index+1
     * 3.(可选)letters中对于0和1的情况置空
     * 4.选择StringBuilder因为string需要频繁增删，sb效率更高
     */
    static List<String> res = new ArrayList<>();
    public static List<String> letterCombinations1(String digits){
        res.clear();
        int n = digits.length();
        if(n==0) return res;
        String[] letters = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb1 = new StringBuilder();
        int[] index = new int[n];
        for(int i=0; i<n; i++){
            index[i] = digits.charAt(i) -'0';
            //System.out.println(index[i]);
        }
        backtracking1(index,0,digits,n,letters,sb1);
        return res;
    }
    public static void backtracking1(int[] index, int start, String digits, int n, String[] letters, StringBuilder sb1){
        if(sb1.length() == n){
            res.add(sb1.toString());
            return;
        }
        for(char c : letters[index[start]].toCharArray()){
            sb1.append(c);
            backtracking1(index,start+1,digits,n,letters,sb1);
            sb1.deleteCharAt(sb1.length()-1);
        }
    }
    /**BackTracking(Map-Array[][])
     * O(n*(4^n)) 100%
     * O(n + n*4^n)
     * 注意事项:
     * 1.letters里的index是从0开始的，但是数字字母映射是从2开始的，注意处理
     */
    public static List<String> letterCombinations2(String digits) {
        res2.clear();
        char[][] letters = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        int n = digits.length();
        if(n==0) return new ArrayList<String>();
        int[] index = new int[n];
        int i=0;
        for(char c : digits.toCharArray()){
            index[i] = c-'0'-2;
            i++;
        }
        StringBuilder sb = new StringBuilder();
        backtracking2(index, 0, sb, letters);
        return res2;
    }
    //终止条件: resL.size == digits.length()
    static List<String> res2 = new ArrayList<>();
    private static void backtracking2(int[] index, int start, StringBuilder sb, char[][] letters){
        if(sb.length() == index.length){
            res2.add(sb.toString());
            return;
        }
        for(char c : letters[index[start]]){
            sb.append(c);
            backtracking2(index, start+1, sb, letters);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}


