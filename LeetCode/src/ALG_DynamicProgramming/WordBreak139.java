/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 * Constraints:
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s and wordDict[i] consist of only lowercase English letters.
 * All the strings of wordDict are unique.
 */
package ALG_DynamicProgramming;
import java.util.ArrayList;
import java.util.List;

public class WordBreak139 {
    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        System.out.println(wordBreak(s,wordDict));
    }
    /** DP(背包问题变题)
     * O(n^3) Beats 85%
     * O(n) Beats 97%
     * 思路:
     * 完全背包问题扩展,但是其不是很能理解怎么应用完全背包
     *    很浓厚的背包问题，背包容量就是s，但是不知道物品是谁
     *    物品不是wordDict
     * 我自己的不依赖于完全背包的理解如下:
     * 题意理解:
     *     是是否能将String s分割成wordDict中的一个或者多个String;
     *     也就是说，wordDict中是否存在一个或多个String能够构成String s
     *     wordDict中的word可以多次重复被使用;
     *     不是每一个word都会用到;
     * DP五部曲:
     * 1.dp[i]表示s的前i长度是否能被wordDict中的word组成
     * 2.递推关系:
     *      将前i长度的string分成两份，一份是dp[j],一份是s[j,i]
     *      然后判断dp[j]是否为true && 判断wordDict是否包含s[j,i]
     *      这样相当于将s分成了多个部分，每个部分都经过了验证，最后dp[n]就是一个判断了在n长度内的所有分割情况的结果
     * 3.dp[0] = true;
     * 4.如果不去套用完全背包，双层循环的次序也很简单，就是从长度为i开始，再在i的内部进行循环判断
     * 剪枝:
     * 1.找到一个true就break
     * 2.如果substring i-j的长度超过wordDict中最长的string的长度，没有必要继续了
     * 注意事项:
     * 1.boolean[] dp = new boolean[n+1]; 声明的是一个基本类型的数组。基本类型的数组在初始化时，每个元素都被自动设置为 false
     *   Boolean[] dp = new Boolean[n+1]; 声明的是一个包装类型的数组。包装类型数组在初始化时，每个元素都被自动设置为 null
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        int max = 0;
        for(String word : wordDict) max = Math.max(max,word.length());
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<=i; j++){
                if(j>=i-max && dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
