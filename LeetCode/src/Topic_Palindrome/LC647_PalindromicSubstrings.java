package Topic_Palindrome;
public class LC647_PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "ababa";
        System.out.println(countSubstrings1(s));
    }
    /**DP
     * O(n^2) Beats 40%
     * O(n^2) Beats 35%
     * Ideas:
     * 2.根据回文的性质，如果知道s.charAt(i) == s.charAt(j),那么如果知道[i+1,j-1]区间的s.substring是不是palindrome就能判断[i,j]区间的s是不是palindrome，这样就找到了递推关系
     * 1.先定义dp[i][j]为:在[i,j]这个区间内的s的substring是不是palindrome
     * 2.然后写出递推关系：
     *      if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1]
     *          但是这里还有两种情况
     *             一是i和j相同，也就是指向同一个字母，此时肯定是回文，也就是true
     *             二是i和j相差1，此时也没有dp[i+1][j-1]存在，但是aa这种肯定也是回文，也就是true
     *      if(!=) 肯定就是false
     *   过程中用res记录true的个数
     * 3.然后根据递推关系确定遍历顺序
     *     i和j的内外顺序，先确定i再确定j，j就是确定子串长度的
     *     从递推公式dp[i+1][j+1] = dp[i+2][j]来看，是从左下角递推到右上角，也就是i要从后往前，j要从左到右
     * SumUp：
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
                    if(i == j) dp[i][j] = true;
                    else if(j-i == 1) dp[i][j] = true;
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                else dp[i][j] = false;
                if(dp[i][j]) res++;
            }
        }
        return res;
    }
    /**Two Points
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
