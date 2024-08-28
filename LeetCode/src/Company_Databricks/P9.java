/**
 * You're given a square matrix ofintegers matrix ofsize nxn
 * Let's define a bouncing diagonal as a seguence which starts from a cell of the leftmost column, ancmatrix.
 * continues diagonally (up-right) until it reaches the rightmost column, bouncing vertically if it reaches the top of the
 * Expand to see the example video.
 * For each cell of the leftmost column, let's define its weight as the sum of the elements in the bounc1g diagonals starting from that cell.
 * Your task is to sort the elements of the leftmost column by their weights in ascending order. in caseof a tie, sort them by their values, also in ascending order.
 * Return the sorted values of the leftmost column of matrix as a single array.
 * Note: You are not expected to provide the most optimal solution, but a solution with time complexitnot worse than o(n?) will fit within the execution time limit.
 * For.
 * matrix =[[2，3，2]，[0，2，5]，[1，0，1]]
 * the output should be solution(matrix)=[1，2,0]
 * Expand to see the example video..
 * o The weight of the firstelementis2+2+1=5
 * o The weight ofthe second elementiso+3+5=8
 * The weight of the third elementis1+2+2=5
 * The second element weightis greater than the others, soits value( o)goes tothe end ofthe resulting array. There's a tie betweenthe fist and third elemenis, so they must besorted by their values ( 1 , 2 ). Therefore, the final order of the elements in the leftmost column is [1, 2, o]
 * For
 * matrix =[[1，3，2，5],[3，2，50]，[9,0，1，3]，[6，1，0，8]]
 * the output should be solution(matrix)=[1，9，3，6].
 * Expand to see the example video.
 * o The weight ofthe firstelementis1+2+1+8=12
 * oThe weight of the second elementis3+3+5+3=14
 * The weight of the third elementis g+2+2+0=13
 * o The weight ofthe fourth elementis6+0+5+5=16
 */
package Company_Databricks;
import java.util.*;

public class P9 {
    /**代码逻辑题
     * O(m*n)
     * O(m)
     * 思路：
     * 1.弹跳题，题目描述很模糊真的无语
     * 2.对于没有碰到边界的球来说，方向一直沿着一个方向跑，如果碰到了边界，就弹到反方向
     * 3.找到路径和
     * 4.然后自定义比较器，比较路径和
     */
    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {2, 3, 2},
                {0, 2, 5},
                {1, 0, 1},
        };
        int m = nums.length;
        int n = nums[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
//            System.out.println("i: "+i);
            int row = i;
            int col = 0;
            int sum = 0;
            int direct = -1;
            while (col < n) {
                sum += nums[row][col];
                //改变方向
                if(col != n-1){
                    if(row == 0){
                        direct = 1;
                    }
                    else if(row == m-1){
                        direct = -1;
                    }
                }
                row += direct;
//                System.out.println("row: "+row);
                col++;
//                System.out.println("col: "+col);
            }
            list.add(new int[]{nums[i][0],sum});
        }
        Collections.sort(list, new Comparator<int[]>(){
            @Override
            public int compare (int[] a, int[] b){
                if (a[1] == b[1]) return a[0] - b[0];
                else return a[1] - b[1];
            }
        });

        for(int[] array : list){
//            System.out.print(Arrays.toString(array) +" ");
            System.out.print(array[0] +" ");
        }
    }
}
