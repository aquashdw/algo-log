package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5954
public class Prob5954 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] coins = reader.lines().limit(n).mapToInt(Integer::parseInt).sorted().toArray();
        int total = Arrays.stream(coins).sum();
        long[] dp = new long[total + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = total; i >= coin; i--) {
                dp[i] += dp[i - coin];
                if (dp[i] > 1000000) dp[i] -= 1000000;
            }
        }

        int ceil = total / 2;
        int max = -1;
        for (int i = ceil; i >= 0; i--) {
            if (dp[i] > 0) {
                max = i;
                break;
            }
        }

        int diff = total - 2 * max;
        long count = dp[max];
        System.out.printf("%d%n%d%n", diff, count % 1000000);
    }

}
