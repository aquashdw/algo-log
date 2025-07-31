package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1652
public class Prob1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        char[][] board = new char[n][];
        for (int i = 0; i < n; i++) {
            board[i] = reader.readLine().toCharArray();
        }

        int row = 0;
        int col = 0;

        for (int i = 0; i < n; i++) {
            boolean rowBefore = false;
            boolean rowOk = false;
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    rowBefore = false;
                    rowOk = false;
                    continue;
                }

                if (rowBefore) {
                    if (!rowOk) {
                        rowOk = true;
                        row++;
                    }
                    continue;
                }
                rowBefore = true;
            }

            boolean colBefore = false;
            boolean colOk = false;
            for (int j = 0; j < n; j++) {
                if (board[j][i] == 'X') {
                    colBefore = false;
                    colOk = false;
                    continue;
                }

                if (colBefore) {
                    if (!colOk) {
                        colOk = true;
                        col++;
                    }
                    continue;
                }
                colBefore = true;
            }
        }

        System.out.printf("%d %d%n", row, col);
    }
}
