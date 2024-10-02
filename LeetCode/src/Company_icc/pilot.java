package Company_icc;

import java.util.HashSet;

public class pilot {
    public static void main(String[] args) {
        String str = "AAAAaaa";
        System.out.println(removeDuplicate(str));
    }
    public static String removeDuplicate(String str){
        if(str == null) return null;
        HashSet<Character> set = new HashSet<>();
        for(char c : str.toCharArray()){
            set.add(c);
        }
        StringBuilder res = new StringBuilder();
        for(char c : set){
            res.append(c);
        }
        return res.toString();
    }
}
