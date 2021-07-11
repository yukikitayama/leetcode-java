import java.util.Arrays;


public class Solution505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        distance[start[0]][start[1]] = 0;

        goto_travel(maze, start, distance);

        if (distance[destination[0]][destination[1]] == Integer.MAX_VALUE) {
            return -1;
        }
        else {
            return distance[destination[0]][destination[1]];
        }
    }

    private void goto_travel(int[][] maze, int[] start, int[][] distance) {

        // Directions: Up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] direction : directions) {

            int row = start[0] + direction[0];
            int col = start[1] + direction[1];
            int count = 0;

            while (0 <= row && row < maze.length
                    && 0 <= col && col < maze[0].length
                    && maze[row][col] == 0) {
                row += direction[0];
                col += direction[1];
                count++;
            }

            int[] end = {row - direction[0], col - direction[1]};

            if (distance[start[0]][start[1]] + count < distance[end[0]][end[1]]) {
                distance[end[0]][end[1]] = distance[start[0]][start[1]] + count;
                goto_travel(maze, new int[]{end[0], end[1]}, distance);
            }
        }
    }

    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] destination = {3,2};
        Solution505 sol = new Solution505();
        int answer = sol.shortestDistance(maze, start, destination);
        System.out.println("Answer: " + answer);
    }

}