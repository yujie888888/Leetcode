/**
 * The Amazon Kindle Store is an online e-book store where readers can choose a book from a wide range of categories. It also provides the ability to bookmark pages the user wishes to return to later. A book is represented as a binary string having two types of pages:
 * '0': an ordinary page
 * '1': a bookmarked page
 * Task: Find the number of ways to select 3 pages in ascending index order such that no two adjacent selected pages are of the same type.
 * Input:
 * A binary string book of length n (1 ≤ n ≤ 10^5) representing the pages of the book.
 * Output:
 * An integer representing the number of ways to select 3 pages in ascending index order such that no two adjacent selected pages are of the same type.
 * Example:
 * Input:
 * book: '01001'
 * Output:
 * 4
 * Explanation:
 * The following sequences of pages match the criterion:
 * [1, 2, 3] (pages: '0', '1', '0')
 * [1, 2, 4] (pages: '0', '1', '0')
 * [2, 3, 5] (pages: '1', '0', '1')
 * [2, 4, 5] (pages: '1', '0', '1')
 * Hence, the answer is 4.
 * 3 <= book.length() <= 10^5
 * book.chatAt(i) is either '0' or '1'.
 */
package Company_Amazon;
import java.util.ArrayList;
import java.util.List;

public class P15_NumberOfWaysToSelect {
    public static void main(String[] args) {
        String book = "01001";
        System.out.println(numberOfAscending1(book));
        System.out.println(numberOfAscending2(book));
    }
    /**
     * update different count recode
     * Ideas:
     * 1.定义状态
     * zero: 出现的0的个数
     * one: 出现的1的个数
     * oneZero: 出现的10的个数
     * zeroOne: 出现的01的个数
     * res: 出现010或者101的个数
     * 2.更新状态
     *   如果遇到0:
     *     那么0可以和前面遇到的1(one)的个数进行配对成为‘10’，‘10’的个数为 oneZero += one;
     *     0还可以和前面遇到的的01(zeroOne)进行配对，数量为res += zeroOne，也就是结果的个数
     *   如果遇到1:
     *     那么1可以和前面遇到的0(zero)的个数进行配对成为‘01’，‘01’的个数为 zeroOne += zero;
     *     1还可以和前面遇到的的10(oneZero)进行配对，数量为res += oneZero，也就是结果的个数
     */
    private static long numberOfAscending1(String book){
        long zero=0, one=0, oneZero=0, zeroOne=0, res=0;
        for(char c : book.toCharArray()){
            if(c == '0'){
                oneZero += one;
                res += zeroOne;
                zero++;
            }
            else{
                ++one;
                zeroOne += zero;
                res += oneZero;
            }
        }
        return res;
    }
    /**
     * O(n) 但是这道题过不了LTE
     * Ideas:
     * 轮流做中间
     */
    private static int numberOfAscending2(String book){
        int n = book.length();
        char[] c = book.toCharArray();
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(c[i] == '0') list0.add(i);
            else list1.add(i);
        }
        int count = 0, target, small, large, equalNum;
        for(int i=0; i<list0.size(); i++){
            target = list0.get(i);
            small = 0;
            large = 0;
            equalNum = 0;
            for(int p=0; p<list1.size(); p++){
                if(list1.get(p)<target) small++;
                else break;
            }
            if(small == 0) continue;
            large = list1.size()-small-equalNum;
            count += (large*small);
        }
        for(int j=0; j<list1.size(); j++){
            target = list1.get(j);
            //System.out.println("target: "+target);
            small = 0;
            large = 0;
            equalNum = 0;
            for(int p=0; p<list0.size(); p++){
                if(list0.get(p)<target) small++;
                else break;
            }
            if(small == 0) continue;
            large = list0.size()-small-equalNum;
            count += (large*small);
            //System.out.println("count: "+count);
        }
        return count;
    }
}
