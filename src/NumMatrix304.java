class NumMatrix304 {
    private int[][] cumsum;

    public NumMatrix304(int[][] matrix) {
        // Initialized by zeroes
        cumsum = new int[matrix.length][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                cumsum[i][j + 1] = matrix[i][j] + cumsum[i][j];
            }
        }

//        for (int[] row : cumsum) {
//            for (int ele : row) {
//                System.out.print(ele + ", ");
//            }
//            System.out.println();
//        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;

        for (int i = row1; i <= row2; i++) {
            int sum_row = cumsum[i][col2 + 1] - cumsum[i][col1];
            ans += sum_row;

//            System.out.println(col2 + 1);
//            System.out.println(cumsum[i][col2 + 1] + ", " + cumsum[i][col1]);
//            System.out.println(sum_row);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] test = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix304 sol = new NumMatrix304(test);
//        int[] query = new int[]{2, 1, 4, 3};
//        int[] query = new int[]{1, 1, 2, 2};
        int[] query = new int[]{1, 2, 2, 4};
        int answer = sol.sumRegion(query[0], query[1], query[2], query[3]);
        System.out.println("Answer: " + answer);
    }
}
