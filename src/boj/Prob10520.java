package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/10520
public class Prob10520 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nd = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nd[0];
        int d = nd[1];
        int[] costs = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[d + 1];
        Arrays.fill(dp, 1, d, 100000000);
        for (int i = 0; i < n; i++) {
            dp[0] += costs[i];
            for (int j = 1; j < d + 1; j++) {
                dp[j] = Math.min(dp[j] + costs[i], ((dp[j - 1] + 5) / 10) * 10);
            }
        }
        System.out.println(((dp[d] + 5) / 10) * 10);
    }
}
