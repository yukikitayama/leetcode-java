public class NumMatrix304 {
    private int[][] dp;

    public NumMatrix304(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        // To easily calculate cumulative sum, get extra one element to each row
        dp = new int[matrix.length][matrix[0].length + 1];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                dp[r][c + 1] = dp[r][c] + matrix[r][c];
            }
        }

        // Check
        for (int[] row : dp) {
            for (int col : row) {
                System.out.print(col + ", ");
            }
            System.out.println();
        }
    }

    /* (row1, col1) is upper left conner. (row2, col2) is lower right conner. They shape rectangle. */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;

        for (int row = row1; row <= row2; row++) {
            sum += dp[row][col2 + 1] - dp[row][col1];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix304 obj = new NumMatrix304(matrix);

    }
}
