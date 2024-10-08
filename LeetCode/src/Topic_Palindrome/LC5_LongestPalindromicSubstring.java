package Topic_Palindrome;
public class LC5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "eeaabababaccabababaasd";
        System.out.println(longestPalindrome1(s));
        System.out.println(longestPalindrome2(s));
        System.out.println(longestPalindrome3(s));
    }
    /**Manacher's Algorithm
     * O(n)
     *
     */



    /**DP
     * O(n^2)
     * O(n^2)
     * Indeas:
     * 1.dp[i][j]: determining whether substring[i-1,j-1] is palindrome
     * 2.if(s[i]==s[j])
     *     if(i==j) dp[i][j] = true;
     *     else if(j-i==1) dp[i][j] = true;
     *     else dp[i][j] = dp[i + 1][j - 1];
     * 3.遍历顺序-> ordered according to the state transfer equation
     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        if(n == 1) return s;
        boolean[][] dp = new boolean[n + 1][n + 1];
        // state transfer equation
        String res = "";
        dp[n][n] = true;
        for (int i = n-1; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    if(i == j){
                        dp[i][j] = true;
                    }
                    else if((j-1==i)){
                        dp[i][j] = true;
                    }
                    else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]){
                    if (j - i + 1 > res.length()) {
                        res = s.substring(i - 1, j);
                    }
                }
            }
        }
        return res;
    }

    /**Expand Method(substring)
     * O(n^2)
     * O(n)
     * 思路:
     * 和P647的双指针做法思路一样
     */
    public static String longestPalindrome1(String s) {
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
    public static String longestPalindrome2(String s) {
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


    /**Brute Force
     * O(n^3)
     * O(1)
     * Ideas:
     * 遍历每一种substring并判断是不是palidrome
     */
    public static String longestPalindrome3(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome3(i, j, s)) {
                    if (j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
    public static boolean isPalindrome3(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
