package ALG_TwoPointers;

public class LC925_LongPressedName {
    public static void main(String[] args) {

    }

    /**
     * O(n)
     * Ideas:
     * 根本就是一道medium题
     * 双指针，先遍历，如果i的位置和j的位置的值相等，i移动到下一个
     *      如果不相等，检查是不是多type了，也就是检查typed.charAt(j) ? typed.charAt(j-1)
     *      如果不相等，返回false；如果j==0也返回false
     * base case：
     * 1. m>n
     * 2. 遍历结束后i<m
     * 注意：
     * 1. i<m
     * 2. j>1
     */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, m = name.length(), n = typed.length();
        if(m > n) return false;
        for(int j=0; j<n; j++){
            if(i<m && name.charAt(i) == typed.charAt(j)){
                i++;
            }
            else{
                if(j == 0 || typed.charAt(j) != typed.charAt(j-1)){
                    return false;
                }
            }
        }
        if(i < m) return false;
        return true;
    }
}
