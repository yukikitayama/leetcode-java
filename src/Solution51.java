import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution51 {
    private int size;
    private List<List<String>> solutions = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {
        size = n;
        char[][] emptyBoard = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                emptyBoard[i][j] = '.';
            }
        }

        // (current row, diagonals, anti-diagonals, columns, state)
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);

        return solutions;
    }

    private void backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols,
                           char[][] state) {
        // End if
        if (row == size) {
            solutions.add(createBoard(state));
            return;
        }

        for (int col = 0; col < size; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;

            // No queen if
            // Can't put a queen
            if (cols.contains(col)
                    || diagonals.contains(currDiagonal)
                    || antiDiagonals.contains(currAntiDiagonal)) {
                continue;
            }

            // Put a queen
            state[row][col] = 'Q';

            // Update helper information
            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);

            // Move to the next row
            backtrack(row + 1, diagonals, antiDiagonals, cols, state);

            // Backtrack
            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            state[row][col] = '.';
        }
    }

    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<String>();

        for (int row = 0; row < size; row++) {
            // From array of chars to String
            // Create String object by passing array name to the constructor
            String current_row = new String(state[row]);
            board.add(current_row);
        }

        return board;
    }

    public static void main(String[] args) {
        int n = 4;
        Solution51 sol = new Solution51();
        List<List<String>> ans = sol.solveNQueens(n);
        System.out.println(ans);
    }
}
