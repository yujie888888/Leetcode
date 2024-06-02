/**
 * You are given a string s. It may contain any number of '*' characters. Your task is to remove all '*' characters.
 * While there is a '*', do the following operation:
 * Delete the leftmost '*' and the smallest non-'*' character to its left. If there are several smallest characters, you can delete any of them.
 * Return the
 * lexicographically smallest
 *  resulting string after removing all '*' characters.
 * Example 1:
 * Input: s = "aaba*"
 * Output: "aab"
 * Explanation:
 * We should delete one of the 'a' characters with '*'. If we choose s[3], s becomes the lexicographically smallest.
 * Example 2:
 * Input: s = "abc"
 * Output: "abc"
 * Explanation:
 * There is no '*' in the string.
 * Constraints:
 * 1 <= s.length <= 105
 * s consists only of lowercase English letters and '*'.
 * The input is generated such that it is possible to delete all '*' characters.
 */
package DataStruc_String;
import java.util.ArrayList;
import java.util.List;

public class Contest400_RemovingStars3170 {
    public static void main(String[] args) {
        String s = "aaba*sad*";
        System.out.println(clearStars(s));
    }
    /**
     * O(26n)
     * O(n)
     * 思路:
     * 不好想
     * 题目说可以删除任意一个左边最小的char，其实只要删除离*最近的最小的那个char，返回的就会是字典序最小的
     * 因为字典序越小的放在前面，整个s的字典序就越小
     * 由此想到记录每个char出现的index，然后遇到*之后就删除最小的char的最后一次出现的位置
     * 1.用List<List> indices 记录每个char出现的index
     * 2.用deleted[]记录要删除的位置
     * 3.从左到右遍历s
     * 4.找到*之后，从左到右遍(保证第一个找到的是最小的char)历indices，只要indices不为空，就将这个list的最后一个的int(index)删掉，也就是删掉离*最近的最小的char
     * 5.删掉char之后，将这个char的位置标记为deleted
     * 6.用StringBuilder和deleted[]构建新的结果
     */
    public static String clearStars(String s) {
        //
        //用{26*{}}存不同的letter出现的index，然后删除最后的那个index
        //用boolean[] deleted 标记要删除的位置
        List<List<Integer>> indecies = new ArrayList<>();
        for(int i=0; i<26; i++){
            indecies.add(new ArrayList<>());
        }
        int n = s.length();
        boolean[] deleted = new boolean[n];
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '*'){
                deleted[i] = true;
                for(int j=0; j<26; j++){
                    if(!indecies.get(j).isEmpty()){
                        deleted[indecies.get(j).get(indecies.get(j).size()-1)] = true;
                        indecies.get(j).remove(indecies.get(j).size()-1);
                        break;
                    }
                }
            }
            else{
                indecies.get(s.charAt(i)-'a').add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            //System.out.println(deleted[i]);
            if(!deleted[i]) sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
