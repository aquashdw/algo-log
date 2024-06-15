package leetcode;

public class Prob36 {
    private char[][] board;

    public boolean isValidSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            if (!checkCol(i)) return false;
            if (!checkRow(i)) return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!checkSquare(i * 3, j * 3)) return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col) {
        boolean[] visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == '.') continue;
            if (visited[board[i][col] - '1']) return false;
            visited[board[i][col] - '1'] = true;
        }
        return true;
    }

    private boolean checkRow(int row) {
        boolean[] visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == '.') continue;
            if (visited[board[row][i] - '1']) return false;
            visited[board[row][i] - '1'] = true;
        }
        return true;
    }

    private boolean checkSquare(int y, int x) {
        boolean[] visited = new boolean[9];
        int startY = (y / 3) * 3;
        int startX = (x / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startY + i][startX + j] == '.') continue;
                if (visited[board[startY + i][startX + j] - '1']) return false;
                visited[board[startY + i][startX + j] - '1'] = true;
            }
        }
        return true;
    }
}
