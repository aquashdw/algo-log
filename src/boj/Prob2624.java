package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://www.acmicpc.net/problem/2624
public class Prob2624 {
    private static int[][] coins;
    private static int[][] dp;
    private static boolean[] visited;
    private static int paper;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        paper = Integer.parseInt(reader.readLine());
        int coinKinds = Integer.parseInt(reader.readLine());
        coins = reader.lines().limit(coinKinds)
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .sorted(Comparator.comparingInt(coin -> -coin[0]))
                .toArray(int[][]::new);
        dp = new int[coinKinds][paper + 1];
        visited = new boolean[paper + 1];
        visited[0] = true;
        for (int i = 0; i < coinKinds; i++) {
            for (int j = 0; j < paper + 1; j++) {
                if (!visited[j]) continue;
                calculate(i, j);
            }
            for (int j = 0; j < paper + 1; j++) {
                visited[j] = dp[i][j] != 0;
            }
        }
        calculate(0, 0);
        System.out.println(dp[coinKinds - 1][paper]);
    }

    private static void calculate(int coin, int startPrice) {
        int price = coins[coin][0];
        for (int i = 0; i < coins[coin][1] + 1; i++) {
            if (startPrice + price * i > paper) break;
            int newPrice = startPrice + price * i;
            dp[coin][newPrice] += coin == 0 ? 1 : dp[coin - 1][startPrice];

        }
    }
}
