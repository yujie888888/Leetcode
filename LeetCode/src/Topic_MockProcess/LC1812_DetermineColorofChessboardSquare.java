package Topic_MockProcess;

public class LC1812_DetermineColorofChessboardSquare {
    public static void main(String[] args) {
        System.out.println(squareIsWhite("b3"));
    }
    public static boolean squareIsWhite(String coordinates) {
        //先记录棋盘
        String[][] chessBoard = new String[9][9];
        // 以黑棋开头
        for(int i=1; i<=8; i+=2){
            for(int j=1; j<=8; j+=2){
                chessBoard[i][j] = "Black";
            }
            for(int j=2; j<=8; j+=2){
                chessBoard[i][j] = "White";
            }
        }
        for(int i=2; i<=8; i+=2){
            for(int j=1; j<=8; j+=2){
                chessBoard[i][j] = "White";
            }
            for(int j=2; j<=8; j+=2){
                chessBoard[i][j] = "Black";
            }
        }
        // 检查
        int x = coordinates.charAt(0)-'a'+1;
        int y = coordinates.charAt(1)-'0';
        return chessBoard[x][y] == "White";
    }
}
