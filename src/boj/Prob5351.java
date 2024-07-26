package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5351
public class Prob5351 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests)
                .map(line -> Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray())
                .forEach(coins -> {
                    if (coins.length == 1) {
                        answer.append(coins[0]).append('\n');
                        return;
                    }
                    if (coins.length == 2) {
                        answer.append(Math.max(coins[0], coins[1])).append('\n');
                        return;
                    }
                    if (coins.length == 3) {
                        answer.append(Math.max(coins[0] + coins[2], coins[1])).append('\n');
                        return;
                    }
                    int[] dp = new int[coins.length];
                    dp[0] = coins[0];
                    dp[1] = coins[1];
                    dp[2] = dp[0] + coins[2];
                    for (int i = 3; i < coins.length; i++) {
                        dp[i] = Math.max(dp[i - 2], dp[i - 3]) + coins[i];
                    }
                    answer.append(Math.max(dp[dp.length - 1], dp[dp.length - 2])).append('\n');
                });
        System.out.print(answer);
    }
}
