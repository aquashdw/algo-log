package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5721
public class Prob5721 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder answer = new StringBuilder();
        while (!(line = reader.readLine()).equals("0 0")) {
            int[] size = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int rows = size[0];
            int cols = size[1];

            int[][] board = new int[rows][];
            for (int i = 0; i < rows; i++) {
                board[i] = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
            }

            int[] rowMax = new int[rows];
            for (int rowIdx = 0; rowIdx < rows; rowIdx++) {
                int[] row = board[rowIdx];
                if (cols == 1) {
                    rowMax[rowIdx] = row[0];
                    continue;
                }
                if (cols == 2) {
                    rowMax[rowIdx] = Math.max(row[0], row[1]);
                    continue;
                }
                int[] dp = new int[cols];
                dp[0] = row[0];
                dp[1] = Math.max(row[0], row[1]);
                for (int i = 2; i < cols; i++) {
                    dp[i] = Math.max(dp[i - 1], dp[i - 2] + row[i]);
                }
                rowMax[rowIdx] = Math.max(dp[cols - 1], dp[cols - 2]);
            }


            if (rows == 1) {
                answer.append(rowMax[0]).append('\n');
                continue;
            }
            if (rows == 2) {
                answer.append(Math.max(rowMax[0], rowMax[1])).append('\n');
                continue;
            }
            int[] dp = new int[rows];
            dp[0] = rowMax[0];
            dp[1] = Math.max(rowMax[0], rowMax[1]);
            for (int i = 2; i < rows; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + rowMax[i]);
            }
            answer.append(dp[rows - 1]).append('\n');
        }
        System.out.print(answer);
    }
}
