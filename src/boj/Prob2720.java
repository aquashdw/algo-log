package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2720
public class Prob2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        int[] coins = {25, 10, 5, 1};
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).mapToInt(Integer::parseInt)
                .forEach(change -> {
                    int[] coinsRequired = {0, 0, 0, 0};
                    int coinIdx = 0;
                    while (coinIdx < 4) {
                        while (change >= coins[coinIdx]) {
                            coinsRequired[coinIdx]++;
                            change -= coins[coinIdx];
                        }
                        coinIdx++;
                    }
                    answer.append(String.format("%d %d %d %d%n", coinsRequired[0], coinsRequired[1], coinsRequired[2], coinsRequired[3]));
                });
        System.out.print(answer);
    }
}
