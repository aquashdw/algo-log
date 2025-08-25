package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14526
public class Prob14526 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine().strip());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int n = Integer.parseInt(reader.readLine().strip());
            int total = 0;
            int[][] bricks = new int[n + 1][];
            for (int i = 0; i < n; i++) {
                bricks[i + 1] = Arrays.stream(reader.readLine().strip().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                total += bricks[i + 1][0];
            }
            int[] dp = new int[202];
            for (int i = 1; i < n + 1; i++) {
                int[] brick = bricks[i];
                for (int j = total; j >= brick[0] + brick[1]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - brick[0] - brick[1]] + brick[0]);
                }
            }
            answer.append(total - dp[total]).append('\n');
        }
        System.out.print(answer);
    }
}
