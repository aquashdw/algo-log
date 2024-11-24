package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/3095
public class Prob3095 {
    private static int n;
    private static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        board = new int[n][];
        for (int i = 0; i < n; i++) {
            board[i] = reader.readLine().chars()
                    .map(c -> c - '0').toArray();
        }

        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                count += countPlus(i, j);
            }
        }
        System.out.println(count);
    }

    private static int countPlus(int y, int x) {
        if (board[y][x] == 0) return 0;
        int size = 1;
        int count = 0;
        while (y - size >= 0 && y + size < n && x - size >= 0 && x + size < n) {
            int topY = y - size;
            int botY = y + size;
            int leftX = x - size;
            int rightX = x + size;
            boolean success = true;
            for (int i = 0; i < size * 2 + 1; i++) {
                int test = i == size ? 1 : 0;
                if (
                        board[topY][i + leftX] != test ||
                        board[botY][i + leftX] != test ||
                        board[i + topY][leftX] != test ||
                        board[i + topY][rightX] != test
                ) {
                    success = false;
                    break;
                }
            }
            if (!success) break;
            count++;
            size++;
        }
        return count;
    }
}
