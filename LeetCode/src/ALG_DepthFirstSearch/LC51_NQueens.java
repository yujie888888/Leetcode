package ALG_DepthFirstSearch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC51_NQueens {
    public static void main(String[] args) {

    }
    /**dfs
     * O(n! * n) n!是递归树节点数 n*(n-1)*..*1 n是isValid()
     * O(n! * n + n^2)
     * Ideas:
     * 每一行肯定放一个，用backtracking找所有可能的结果
     * 返回条件：到了最后一行
     * Main Core:
     *   遍历每一列，如果能放(isValid)，就往深处dfs
     *   出来之后记得复原上一层的选择
     * isValid() 是检查同一列，同一对角线（有两条），只需要检查两条对角线的上半部分，因为是从第一行开始放的
     * 结果的存放用List<List<String>>，inner List<String>放的是每一种可行的design
     * 格式转换有点麻烦，逻辑上还好
     */
    static List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        res.clear();
        char[][] chessBoard = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(chessBoard[i], '.');

        dfs(0, n, chessBoard);
        return res;
    }

    public static void dfs(int i, int n, char[][] chessBoard) {
        if (i == n) {
            res.add(new ArrayList<>(ArraysToList(res, chessBoard, n)));
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValid(i, j, n, chessBoard)) {
                chessBoard[i][j] = 'Q';
                dfs(i + 1, n, chessBoard);
                chessBoard[i][j] = '.';
            }
        }
    }
    public static List<String> ArraysToList(List<List<String>> res,  char[][] chessBoard, int n){
        List<String> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String row = new String(chessBoard[i]);
            list.add(row);
        }
        return list;
    }

    public static Boolean isValid(int i, int j, int n,  char[][] chessBoard) {
        // check same cols
        for (int row = 0; row < i; row++) {
            if (chessBoard[row][j] == 'Q') return false;
        }

        // check same slash
        int i1 = i, i2=i, j1=j, j2=j;
        // check same slash1-up
        while (i1 > 0 && j1 > 0) {
            i1--;
            j1--;
            if (chessBoard[i1][j1] == 'Q') return false;

        }
        // check same slash2-up
        while (i2 > 0 && j2 < n - 1) {
            i2--;
            j2++;
            if (chessBoard[i2][j2] == 'Q') return false;
        }

        return true;
    }
}
