package Topic_ClassDesign;

public class LC304_RangeSumQuery2D {
}

/**
 * 先构建prefix sum
 * 再找规律
 * 难点是处理edge case
 */
class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m][n];
        sum[0][0] = matrix[0][0];

        for(int i=1; i<m; i++){
            sum[i][0] = sum[i-1][0] + matrix[i][0];
        }

        for(int j=1; j<n; j++){
            sum[0][j] = sum[0][j-1] + matrix[0][j];
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + matrix[i][j];
            }
        }
    }

    // O(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return sum[row2][col2];
        }

        if (row1 == 0) {
            return sum[row2][col2] - sum[row2][col1-1];
        }

        if (col1 == 0) {
            return sum[row2][col2] - sum[row1-1][col2];
        }

        return sum[row2][col2] - sum[row2][col1-1] - sum[row1-1][col2] + sum[row1-1][col1-1];
    }
}
