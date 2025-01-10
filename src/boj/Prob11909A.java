package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11909
public class Prob11909A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + (map[0][i - 1] > map[0][i] ? 0 : map[0][i] - map[0][i - 1] + 1);
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + (map[i - 1][0] > map[i][0] ? 0 : map[i][0] - map[i - 1][0] + 1);
            for (int j = 1; j < n; j++) {
                int costDown = dp[i - 1][j] + (map[i - 1][j] > map[i][j] ? 0 : map[i][j] - map[i - 1][j] + 1);
                int costLeft = dp[i][j - 1] + (map[i][j - 1] > map[i][j] ? 0 : map[i][j] - map[i][j - 1] + 1);
                dp[i][j] = Math.min(costLeft, costDown);
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}
