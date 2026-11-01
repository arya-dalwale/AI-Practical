import java.util.*;

public class BFSRobot {

    static int[][] grid = {
        {0, 0, 0, 1, 0},
        {1, 1, 0, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0}
    };

    static int rows = 5;
    static int cols = 5;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int r, c;
        Node parent;

        Node(int r, int c, Node parent) {
            this.r = r;
            this.c = c;
            this.parent = parent;
        }
    }

    static void printPath(Node node) {

        ArrayList<Node> path = new ArrayList<>();

        while (node != null) {
            path.add(node);
            node = node.parent;
        }

        Collections.reverse(path);

        System.out.println("Robot Path:");

        for (Node p : path)
            System.out.println("(" + p.r + "," + p.c + ")");

        System.out.println("Total Steps: " + (path.size() - 1));
    }

    public static void main(String[] args) {

        Node start = new Node(0, 0, null);

        int goalR = 4;
        int goalC = 4;

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        queue.add(start);
        visited[0][0] = true;

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            if (current.r == goalR && current.c == goalC) {
                printPath(current);
                return;
            }

            for (int i = 0; i < 4; i++) {

                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (nr >= 0 && nr < rows &&
                    nc >= 0 && nc < cols &&
                    grid[nr][nc] == 0 &&
                    !visited[nr][nc]) {

                    visited[nr][nc] = true;

                    queue.add(new Node(nr, nc, current));
                }
            }
        }

        System.out.println("No path found.");
    }
}