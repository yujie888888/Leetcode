package Struc_string;

public class FirstUniqueCharacter387 {
    public static void main(String[] args) {

    }
    //两个for-loop + flag
    //O(n^2) Beats 65%
    public int firstUniqChar1(String s) {
        int res = -1;
        int flag;
        char[] cs = s.toCharArray();
        for(int i=0; i<cs.length; i++){
            flag = 0;
            for(int j=0; j<cs.length; j++){
                if(cs[i] == cs[j] && i != j){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) return i;
        }
        return res;
    }
    // 先把每个char的freq存起来
    // 然后最巧妙的一步来了：按照输入的字符串的顺序，比较freq[char c]是否为1，如果为1，那么这个肯定是第一个出现的不重复的char
    // 相当于把无序输入的HashMap变成有序状态
    // O(n) Beats 100%
    public int firstUniqChar2(String s) {
        int[] freq = new int[26];
        char[] cs = s.toCharArray();
        for(char c : cs){
            freq[c-'a']++;
        }
        for(int i=0; i<s.length();i++){
            if(freq[cs[i]-'a'] == 1) return i;
        }
        return -1;
    }
}
