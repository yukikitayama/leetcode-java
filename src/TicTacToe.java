public class TicTacToe {
    private int[][] board;
    private int n;

    public TicTacToe(int n) {
        // Initialize each elements zero
        board = new int[n][n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;

        // Check if the player wins
        if ((checkRow(row, player)) ||
                (checkColumn(col, player)) ||
                (row == col && checkDiagonal(player)) ||
                (col == n - row - 1 && checkAntiDiagonal(player))) {
            return player;
        }

        // No one wins
        return 0;
    }

    private boolean checkRow(int row, int player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][row] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAntiDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][n - row - 1] != player) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(3);
        int[][] moves = {
                {0, 0, 1},
                {0, 2, 2},
                {2, 2, 1},
                {1, 1, 2},
                {2, 0, 1},
                {1, 0, 2},
                {2, 1, 1}
        };
        for (int[] move : moves) {
            int answer = game.move(move[0], move[1], move[2]);
            System.out.println("Answer: " + answer);
        }
    }
}
