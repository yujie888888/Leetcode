package ALG_BinarySearch;
import java.util.HashSet;

public class LC1044_LongestDuplicateSubstring {
    public static void main(String[] args) {

    }
    /**
     * 这道题要自己写Hash，太麻烦了有闲空再说，太难了估计不会考
     */
    public String longestDupSubstring(String s) {
        // Binary Search + Rabin-Karp (HashSet + Slidewindow)
        HashSet<int[]> set = new HashSet<>();
        int left = 1;
        int right = s.length();
        String res = "";
        // Binary Search 找是否存在长度为x的的重复subString
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // if temp为空就说明不存在长度为mid的重复子串
            // if tmep不为空就说明存在长度为mid的重复子串
            String temp = hasDuplicate(s, mid);
            // System.out.println(temp);
            if (temp.length() != 0) {
                left = mid + 1;
                res = res.length() > temp.length() ? res : temp;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    private static String hasDuplicate(String s, int mid) {
        int left = 0;
        int right = 0;
        // create hash值
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();

        while (right < s.length()) {
            if (right - left + 1 <= mid) {
                sb.append(s.charAt(right));
                right++;
            }
            else {
                while (right < s.length()) {
                    // 当子串长度为mid的时候，要判断前面是否有重复的子串出现过
                    if (set.contains(sb)) {
                        return sb.toString();
                    }
                    // 如果没有，把每个满足条件的hash值(int[])存起来
                    set.add(new String(sb.toString()));

                    // 更新长度为mid的String
                    sb.delete(0,1);
                    left++;
                    sb.append(s.charAt(right));
                    right++;
                }
            }
        }
        return "";
    }
}
