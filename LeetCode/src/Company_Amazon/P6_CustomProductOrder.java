/**
 * Amazon has millions of products sold on its e-commerce website, and each product is identified by its product code.
 * Given an array of n productCodes and order, a string that represents the precedence of characters,
 * sort the productCodes in lexicographically increasing order per the precedence.
 * Note: Lexicographical order is defined in the following way. When we compare strings s and t,
 * first we find the leftmost position with differing characters: s_i ≠ t_i. If there is no such position
 * (i.e. s is a prefix of t or vice versa) the shortest string is less. Otherwise,
 * we compare characters s_i and t_i according to their order in the given precedence order.
 * Example:
 * If n = 2, order = "abcdefghijklmnopqrstuvwxyz", and productCodes is ["adc", "abc"], the sorted order is ["abc", "adc"].
 * Consider the strings "adc" and "abc", the first point of difference is at position 1 (assuming start index is 0),
 * and 'd' > 'b' according to the given precedence order.
 * Function Description
 * Complete the function sortProductCodes in the editor below.
 * sortProductCodes has the following parameter(s):
 * string order: the new precedence order
 * string productCodes[n]: the array to sort
 * Returns
 * string[n]: the productCodes array in sorted order
 * Constraints
 * 1 ≤ n ≤ 5000
 * 1 ≤ length(productCodes[i]) ≤ 100
 * length(order) = 26
 * order and all productCodes[i] contain lowercase English letters only.
 */
package Company_Amazon;
import java.util.Arrays;
import java.util.HashMap;

public class P6_CustomProductOrder {
    public static void main(String[] args) {
        String order = "abcdefghijklmnopqrstuvwxyz";
        String[] productCodes = {"adc", "abc", "aab", "aaa", "bbb", "bba"};
        System.out.println(Arrays.toString(sortProductCodes(productCodes,order)));
    }
    /**Custom comparator
     * O(m*nlogn) m is the length of element of productCodes[]
     *   Arryas.sort() for n elements of productCodes, to sort them the time complexity is O(nlogn)
     *   in the sort(), for every element, the time complexity is m
     * O(26)/O(1)
     * Ideas:
     * 1.Custom the Arrays.sort() logic to sort the productCodes
     *   1.different length -> shorter is smaller
     *   2.same length -> according to the order a[i] and b[i]
     *     the order is stored in map
     *     use key(char) -> get value(order)
     *     smaller -> smaller
     * 2.The order of letter is defined in String order
     *   Hence use a map to store the order, (char,order)
     */
    private static String[] sortProductCodes(String[] productCodes, String order){
        HashMap<Character,Integer> sortOrder = new HashMap<>();
        char[] charOrder = order.toCharArray();
        for(int i=0; i<order.length(); i++){
            sortOrder.put(charOrder[i],i);
        }
        Arrays.sort(productCodes, (a,b)->{
            if(a.length() != b.length()) return a.length()-b.length();
            else{
                for(int i=0; i<a.length(); i++){
                    if(a.charAt(i) != b.charAt(i)){
                        return sortOrder.get(a.charAt(i)) - sortOrder.get(b.charAt(i));
                    }
                }
            }
            return 0;
        });
        return productCodes;
    }
}
