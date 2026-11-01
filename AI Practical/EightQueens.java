public class EightQueens {

    static int N = 8;
    static int[] board = new int[N];

    // Check whether queen can be placed
    static boolean isSafe(int row, int col) {

        for (int i = 0; i < row; i++) {

            // Same column
            if (board[i] == col)
                return false;

            // Same diagonal
            if (Math.abs(board[i] - col) == Math.abs(i - row))
                return false;
        }

        return true;
    }

    // Backtracking
    static boolean solve(int row) {

        if (row == N)
            return true;

        for (int col = 0; col < N; col++) {

            if (isSafe(row, col)) {

                board[row] = col;

                if (solve(row + 1))
                    return true;

                // Backtrack
                board[row] = -1;
            }
        }

        return false;
    }

    // Print chess board
    static void printBoard() {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                if (board[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Initialize board
        for (int i = 0; i < N; i++)
            board[i] = -1;

        if (solve(0)) {

            System.out.println("8 Queens Solution:");
            printBoard();

        } else {
            System.out.println("No solution found.");
        }
    }
}