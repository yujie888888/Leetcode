/**
 * input是一个字串list，比如说[“af”,“cag”,“peh”]
 * 输出是每个input子字串的首字母 + 下一个子字串的尾字母所形成的两个字母的子字串
 * 比如说输出应该是ag，ch和pf。
 */
package Company_Databricks;
import java.util.Arrays;

public class P4_StringChar {
    /**String
     * O(n)
     * O(n)
     * 思路：
     * 主要关注一下char怎么连接成String；以及回环的问题；
     */
    public static void main(String[] args){
        String[] strs = new String[]{"af","cag","peh"};
        String[] res = new String[strs.length];
        for(int i=0; i<strs.length; i++){
            char first = strs[i].charAt(0);
            char last;
            if(i==strs.length-1){
                last = strs[0].charAt(strs[0].length()-1);
            }
            else{
                last = strs[i+1].charAt(strs[i+1].length()-1);
            }
            res[i] = "" + first + last; //通过 "" + 将 char 转换为字符串；直接+是ASCII码的值
        }
        System.out.println(Arrays.toString(res));
    }
}
