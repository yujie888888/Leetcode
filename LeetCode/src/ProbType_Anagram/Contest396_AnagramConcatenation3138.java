/**
 * You are given a string s, which is known to be a concatenation of anagrams of some string t.
 * Return the minimum possible length of the string t.
 * An anagram is a word or phrase formed by rearranging the letters of a word or phrase, typically using all the original letters exactly once.
 * Example 1:
 * Input: s = "abba"
 * Output: 2
 * Explanation:
 * One possible string t could be "ba".
 * Example 2:
 * Input: s = "cdef"
 * Output: 4
 * Explanation:
 * One possible string t could be "cdef", notice that t can be equal to s.
 * Example 3:
 * s = "xxe"
 * Output: 3
 * Constraints:
 * 1 <= s.length <= 105
 * s consist only of lowercase English letters.
 */
package ProbType_Anagram;
import java.util.HashMap;
import java.util.Map;
/**Anagram
 * O(n) + O(log(min(a,b)))    O(log(min(a,b)))也是求GCD的欧几里得算法的时间复杂度
 * O(1)
 * 一个新的概念：最大公约数 GCD(Greatest common denominator)
 * 使用场景：
 * 1.在处理周期性重复的字符串或数组时，GCD 可以帮助识别最小的重复单元
 * 2.在对数字进行分组或划分时，GCD 可以用来确定最优的分组方式，从而减少计算量，优化算法性能。比如在处理分数数组或数列合并问题时，利用 GCD 确定最小化操作步骤
 * 例题：
 * P365
 * 这道题的思路：
 * 写了一半才发现这道题不能用GCD，比如"aabbcc"这个输入，输出应该是6，但是用GCD输出是3
 * 如果改一下题目变成"对于一个String s,它能由 哪个最小长度的anagram串联构成" 这样对于aabbcc来说，可以由abc这个最短的anagram串联而成
 * 但是对于这道题要求是s已经由anagram串联构成了，所以要看s的构成情况才行，可以用
 *      "检查所有可能的子串长度：对于每一个可能的子串长度（即从 1 到字符串总长度的所有因子），检查通过重排这些子串是否可以恰好组成原字符串。"
 *      这个方法，但是我懒得写了，就当这道题引入了GCD概念
 * 题目要求是求一个最小的anagram子串，这个子串重复多次构成了s
 * string s, which is known to be a concatenation of anagrams of some string t.这句话说明给定的s肯定至少存在一个anagram子串
 * 如果一个字符串可以被分割成多个完全一样的子串的连接：
 *      那么每种char出现的总次数一定能被这些子串的数量整除；
 *      不管一个anagram有多少个char，以及内部有多少重复的char，每个char出现的频率肯定能被子串的数量k整除；
 *      要找到这个能被所有数整除的数量k，就是在找最大公约数
 * 比如"xxefgefxgx",x出现了4次，e和f和g出现了2次，所有的char都能被2整除，所有char的最大公约数也是2
 * Steps:
 * 1.先用hashmap储存每个char出现的freq,可以换成array
 * 2.求所有char的最大公约数,得到anagram的重复次数
 * 3.用s.length / 重复次数 = anangram的长度
 */
public class Contest396_AnagramConcatenation3138 {
    public static void main(String[] args) {
        String s = "aabbcc";
        Map<Character,Integer> hashmap = new HashMap<>();
        for(char c : s.toCharArray()){
            hashmap.put(c,hashmap.getOrDefault(c,0)+1);
        }
        int gcd = hashmap.get(s.charAt(0));
        for(int freq : hashmap.values()){
            gcd = getGcd(gcd, freq);
            if(gcd == 1) break;
        }
        System.out.println(s.length() / gcd);
    }
    public static int getGcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
