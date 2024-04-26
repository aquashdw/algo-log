package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/9095
public class Prob9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] cases = reader.lines().limit(n)
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = Arrays.stream(cases)
                .max()
                .orElseThrow();

        int[] dp = new int[max + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < max + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        StringBuilder answer = new StringBuilder();
        for (int num: cases) {
            answer.append(dp[num]).append('\n');
        }
        System.out.println(answer);
    }
}
