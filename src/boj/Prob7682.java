package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/7682
public class Prob7682 {
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder answer = new StringBuilder();
        while (!(line = reader.readLine()).equals("end")) {
            board = new char[3][3];
            int[] count = new int[2];
            for (int i = 0; i < 9; i++) {
                int y = i / 3;
                int x = i % 3;
                board[y][x] = line.charAt(i);
                if (board[y][x] == '.') continue;
                count[board[y][x] == 'X' ? 0 : 1]++;
            }
            if (count[0] != count[1] + 1 && count[0] != count[1]) {
                answer.append("invalid\n");
                continue;
            }

            int xWins = wins('X');
            int oWins = wins('O');
            if (xWins > 0 && oWins > 0) {
                answer.append("invalid\n");
                continue;
            }
            if (xWins == 0 && oWins == 0 && count[0] + count[1] != 9) {
                answer.append("invalid\n");
                continue;
            }
            if (xWins > 0 && count[0] != count[1] + 1) {
                answer.append("invalid\n");
                continue;
            }
            if (oWins > 0 && count[0] != count[1]) {
                answer.append("invalid\n");
                continue;
            }
            answer.append("valid\n");
        }
        System.out.print(answer);
    }

    private static int wins(char player) {
        int wins = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) wins++;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) wins++;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) wins++;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) wins++;
        return wins;
    }
}
