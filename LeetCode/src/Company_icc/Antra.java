package Company_icc;

import java.util.HashMap;

public class Antra {
    /**
     * For example if input is “”
     * Output = a3b5c3
     * Input = “aaaccbbccbbb”
     * Output = a3c4b5
     */
    public static void main(String[] args) {
        String str = "aaaccbbccbbb";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        StringBuilder res = new StringBuilder();
        for(char key : map.keySet()){
            res.append(key);
            res.append(map.get(key));
        }
        System.out.println(res.toString());
    }
}
