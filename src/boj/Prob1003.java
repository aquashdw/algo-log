package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/1003
public class Prob1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        int[] nums = reader.lines().limit(tests)
                .mapToInt(Integer::parseInt)
                .toArray();
        int max = Arrays.stream(nums).max().orElseThrow();
        int[][] dp = new int[(max == 0 ? 1 : max) + 1][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i < max + 1; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        StringBuilder answer = new StringBuilder();
        Arrays.stream(nums)
                .forEach(i -> answer.append(String.format("%d %d\n", dp[i][0], dp[i][1])));
        System.out.print(answer);
    }
}
