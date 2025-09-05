package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/13382
public class Prob13382 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int n = Integer.parseInt(reader.readLine());
            double[] probs = Arrays.stream(reader.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            if (n < 3) {
                double max = Arrays.stream(probs).max().orElseThrow();
                answer.append(String.format("%.1f%n", max));
                continue;
            }

            double[] dp = new double[n];
            dp[0] = probs[0];
            dp[1] = Math.max(probs[0], probs[1]);
            dp[2] = Math.max(dp[1], probs[2]);

            for (int i = 3; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], probs[i] + dp[i - 3]);
            }

            answer.append(String.format("%.1f%n", dp[n - 1]));
        }
        System.out.print(answer);
    }

}
