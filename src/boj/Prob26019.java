package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/26019
public class Prob26019 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        long[] costs = new long[n + 1];
        Arrays.fill(costs, Long.MAX_VALUE);
        costs[0] = 0;

        for (int i = 0; i < n; i++) {
            long[] prices = Arrays.stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong).toArray();
            int futures = Math.min(m, n - i);
            for (int j = 1; j < futures + 1; j++) {
                long price = prices[j];
                costs[i + j] = Math.min(costs[i + j], costs[i] + prices[0] - price);
            }
        }
        System.out.println(costs[n]);
    }
}
