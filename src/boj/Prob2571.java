package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2571
public class Prob2571 {
    private static final int[][] board = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.lines().limit(n).forEach(line -> {
            int[] ru = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    board[i + ru[0]][j + ru[1]] = 1;
                }
            }
        });

        int maxSize = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (i * j < maxSize) continue;
                if (checkBySize(i, j)) maxSize = Math.max(maxSize, i * j);
            }
        }
        System.out.println(maxSize);
    }

    private static boolean checkBySize(int x, int y) {
        for (int i = 0; i < 100 - x + 1; i++) {
            for (int j = 0; j < 100 - y + 1; j++) {
                if (checkIfSquare(i, j, i + x, j + y)) return true;
            }
        }
        return false;
    }

    private static boolean checkIfSquare(int startX, int startY, int endX, int endY) {
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                if (board[i][j] == 0) return false;
            }
        }
        return true;
    }
}
