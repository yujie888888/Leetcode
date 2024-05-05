package ProbType_Palindrome;

public class ValidPalindrome125 {
    public static void main(String[] args) {

    }
    //用双指针,其实就是Character的一些方法应用
    //O(n) Beats 75%
    public boolean isPalindrome(String s) {
        //A-Z 65-90
        //a-z 97-122
        //0-9 48-57
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }
            right --;
            left ++;
        }
        return true;
    }
}
