package Company_Cisco;
/**
 * Lucy喜欢玩Hop, Skip and Jump游戏。给定一个N*M矩阵，从单元格(1,1)开始，她的挑战是以反时针方向跳跃并跳过交替的单元格。目标是找出她最后会跳到哪个单元格。
 * 编写一个算法来找出Lucy在按反时针方向移动并跳过交替单元格后最后会跳到的单元格。
 * 输入：
 * 第一行输入包含两个整数 - matrix_row 和 matrix_col，分别表示矩阵中的行数(N)和列数(M)。
 * 接下来的M行包含N个用空格分隔的整数，表示矩阵中每个单元格的元素。
 * 输出：
 * 打印一个整数，表示Lucy按照给定指令移动后最后跳到的单元格的值。
 * 示例：
 * 输入：
 * 3 3
 * 29 8 37
 * 15 41 3
 * 1 10 14
 * 输出：
 * 41
 * 解释：
 * Lucy从29开始，跳过15，跳到1，跳过10，跳到14，跳过3，跳到37，跳过8，最后跳到41。
 * 所以输出是41。
 */
public class LucySkipGrid {
    public static void main(String[] args) {
        //int[][] grid = new int[][]{{29,8,37},{15,41,3},{1,10,14}};
        //int[][] grid = new int[][]{{42}};
        //int[][] grid = new int[][]{{1},{2},{3},{4},{5}};
        //int[][] grid = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] grid = new int[][]{{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
        System.out.println(finalGrid(grid));
    }

    /**
     * O(m*n)
     * Ideas:
     * 在完整的顺一遍matrix的基础上加一个skip，标记为skip的就跳过
     */
    public static int finalGrid(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        // 按逆时针排
        int[][] dct = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int index = 0;
        int row=0;
        int col=0;
        int skip = 0; // 1表示跳过；0表示不跳
        int count = 0;
        int[][] visited = new int[n][m];
        while(count < m*n){
            visited[row][col] = 1;
            if (skip == 0) res = grid[row][col];

            // 找下一个位置
            int newRow = row + dct[index][0];
            int newCol = col + dct[index][1];

            // 如果下一个位置越界了，就变方向
            if(newRow<0 || newRow>=n || newCol<0 || newCol>=m || visited[newRow][newCol] == 1){
                index = (index+1) % 4;
                newRow = row + dct[index][0];
                newCol = col + dct[index][1];
            }

            row = newRow;
            col = newCol;

            skip = skip == 1 ? 0 : 1;
            count++;
        }
        return res;
    }
}
