package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/24785
public class Prob24785 {
    private static final char[][] board = new char[8][];
    private static final int[][] delta = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            board[i] = reader.readLine().toCharArray();
        }

        int y = 7;
        int x = 0;
        int dir = 0;
        board[y][x] = '.';

        for (char command : reader.readLine().toCharArray()) {
            switch (command) {
                case 'F' -> {
                    int targetY = y + delta[dir][0];
                    int targetX = x + delta[dir][1];
                    if (!checkBounds(targetY, targetX) || !(board[targetY][targetX] == '.' || board[targetY][targetX] == 'D')) {
                        System.out.println("Bug!");
                        return;
                    }
                    y = targetY;
                    x = targetX;
                }
                case 'L' -> dir = dir - 1 < 0 ? 3 : dir - 1;
                case 'R' -> dir = dir + 1 > 3 ? 0 : dir + 1;
                case 'X' -> {
                    int targetY = y + delta[dir][0];
                    int targetX = x + delta[dir][1];
                    if (!checkBounds(targetY, targetX) || board[targetY][targetX] != 'I') {
                        System.out.println("Bug!");
                        return;
                    }
                    board[targetY][targetX] = '.';
                }
            }
        }

        System.out.println(board[y][x] == 'D' ? "Diamond!" : "Bug!");
    }

    private static boolean checkBounds(int y, int x) {
        return y >= 0 && y < 8 && x >= 0 && x < 8;
    }
}
