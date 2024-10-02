package Topic_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class LC22_GenerateParentheses {
    public static void main(String[] args) {

    }
    public static List<String> generateParentheses(int n) {
        return bk(n, n, n, new StringBuilder(), new ArrayList<>());
    }

    /**BackTracking
     * O()
     * O()
     * Ideas：
     * 用回溯找出所有合法的Parentheses组合
     * 每层选谁加入，可以选'(' 也可以选')'
     *          判断parentheses是否合法可以放在main core里
     *              只需要记录left和right，left表示还有多少个left bracket能放，同理right
     *              如果left>0,就可以放left bracket
     *              如果right > left，就可以放right bracket (n-left > n-right)
     * 返回条件是resL长度到达2n
     * Pay Attention:
     *  尽量不要用static，不太符合java的OOP设计原则，能传参数就传参数吧
     */
    public static List<String> bk(int n, int left, int right, StringBuilder resL, List<String> res ) {
        if (resL.length() == 2 * n) {
            res.add(resL.toString());
            return res;
        }

        // main core
        if (left > 0) {
            resL.append('(');
            bk(n, left - 1, right, resL, res);
            resL.deleteCharAt(resL.length() - 1); // recovery
        }
        if (right > left) {
            resL.append(')');
            bk(n, left, right - 1, resL, res);
            resL.deleteCharAt(resL.length() - 1); // recovery
        }

        return res;
    }
}
