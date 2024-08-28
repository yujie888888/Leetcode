/**
 * 给定一个字符串 word，你可以从 word 的开头或结尾反转某些字符的顺序以获得新字符串。
 * 反转字符串 word 的前 k 个字符（例如从 w_0 到 w_{k-1}），会生成一个新的字符串。
 * 反转字符串 word 的后 k 个字符（例如从 w_{n-k} 到 w_{n-1}），会生成一个新的字符串。
 * 你的任务是遍历通过这种方式可以形成的所有新字符串，并返回按字母顺序排列的最小字符串。
 * 注意：
 * 你不需要提供最优解，但时间复杂度不应超过 O(word.length^3)，以确保在执行时间限制内。
 * 示例：
 * 对于 word = "dbaca"，输出应为 solution(word) = "abdca"。
 * 解析：
 * 反转第一个字符得到 "dbaca"。
 * 反转前两个字符得到 "bdaca"。
 * 反转前三个字符得到 "abdca"。
 * 反转前四个字符得到 "cabda"。
 * 反转前五个字符得到 "acabd"。
 * 反转最后一个字符得到 "dbaca"。
 * 反转最后两个字符得到 "dbaac"。
 * 反转最后三个字符得到 "dbaca"。
 * 反转最后四个字符得到 "dacba"。
 * 反转最后五个字符得到 "acabd"。
 * 在这些字符串中，按字母顺序排列的最小字符串是 "abdca"，因此它应作为最终输出
 */
package Company_Databricks;

public class P8 {
    public static void main(String[] args){
        String word = "dbaca";
        int n = word.length();
        String res = word;
        for(int i=1; i<n; i++){
            StringBuilder sb = new StringBuilder(word.substring(0,i+1));
            String resL = sb.reverse()+word.substring(i,n);
            if(resL.compareTo(res)<0) res = resL;
        }
        for(int i=n-2; i>=0; i--){
            StringBuilder sb = new StringBuilder(word.substring(i,n));
            String resL = sb.reverse()+word.substring(0,i);
            if(resL.compareTo(res)<0) res = resL;
        }
        System.out.println(res);
    }
}
