/**这道题不是原题，我让GPT出的一道字符串分割的题 “第二题是是字串分割题”
 * 写一个函数 splitString，该函数接收一个字符串 s 和一个整数 k 作为输入
 * 函数的任务是将字符串 s 按照长度为 k 的子串分割，并返回一个由这些子串组成的列表
 * 如果最后一个子串的长度不足 k，则在其后面用字符 * 补齐，直到长度为 k
 * Ex:
 * 输入: s = "abcdefghij", k = 3
 * 输出: ["abc", "def", "ghi", "j**"]
 */
package Company_Databricks;
import java.util.Arrays;

public class P5_SplitString {
    /**string
     * O(n)
     * O(n)
     * 思路：
     * 技巧：
     *   求count用(n+k-1)/k;
     *   求第几组用res[i/k]
     * substring = String.format("%-" + k + "s", substring).replace(' ', '*');
     *   "%-"：左对齐
     *   k：长度
     *   "s"：字符串
     *   substring：操作对象
     *   将substring用空格补充到k长度，并且左对齐
     *   .replace()：把空格替换成*
     */
    public static void main(String[] args){
        String s = "abcdefghij";
        int n = s.length();
        int k = 3;
        int count = (n+k-1)/k;
        String[] res = new String[count];
        for(int i=0; i<n; i+=k){
            int index = i/k;
            if(index == count-1){
                res[index] = s.substring(i,n);
                res[index] = String.format("%-" + k + "s", res[index]).replace(" ","*");
            }
            else res[index] = s.substring(i,i+k);
        }
        System.out.println(Arrays.toString(res));
    }
}
