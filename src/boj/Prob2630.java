package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2630
public class Prob2630 {
    private static int[][] paper;
    private static int count0 = 0;
    private static int count1 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        paper = new int[n][];
        for (int i = 0; i < n; i++) {
            paper[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        divide(0, 0, n);
        System.out.printf("%d%n%d%n", count0, count1);
    }

    private static void divide(int y, int x, int size) {
        int color = checkColor(y, x, size);
        switch (color) {
            case -1 -> {
                int nextSize = size / 2;
                divide(y, x, nextSize);
                divide(y + nextSize, x, nextSize);
                divide(y, x + nextSize, nextSize);
                divide(y + nextSize, x + nextSize, nextSize);
            }
            case 0 -> count0++;
            case 1 -> count1++;
            default -> throw new IllegalArgumentException();
        }
    }

    private static int checkColor(int y, int x, int size) {
        int color = paper[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (paper[i][j] != color) return -1;
            }
        }
//        System.out.printf("%d %d %d%n", y, x, size);
        return color;
    }
}
