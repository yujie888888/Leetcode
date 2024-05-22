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
package Topic_Palindrome;
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {
    public static void main(String[] args) {
        String s = "aabbccde";
        res.clear();
        backtracking(s);
        //System.out.println("resFinal: "+res);
        System.out.println(res);
    }
    /**BackTracking
     * O(n * 2^n)
     *      对于每个字符的分割，存在有效和无效分割点，不会达到阶乘级别的情况。
     *      回溯树的节点数量虽然大，但由于回文和字符串操作的限制，更接近于 O(2^n)
     * O()
     * 思路:
     * 真的很难想，做完了都不知道怎么做出来的
     * 虽然很难，但是一定要开始写，只要开始写了，就知道怎么慢慢改了
     * 1.确定参数: 这个一边做一边确认
     * 2.确定终止条件: 画树来看，能看出来，如果s为空string的时候，就终止这一条路的递归
     *      substring(i,j) if i==j return一个长度为0的String
     * 3.确定递归逻辑: 这个一步步来
     *      画树的时候会发现,可以按照切割点将s分割成n个组，每个组都是s.substring(0,i) i<=n
     *      然后继续从每个组出发，对每个组进行分割，直到当前被分割的s长度为0，终止
     *      同时每次分割都要判断此次分割得到的String是否是palindrome
     *          如果是palindrome,就继续忘"深层递归"
     *          如果不是palindrome,就"横向遍历"，也就是换一组继续
     * 注意事项:
     * 1.在res.add(resL)时，不能直接add resL, 要res.add(new ArrayList<>(resL))，
     *   因为resL是一个全局变量，我们在递归的时候改变了resL的值，而我们要的也是resL的值
     * 举例理解回溯操作：
     * 返回到第三次调用 backtracking("b")：
     *      resL.remove(resL.size() - 1) -> resL = ["a", "a"]
     *      继续遍历 j，但因为 j 达到最大值，所以返回上一层递归
     * 返回到第二次调用 backtracking("ab")：
     *      resL.remove(resL.size() - 1) -> resL = ["a"]
     *      继续遍历 j：
     *      j = 2，s1 = "ab"：
     *      isPalindrome("ab") 返回 false，所以继续循环，但没有更多 j 值
     *      返回上一层递归
     * 返回到第一次调用 backtracking("aab")：
     *      resL.remove(resL.size() - 1) -> resL = []
     *      继续遍历 j：
     *      j = 2，s1 = "aa"：
     *      isPalindrome("aa") 返回 true，所以 resL.add("aa") -> resL = ["aa"]
     *      递归调用 backtracking("b")
     */
    static List<List<String>> res = new ArrayList<>();
    static List<String> resL = new ArrayList<>();
    public static void backtracking(String s){
        //System.out.println("s: "+s);
        if(s.length() == 0){
            res.add(new ArrayList<>(resL));
            //System.out.println("res: "+res);
            return;
        }
        for(int j=1; j<= s.length(); j++){
            String s1 = s.substring(0,j);
            if(isPalindrome(s1)){
                resL.add(s1);
                //System.out.println("resL: "+resL);
            }
            else{
                continue;
            }
            backtracking(s.substring(j,s.length()));
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
}
