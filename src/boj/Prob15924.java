package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/15924
public class Prob15924 {
    private static final int mod = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = nm[0];
        int cols = nm[1];

        char[][] map = new char[rows][];
        for (int i = 0; i < nm[0]; i++) {
            map[i] = reader.readLine().toCharArray();
        }
        int[][] dp = new int[rows][cols];
        int total = 0;
        dp[rows - 1][cols - 1] = 1;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                total += dp[i][j] % mod;
                total %= mod;
                if (i - 1 >= 0 && (map[i - 1][j] == 'S' || map[i - 1][j] == 'B')) {
                    dp[i - 1][j] += dp[i][j] % mod;
                    dp[i - 1][j] %= mod;
                }
                if (j - 1 >= 0 && (map[i][j - 1] == 'E' || map[i][j - 1] == 'B')) {
                    dp[i][j - 1] += dp[i][j] % mod;
                    dp[i][j - 1] %= mod;
                }
            }
        }
        System.out.println(total);
    }

}
