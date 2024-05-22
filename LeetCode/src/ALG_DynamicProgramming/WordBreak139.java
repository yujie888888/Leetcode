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
     * O(n^3) Beats 70%
     * O(n) Beats 90%
     * 思路:
     * 其实是看答案看懂的，不是特别透彻的理解
     * 题意是是否能将String s分割成wordDict中的一个或者多个String;
     * 也就是说，wordDict中是否存在一个或多个String能够构成String s
     * 而且wordDict中的word可以多次重复被使用;不是每一个word都会用到
     * 1.dp[i]表示s的前i长度是否能被wordDict中的word组成
     * 2.递推关系:
     *      将前i长度的string分成两份，一份是dp[j],一份是s[j,i]
     *      然后判断dp[j]是否为true
     *      判断wordDict是否包含s[j,i]
     *      这样相当于将s分成了多个部分，每个部分都经过了验证，最后dp[n]就是一个判断了在n长度内的所有分割情况的结果
     *
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];//dp初始值是false
        int max = 0;
        for(String word : wordDict) max = Math.max(max,word.length());
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<=i; j++){
                if(j>=i-max && dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
