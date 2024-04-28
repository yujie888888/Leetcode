package Struc_string;
// two points
// O(n) Beats 100%
public class ReverseString344 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        int left = 0;
        int right = s.length - 1;
        char temp;
        while(left<right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
        for(char c : s) {
            System.out.print(c +",");
        }
    }
}
