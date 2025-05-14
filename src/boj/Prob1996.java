package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/1996
public class Prob1996 {
    private static final int[][] deltas = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1},
    };

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        char[][] mineMap = new char[n][];
        for (int i = 0; i < n; i++) {
            mineMap[i] = reader.readLine().toCharArray();
        }
        char[][] result = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mineMap[i][j] != '.') {
                    result[i][j] = '*';
                    continue;
                }

                int mines = 0;
                for (int[] delta : deltas) {
                    int nextY = i + delta[0];
                    int nextX = j + delta[1];
                    if (!checkBounds(nextY, nextX)) continue;
                    if (!Character.isDigit(mineMap[nextY][nextX])) continue;
                    mines += mineMap[nextY][nextX] - '0';
                    if (mines > 9) break;
                }
                result[i][j] = mines > 9 ? 'M' : (char) ('0' + mines);
            }
        }

        System.out.println(Arrays.stream(result)
                .map(String::valueOf)
                .collect(Collectors.joining("\n")));
        ;
    }

    private static boolean checkBounds(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
