package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14494
public class Prob14494 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] goalNm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = goalNm[0];
        int m = goalNm[1];
        long[][] dp = new long[m][n];
        int mod = 1000000007;
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }
}
