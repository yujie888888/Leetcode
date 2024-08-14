/**
 * Given a string s, partition s such that every
 * substring
 *  of the partition is a
 * palindrome
 * . Return all possible palindrome partitioning of s.
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;

public class P131_PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aabbccde";
        System.out.println(PalindromeParitition1(s));
        System.out.println(PalindromeParitition2(s));
    }
    /**BackTracking + Double Points
     * O(2^n)
     * O(n)
     * 思路:
     * 这其实是个切割题，把这个切割题抽象为一个组合题
     * 1.回溯逻辑：
     *      给一个string s，然后分割s，看有多少组分割其substring全是回文
     *      用回溯切割，对于每一层，从satrt的位置开始，切割点为i
     *          如果[start,i]这个区间内的string是回文，那么把这个子串加入resL
     *          如果不是回文，i移动，也就是横向遍历，在这一层继续找回文
     *      如果在这一层找到了回文子串，就可以继续从start的下一个位置开始，找下一个回文，也就是在下一层找下一个回文，这是个递归过程
     * 2.终止条件：
     *      如果start到了最后的位置，就说明找到了一个符合条件的子串组合
     */
    public static List<List<String>> PalindromeParitition1(String s){
        res.clear();
        backtracking1(s);
        return res;
    }
    static List<List<String>> res = new ArrayList<>();
    static List<String> resL = new ArrayList<>();
    public static void backtracking1(String s){
        if(s.length() == 0){
            res.add(new ArrayList<>(resL));
            return;
        }
        for(int j=1; j<= s.length(); j++){
            String s1 = s.substring(0,j);
            if(isPalindrome(s1)){
                resL.add(s1);
            }
            else{
                continue;
            }
            backtracking1(s.substring(j,s.length()));
            if(resL.size() != 0) resL.remove(resL.size()-1);
        }
    }
    public static Boolean isPalindrome(String s){
        if(s.length()==1) return true;
        else{
            int left = 0;
            int right = s.length()-1;
            while(left<right){
                if(s.charAt(left) != s.charAt(right)) return false;
                left++;
                right--;
            }
        }
        return true;
    }
    /**Backtracking + DP
     * 逻辑是一样的，只是在判断回文子串的时候用dp存，方便直接查找
     */
    public static List<List<String>> PalindromeParitition2(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=n-1; i>=0; i--){
            for(int j=i; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i<=1) dp[i][j] = true;
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                else dp[i][j] = false;
            }
        }
        res.clear();
        backtracking2(s,0,dp);
        return res;
    }
    private static void backtracking2(String s, int start, boolean[][] dp){
        if(start == s.length()){
            res.add(new ArrayList<>(resL));
            return;
        }
        for(int i=start; i<s.length(); i++){
            if(dp[start][i]){
                resL.add(s.substring(start,i+1));
            }
            else continue;
            backtracking2(s,i+1,dp);
            resL.remove(resL.size()-1);
        }
    }
}
