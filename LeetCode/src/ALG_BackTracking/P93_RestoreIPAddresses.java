/**
 * A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
 * For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 * Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
 * Example 1:
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * Example 2:
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * Example 3:
 * Input: s = "101023"
 * Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * Constraints:
 * 1 <= s.length <= 20
 * s consists of digits only.
 */
package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;

public class P93_RestoreIPAddresses {
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        String s = "101023";
        res.clear();
        StringBuilder sb = new StringBuilder();
        backtracking(s,0,sb,0);
        System.out.println(res);
    }
    /**Backtracking
     * O(3^4) 每层最多有三个选择，一共有4层
     * O(n)
     * Ideas:
     * 明确这是一个切割问题，切割问题可以抽象成组合问题
     * 基本思路就是有4层，每一层是递归，这是纵向遍历；
     * 每一层可以选择不同的string，然后每一层要确定的就是string的长度，也就是切割的长度，这是横向遍历；
     * 如果start也就是切割开始点的位置已经到了最后，而且已经有了四个部分，那么这个string就是一个结果
     * 1.终止条件：有四个部分；
     * 2.循环逻辑：每一层依次选择string，因为是单个集合，所以用start来表示每一层的切割开始的位置，i表示切割结束的位置
     * 3.参数：一边做一遍确定
     * 注意事项：
     * 1.回溯的时候，记录每次传进来的sb的长度，然后在递归返回之后重新恢复到这个长度。
     *   虽然我不知道为什么我用sb和part的长度来进行恢复会报错，但是显然先记录len的方法更直观
     */
    private static void backtracking(String s, int start, StringBuilder sb, int pointNum){
        if(pointNum == 4){
            if(start == s.length()){
                sb.deleteCharAt(sb.length()-1);
                res.add(sb.toString());
            }
            return;
        }
        int len = sb.length();
        for(int i=start; i<start+3 && i<s.length(); i++){
            String part = s.substring(start,i+1);
            if(Qualfied(part)){
                sb.append(part);
                sb.append('.');
                pointNum ++;
                backtracking(s, i+1, sb, pointNum);
                sb.setLength(len);
                pointNum --;
            }
            else break;
        }
    }
    private static boolean Qualfied(String part){
        if(part.length()>1 && part.charAt(0) == '0') return false;
        if(part.length() > 3) return false;
        int num = 0;
        int digit = 1;
        for(int i=part.length()-1; i>=0; i--){
            char c = part.charAt(i);
            if(!(0<= c-'0' && c-'0' <= 9)) return false;
            num += (c-'0')*digit;
            digit *= 10;
        }
        if(num > 255) return false;
        return true;
    }
}
