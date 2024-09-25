package Company_icc;

public class GTS {

    public static void main(String[] args) {
        int x = 4;
        int y = 11;
        System.out.println(findWinner(x,y));
    }
    public static String findWinner(int x, int y){
        int y1 = x * 4;
        // find how many rounds it can be excued
        int realRound = 0;
        if(y < y1){
            realRound = y/4;
        }
        else{
            realRound = x;
        }
        if(realRound % 2 == 0){
            return "Bob";
        }
        else{
            return "Alice";
        }
    }
}
