/**
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 * Example 1:
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * Constraints:
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */
package Topic_Palindrome;
public class PalindromicSubstrings647 {
    public static void main(String[] args) {
        String s = "ababa";
        System.out.println(countSubstrings1(s));
    }
    /**DP
     * O(n^2) Beats 35%
     * O(n^2) Beats 35%
     * 思路:
     * 这道题把dp的含义设置为题目求的找不出来递推关系(md我怎么知道能不能找到)
     * 根据回文的性质，如果知道s.charAt(i) == s.charAt(j),那么如果知道[i+1,j-1]区间的s.substring是不是palindrome就能判断[i,j]区间的s是不是palindrome
     *     这样就找到了递推关系
     *     先定义dp[i][j]为在[i,j]这个区间内的s.substring是不是palindrome
     *     然后写出递推关系：
     *         if(s.charAt(i) == s.charAt(j)) dp[i+1][j+1] = dp[i+2][j]
     *             但是这里还有两种情况，因为i+2有可能>j，这样无法获得substring，必须满足j>=i+2 -> j-i>=2
     *             那么单独讨论不满足的两种情况j-i==0/j-i==1，对于i==j，肯定是true；对于j-i==1，肯定也是true
     *         if(!=) 肯定就是false
     *     过程中用res记录true的个数
     *     然后根据递推关系确定遍历顺序
     *         i和j的内外顺序很明显
     *         从递推公式dp[i+1][j+1] = dp[i+2][j]来看，是从左下角递推到右上角，也就是i要从后往前，j要从左到右
     * 1.dp[i+1][j+1]: 在[i,j]这个区间内的s.substring是不是palindrome
     * 2.用res记录个数
     * 3.if(s.charAt(i) == s.charAt(j))
     *     if(i==j) dp[i+1][j+1] = true;
     *     if(j-i == 1) dp[i+1][j+1] = true;
     *     if(j-i >= 2) dp[i+1][j+1] = dp[i+2][j];
     *   else
     *     dp[i+1][j+1] = false
     * 4.初始化 没有需要初始化的
     * 5.确定递推关系
     */
    public static int countSubstrings1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        int res = 0;
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i==j || j-i == 1) dp[i+1][j+1] = true;
                    else if(j-i >= 2) dp[i+1][j+1] = dp[i+2][j];
                }
                if(dp[i+1][j+1]) res++;
            }
        }
        return res;
    }
    /**Double Points
     * O(n^2) Beats 97%
     * O(1) Beats 80%
     * 思路:
     * 暴力解法就是遍历每一种可能的组合，再判断这些组合是不是palindrome
     * 不论什么做法一定要把所有可能的子串找出来进行判断
     * 双指针法（中心扩展法）可以遍历所有可能的回文子串，举例看了确实是这样
     * 回文特性: 回文字符串在左右对称的基础上，字符相同。因此，我们可以从中心位置开始，向左右两边扩展，直到不再满足回文条件为止。
     * 中心点的选择：对于一个长度为n的字符串，有n个单字符作为中心点,适用于奇数长度的回文,还有n−1个相邻字符之间的位置作为中心点,适用于偶数长度的回文
     */
    public static int countSubstrings2(String s) {
        int n = s.length();
        int res = 0;
        for(int i=0; i<n; i++){
            res += count(i,i,s,n);
            res += count(i,i+1,s,n);
        }
        return res;
    }
    private static int count(int i, int j, String s, int n){
        int res = 0;
        while(i>=0 && j<n && s.charAt(i) == s.charAt(j)){
            res++;
            i--;
            j++;
        }
        return res;
    }
}
