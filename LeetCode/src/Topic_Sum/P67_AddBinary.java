/**
 * Given two binary strings a and b, return their sum as a binary string.
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * Constraints:
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
package Topic_Sum;
/**代码逻辑题
 * O(n) Beats 100%
 * Ideas:
 * 1.从a和b的最后一位开始，依次将对应的位置的数字相加
 * 2.如果需要进一位，就记录carry
 * 3.用carry记录每一次加的值，将a[i]和b[j]和carry相加
 * 4.carry%2就是当前位需要放入的值
 * 5.carry/2就是当前位需要进位的值
 * 6.用sb来存储结果，不用array，麻烦，记得最后的结果要reverse，这里也不用讨论首位为0的可能性，因为不可能
 * 7.注意while循环条件的carry==1，因为最后如果还有一个进位，那么应该将这个carry加入
 */
public class P67_AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i>=0 || j>=0 || carry==1){
            if(i>=0){
                carry += a.charAt(i) - '0';
                i--;
            }
            if(j>=0){
                carry += b.charAt(j) - '0';
                j--;
            }
            sb.append(carry%2);
            carry /= 2;
        }
        System.out.println(sb.reverse().toString());
    }
}
