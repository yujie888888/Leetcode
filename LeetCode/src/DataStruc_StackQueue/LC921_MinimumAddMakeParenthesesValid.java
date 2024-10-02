package DataStruc_StackQueue;

public class LC921_MinimumAddMakeParenthesesValid {
    public static void main(String[] args) {

    }

    /**Stack
     * O(n)
     * O(n)
     * Ideas:
     * 是Stack思路，但是用left简化了这个过程，很有意思
     * left就是left bracket的数量
     *  如果遇到left bracket，left++
     *  如果是right bracket，left--，表示匹配上了
     *      如果left<=0,也就是说right bracket多了，res++
     * 最后left就是多余的left的数量
     * 最后返回需要add的right bracket(left) 和 left bracket(res)
     */
    public static int minAddToMakeValid(String s) {
        int left = 0;
        int res = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                left ++;
            }
            else{
                if(left > 0) left --;
                else res ++;
            }
        }
        return res + left;
    }
}
