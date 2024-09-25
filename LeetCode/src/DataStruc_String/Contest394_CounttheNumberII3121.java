package DataStruc_String;
public class Contest394_CounttheNumberII3121 {
    public static void main(String[] args) {
        String word = "aaAbcBC";
        System.out.println(numberOfSpecialChars(word));
    }
    /**异或置位法
     * O(n) Beats 65%
     * O(1) Beats 99%
     * 思路：
     * 明确会出现的所有情况
     * 1.该小写之前没有该字母，此时值为0，满足继续条件
     * 2.该小写之前有小写，此时值为1，满足继续条件
     * 3.该小写之前有大写，此时值为2，标记为不满足 (其实这种情况在大写的1就处理过了)
     * 4.该小写之前有小写和大写，此时值为3，标记为不满足
     *
     * 1.该大写之前没有字母，此时值为0，标记为不满足
     * 2.该大写之前有小写，此时值为1，满足继续条件
     * 3.该大写之前有大写，标记为不满足
     * 4.该大写之前有小写和大写，此时值为3，标记为不满足
     */
    public static int numberOfSpecialChars(String word) {
        int[] arr = new int[26];
        for(char c : word.toCharArray()){
            if(Character.isLowerCase(c)){
                if(arr[c-'a'] >= 2) arr[c-'a'] = -1;
                else if(arr[c-'a'] == -1) continue;
                else arr[c-'a'] |= 1;
            }
            else{
                if(arr[c-'A'] == 1 || arr[c-'A'] == 3) arr[c-'A'] |= 2;
                else if(arr[c-'A'] == -1) continue;
                else arr[c-'A'] |= -1;
            }
        }
        int count = 0;
        for(int i : arr){
            if(i == 3) count ++;
        }
        return count;
    }
}
