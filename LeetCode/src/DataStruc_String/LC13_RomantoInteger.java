package DataStruc_String;

import java.util.HashMap;

public class LC13_RomantoInteger {
    public static void main(String[] args) {

    }

    /**HashMap
     * O(n)
     * Ideas:
     * working the string from back to front and using a map
     * And 记录一个temp，用来标记是-还是+
     */
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        int temp = 0; // last char value
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(temp > map.get(c)){
                res -= map.get(c);
            }
            else{
                res += map.get(c) ;
            }
            // System.out.println(res);
            temp = map.get(c);
        }
        return res;
    }
}
