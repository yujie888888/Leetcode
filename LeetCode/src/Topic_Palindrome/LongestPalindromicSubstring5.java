/**
 * Given a string s, return the longest palindromic substring in s.
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
package Topic_Palindrome;
public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        String s = "eeaabababaccabababaasd";
        System.out.println(longestPalindrome1(s));
        System.out.println(longestPalindrome2(s));
        System.out.println(longestPalindrome3(s));
    }
    /**DP
     * O(n^2) Beats 40%
     * O(n^2) Beats 20%
     * 思路:
     * 和P647思路一样
     * 1.dp[i+1][j+1]: s在区间[i,j]内的substring是不是回文
     * 2.if(s[i]==s[j])
     *     if(i==j) dp[i+1][j+1] = true;
     *     else if(j-i==1) dp[i+1][j+1] = true;
     *     else dp[i+1][j+1] = dp[i+2][j];
     * 3.遍历顺序
     */
    public static String longestPalindrome1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n+1][n+1];
        int maxLen = 0;
        String res = "";
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i<=1) dp[i+1][j+1] = true;
                    else dp[i+1][j+1] = dp[i+2][j];
                }
                if(dp[i+1][j+1]){
                    if(j-i+1 > maxLen){
                        maxLen = j-i+1;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }
    /**Double points(substring)
     * O(n^2) Beats 40%
     * O(n) Beats 65%
     * 思路:
     * 和P642的双指针做法思路一样
     */
    public static String longestPalindrome2(String s) {
        String res = "";
        String temp = "";
        for(int i=0; i<s.length(); i++){
            String s1 = Searchlength1(i, i, s);
            String s2 = Searchlength1(i, i+1, s);
            temp = s1.length() > s2.length() ?  s1 : s2;
            if(temp.length() > res.length()) res = temp;
        }
        return res;
    }
    private static String Searchlength1(int i, int j, String s){
        String subs = "";
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            if(subs.length() < j-i+1) subs = s.substring(i,j+1);
            i--;
            j++;
        }
        return subs;
    }
    /**Double points(int)
     * O(n^2) Beats 80%
     * O(1) Beats 70%
     * 思路：
     * 多次substring影响时间复杂度，换成返回len，利用i和len来获得遍历到i时的substring
     */
    public static String longestPalindrome3(String s) {
        String res = "";
        int len1,len2,temp;
        for(int i=0; i<s.length(); i++){
            len1 = Searchlength2(i, i, s);
            len2 = Searchlength2(i, i+1, s);
            temp = len1 > len2 ? len1 : len2;
            if(temp > res.length()){
                if(temp == len1) res = s.substring(i-(len1-1)/2,i+(len1-1)/2+1);
                else res = s.substring(i-(len2-1)/2, i+(len2-2)/2+2);
            }
        }
        return res;
    }
    private static int Searchlength2(int i, int j, String s){
        int maxLen = 0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            if(maxLen < j-i+1) maxLen = j-i+1;
            i--;
            j++;
        }
        return maxLen;
    }
}
