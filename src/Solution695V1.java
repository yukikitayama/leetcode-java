import java.util.Stack;

public class Solution695V1 {
    public int maxAreaOfIsland(int[][] grid) {
        // Initialized with false
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // Direction [down, up, right, left]
        int[] directionR = new int[]{1, -1, 0, 0};
        int[] directionC = new int[]{0, 0, 1, -1};

        int answer = 0;

        for (int r = 0; r < grid.length; r++) {

            for (int c = 0; c < grid[0].length; c++) {

                // We can visit if it's island and not yet visited
                if (grid[r][c] == 1 && !visited[r][c]) {

                    int currArea = 0;

                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{r, c});

                    // Mark visited
                    visited[r][c] = true;

                    while (!stack.empty()) {

                        int[] vertex = stack.pop();
                        int currR = vertex[0];
                        int currC = vertex[1];

                        currArea++;

                        // Try 4 directions
                        for (int k = 0; k < 4; k++) {

                            int nextR = currR + directionR[k];
                            int nextC = currC + directionC[k];

                            // Boundary condition
                            if (0 <= nextR && nextR < grid.length &&
                                    0 <= nextC && nextC < grid[0].length &&
                                    grid[nextR][nextC] == 1 &&
                                    !visited[nextR][nextC]) {
                                stack.push(new int[]{nextR, nextC});
                                visited[nextR][nextC] = true;
                            }
                        }
                    }
                    answer = Math.max(answer, currArea);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution695V1 sol = new Solution695V1();
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        int answer = sol.maxAreaOfIsland(grid);
        System.out.println("Answer: " + answer);
    }
}
