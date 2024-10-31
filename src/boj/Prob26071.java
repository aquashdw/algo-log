package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/26071
public class Prob26071 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        boolean[][] board = new boolean[n][n];
        int lowBound = Integer.MAX_VALUE;
        int highBound = Integer.MIN_VALUE;
        int leftBound = Integer.MAX_VALUE;
        int rightBound = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            boolean gInRow = false;
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) == 'G';
                if (board[i][j]) {
                    gInRow = true;
                    leftBound = Math.min(j, leftBound);
                    rightBound = Math.max(j, rightBound);
                }
            }
            if (gInRow) {
                lowBound = Math.min(i, lowBound);
                highBound = Math.max(i, highBound);
            }
        }
        int horDiff = rightBound - leftBound;
        int horDist = horDiff == 0 ? 0 : Math.min(leftBound, n - rightBound - 1);
        int verDiff = highBound - lowBound;
        int verDist = verDiff == 0 ? 0 : Math.min(lowBound, n - highBound - 1);
        System.out.println(horDiff + horDist + verDiff + verDist);
    }
}
