package Topic_Math;

public class LC2180_CountIntegersWithEvenDigitSum {
    public static void main(String[] args) {

    }

    /**String做法
     * O(num)
     */
    public static int countEven(int num) {
        int res = 0;
        for(int i=1; i<=num; i++){
            if(isEven(i)){
                res++;
            }
        }
        return res;
    }
    private static boolean isEven(int num){
        String str = String.valueOf(num);
        int sum = 0;
        for(char c : str.toCharArray()){
            sum += (c- '0');
        }
        if(sum % 2 == 0) return true;
        return false;
    }

    /**Math
     *
     */
    public static int countEven2(int num) {
        int res = 0;
        for(int i=1; i<=num; i++){
            if(isEven(i)){
                res++;
            }
        }
        return res;
    }
    private static boolean isEven2(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        if(sum % 2 == 0) return true;
        return false;
    }
}
