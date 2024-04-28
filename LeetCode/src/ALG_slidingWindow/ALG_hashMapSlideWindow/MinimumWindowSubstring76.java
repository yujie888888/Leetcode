package ALG_slidingWindow.ALG_hashMapSlideWindow;
/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
 * every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 * Constraints:
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s and t consist of uppercase and lowercase English letters.
 */
/*
伪代码
//大写字母A至Z的ASCII码值范围从65到90。
//小写字母a至z的ASCII码值范围从97到122。
//这里hashmap不能用array了
create hashmap<(char)key,(int)value>
把t存进hashmap频率表中
//用双指针找
left = 0, right = 0;
int count= slength；
int min_len = MAXINT;
while(right<s.length){
    //如果right指向的字母是t中的字母
    if(hashmap.get(right)>0){
        count--//只需要再找剩下的count个数量
        //当前right的字母要在hashmap中更新
        hashmap.put(s.charAt(right), hashmap.get(s.charAt(right)) - 1);
        right++;
        }
    else{
        //还是要更新其他的字母
        put(right,hashmap.get(right)--);
        right++;
    }
    while(count == 0){
        说明该窗口内已经包含了t中所有的字母
        更新min_len
        //缩小窗口,如果left对应的字母是t中的字母，那么count++
        if(hashmap.get(left)==0){
            //当前left的字母要在hashmap中更新
            hashmap.put(s.charAt(left), hashmap.get(s.charAt(left)) + 1)
            left++;
            count++;
        }
        else{
            //恢复，当前left的字母要在hashmap中更新
            put(left,hashmap.get(right)++);
            left++;
        }
    }
}
return 如果min_len依旧是MAXINT 返回null，如果不是，返回min_len
 */
import java.util.HashMap;
import java.util.Scanner;
public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input string s:");
        String sLine = sc.nextLine();
        System.out.println("Please input string t:");
        String tLine = sc.nextLine();
        if(sLine == "" || tLine =="" || sLine.length() < tLine.length()){
            System.out.println("");
            return;
        }

        //searchMinimum(sLine, tLine);
    }

    /**HashMap + changeable window
     * 可变窗口用的是while，固定窗口用if，这是最大的区别
     * hash用contains，array用值
     */
    public String minimum1(String s, String t) {
        //HashMap + changeable window
        HashMap<Character,Integer> freq = new HashMap<>();
        for(char c : t.toCharArray()){
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        String result = "";
        int left = 0;
        int count = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for(int right=0; right<s.length(); right++){
            char rkey = s.charAt(right);
            if(freq.containsKey(rkey)){
                if(freq.get(rkey)>0) count ++;
                freq.put(rkey, freq.get(rkey)-1);
            }
            while(count == t.length()){
                if(minLen > right-left+1){
                    minLen = right-left+1;
                    start = left;
                }
                char lkey = s.charAt(left);
                if(freq.containsKey(lkey)){
                    if(freq.get(lkey)>=0) count --;
                    freq.put(lkey, freq.get(lkey)+1);
                }
                left ++;
            }
        }
        if(minLen != Integer.MAX_VALUE){
            result = s.substring(start,start+minLen);
        }
        return result;
    }
    //优化，用array代替hashmap
    public String minWindow2(String s, String t) {
        //大写字母65-90 小写字母97-122 60个就够了
        int[] freq = new int[60];
        for(char c : t.toCharArray()){
            freq[c - 'A']++;
        }
        int m = s.length();
        int n = t.length();
        if(m<n) return "";

        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int left = 0;
        int right = 0;
        int start = 0;
        while(right < m){
            int indexR = s.charAt(right)-'A';
            if(freq[indexR] > 0){
                freq[indexR] --;
                count ++;
            }
            else{
                freq[indexR] --;
            }
            while(count == n){
                if(minLen>right-left+1){
                    minLen = right-left+1;
                    start = left;
                }
                int indexL = s.charAt(left)-'A';
                if(freq[indexL]>=0){
                    freq[indexL] ++;
                    count --;
                }
                else{
                    freq[indexL] ++;
                }
                left ++;
            }
            right ++;
        }
        //注意这里如果找不到，要返回""，别忘了
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(start,start+minLen);
    }
}
