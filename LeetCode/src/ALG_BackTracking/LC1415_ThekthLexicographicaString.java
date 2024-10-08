package ALG_BackTracking;
import java.util.ArrayList;
import java.util.List;

public class LC1415_ThekthLexicographicaString {
    public static void main(String[] args) {

    }

    /**Backtracking
     * O()
     * O()
     * Ideas:
     * 1. unique resL
     * 2. 元素distinct，可重复使用（根据题意i==0）
     * 3. resL condition
     */
    public String getHappyString(int n, int k) {
        char[] set = new char[]{'a', 'b', 'c'};
        List<String> list = bk(n, new StringBuilder(), new ArrayList<>(), set);
        if(k > list.size()) return "";
        return list.get(k-1);
    }

    public static List<String> bk(int n, StringBuilder sb, List<String> res, char[] set){
        //  n = 3, k = 9
        if(sb.length() == n){
            res.add(sb.toString());
            return res;
        }

        // layer logic
        for(int i=0; i<set.length; i++){
            // repeat neibor elements
            if(sb.length() >= 1 && sb.charAt(sb.length()-1) == set[i]){
                continue;
            }
            sb.append(set[i]); // sb: "acb"
            bk(n, sb, res, set);
            sb.deleteCharAt(sb.length()-1);
        }

        return res;
    }
}
