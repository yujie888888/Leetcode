package Topic_Anagram;
import java.util.*;

public class LC49_GroupAnagrams {
    public static void main(String[] args) {
        String[] List = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(sortMethod(List));
    }
    /**Sort + map
     * O(n)
     */
    private static List<List<String>> sortMethod(String[] strs){
        // 用map存所有一样的结果
        HashMap<String, List<String>> map = new HashMap<>();
        // 遍历strs，将排序后string一致的string分成一类并加入list
        for(String s : strs){
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String str = String.valueOf(temp);
            if(map.containsKey(str)){
                map.get(str).add(s);
            }
            else{
                // 注意这里就算map中不存在这个s，也要把s放进去不然就漏掉了
                map.put(str, new ArrayList<String>());
                map.get(str).add(s);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(String str : map.keySet()){
            res.add(new ArrayList(map.get(str)));
        }

        return res;
    }
}
