/**
 * Imagine a board of size numRows × numColumns with some lasers placed on it. These lasers are placed at coordinates specified
 * in the two-dimensional array laserCoordinates, where laserCoordinates[i] is a two-element array containing coordinates for
 * the center of the ith laser. Lasers with a center in a cell (row, column) destroy everything in the same row (i.e. rows with index row)
 * and the same column (i.e. columns with index column).
 * Now imagine there is a robot at coordinates (curRow, curColumn).
 * The robot can only move in a straight line, either left, right, up, or down within this board.
 * Your task is to count the maximum number of cells that the robot can safely move through (in any direction) before being destroyed by lasers.
 * Note: You can assume that the initial cell is protected, and lasers cannot destroy the robot there even
 * if they cover this cell in their destruction area.
 * Note: You are not expected to provide the most optimal solution, but a solution with time complexity not worse than
 * O(numRows · numColumns · laserCoordinates.length) will fit within the execution time limit.
 * Example
 * For numRows = 8, numColumns = 8, curRow = 5, curColumn = 3, and laserCoordinates = [[1, 6], [2, 8]],
 * the output should be solution(numRows, numColumns, curRow, curColumn, laserCoordinates) = 3.
 * Explanation:
 * Given the 8 × 8 board, there are two lasers with centers at cells (1, 6)and (2, 8).
 * The animation below shows that the longest safe path for the robot is 3.
 */
package Company_Databricks;
import java.util.ArrayList;

public class P2_MaxSafePath {
    /**代码逻辑题
     * ArrayList
     * O(n)
     * O(n)
     */
    public static void main(String[] args){
        int[][] lasers = new int[][]{ {1,6}, {2,8} };
        int numrows = 8, numcols = 8;
        int currow = 5, curcol = 3;
        ArrayList<Integer> blockedRow = new ArrayList<>();
        ArrayList<Integer> blockedCol = new ArrayList<>();
        for(int[] laser : lasers){
            blockedRow.add(laser[0]);
            blockedCol.add(laser[1]);
        }
        int count1 = 0;
        for(int i=currow+1; i<numcols; i++){
            if(!blockedRow.contains(i)){
                count1++;
            }
            else break;
        }
        int count2 = 0;
        for(int i=curcol+1; i<numrows; i++){
            if(!blockedCol.contains(i)){
                count2++;
            }
            else break;
        }
        int count3 = 0;
        for(int i=currow-1; i>=0; i--){
            if(!blockedRow.contains(i)){
                count3++;
            }
            else break;
        }
        int count4 = 0;
        for(int i=curcol-1; i>=0; i--){
            if(!blockedCol.contains(i)){
                count4++;
            }
            else break;
        }
        int res = Math.max(Math.max(count1,count2),Math.max(count3,count4));
        System.out.println(res);
    }
}
