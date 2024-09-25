package Company_icc;

public class GTS2 {
    public static void main(String[] args) {
        String a = "abcd";
        String b = "abecd";
        System.out.println(findChar(a,b));
    }
    public static Character findChar(String a, String b){
        int sum1 = 0, sum2 = 0;
        for(char c : a.toCharArray()){
            sum1 += c;
        }
        for(char c : b.toCharArray()){
            sum2 += c;
        }
        return (char)Math.abs(sum1-sum2);
    }
}
