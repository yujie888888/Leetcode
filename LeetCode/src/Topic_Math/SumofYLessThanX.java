package Topic_Math;
/**
 * Given an integer X, write an algorithm to find the number of integers which are less than or equal to X and whose digits add up to Y.
 * Input
 * The first line of input consists of an integer- inputNum1, representing the given number X.
 * The next line consists of an integer- inputNum2, representing the given number Y.
 * Output
 * Print the count of numbers whose digits add up to Y for the given number X.
 * Note
 * If no numbers are found whose digits add up to Y for the given number X, then print -1.
 * Example
 * Input:
 * 20
 * 5
 * Output:
 * 2
 * Explanation:
 * X is 20 and Y is 5. There are only 2 integers <= 20, i.e., 5 and 14 whose digits add up to 5.
 * So, the output is 2.
 */
public class SumofYLessThanX {
    public static void main(String[] args) {
        int X = 20;
        int Y = 5;
        System.out.println(getCount(X,Y));
    }

    /**
     * O(X * num的位数) 大约在O(X)
     * Ideas：
     * 不用数学方法，用String和char来计算，比较好理解
     */
    public static int getCount(int X, int Y){
        int res = 0;
        for(int i=0; i<=X; i++){
            //if(equalToY1(i,Y)) res++;
            if(equalToY2(i,Y)) res++;
        }
        return res;
    }
    private static boolean equalToY1(int num, int target){
        String str = String.valueOf(num);
        int sum = 0;
        for(char c : str.toCharArray()){
            sum += (c-'0');
        }
        if(sum == target) return true;
        else return false;
    }
    private static boolean equalToY2(int num, int target){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        if(sum == target) return true;
        else return false;
    }
}
