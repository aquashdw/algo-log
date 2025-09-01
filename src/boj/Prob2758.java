package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2758
public class Prob2758 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int[] nm = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int n = nm[0];
            int m = nm[1];

            long[][] dp = new long[n][m + 1];
            Arrays.fill(dp[0], 1, m + 1, 1);
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m + 1; j++) {
                    for (int k = j * 2; k < m + 1; k++) {
                        // i번째 수가 j인 경우의 수
                        // == i-1번째 수가 j*2 보다 크거나 같은 모든 경우의 수
                        dp[i][j] += dp[i - 1][k];
                    }
                }
            }
            answer.append(Arrays.stream(dp[n - 1]).sum()).append('\n');
        }
        System.out.print(answer);
    }
}
