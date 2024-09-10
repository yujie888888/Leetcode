package ALG_DivideAndConquer;

public class LC395_LongestSubstring {
    public static void main(String[] args) {

    }
    //Divide and Conquer
    public static int longestSubstring1(String s, int k) {

        return 2;
    }


    //brute force
    public static int longestSubstring2(String s, int k) {
        if (s == null || s.isEmpty() || k > s.length()) {
            return 0;
        }
        int res = -1;
        for(int i=0; i<s.length(); i++){
            int[] map = new int[26];
            for(int index=0; index<26; index++) map[index] = -1;
            for(int j=i; j<s.length(); j++){
                if(map[s.charAt(j)-'a'] == -1){
                    map[s.charAt(j)-'a'] = 1;
                }
                else{
                    map[s.charAt(j)-'a'] += 1;
                }
                if(isValid(k, map)){
                    System.out.println(res);
                    System.out.println( Math.max(res, j-i+1));
                    res = Math.max(res, j-i+1);
                }
            }
        }
        return res = res == -1 ? 0 : res;
    }
    private static boolean isValid(int k, int[] map){
        for(int num : map){
            if(num != -1 && num < k){
                return false;
            }
        }
        return true;
    }
}
