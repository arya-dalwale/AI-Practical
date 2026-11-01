import java.util.*;

public class DFSMaze {

    static int[][] maze = {
        {0, 1, 0, 0, 0},
        {0, 1, 0, 1, 0},
        {0, 0, 0, 1, 0},
        {1, 1, 0, 0, 0},
        {0, 0, 0, 1, 0}
    };

    static int rows = 5;
    static int cols = 5;

    static boolean[][] visited = new boolean[5][5];

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static boolean dfs(int r, int c) {

        // Outside maze
        if (r < 0 || r >= rows || c < 0 || c >= cols)
            return false;

        // Wall or already visited
        if (maze[r][c] == 1 || visited[r][c])
            return false;

        visited[r][c] = true;

        // Goal reached
        if (r == 4 && c == 4) {
            System.out.println("(" + r + "," + c + ")");
            return true;
        }

        // Print current position
        System.out.println("(" + r + "," + c + ")");

        // Try all four directions
        for (int i = 0; i < 4; i++) {

            if (dfs(r + dr[i], c + dc[i]))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("DFS Path:");

        if (!dfs(0, 0))
            System.out.println("No path found.");
    }
}