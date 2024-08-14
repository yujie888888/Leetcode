package Company_icc;

/**
 * Question:
 * Write a program which takes 2 digits, X,Y as input and generates a 2-dimensional array.
 * The element value in the i-th row and j-th column of the array should be i*j.
 * Note: i=0,1.., X-1; j=0,1,¡Y-1.
 * Example
 * Suppose the following inputs are given to the program:
 * 3,5
 * Then, the output of the program should be:
 * [[0, 0, 0, 0, 0], [0, 1, 2, 3, 4], [0, 2, 4, 6, 8]]
 */
public class icc_iOasiZ {
    public static void main(String[] args) {
        //test case
        int x = 3, y=5;
        int[][] res = new int[x][y];
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                res[i][j] = i*j;
            }
        }
        //System.out.println(Arrays.deepToString(res));
        test2();
    }
    public static void test2(){
        String mail = "yz0088800@gmial.com";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<mail.length(); i++){
            if(mail.charAt(i) == '@') break;
            sb.append(mail.charAt(i));
        }
        System.out.println(sb);
    }
}
