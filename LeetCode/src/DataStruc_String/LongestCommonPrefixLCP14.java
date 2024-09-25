/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
package DataStruc_String;

public class LongestCommonPrefixLCP14 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flowight"};
        System.out.println(longestCommonPrefix1(strs));
    }
    /**逐渐缩短法 substring()
     * O(kn)
     * O(n)
     * 思路：
     * 1.用第一个str当作prefix
     * 2.然后遍历之后的每一个str
     * 3.只要prefix和str的前prefix长度的substring不相等，就prefix长度--
     * 4.只要str不以prefix开头就长度--
     */
    public static String longestCommonPrefix1(String[] strs) {
        if(strs.length == 1) return strs[0];
        String prefix = strs[0];
        for(String str : strs){
            while(prefix.length()>0 && str.length() < prefix.length()){
                prefix = prefix.substring(0, prefix.length()-1);
            }
            while(prefix.length()>0 && !str.startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }

    /**逐渐缩短法 .indexOf(string)
     * O(kn) Beats 100%
     * O(1) Beats 90% 相比起方法1空间复杂度更好
     * 思路：
     * 1.将字符串数组的第一个字符串看作是prefix
     * 2.将prefix与接下来的字符串进行对比
     * 3.只要不满足前缀条件，就将prefix长度-1
     * 4.用.indexOf(string)方法，该方法返回的是string第一次出现的索引位置，如果不存在就返回-1。出现位置为0的时候才说明是前缀。
     * 5.注意prefix为空时，要返回""
     */
    public static String longestCommonPrefix2(String[] strs){
        String prefix = strs[0];
        for(String str : strs){
            while(str.indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    /**逐渐增加法/垂直检查法
     * 没仔细看，时间复杂度有点高
     */
    public static String longestCommonPrefix3(String[] strs) {
        for(int i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(String str : strs){
                if(i == str.length() || str.charAt(i) != c){
                    //substring(0,i)中if i==0， 会返回一个""
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
