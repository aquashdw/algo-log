package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// https://www.acmicpc.net/problem/1018
public class Prob1018 {
    private static char[][] board;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] heightWidth = reader.readLine().split(" ");
        int height = Integer.parseInt(heightWidth[0]);
        int width = Integer.parseInt(heightWidth[1]);

        board = new char[height][];
        for (int i = 0; i < height; i++) {
            board[i] = reader.readLine().toCharArray();
        }

        for (int i = 0; i < height - 7; i++) {
            for (int j = 0; j < width - 7; j++) {
                count(i, j);
            }
        }
        System.out.println(min);
    }

    public static void count(int y, int x) {
        // 제일 왼쪽위를 기준으로, 흑일때 한번
        int baseB = 0;
        for (int i = y; i < y + 8; i++) {
            boolean fail = false;
            for (int j = x; j < x + 8; j++) {
                if ((i + j) % 2 == 0 && board[i][j] == 'W') baseB++;
                else if ((i + j) % 2 == 1 && board[i][j] == 'B') baseB++;
                if (baseB > min) {
                    fail = true;
                    break;
                }
            }
            if (fail) break;
        }
        min = Math.min(min, baseB);

        // 백일때 한번
        int baseW = 0;
        for (int i = y; i < y + 8; i++) {
            boolean fail = false;
            for (int j = x; j < x + 8; j++) {
                if ((i + j) % 2 == 0 && board[i][j] == 'B') baseW++;
                else if ((i + j) % 2 == 1 && board[i][j] == 'W') baseW++;
                if (baseW > min) {
                    fail = true;
                    break;
                }
            }
            if (fail) break;
        }
        min = Math.min(min, baseW);
    }
}
